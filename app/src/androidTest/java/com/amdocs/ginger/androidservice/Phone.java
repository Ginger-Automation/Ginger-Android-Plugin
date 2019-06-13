package com.amdocs.ginger.androidservice;

import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.support.test.InstrumentationRegistry;

import androidx.test.uiautomator.UiDevice;

import com.amdocs.ginger.plugin.platform.IPhone;


public class Phone implements IPhone {

    public static UiDevice device;
    @Override
    public void Dial(String number)
    {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:91-000-000-0000"));

        //TODO: check permssion or add

        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();

        instrumentation.startActivitySync(phoneIntent);
    }

    @Override
    public void Hangup() {

    }
}
