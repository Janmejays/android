package com.example.janmejay.meete.controller.Home;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.janmejay.meete.R;
import com.example.janmejay.meete.controller.map.MapsActivity;
import com.example.janmejay.meete.controller.map.mapFragment;

public class mainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.rl_container,new mapFragment());
        ft.commit();
    }

    public void btnMap(View view) {
        startActivity(new Intent(this, MapsActivity.class));
    }
}
