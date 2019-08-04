package com.ajinkya.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar mSeekBar;
    ImageView mImageView;
    TextView mTextView;
    Button mButton;
    Boolean counterIsActive=false;
    CountDownTimer countDownTimer;

    public void ResetTimer(){

        mTextView.setText("0:30");
        mSeekBar.setProgress(30);
        mSeekBar.setEnabled(true);

        countDownTimer.cancel();
        mButton.setText("Go!");
        counterIsActive=false;
    }


    public void updateTimer(int i)
    {
        int Minutes=i/60;
        int Seconds=i-Minutes*60;
        mTextView.setText(Integer.toString(Minutes)+":"+Integer.toString(Seconds));

        String secondString=Integer.toString(Seconds);
        if(Seconds <= 9){
            secondString="0"+secondString;
        }
        mTextView.setText(Integer.toString(Minutes)+":"+secondString);
    }


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeekBar=findViewById(R.id.seekBar);
        mImageView=findViewById(R.id.imageView);
        mTextView=findViewById(R.id.textView);
        mButton=findViewById(R.id.button);


        mSeekBar.setMax(600);
        mSeekBar.setProgress(30);



        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                updateTimer(i);
//
//                int Minutes=i/60;             //MINUTE=600/60=10     min
//                int Seconds=i-Minutes*60;     //Seconds=(600-10*60)=600-600=0 sec
//
//                mTextView.setText(Integer.toString(Minutes)+":"+Integer.toString(Seconds));
//
//                String secondString=Integer.toString(Seconds);
//                if(Seconds <= 9){
//                    secondString="0"+secondString;
//                }
//                mTextView.setText(Integer.toString(Minutes)+":"+secondString);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (counterIsActive) {

                    ResetTimer();

//                    mTextView.setText("0:30");
//                    mSeekBar.setProgress(30);
//                    mSeekBar.setEnabled(true);
//                    countDownTimer.cancel();
//                    mButton.setText("Go!");
//                    counterIsActive=false;

                }

                else {

                    counterIsActive = true;
                    mSeekBar.setEnabled(false);
                    mButton.setText("STOP!");

                  countDownTimer=new CountDownTimer(mSeekBar.getProgress() * 1000 + 100, 1000) {


                        @Override
                        public void onTick(long millisUntilFinished) {

                            updateTimer((int) millisUntilFinished / 1000);
                        }

                        @Override
                        public void onFinish() {

                            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                            mediaPlayer.start();
                            ResetTimer();

                        }
                    }.start();
                }
            }


        });

    }
}
