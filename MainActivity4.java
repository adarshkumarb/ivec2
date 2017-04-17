package com.example.vecmo.ivec;


import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.NotificationCompatSideChannelService;
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

import static com.example.vecmo.ivec.R.id.add;
//import static com.example.vecmo.ivec.R.id.textView;

public class MainActivity4 extends Activity {

    DatabaseHelper myDB;
    Button bt41;
    EditText et41,et42,et43,et44,et45,et46;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        myDB = new DatabaseHelper(this);


        bt41 = (Button) findViewById(R.id.button4);
        et41 = (EditText) findViewById(R.id.editText3);
        et42 = (EditText) findViewById(R.id.editText5);
        et43 = (EditText) findViewById(R.id.editText6);
        et44 = (EditText) findViewById(R.id.editText7);
        et45 = (EditText) findViewById(R.id.editText9);
        et46 = (EditText) findViewById(R.id.editText10);

       addData();
    }


    public void addData() {

                bt41.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (et41.getText().toString().matches("") || et42.getText().toString().matches("") || et43.getText().toString().matches("") ||
                                et44.getText().toString().matches("") || et45.getText().toString().matches("") || et46.getText().toString().matches(""))
                            Toast.makeText(MainActivity4.this, "Please Key in All the Values", Toast.LENGTH_SHORT).show();

                        else
                        {
                            if (et42.getText().toString().matches(et43.getText().toString()) ) {
                        boolean isInserted = myDB.insertData(et41.getText().toString(), et42.getText().toString(), et44.getText().toString(), et45.getText().toString(), et46.getText().toString());
                        if (isInserted = true)
                            Toast.makeText(MainActivity4.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity4.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();

                        final Intent mainIntent = new Intent(MainActivity4.this, MainActivity3.class);
                        MainActivity4.this.startActivity(mainIntent);
                        Toast.makeText(MainActivity4.this, "PASSWORD: ADMIN123 AND USERNAME: ADMIN123 GENERATED ", Toast.LENGTH_LONG).show();
                    }
                            else Toast.makeText(MainActivity4.this, "Passwords Mismatch", Toast.LENGTH_SHORT).show();
                        }
                    }
                });




    }
}