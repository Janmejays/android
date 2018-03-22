package com.example.janmejay.meete.controller.people;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.janmejay.meete.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class peopleFragment extends Fragment {
   private FragmentManager fm;
   private ViewPager viewPager;
   private TabLayout tabLayout;
   private TextView tvToolbarHeading;
    public peopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_people, container, false);

        tabLayout=view.findViewById(R.id.tab_layout_people);
        viewPager=view.findViewById(R.id.view_pager_people);
        fm= getActivity().getSupportFragmentManager();
        TabAdapter tabAdapter=new TabAdapter(fm);
        tabAdapter.addTabs(new EveryoneFragment(),"Everyone");
        tabAdapter.addTabs(new FriendFragment(),"My Friend");
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

}
