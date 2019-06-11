package com.amdocs.ginger.androidservice;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiSelector;

import com.amdocs.ginger.plugin.platform.IGingerAndroidElement;
import com.amdocs.ginger.plugin.platform.ILocateAndroidElement;
import com.amdocs.ginger.plugin.platform.UIElements.eElementType;

class LocateAndroidElement implements ILocateAndroidElement {

    UiDevice mDevice;

    public LocateAndroidElement(UiDevice device)
    {
        mDevice = device;
    }

    @Override
    public IGingerAndroidElement LocateElementByID(eElementType elementType, String id)
    {

        // UiObject UIO = mDevice.findObject(new UiSelector().resourceId(id));
        UiObject2 UIO2 = mDevice.findObject(By.descContains(id));
        //UiObject2 wifiops = device.findObject(By.text("WLAN"));
        //TODO: check not null

        // if element type = textbox ....

        TextBox txt = new TextBox(UIO2);
        return txt;
    }

    @Override
    public IGingerAndroidElement LocateElementByXPath(eElementType elementType, String xpath) {
        return null;
    }

    @Override
    public IGingerAndroidElement LocateElementByCss(eElementType elementType, String LocateValue) {
        return null;
    }

    @Override
    public IGingerAndroidElement LocateElementByLinkTest(eElementType elementType, String LocateValue) {
        return null;
    }

    @Override
    public IGingerAndroidElement LocateElementByPartiallinkText(eElementType elementType, String LocateValue) {
        return null;
    }

    @Override
    public IGingerAndroidElement LocateElementByTag(eElementType elementType, String LocateValue) {
        return null;
    }

    @Override
    public IGingerAndroidElement LocateElementByName(eElementType elementType, String locateByValue) {
        return null;
    }
}
