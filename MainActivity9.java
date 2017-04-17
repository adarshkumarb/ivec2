package com.example.vecmo.ivec;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by vecmo on 22-03-2017.
 */

public class MainActivity9 extends Activity {

    BluetoothAdapter mBluetoothAdapter;

    Button bt91;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        bt91 = (Button)findViewById(R.id.button12);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        bt91.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent mainIntent = new Intent(MainActivity9.this, MainActivity5.class);
                MainActivity9.this.startActivity(mainIntent);

                Toast.makeText(MainActivity9.this, "Vehicle Tracking has been initiated and Details sent to Mobile# ##### until further Key Use", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void enableDisableBT()
    {
        if(mBluetoothAdapter==null)
            Toast.makeText(MainActivity9.this, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
        if(!mBluetoothAdapter.isEnabled()){
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBTIntent);
        }
    }
}