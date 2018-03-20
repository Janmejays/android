package com.example.janmejay.meete.controller.map;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.janmejay.meete.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class mapFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mGooglemap;

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


        mGooglemap = googleMap;


        // Add a marker in Sydney and move the camera
        float zoomLevel = (float) 13;
        LatLng IndiaGate = new LatLng(28.612912, 77.229510);
        LatLng RajGhat = new LatLng(28.640621, 77.249500);
        LatLng PuranaQila = new LatLng(28.609574, 77.243737);
        mGooglemap.addMarker(new MarkerOptions().position(RajGhat).title("Raj Ghat").snippet("i am in Rajghat").icon(BitmapDescriptorFactory.fromResource(R.mipmap.raj_round)));
        mGooglemap.addMarker(new MarkerOptions().position(IndiaGate).title("India Gate").icon(BitmapDescriptorFactory.fromResource(R.mipmap.india_gate_round)));
        mGooglemap.addMarker(new MarkerOptions().position(PuranaQila).title("Purana Qila").icon(BitmapDescriptorFactory.fromResource(R.mipmap.pq_round)));
        mGooglemap.moveCamera(CameraUpdateFactory.newLatLngZoom(RajGhat, zoomLevel));


        if ((mGooglemap != null)) {
            mGooglemap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View view = getLayoutInflater().inflate(R.layout.map_icon, null);
                    TextView tvTitle = view.findViewById(R.id.tv_title);
                    ImageView ivLocation = view.findViewById(R.id.iv_location);
                    // LatLng ll=marker.getPosition();
                    tvTitle.setText(marker.getTitle());
                    if (marker.getTitle().equals("Raj Ghat")) {
                        ivLocation.setImageResource(R.mipmap.raj_round);
                    } else if (marker.getTitle().equals("India Gate")) {
                        ivLocation.setImageResource(R.mipmap.india_gate_round);
                    } else if (marker.getTitle().equals("Purana Qila")) {
                        ivLocation.setImageResource(R.mipmap.pq_round);
                    }
                    //  ivLocation.setImageResource(R.mipmap.raj_round);
                    return view;
                }
            });
        }


    }
}

