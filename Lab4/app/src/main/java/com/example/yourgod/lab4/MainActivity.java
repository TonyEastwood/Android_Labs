package com.example.yourgod.lab4;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mPlayer1;
    MediaPlayer mPlayer2;
    MediaPlayer mPlayer3;
    Button startButton1, pauseButton1, stopButton1,startButton2, pauseButton2, stopButton2
            ,startButton3, pauseButton3, stopButton3;
    VideoView videoPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //video
        videoPlayer =  (VideoView)findViewById(R.id.videoPlayer);
        Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.videoy);
        videoPlayer.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);
        //

        //audio
        mPlayer1=MediaPlayer.create(this, R.raw.song1);
        mPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay1();
            }
        });
        startButton1 = (Button) findViewById(R.id.start1);
        pauseButton1 = (Button) findViewById(R.id.pause1);
        stopButton1 = (Button) findViewById(R.id.stop1);

        pauseButton1.setEnabled(false);
        stopButton1.setEnabled(false);
        //
        //audio
        mPlayer2=MediaPlayer.create(this, R.raw.song2);
        mPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay2();
            }
        });
        startButton2 = (Button) findViewById(R.id.start2);
        pauseButton2 = (Button) findViewById(R.id.pause2);
        stopButton2 = (Button) findViewById(R.id.stop2);

        pauseButton2.setEnabled(false);
        stopButton2.setEnabled(false);
        //
        //audio
        mPlayer3=MediaPlayer.create(this, R.raw.song3);
        mPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay3();
            }
        });
        startButton3 = (Button) findViewById(R.id.start3);
        pauseButton3 = (Button) findViewById(R.id.pause3);
        stopButton3 = (Button) findViewById(R.id.stop3);

        pauseButton3.setEnabled(false);
        stopButton3.setEnabled(false);
        //
    }


    private void stopPlay1(){
        mPlayer1.stop();
        pauseButton1.setEnabled(false);
        stopButton1.setEnabled(false);
        try {
            mPlayer1.prepare();
            mPlayer1.seekTo(0);
            startButton1.setEnabled(true);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void stopPlay2(){
        mPlayer2.stop();
        pauseButton2.setEnabled(false);
        stopButton2.setEnabled(false);
        try {
            mPlayer2.prepare();
            mPlayer2.seekTo(0);
            startButton2.setEnabled(true);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void stopPlay3(){
        mPlayer3.stop();
        pauseButton3.setEnabled(false);
        stopButton3.setEnabled(false);
        try {
            mPlayer3.prepare();
            mPlayer3.seekTo(0);
            startButton3.setEnabled(true);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }







    public void StartMedia1(View view)
    {
        mPlayer1.start();
        startButton1.setEnabled(false);
        pauseButton1.setEnabled(true);
        stopButton1.setEnabled(true);
        videoPlayer.pause();
        stopPlay2();
        stopPlay3();
    }
    public void PauseMedia1(View view)
    {
        mPlayer1.pause();
        startButton1.setEnabled(true);
        pauseButton1.setEnabled(false);
        stopButton1.setEnabled(true);
    }
    public void StopMedia1(View view)
    {
        stopPlay1();
    }

    public void StartMedia2(View view)
    {
        mPlayer2.start();
        startButton2.setEnabled(false);
        pauseButton2.setEnabled(true);
        stopButton2.setEnabled(true);
        videoPlayer.pause();
        stopPlay1();
        stopPlay3();
    }
    public void PauseMedia2(View view)
    {
        mPlayer2.pause();
        startButton2.setEnabled(true);
        pauseButton2.setEnabled(false);
        stopButton2.setEnabled(true);
    }
    public void StopMedia2(View view)
    {
        stopPlay2();
    }
    public void StartMedia3(View view)
    {
        mPlayer3.start();
        startButton3.setEnabled(false);
        pauseButton3.setEnabled(true);
        stopButton3.setEnabled(true);
        videoPlayer.pause();
        stopPlay2();
        stopPlay1();
    }
    public void PauseMedia3(View view)
    {
        mPlayer3.pause();
        startButton3.setEnabled(true);
        pauseButton3.setEnabled(false);
        stopButton3.setEnabled(true);
    }
    public void StopMedia3(View view)
    {
        stopPlay3();
    }
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer1.isPlaying()) {
            stopPlay1();
        }
        if (mPlayer2.isPlaying()) {
            stopPlay2();
        }
        if (mPlayer3.isPlaying()) {
            stopPlay3();
        }
    }
}
