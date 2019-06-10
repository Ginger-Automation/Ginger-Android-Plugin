package com.amdocs.ginger.plugin.platform;

public interface IDeviceActions
{

    public void WakeUp();

    public void PressHome();

    public void PressApps();

    public void RotateLeft();

    public void RotateRight();

    String GetPageSource();
}
