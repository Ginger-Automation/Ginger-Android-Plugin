package com.amdocs.ginger.plugin.core.CommLib;

import com.amdocs.ginger.androidtestapp.AndroidDevice;

import java.io.*;
import java.net.*;

public class GingerSocketClient
{
    DataOutputStream dout = null;
    DataInputStream din= null;
    Socket socket = null;

    public void connect()
    {
        try
        {   
            // InetAddress host = InetAddress.getLocalHost();
            // Socket socket = new Socket("172.30.80.1", 15001);
            socket = new Socket("192.168.1.107", 15001);
            dout=new DataOutputStream(socket.getOutputStream());
            din=new DataInputStream(socket.getInputStream());

            Boolean bSuccess =  register();

            if (bSuccess) {
                // Wait for commands loop
                while (true)
                {
                    Payload request = ReadIncomingPayload();
                    ProcessRequest(request);
                }
            }
            else
            {
                System.out.println("Failed to connect"); // TODO: add explnations from payload
            }

            //TODO: !!!!!!!!!!!!!!!!!!!
            //dout.close();  
            //socket.close();  
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    private void ProcessRequest(Payload request)
    {
        Payload response = null;
        if(request.Name.equals("Ping"))
        {
            // AndroidDevice device = new AndroidDevice();
            // device.pressHome();
            response = new Payload("OK");
            response.payloadType = Payload.ePaylodType.ResponsePayload;
            response.ClosePackage();
            sendPayload(response);
        }
    }

    private Boolean register()
    {
        Payload payload = new Payload("Register");
        payload.payloadType = Payload.ePaylodType.RequestPayload;
        payload.AddValue("Android Service");
        payload.AddValue("service 1");
        payload.AddValue(android.os.Build.VERSION.RELEASE);
        payload.AddValue("machine");
        payload.AddValue(socket.getInetAddress().getHostAddress());
        payload.ClosePackage();

        Payload response = SendRequest(payload);
        if (response.Name.equals("SessionID"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private Payload SendRequest(Payload payload)
    {
        sendPayload(payload);
        Payload resp = ReadIncomingPayload();
        System.out.println(resp.Name);
        return  resp;
    }

    private void sendPayload(Payload payload)
    {
        try {
            dout.write(payload.GetPackage());
            dout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private Payload ReadIncomingPayload() {
        byte[] bb = new byte[1024];
        try {
            din.read(bb);  // TODO: read 4 bytes len etc...
            Payload resp = new Payload(bb);
            return  resp;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;  // !!!!!!!!!!!!!!!
    }


//    public void ConnectAsync()
//    {
//        AsynchronousSocketChannel client = null;
//        try {
//            client = AsynchronousSocketChannel.open();
//            InetSocketAddress hostAddress = new InetSocketAddress("192.168.1.107", 15001);
//            Future<Void> future = client.connect(hostAddress);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//        try (AsynchronousSocketChannel client2 = AsynchronousSocketChannel.open())
//        {
//            Future<Void> result = client.connect(new InetSocketAddress("192.168.1.107", 15001));
//
//
//
//            result.get();
//            String str= "Hello! How are you?";
//            ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
//            Future<Integer> writeval = client.write(buffer);
//            System.out.println("Writing to server: "+str);
//            writeval.get();
//            buffer.flip();
//            Future<Integer> readval = client.read(buffer);
//            System.out.println("Received from server: " +new String(buffer.array()).trim());
//            readval.get();
//            buffer.clear();
//        }
//        catch (ExecutionException | IOException e) {
//            e.printStackTrace();
//        }
//        catch (InterruptedException e) {
//            System.out.println("Disconnected from the  server.");
//        }
//    }

}