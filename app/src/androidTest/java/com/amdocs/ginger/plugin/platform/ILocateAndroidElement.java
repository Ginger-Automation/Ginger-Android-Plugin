package com.amdocs.ginger.plugin.platform;


import com.amdocs.ginger.plugin.platform.UIElements.eElementType;

public interface ILocateAndroidElement
{
    IGingerAndroidElement LocateElementByID(eElementType elementType, String id);

    IGingerAndroidElement LocateElementByXPath(eElementType elementType, String xpath);


    // TODO: make all below same like above
    IGingerAndroidElement LocateElementByCss(eElementType elementType, String LocateValue);

    IGingerAndroidElement LocateElementByLinkTest(eElementType elementType,String LocateValue);

    IGingerAndroidElement LocateElementByPartiallinkText(eElementType elementType,String LocateValue);

    IGingerAndroidElement LocateElementByTag(eElementType elementType,String LocateValue);

    IGingerAndroidElement LocateElementByName(eElementType elementType, String locateByValue);
}
