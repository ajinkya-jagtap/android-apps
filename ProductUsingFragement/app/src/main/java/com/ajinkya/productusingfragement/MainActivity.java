package com.ajinkya.productusingfragement;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    ListOfProduct mListOfProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentManager fragmentManager=getSupportFragmentManager();
//        mListOfProduct= (ListOfProduct)fragmentManager.findFragmentById(R.id.fragementList);

    }
}
