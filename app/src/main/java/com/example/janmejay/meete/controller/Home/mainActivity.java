package com.example.janmejay.meete.controller.Home;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.janmejay.meete.R;
import com.example.janmejay.meete.controller.history.histroyFragment;
import com.example.janmejay.meete.controller.map.mapFragment;
import com.example.janmejay.meete.controller.people.peopleFragment;
import com.example.janmejay.meete.helper.NearByFragment;

public class mainActivity extends AppCompatActivity {
    private ImageView ivMap;
    private ImageView ivListPlaces;
    private ImageView ivListPeople;
    private ImageView ivHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMap=findViewById(R.id.iv_map);
        ivListPlaces=findViewById(R.id.iv_list_places);
        ivMap.setImageResource(R.mipmap.map_ac);
        ivListPeople=findViewById(R.id.iv_list_people);
        ivHistory=findViewById(R.id.iv_history);
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.add(R.id.rl_container,new mapFragment());
        ft.commit();
    }


    public void btnNearBy(View view) {

        ivListPlaces.setImageResource(R.mipmap.list_ac);
        ivMap.setImageResource(R.mipmap.map);
        ivHistory.setImageResource(R.mipmap.hist);
        ivListPeople.setImageResource(R.mipmap.group);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rl_container, new NearByFragment());
        ft.commit();


    }

    public void btnClickMap(View view) {
        ivListPlaces.setImageResource(R.mipmap.list);
        ivMap.setImageResource(R.mipmap.map_ac);
        ivHistory.setImageResource(R.mipmap.hist);
        ivListPeople.setImageResource(R.mipmap.group);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rl_container, new mapFragment());
        ft.commit();
    }

    public void btnlistpeople(View view) {
        ivListPlaces.setImageResource(R.mipmap.list);
        ivMap.setImageResource(R.mipmap.map);
        ivHistory.setImageResource(R.mipmap.hist);
        ivListPeople.setImageResource(R.mipmap.group_ac);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rl_container, new peopleFragment());
        ft.commit();
    }

    public void btnHistory(View view) {
        ivListPlaces.setImageResource(R.mipmap.list);
        ivMap.setImageResource(R.mipmap.map);
        ivHistory.setImageResource(R.mipmap.hist_ac);
        ivListPeople.setImageResource(R.mipmap.group);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rl_container, new histroyFragment());
        ft.commit();

    }


}
