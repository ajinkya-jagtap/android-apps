package com.ajinkya.sqlitedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.lang.Boolean;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private Button mAdd,mView;
    private EditText mEdt;

    private Databasehelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdt=findViewById(R.id.edttxt);
        mAdd=findViewById(R.id.addData);
        mDatabaseHelper=new Databasehelper(this);
        mView=findViewById(R.id.viewData);


        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEdt.length() != 0){
                    String newEntry=mEdt.getText().toString();
                    AddData(newEntry);
                    mEdt.setText("");
                }
                else{
                    Log.e("tag","Not inserted");
                }
            }
        });

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,List.class);
                startActivity(intent);

            }
        });

    }

    public void AddData(String newEntry){
        Boolean insert=mDatabaseHelper.addData(newEntry);
        if(insert){
            Toast.makeText(this, "Added data", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Not added data", Toast.LENGTH_SHORT).show();
        }

    }
}
