package com.example.audioembed;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer media;   //adds media items e.g audio player

    AudioManager audio; //controls audio on the mobile device
    SeekBar volume;     //seekbar widget
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        media=MediaPlayer.create(this,R.raw.rain);
        volume=findViewById(R.id.seekBar2);
        audio = (AudioManager) getSystemService(AUDIO_SERVICE);  //give access to audio service to the AudioManager
        int maxVol=audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC); //set max volume variable to be equal to maximum device volume
        int currentVol=audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        volume.setMax(maxVol); //set maximum point of seekbar to be equal tu max device volume
        volume.setProgress(currentVol);
    volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Log.i("Seekbar", Integer.toString(progress));
            audio.setStreamVolume(audio.STREAM_MUSIC,progress,0);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });
    }


    public void play(View view) {


        media.start();
    }

    public void pause(View view) {
        media.pause();
    }
}
