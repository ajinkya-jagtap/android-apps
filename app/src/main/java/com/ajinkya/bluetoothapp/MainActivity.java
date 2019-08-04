package com.ajinkya.bluetoothapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    Button mSearching;
    ListView mListView;
    TextView mTextView;

    BluetoothAdapter bluetoothAdapter;



    private final BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String action=intent.getAction();

            if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){

                mTextView.setText("Finished..");
                mSearching.setEnabled(true);

            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView=findViewById(R.id.ListView);
        mSearching=findViewById(R.id.button);
        mTextView=findViewById(R.id.textView);


        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();


        IntentFilter intentFilter=new IntentFilter();

        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);

        registerReceiver(broadcastReceiver,intentFilter);

        mSearching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTextView.setText("Searching...");
                mSearching.setEnabled(false);
                bluetoothAdapter.startDiscovery();


            }
        });
    }
}
