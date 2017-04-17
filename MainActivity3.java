package com.example.vecmo.ivec;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import static com.example.vecmo.ivec.R.id.textView;

public class MainActivity3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final EditText et11,et12;
        Button bt11,bt12;

        bt11 = (Button)findViewById(R.id.button);
        et11 = (EditText)findViewById(R.id.editText);
        et12 = (EditText)findViewById(R.id.editText2);
        bt12 = (Button)findViewById(R.id.button2);

        Toast.makeText(MainActivity3.this, "This Page is One Time Login Page", Toast.LENGTH_SHORT).show();

        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et11.getText().toString().equals("admin") &&
                        et12.getText().toString().equals("admin") || et11.getText().toString().equals("admin123") &&
                        et12.getText().toString().equals("admin123") ) {
                    Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                    final Intent mainIntent = new Intent(MainActivity3.this, MainActivity6.class);
                    MainActivity3.this.startActivity(mainIntent);
                }else

                {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                }
            }
        });

        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent mainIntent = new Intent(MainActivity3.this, MainActivity4.class);
                MainActivity3.this.startActivity(mainIntent);
            }
        });

    }
}