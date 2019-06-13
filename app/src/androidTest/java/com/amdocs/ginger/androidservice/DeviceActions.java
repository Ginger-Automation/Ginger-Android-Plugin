package com.amdocs.ginger.androidservice;


import android.graphics.Bitmap;
import android.os.RemoteException;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import com.amdocs.ginger.plugin.platform.IDeviceActions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DeviceActions implements IDeviceActions {

    UiDevice mDevice;

    public DeviceActions(UiDevice device) {
        mDevice = device;
    }

    @Override
    public void WakeUp()
    {
        try {
            mDevice.wakeUp();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void PressHome() {
        mDevice.pressHome();
    }

    @Override
    public void PressApps()
    {
        UiObject UIO = mDevice.findObject(new UiSelector().description("Apps"));
        try {
            UIO.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void RotateLeft() {
        try {
            mDevice.setOrientationLeft();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void RotateRight() {
        try {
            mDevice.setOrientationRight();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String GetPageSource() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try
        {
            mDevice.dumpWindowHierarchy(os);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return os.toString();
    }



    public Bitmap TakeScreenshot()
    {
        Bitmap bmp = AndroidDevice.UiAutomation.takeScreenshot();
        return bmp;
    }

}
