package in.bitcode.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView txt;
    private EditText edt;
    private Button btn, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById( R.id.txt );
        edt = findViewById( R.id.edt );
        btn = findViewById( R.id.btn );
        btnNext = findViewById( R.id.btnNext );

        /*View.OnClickListener onClickListener = new BtnClickListener();
        btn.setOnClickListener(  onClickListener );
        txt.setOnClickListener( onClickListener );*/


        /*btn.setOnClickListener( this );
        txt.setOnClickListener( this );*/

        /*btn.setOnClickListener( new BtnClickListener() );
        txt.setOnClickListener( new TxtClickListener() );*/

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txt.setText(edt.getText().toString());
                    }
                }
        );

        txt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("");
            }
        });





        btnNext.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to start next activity
                //we will ask os to start ActNew
                Intent intent = new Intent(MainActivity.this, ActNew.class);
                startActivity(intent);


                Intent intent1 = new Intent(MainActivity.this, ActNew.class);
                intent1.putExtra("name",e.getText().toString());


                startActivityForResult(intent1,1);

                intent1.putExtra("name",e.getText(),toString())
                Intent intent2 = getIntent();

                String first = intent2.getStringExtra("name");

                Intent intent2 = getIntant();
            }



        });

    }

    class BtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            txt.setText(edt.getText().toString());
        }
    }

    class TxtClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            txt.setText("");
        }
    }


   /*class BtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if( v == btn ) {
                txt.setText(edt.getText().toString());
            }
            if( v == txt ) {
                txt.setText("");
            }
        }
    }*/

    @Override
    public void onClick(View v) {
        if( v == btn ) {
            txt.setText(edt.getText().toString());
        }
        if( v == txt ) {
            txt.setText("");
        }
    }
}




