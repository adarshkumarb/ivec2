package com.example.vecmo.ivec;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity7 extends Activity {


    Button bt71;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        bt71 = (Button)findViewById(R.id.button13);

        bt71.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent mainIntent = new Intent(MainActivity7.this, MainActivity8.class);
                MainActivity7.this.startActivity(mainIntent);
            }
        });

    }

}