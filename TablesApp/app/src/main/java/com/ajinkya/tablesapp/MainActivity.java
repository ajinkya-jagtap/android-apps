package com.ajinkya.tablesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    SeekBar mSeekBar;

    Integer ArrayOne[] ={1,2,3,4,5,6,7,8,9,10};

    Integer ArrayTwo[]={1,2,3,4,5,6,7,8,9,10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView=findViewById(R.id.MyListView);
        mSeekBar=findViewById(R.id.SeeekBar);

        mSeekBar.setMax(20);
        mSeekBar.setProgress(10);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Integer Min=1;
                Integer num;
                if(progress<1){
                    num=Min;
                }
                else {
                    num=progress;
                }

                Log.i("ddfdfd",Integer.toString(num));

                Integer []ArrayOne={};

                for(Integer j=1;j<=10;j++){
                    ArrayOne.add(Integer.toString(j*num));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ArrayAdapter<Integer> Table=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,ArrayOne);











    }
}
