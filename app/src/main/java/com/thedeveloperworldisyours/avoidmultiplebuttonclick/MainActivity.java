package com.thedeveloperworldisyours.avoidmultiplebuttonclick;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button mRightbutton;
    Button mLeftButton;
    ListView listView;

    // variable to track event time
    private long mLastClickTime = 0;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRightbutton = (Button) findViewById(R.id.activity_main_button_right);
        mLeftButton = (Button) findViewById(R.id.activity_main_button_left);

        mLeftButton.setOnClickListener(this);
        mRightbutton.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.activity_main_list_view);

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };

        adapter = new ListViewAdapter(this,values,this);
        listView.setAdapter(adapter);
    }


    public void pressedOnClick(View v){
        switch (v.getId()){
            case R.id.row_main_left_button:
                showToast((String) v.getTag());
                break;

            case R.id.row_main_right_button:
                showToast((String) v.getTag());
                break;

            case R.id.activity_main_button_left:
                showToast("Left_activity_main");
                break;

            case R.id.activity_main_button_right:
                showToast("Right_activity_main");
                break;
        }

    }

    public void showToast(String text) {
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        // Preventing multiple clicks, using threshold of 1 second
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        pressedOnClick(view);
    }
}
