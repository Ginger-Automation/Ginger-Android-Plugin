package com.amdocs.ginger.plugin.platform;

public interface IAndroidPlatform //: IPlatformService
{

    public abstract IDeviceActions DeviceActions();

    abstract ILocateAndroidElement LocateAndroidElement();

}
