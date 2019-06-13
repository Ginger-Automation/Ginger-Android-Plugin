package com.amdocs.ginger.androidservice;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;

public class Audio {

    private static final int AUDIO_SAMPLE_RATE = 44100;

    /**
     * Recorded audio's channel.
     */
    private static final int RECORDER_CHANNEL = AudioFormat.CHANNEL_IN_MONO;

    /**
     * Recorded audio's encoding.
     */
    private static final int RECORDER_AUDIO_ENCODING = AudioFormat.ENCODING_PCM_16BIT;

    private int sampleRate = 16000 ; // 44100 for music
    private int channelConfig = AudioFormat.CHANNEL_CONFIGURATION_MONO;
    private int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
    int minBufSize = AudioRecord.getMinBufferSize(sampleRate, channelConfig,     audioFormat);
    private boolean status = true;
    public byte[] buffer;
    int bufferSize = 8000;


    void record2()
    {
        AndroidDevice.grantPermission("android.permission.RECORD_AUDIO");
        AndroidDevice.grantPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        AndroidDevice.grantPermission("android.permission.CAPTURE_AUDIO_OUTPUT");


        AudioRecord recorder = new AudioRecord(MediaRecorder.AudioSource.VOICE_CALL , AUDIO_SAMPLE_RATE, RECORDER_CHANNEL,
                RECORDER_AUDIO_ENCODING, bufferSize);

        if (recorder.getState() == AudioRecord.STATE_INITIALIZED)
        {
            //m_Recorder = recorder;
            //m_RecordingThread = Executors.newSingleThreadExecutor();
            //m_IsInitialized = true;
            return;
        }

    }

    private void record() {

        AndroidDevice.grantPermission("android.permission.RECORD_AUDIO");
        AndroidDevice.grantPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        AndroidDevice.grantPermission("android.permission.CAPTURE_AUDIO_OUTPUT");

        startRecording();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopRecording();

        play();
    }

    private void play() {
        String fileName = getFileName();
        MediaPlayer mediaPlayer = MediaPlayer.create(AndroidDevice.Context, Uri.parse(fileName));
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
    }


    private MediaRecorder recorder = null;


//    public class LocalBinder extends Binder {
//        GingerService getService() {
//            // Return this instance of LocalService so clients can call public methods
//            return GingerService.this;
//        }
//    }

    String getFileName()
    {
        return AndroidDevice.Context.getFilesDir().getAbsolutePath() + "/" + "aaa.aac";
    }

    private void startRecording() {
        //MediaStore.Audio audio = new MediaStore.Audio();
        //audio. .StartRecording(FileName);

        try {
            recorder = new MediaRecorder();
            recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL );
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            String fileName = getFileName();
//        recorder.setOutputFile("/sdcard/777.mpeg4");
            // recorder.setOutputFile("/dev/null");
            recorder.setOutputFile(fileName);

            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);


            recorder.prepare();
            recorder.start();
        } catch (IOException e)
        {
            String exx = e.getMessage();
            Log.e("GGGGGG", "prepare() failed");
        }
        catch (Exception ex)
        {
            String exe = ex.getMessage();
            Log.e("GGGGGG", "prepare() failed");
        }



    }

    private void stopRecording() {
        recorder.stop();
        recorder.release();
        recorder = null;
    }
}
