package com.example.vecmo.ivec;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity8 extends Activity {


    Button bt81,bt82,bt83,bt84;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        bt81 = (Button)findViewById(R.id.button10);
        bt82 = (Button)findViewById(R.id.button11);
        bt83 = (Button)findViewById(R.id.button14);
        bt84 = (Button)findViewById(R.id.button20);


        bt81.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent mainIntent = new Intent(MainActivity8.this, MainActivity7.class);
                MainActivity8.this.startActivity(mainIntent);

            }
        });

        bt82.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent mainIntent = new Intent(MainActivity8.this, MainActivity9.class);
                MainActivity8.this.startActivity(mainIntent);

            }
        });

        bt83.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent mainIntent = new Intent(MainActivity8.this, MainActivity5.class);
                MainActivity8.this.startActivity(mainIntent);

            }
        });

        bt84.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent mainIntent = new Intent(MainActivity8.this, MainActivity7.class);
                MainActivity8.this.startActivity(mainIntent);

            }
        });

    }

}