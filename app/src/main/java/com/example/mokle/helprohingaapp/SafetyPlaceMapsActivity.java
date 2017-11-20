package com.example.mokle.helprohingaapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SafetyPlaceMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String[] latList;
    String[] lngList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_place_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //latList = getResources().getStringArray(R.array.latList);
        //lngList = getResources().getStringArray(R.array.longList);

//        for (int i =0; i<latList.length; i++){
//            for (int j =i; j<=i; j++) {
//
//                double tmp1 = Double.parseDouble(latList[i]);
//                double tmp2 = Double.parseDouble(lngList[j]);
//                LatLng sydney = new LatLng(tmp1, tmp2);
//                addMarker(sydney);
//            }
//        }
        addMarker(new LatLng(23.783726,90.344246));

    }
    public void addMarker (LatLng latLng){
        mMap.addMarker(new MarkerOptions().position(latLng).title("ROHINGGA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }
}
