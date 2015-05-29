package com.example.mapmarker;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity
        implements OnMapReadyCallback {

    private LatLng mLatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);

        String dlugoscGeo = getIntent().getExtras().getString("map_bundle_dlugosc");
        String szerokoscGeo = getIntent().getExtras().getString("map_bundle_szerokosc");

        mLatLng = new LatLng(Double.valueOf(szerokoscGeo), Double.valueOf(dlugoscGeo));

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().position(mLatLng));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(mLatLng));
    }
}
