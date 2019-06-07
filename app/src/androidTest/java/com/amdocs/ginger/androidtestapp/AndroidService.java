package com.amdocs.ginger.androidtestapp;

import android.util.Log;

import androidx.test.uiautomator.UiDevice;

import com.amdocs.ginger.plugin.core.IGingerAction;

public class AndroidService
{
    public void pressHome(IGingerAction gingerAction)
    {
        // Arrange
        Log.d("Ginger", "Before press home");

        // Act
        AndroidDevice.device.pressHome();

        // Info
        Log.d("Ginger", "After press home");
        gingerAction.AddExInfo("Home button pressed");
    }
}
