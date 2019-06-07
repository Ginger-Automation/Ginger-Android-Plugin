package com.amdocs.ginger.plugin.platform;

interface IGingerAndroidElement
{
    Object Element = null;

    //void DragAndDrop(String DragDropType,IGingerWebElement Element);

    String GetAttribute(String attributeName);

    int GetHeight();

    //TODO:Enable Item count
    //int GetItemCount();
//    Size GetSize();
//    String GetStyle();
    int GetWidth();
//    void Hover();
    Boolean IsEnabled();
    Boolean IsVisible();
    // void RightClick();
    // string RunJavascript(string Script);
    // void ScrollToElement();
    // void SetFocus();
}
