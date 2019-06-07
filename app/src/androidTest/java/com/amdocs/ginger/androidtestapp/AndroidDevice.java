package com.amdocs.ginger.androidtestapp;

import android.os.RemoteException;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import com.amdocs.ginger.plugin.core.GingerAction;
import com.amdocs.ginger.plugin.core.GingerAction;
import com.amdocs.ginger.plugin.core.IGingerAction;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AndroidDevice {

    public static UiDevice device;

    public void pressHome(IGingerAction gingerAction)
    {
        device.pressHome();

        gingerAction.AddExInfo("Home button pressed");
    }


    public void LaunchApp(IGingerAction gingerAction, String appName)
    {
        device.pressHome();

        gingerAction.AddExInfo("Home button pressed");
    }

    public void RotateLeft(GingerAction gingerAction)
    {
        try {
            device.setOrientationLeft();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void RotateRight(GingerAction gingerAction)
    {
        try {
            device.setOrientationRight();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public void ClickApps(GingerAction gingerAction)
    {
        // UiObject UIO =  FindElement(LocateBy, LocateValue, ElementType);
        // UiObject UIO = device.findObject(new UiSelector().resourceId("Apps"));
        UiObject UIO = device.findObject(new UiSelector().description("Apps"));
        try {
            UIO.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }


    }


    public String GetPageSource()
    {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try
        {
            device.dumpWindowHierarchy(os);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return os.toString();
    }


    public void Wakeup(GingerAction gingerAction) {
        try {
            device.wakeUp();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

//    public void Wakeup(GingerAction gingerAction) {
//        try {
//            device. .wakeUp();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }

}
