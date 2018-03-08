package com.example.janmejay.meete.controller.map;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.janmejay.meete.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class mapFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    public mapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_map, container, false);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        SupportMapFragment fragment = new SupportMapFragment();
        transaction.add(R.id.mapView, fragment);
        transaction.commit();
        fragment.getMapAsync(this);
        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        float zoomLevel = (float) 12.7;
        LatLng  IndiaGate=new LatLng(28.612912 , 77.229510);
        LatLng RajGhat=new LatLng(28.640621 ,77.249500);
        LatLng PuranaQila=new LatLng(28.609574,77.243737);
        mMap.addMarker(new MarkerOptions().position(RajGhat).title("Raj Ghat").icon(BitmapDescriptorFactory.fromResource(R.mipmap.rajghat)));
        mMap.addMarker(new MarkerOptions().position(IndiaGate).title("India Gate").icon(BitmapDescriptorFactory.fromResource(R.mipmap.indiagate)));
        mMap.addMarker(new MarkerOptions().position(PuranaQila).title("Purana Qila").icon(BitmapDescriptorFactory.fromResource(R.mipmap.purana)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(RajGhat,zoomLevel));

    }
}

