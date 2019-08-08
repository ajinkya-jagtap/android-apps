package com.ajinkya.sqlitedb;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    ListView mListView;
    Databasehelper mD;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        populateListView();
    }

    private void populateListView() {

        Cursor data=mD.getData();
        ArrayList<String> list=new ArrayList<>();
        while (data.moveToNext()){
            list.add(data.getString(1));
        }
        ListAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
    }
}
