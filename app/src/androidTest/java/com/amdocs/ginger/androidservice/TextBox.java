package com.amdocs.ginger.androidservice;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;

import com.amdocs.ginger.plugin.platform.IGingerAndroidElement;
import com.amdocs.ginger.plugin.platform.UIElements.ITextBox;

import org.w3c.dom.Text;

public class TextBox extends UIElement implements ITextBox {

    UiObject2 UIO;

    public TextBox(UiObject2 uiObject)
    {
        UIO = uiObject;
    }

    @Override
    public void SetText(String text)
    {
        //mDevice.
        //try
        //{
            // UIO.click();
            //if (UIO.isEnabled())
            //{

                // UIO.legacySetText(text);
                UIO.setText(text);
            //}
//            else
//            {
//                // TODO: throw err
//            }
//        } catch () {
//            e.printStackTrace();
//        }
    }

    @Override
    public String GetText() {
        return UIO.getText();

        // TODO: throw !!!
        // return null;
    }
}
