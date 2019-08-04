package in.bitcode.firstapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActNew extends Activity {

    private TextView mTxtInfo;
    private LinearLayout mLayout;
    private EditText mEdtInfo;
    private Button mBtnSetAndFinish;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        mLayout = new LinearLayout( this );
        mLayout.setOrientation( LinearLayout.VERTICAL );
        mLayout.setLayoutParams( layoutParams );

        mTxtInfo = new TextView( this );
        mTxtInfo.setText("This is ActNew");
        mTxtInfo.setTextColor(Color.RED);
        mTxtInfo.setTextSize( 40 );
        mTxtInfo.setLayoutParams( layoutParams );
        mLayout.addView( mTxtInfo );

        mEdtInfo = new EditText( this );
        mEdtInfo.setHint("Enter some info");
        mEdtInfo.setLayoutParams( layoutParams );
        mLayout.addView( mEdtInfo );

        mBtnSetAndFinish = new Button( this );
        mBtnSetAndFinish.setLayoutParams( layoutParams );
        mBtnSetAndFinish.setText("Set and Finish");
        mLayout.addView( mBtnSetAndFinish );

        setContentView( mLayout );

    }


}
