package com.amdocs.ginger.androidservicetest;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Binder;
import android.os.WorkSource;
import android.provider.MediaStore;
import android.support.test.InstrumentationRegistry;

// import android.support.test.espresso.action. .uiautomator.UiDevice;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.uiautomator.UiDevice;
// import android.tes

// import androidx.test.runner.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.Until;

import com.amdocs.ginger.androidservice.AndroidDevice;
import com.amdocs.ginger.androidservice.AndroidPlatform;
import com.amdocs.ginger.androidservice.TextBox;
import com.amdocs.ginger.plugin.core.CommLib.GingerSocketClient;
import com.amdocs.ginger.plugin.core.GingerAction;
import com.amdocs.ginger.plugin.platform.IAndroidPlatform;
import com.amdocs.ginger.plugin.platform.IGingerAndroidElement;
import com.amdocs.ginger.plugin.platform.UIElements.eElementType;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AndroidServiceTest {


    private static final String BASIC_SAMPLE_PACKAGE
            = "com.example.android.testing.uiautomator.BasicSample";
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";

    static IAndroidPlatform mAndroidPlatform;

    @Before
    public void setUp()
    {
        AndroidDevice.init();
        mAndroidPlatform = new AndroidPlatform(AndroidDevice.UiDevice);
        mAndroidPlatform.DeviceActions().WakeUp();
    }


    @Test
    public void PressApps()
    {
        // Arrange

        //Act
        mAndroidPlatform.DeviceActions().PressApps();
        String s = mAndroidPlatform.DeviceActions().GetPageSource();

        //Assert
        assertTrue(s.contains("com.sec.android.app.launcher:id/apps_grid"));

    }

    @Test
    public void PressHome()
    {
        mAndroidPlatform.DeviceActions().PressHome();
    }


    @Test
    public void dial()
    {
        mAndroidPlatform.Phone().Dial("1234");
    }

    @Test
    public void EnterEmail()
    {
        // Arrange

        String txt = "Hello";
        // String pageSource = androidDevice.DeviceActions().GetPageSource();
        // IGingerAndroidElement aaa =  androidDevice.LocateAndroidElement().LocateElementByID(eElementType.TextBox, "com.amdocs.ginger.androidtestapp:id/username");

        // Act
        IGingerAndroidElement element =  mAndroidPlatform.LocateAndroidElement().LocateElementByID(eElementType.TextBox, "userid");
        TextBox textBox = (TextBox)element;
        textBox.SetText(txt);
        String elementText = textBox.GetText();

        // Assert
        assertEquals(txt, elementText);
    }


    //@Test
    public void GingerGrid()
    {
        ConnectToGingerGrid();
    }

    private void ConnectToGingerGrid() {
        GingerSocketClient gingerSocketClient = new GingerSocketClient();
        gingerSocketClient.connect();
        // gingerSocketClient.ConnectAsync();
    }

    @Test
    public void startMainActivityFromHomeScreen()
    {

        // Initialize UiDevice instance
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        device.pressHome();

        // Wait for launcher
        final String launcherPackage = device.getLauncherPackageName();
        // assertThat(launcherPackage, notNullValue());
        // device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);



        // Launch the app
        Context context = ApplicationProvider.getApplicationContext();
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);
    }




    //@Test
    public void useAppContext() {



        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.amdocs.ginger.androidplugin", appContext.getPackageName());


    }

    //@Test
    public void PressHomeTest() {



        AndroidDevice androidDevice = new AndroidDevice();

        GingerAction gingerAction = new GingerAction();

        mAndroidPlatform.DeviceActions().WakeUp();

        // androidDevice.

        mAndroidPlatform.DeviceActions().PressHome();

        String s = mAndroidPlatform.DeviceActions().GetPageSource();

        // mAndroidPlatform.DeviceActions().ClickApps(gingerAction);

        //assertEquals("Home button pressed", gingerAction.ExInfo);
        //assertTrue(gingerAction.Error); Equals("Home button pressed", gingerAction.ExInfo);

    }

    @Test
    public void RotateLeft() {

        // Init();

        // AndroidDevice androidDevice = new AndroidDevice();

        //GingerAction gingerAction = new GingerAction();
        //androidDevice.RotateLeft(gingerAction);

        mAndroidPlatform.DeviceActions().RotateLeft();
        // assertEquals("Home button pressed", gingerAction.ExInfo);
        //assertTrue(gingerAction.Error); Equals("Home button pressed", gingerAction.ExInfo);

    }


    @Test
    public void RotateRight() {

        //Init();

        //AndroidDevice androidDevice = new AndroidDevice();

        // GingerAction gingerAction = new GingerAction();
        mAndroidPlatform.DeviceActions().RotateRight();

        // assertEquals("Home button pressed", gingerAction.ExInfo);
        //assertTrue(gingerAction.Error); Equals("Home button pressed", gingerAction.ExInfo);

    }

    //@Test
    public void PlatformTest() {
        // AndroidPlatform androidPlatform = new AndroidPlatform();
        // IGingerAndroidElement elem = androidPlatform.LocateAndroidElement.LocateElementByID(eElementType.Button, "bid");

    }



}
