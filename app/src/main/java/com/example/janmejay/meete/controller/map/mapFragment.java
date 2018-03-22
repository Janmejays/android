package com.example.janmejay.meete.controller.map;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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
import com.example.janmejay.meete.controller.login.LoginActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class mapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private GoogleMap mGooglemap;
    Context context;
    private boolean clickflag = false;
    Map<String, Integer> markerHashMap = new HashMap<>();
    private int count = 0;

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

    // getting  context
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        mGooglemap = googleMap;


        // Add a marker in Sydney and move the camera
        float zoomLevel = 13.8f;
        LatLng IndiaGate = new LatLng(28.612912, 77.229510);
        LatLng RajGhat = new LatLng(28.640621, 77.249500);
        LatLng PuranaQila = new LatLng(28.609574, 77.243737);
        markerHashMap.put("Raj Ghat", R.mipmap.raj_round);
        markerHashMap.put("India Gate", R.mipmap.india_gate);
        markerHashMap.put("Purana Qila", R.mipmap.purana);
        mGooglemap.addMarker(new MarkerOptions().position(RajGhat).title("Raj Ghat").icon(BitmapDescriptorFactory.fromBitmap(setmarkerimage(R.mipmap.raj_round, clickflag, "RajGhat"))));
        mGooglemap.addMarker(new MarkerOptions().position(IndiaGate).title("India Gate").icon(BitmapDescriptorFactory.fromBitmap(setmarkerimage(R.mipmap.india_gate, clickflag, "India Gate"))));
        mGooglemap.addMarker(new MarkerOptions().position(PuranaQila).title("Purana Qila").icon(BitmapDescriptorFactory.fromBitmap(setmarkerimage(R.mipmap.purana, clickflag, "Purana Qila"))));
        mGooglemap.moveCamera(CameraUpdateFactory.newLatLngZoom(IndiaGate, zoomLevel));
        mGooglemap.getUiSettings().setCompassEnabled(false);
        mGooglemap.getUiSettings().setZoomControlsEnabled(false);
        mGooglemap.getUiSettings().setRotateGesturesEnabled(false);
        mGooglemap.setOnMarkerClickListener(this);

    }


    public boolean onMarkerClick(Marker marker) {


        if (clickflag != true && count == 0) {
            clickflag = true;
            count++;
        } else {
            clickflag = false;
            count = 0;
        }
        int i = R.layout.map_icon;
        marker.setIcon(BitmapDescriptorFactory.fromBitmap(setmarkerimage(markerHashMap.get(marker.getTitle()), clickflag, marker.getTitle())));
        return false;
    }


    private Bitmap setmarkerimage(Integer map_icon, boolean clickflag, String title) {


        View customMarkerView;
        TextView tv_viewDetails;
        ImageView ivpic;
        if (clickflag) {
            customMarkerView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.map_icon, null);
            ivpic = customMarkerView.findViewById(R.id.iv_location_icon);
            ivpic.setImageResource(map_icon);
            ivpic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(context, LoginActivity.class));
                }
            });
            tv_viewDetails = customMarkerView.findViewById(R.id.tv_title_icon);
            tv_viewDetails.setText(title);
            tv_viewDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(context, LoginActivity.class));
                }
            });
        } else {
            customMarkerView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.map_no_text, null);
            ivpic = customMarkerView.findViewById(R.id.iv_location_no_text);
            ivpic.setImageResource(map_icon);
        }
        ivpic.setImageResource(map_icon);
        customMarkerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        customMarkerView.layout(0, 0, customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight());
        customMarkerView.buildDrawingCache();
        Bitmap returnedBitmap = Bitmap.createBitmap(customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = customMarkerView.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        customMarkerView.draw(canvas);
        return returnedBitmap;
    }

}






