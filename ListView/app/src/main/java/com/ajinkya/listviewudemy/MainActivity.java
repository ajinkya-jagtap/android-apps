package com.ajinkya.listviewudemy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    String [] Arr={"Ajinkya","Pratik","Sourabh","Abhi","Vaibhav","Sham","Sachin","Abhinav","kiran","Swapnil","Umang",
    "Ajay","Sagar","Ashutosh","Ajinkya","Pratik","Sourabh","Abhi","Vaibhav","Sham","Sachin","Abhinav","kiran","Swapnil","Umang",
            "Ajay","Sagar","Ashutosh"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<String> ABC= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Arr);

        mListView=findViewById(R.id.myListView);

        mListView.setAdapter(ABC);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, Arr[position], Toast.LENGTH_SHORT).show();

            }
        });






    }
}
