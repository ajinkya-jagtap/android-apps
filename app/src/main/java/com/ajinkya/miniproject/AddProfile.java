package com.ajinkya.miniproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class AddProfile extends AppCompatActivity {


    EditText mSetRingTone;

    RadioGroup mRadioGroup;
    RadioButton mRinging;
    RadioButton mSilent;
    RadioButton mVibration;

    ImageView mImageView;
    private static final int Pick_Image=1;
    Uri imageUri;

    private AudioManager audioManager;
    SeekBar mRingVolume;
    SeekBar mAlarm;
    SeekBar mMedia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_profile);

        mSetRingTone = findViewById(R.id.selectRingTon);
        mRinging = findViewById(R.id.radioButton3);
        mSilent = findViewById(R.id.radioButton4);
        mVibration = findViewById(R.id.radioButton5);
        mRadioGroup = findViewById(R.id.radiogroup);

        mImageView = findViewById(R.id.wallpaper);

        mRingVolume = findViewById(R.id.seekBar1);
        mAlarm = findViewById(R.id.seekBar2);
        mMedia = findViewById(R.id.seekBar3);


        mRinging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = mRadioGroup.getCheckedRadioButtonId();
                mRinging = findViewById(radioId);
                Toast.makeText(AddProfile.this, "Ringing", Toast.LENGTH_SHORT).show();

            }
        });

        mSilent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = mRadioGroup.getCheckedRadioButtonId();
                mSilent = findViewById(radioId);
                Toast.makeText(AddProfile.this, "Silent", Toast.LENGTH_SHORT).show();

            }
        });

        mVibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = mRadioGroup.getCheckedRadioButtonId();
                mVibration = findViewById(radioId);
                Toast.makeText(AddProfile.this, "Vibration", Toast.LENGTH_SHORT).show();

            }
        });


        mSetRingTone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gallery=new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gallery,"select image"),Pick_Image);

            }
        });


        setVolumeControlStream(AudioManager.STREAM_RING);
        setVolumeControlStream(AudioManager.STREAM_ALARM);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        try {
            audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
            mRingVolume.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_RING));
            mRingVolume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_RING));

            mAlarm.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM));
            mAlarm.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_ALARM));

            mMedia.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            mMedia.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        mRingVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_RING,progress,0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mAlarm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_ALARM,progress,0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mMedia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==Pick_Image && requestCode==RESULT_OK){

            imageUri=data.getData();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                mImageView.setImageBitmap(bitmap);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}