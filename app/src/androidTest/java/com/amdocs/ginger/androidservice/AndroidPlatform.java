package com.amdocs.ginger.androidservice;

import androidx.test.uiautomator.UiDevice;

import com.amdocs.ginger.plugin.platform.IAndroidPlatform;
import com.amdocs.ginger.plugin.platform.IDeviceActions;
import com.amdocs.ginger.plugin.platform.ILocateAndroidElement;
import com.amdocs.ginger.plugin.platform.IPhone;

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

    @Override
    public ILocateAndroidElement LocateAndroidElement() {
        return new LocateAndroidElement(mDevice);
    }

    @Override
    public IPhone Phone() {
        return new Phone();
    }
}
