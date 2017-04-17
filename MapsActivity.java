package com.example.vecmo.ivec;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Button bt1;

        bt1=(Button)findViewById(R.id.button6) ;

        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final Intent mainIntent = new Intent(MapsActivity.this, MainActivity5.class);
                MapsActivity.this.startActivity(mainIntent);
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Vecmocon Technologies
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(new LatLng(28.543513,77.191692)).title("Marker at Vecmocon Technologies Pvt Ltd"));
        mMap.moveCamera(CameraUpdateFactory.zoomIn());
        LatLng currentLocation = new LatLng(28.543513,77.191692);
        //LatLng newLocation = new LatLng(28.5392766,77.3445384);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,17));
        //mMap.moveCamera();


    }
}
