package com.ajinkya.calculatorapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {


    private Button mOne,mTwo,mThree,MFour,mFive,mSix,mSeven,mEight,mNine,mZero,mAdd,mSub,mMul,mDiv,mEqu,mBack,mPer,mPoint;
    private TextView mResult;
    double var1,var2;
    boolean add,sub,mul,div,per;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOne=findViewById(R.id.one);
        mTwo=findViewById(R.id.two);
        mThree=findViewById(R.id.three);
        mFive=findViewById(R.id.five);
        MFour=findViewById(R.id.four);
        mSix=findViewById(R.id.six);
        mSeven=findViewById(R.id.seven);
        mEight=findViewById(R.id.eight);
        mNine=findViewById(R.id.nine);
        mZero=findViewById(R.id.zero);
        mAdd=findViewById(R.id.plus);
        mSub=findViewById(R.id.minus);
        mMul=findViewById(R.id.multiply);
        mDiv=findViewById(R.id.divide);
        mPer=findViewById(R.id.percentage);
        mBack=findViewById(R.id.back);
        mEqu=findViewById(R.id.equal);
        mPoint=findViewById(R.id.point);

        mResult=findViewById(R.id.result);


        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mResult.setText("");
            }

        });

        mOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText(mResult.getText()+"1");
            }
        });


        mTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText(mResult.getText()+"2");
            }
        });


        mThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText(mResult.getText()+"3");
            }
        });


        mFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText(mResult.getText()+"5");
            }
        });


        MFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText(mResult.getText()+"4");
            }
        });


        mSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText(mResult.getText()+"6");
            }
        });


        mSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText(mResult.getText()+"7");
            }
        });


        mEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText(mResult.getText()+"8");
            }
        });


        mNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText(mResult.getText()+"9");
            }
        });


        mZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText(mResult.getText()+"0");
            }
        });


        mPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResult.setText(mResult.getText()+".");
            }
        });




        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                var1=Double.parseDouble(mResult.getText()+"");
                add=true;
                mResult.setText(null);

            }
        });


        mSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1=Double.parseDouble(mResult.getText()+"");
                sub=true;
                mResult.setText(null);
            }
        });


        mMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1=Double.parseDouble(mResult.getText()+"");
                mul=true;
                mResult.setText(null);
            }
        });


        mDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1=Double.parseDouble(mResult.getText()+"");
                div=true;
                mResult.setText(null);
            }
        });



        mPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1=Double.parseDouble(mResult.getText()+"");
                per=true;
                mResult.setText(null);
            }
        });


        mEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                var2=Double.parseDouble(mResult.getText()+"");
                if(add==true){
                    mResult.setText(var1+var2+"");
                    add=false;
                }


                var2=Double.parseDouble(mResult.getText()+"");
                if(sub==true){
                    mResult.setText(var1-var2+"");
                    add=false;
                }


                var2=Double.parseDouble(mResult.getText()+"");
                if(mul==true){
                    mResult.setText(var1*var2+"");
                    add=false;
                }


                var2=Double.parseDouble(mResult.getText()+"");
                if(div==true){
                    mResult.setText(var1/var2+"");
                    add=false;
                }

                var2=Double.parseDouble(mResult.getText()+"");
                if(per==true){

                    double dec=var1/100;
                    double total=dec*Double.parseDouble(var2+"");

                    mResult.setText(total+"");
                    per=false;

                }


            }
        });





    }

}
