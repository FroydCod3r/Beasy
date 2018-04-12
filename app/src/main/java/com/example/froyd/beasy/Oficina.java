package com.example.froyd.beasy;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Oficina extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficina);

        carregarmapa();

    }


    public void carregarmapa() {

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @SuppressLint("MissingPermission")
            @Override
            public void onMapReady(GoogleMap map) {

                LatLng oficina1 = new LatLng(-25.443150, -49.238243);
                map.addMarker(new MarkerOptions().position(oficina1).title("Oficina do jailson"));
                map.moveCamera(CameraUpdateFactory.newLatLng(oficina1));
                map.setMinZoomPreference(11.5f);
                map.setMaxZoomPreference(14.0f);

                map.setMyLocationEnabled(true);


            }
        });


    }


    @Override
    public void onMapReady (GoogleMap googleMap){

    }
}
