package com.ajinkya.practiceadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;



    private String [] text={"ddfdfd","dfdfd","eerer","ddfdfd","dfdfd","eerer","ddfdfd","dfdfd","eerer","ddfdfd","dfdfd","eerer","ddfdfd","dfdfd","eerer"
    ,"ddfdfd","dfdfd","eerer","ddfdfd","dfdfd","eerer","ddfdfd","dfdfd","eerer","ddfdfd","dfdfd","eerer","ddfdfd","dfdfd","eerer"};

    private AdapterText mAdapterText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView=findViewById(R.id.myListViewXml);
       mAdapterText=new AdapterText(text,this);

        mListView.setAdapter(mAdapterText);


    }
}
