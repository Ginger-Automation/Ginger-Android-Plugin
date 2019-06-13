package com.amdocs.ginger.androidservice;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.content.Context;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import com.amdocs.ginger.plugin.core.GingerAction;
import com.amdocs.ginger.plugin.core.IGingerAction;

import java.io.ByteArrayOutputStream;
import java.io.IOException;



public class AndroidDevice
{
    public static Instrumentation Instrumentation;
    public static UiAutomation UiAutomation;
    public static UiDevice UiDevice;
    public static Context Context;


    public static void init()
    {
        Instrumentation = InstrumentationRegistry.getInstrumentation();
        UiAutomation = Instrumentation.getUiAutomation();
        UiDevice = UiDevice.getInstance(Instrumentation);
        Context =  InstrumentationRegistry.getTargetContext();
    }

    public static void grantPermission(String p)
    {
        // TODO: check if below is better
        // UiAutomation.grantRuntimePermission(p);

        String cmd = "pm grant " + Context.getPackageName() + " " + p;

        // mInstrumentation.de
        UiAutomation.executeShellCommand(cmd);
    }

//    public void pressHome(IGingerAction gingerAction)
//    {
//        device.pressHome();
//
//        gingerAction.AddExInfo("Home button pressed");
//    }
//
//
//    public void LaunchApp(IGingerAction gingerAction, String appName)
//    {
//        device.pressHome();
//
//        gingerAction.AddExInfo("Home button pressed");
//    }
//
//    public void RotateLeft(GingerAction gingerAction)
//    {
//
//    }
//
//    public void RotateRight(GingerAction gingerAction)
//    {
//
//    }
//
//
//    public void ClickApps(GingerAction gingerAction)
//    {
//        // UiObject UIO =  FindElement(LocateBy, LocateValue, ElementType);
//        // UiObject UIO = device.findObject(new UiSelector().resourceId("Apps"));
//
//
//
//    }
//
//
//    public String GetPageSource()
//    {
//
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try
//        {
//            device.dumpWindowHierarchy(os);
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//
//        return os.toString();
//    }
//
//
//    public void Wakeup(GingerAction gingerAction) {
//        try {
//            device.wakeUp();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }



//    public void Wakeup(GingerAction gingerAction) {
//        try {
//            device. .wakeUp();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }

}
