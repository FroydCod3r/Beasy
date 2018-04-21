package com.example.froyd.beasy;

import android.annotation.SuppressLint;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class Oficina extends AppCompatActivity implements OnMapReadyCallback {
    public FusedLocationProviderClient mFusedLocationClient;


    public LatLng myloc;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficina);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        final LatLng myloc = new LatLng(location.getLatitude(), location.getLongitude());
                        carregarmapa(myloc);

                        if (location != null) {
                            // Logic to handle location object
                        }
                    }
                });



    }



    public void carregarmapa(final LatLng myloc) {

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @SuppressLint("MissingPermission")
            @Override
            public void onMapReady(GoogleMap map) {

                LatLng oficina1 = new LatLng(-25.443150, -49.238243);
                map.addMarker(new MarkerOptions().position(oficina1).title("Oficina do jailson"));
                map.moveCamera(CameraUpdateFactory.newLatLng(myloc));
                map.setMinZoomPreference(11.5f);
                map.setMaxZoomPreference(14.0f);

                map.setMyLocationEnabled(true);









            }
        });


    }


    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady (final GoogleMap googleMap){

    }


}
