package com.example.janmejay.meete.controller.Home;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.janmejay.meete.R;
import com.example.janmejay.meete.controller.map.MapsActivity;
import com.example.janmejay.meete.controller.map.mapFragment;
import com.example.janmejay.meete.controller.people.peopleFragment;
import com.example.janmejay.meete.helper.NearByFragment;

public class mainActivity extends AppCompatActivity {
    private ImageView ivMap;
    private ImageView ivListPlaces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMap=findViewById(R.id.iv_map);
        ivListPlaces=findViewById(R.id.iv_list_places);
        ivMap.setImageResource(R.mipmap.map_ac);
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.add(R.id.rl_container,new mapFragment());
        ft.commit();
    }


    public void btnNearBy(View view) {

        ivListPlaces.setImageResource(R.mipmap.list_ac);
        ivMap.setImageResource(R.mipmap.map);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //ft.replace(R.id.rl_container,new mapFragment());
        ft.replace(R.id.rl_container, new NearByFragment());
        ft.commit();


    }

    public void btnClickMap(View view) {
        ivMap.setImageResource(R.mipmap.map_ac);
        ivListPlaces.setImageResource(R.mipmap.list);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rl_container, new mapFragment());
        ft.commit();
    }

    public void btnlistpeople(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rl_container, new peopleFragment());
        ft.commit();
    }
}
