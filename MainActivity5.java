package com.example.vecmo.ivec;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.logging.ConsoleHandler;

import static android.content.ContentValues.TAG;
//import static com.example.vecmo.ivec.R.id.textView;

public class MainActivity5 extends Activity {

    BluetoothAdapter mBluetoothAdapter;
    BluetoothSocket mmSocket;
    BluetoothDevice mmDevice;
    OutputStream mmOutputStream;
    InputStream mmInputStream;
    Thread workerThread;
    byte[] readBuffer;
    int readBufferPosition;
    int counter;
    volatile boolean stopWorker;
    TextView tv51,tv52,tv53;
    int value=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button bt51,bt52,bt53,bt54,bt55,bt56,bt57;
        int n;

        // Button bt52,bt53,bt54,bt55;
        bt51 = (Button) findViewById(R.id.button3);
        bt52 = (Button) findViewById(R.id.button5);
        bt53 = (Button) findViewById(R.id.button7);
        bt54 = (Button) findViewById(R.id.button8);
        bt55 = (Button) findViewById(R.id.button9);
        bt57 = (Button) findViewById(R.id.button19);
        bt56 = (Button) findViewById(R.id.button15);
        tv51 = (TextView) findViewById(R.id.textView5);
        tv52 = (TextView) findViewById(R.id.textView8);
        tv53 = (TextView) findViewById(R.id.textView10);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Button openButton = (Button)findViewById(R.id.button21);
        Button sendButton = (Button)findViewById(R.id.button24);
        Button closeButton = (Button)findViewById(R.id.button25);
        //tv51 = (TextView)findViewById(R.id.textView5);

      //myTextbox = (EditText)findViewById(R.id.entry);

        //Open Button
        openButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                try
                {
                    findBT();
                    openBT();
                }
                catch (IOException ex) { }
            }
        });

        //Send Button
        sendButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                try
                {
                    sendData();
                }
                catch (IOException ex) { }
            }
        });

        //Close button
        closeButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                try
                {
                    closeBT();
                }
                catch (IOException ex) { }
            }
        });




        bt53.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //tv51.setText(Integer.toString(45));
                //tv51.setText("Speed");
              /*  int min1 = 1000;
                int max1 = 8000;
                Random r1 = new Random();
                int random1 = r1.nextInt(max1 - min1) + min1;
                tv52.setText(""+random1);

                int min2 = 0;
                int max2 = 120;
                Random r2 = new Random();
                int random2 = r1.nextInt(max2 - min2) + min2;
                tv51.setText(""+random2);

                int min3 = 0;
                int max3 = 100;
                Random r3  = new Random();
                int random3 = r1.nextInt(max3 - min3) + min3;
                tv53.setText(""+random3);
                */

              for (int i2=100;i2<=8000;i2=i2+50)
                tv52.setText(""+i2);

                for (int i1=0;i1<=150;i1=i1+5)
                    tv52.setText(""+i1);

                for (int i3=100;i3>=0;i3--)
                    tv52.setText(""+i3);


            }
        });

        bt57.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                value = value+1;
                if (value%2==0)
                Toast.makeText(MainActivity5.this, "Your have Opted for EcoMode", Toast.LENGTH_LONG).show();
                else Toast.makeText(MainActivity5.this, "Your have Opted for Normal Mode", Toast.LENGTH_LONG).show();


            }
        });

        bt54.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity5.this, "No Charging Stations Near By", Toast.LENGTH_LONG).show();

            }
        });

        bt55.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity5.this, "Customizable Button for Users", Toast.LENGTH_LONG).show();

            }
        });



        bt51.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enableDisableBT();
            }
        });

        bt56.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent mainIntent = new Intent(MainActivity5.this, MainActivity8.class);
                MainActivity5.this.startActivity(mainIntent);
            }
        });

        bt52.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent mainIntent = new Intent(MainActivity5.this, MapsActivity.class);
                MainActivity5.this.startActivity(mainIntent);
            }
        });
/*
        Log.v(TAG, "Initializing sounds...");
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.Sound.mp3);
        bt56.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(TAG, "Playing sound...");
                mp.start();
            }
        });*/

    }
    public void enableDisableBT()
    {
        if(mBluetoothAdapter==null)
            Toast.makeText(MainActivity5.this, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
        if(!mBluetoothAdapter.isEnabled()){
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBTIntent);

            }
        if (mBluetoothAdapter.isEnabled())
            mBluetoothAdapter.disable();
    }

    void findBT()
    {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter == null)
        {

            Toast.makeText(MainActivity5.this, "No bluetooth adapter available", Toast.LENGTH_LONG).show();
        }

        if(!mBluetoothAdapter.isEnabled())
        {
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth, 0);
        }

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        if(pairedDevices.size() > 0)
        {
            for(BluetoothDevice device : pairedDevices)
            {
                if(device.getName().equals("HC-05"))
                {
                    mmDevice = device;
                    break;
                }
            }
        }

        Toast.makeText(MainActivity5.this, "Bluetooth Device Found", Toast.LENGTH_LONG).show();
    }

    void openBT() throws IOException
    {
        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); //Standard SerialPortService ID
        mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
        mmSocket.connect();
        mmOutputStream = mmSocket.getOutputStream();
        mmInputStream = mmSocket.getInputStream();

        beginListenForData();

        Toast.makeText(MainActivity5.this, "Bluetooth Opened", Toast.LENGTH_LONG).show();
    }

    void beginListenForData()
    {
        final Handler handler = new Handler();
        final byte delimiter = 10; //This is the ASCII code for a newline character

        stopWorker = false;
        readBufferPosition = 0;
        readBuffer = new byte[1024];
        workerThread = new Thread(new Runnable()
        {
            public void run()
            {
                while(!Thread.currentThread().isInterrupted() && !stopWorker)
                {
                    try
                    {
                        int bytesAvailable = mmInputStream.available();
                        if(bytesAvailable > 0)
                        {
                            byte[] packetBytes = new byte[bytesAvailable];
                            mmInputStream.read(packetBytes);
                            for(int i=0;i<bytesAvailable;i++)
                            {
                                byte b = packetBytes[i];
                                if(b == delimiter)
                                {
                                    byte[] encodedBytes = new byte[readBufferPosition];
                                    System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.length);
                                    final String data = new String(encodedBytes, "US-ASCII");
                                    readBufferPosition = 0;

                                    handler.post(new Runnable()
                                    {
                                        public void run()
                                        {
                                            tv51.setText(data);
                                        }
                                    });
                                }
                                else
                                {
                                    readBuffer[readBufferPosition++] = b;
                                }
                            }
                        }
                    }
                    catch (IOException ex)
                    {
                        stopWorker = true;
                    }
                }
            }
        });

        workerThread.start();
    }

    void sendData() throws IOException
    {
       /* String msg = myTextbox.getText().toString();
        msg += "\n";
        mmOutputStream.write(msg.getBytes());*/
        Toast.makeText(MainActivity5.this, "Data Sent", Toast.LENGTH_LONG).show();
    }

    void closeBT() throws IOException
    {
        stopWorker = true;
        ConsoleHandler mmOutputStream = null;
        mmOutputStream.close();
        mmInputStream.close();
        mmSocket.close();
        Toast.makeText(MainActivity5.this, "Bluetooth Closed", Toast.LENGTH_LONG).show();
    }

}
