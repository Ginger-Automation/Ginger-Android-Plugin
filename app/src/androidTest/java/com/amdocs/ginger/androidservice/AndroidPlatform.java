package com.amdocs.ginger.androidservice;

import androidx.test.uiautomator.UiDevice;

import com.amdocs.ginger.plugin.platform.IAndroidPlatform;
import com.amdocs.ginger.plugin.platform.IDeviceActions;

public class AndroidPlatform implements IAndroidPlatform
{

    UiDevice mDevice;

    DeviceActions deviceActions;

    public AndroidPlatform(UiDevice device)
    {
        mDevice = device;
        deviceActions = new DeviceActions(device);
    }




    @Override
    public IDeviceActions DeviceActions() {
        return deviceActions;
    }
}
