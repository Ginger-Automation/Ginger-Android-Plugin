package com.amdocs.ginger.plugin.core.CommLib;

import java.io.*;
import java.net.*;  

public class GingerSocketClient
{
    public void connect()
    {
        try
        {   
            // InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket("172.30.80.1", 15001);
            DataOutputStream dout=new DataOutputStream(socket.getOutputStream());  
            DataInputStream din=new DataInputStream(socket.getInputStream());  

            Payload payload = new Payload("Register");
            payload.AddValue("java 1");
            payload.AddValue("service 1");
            payload.AddValue("os ver");
            payload.AddValue("machine");
            payload.AddValue("IP");
            payload.ClosePackage();

            dout.write(payload.GetPackage());
            dout.flush();  
            byte[] bb = new byte[1024];
            din.read(bb);

            Payload resp = new Payload(bb);
            System.out.println(resp.toString());

            //dout.close();  
            //socket.close();  
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}