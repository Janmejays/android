package com.example.janmejay.meete.controller.people;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.janmejay.meete.R;
import com.example.janmejay.meete.helper.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EveryoneFragment extends Fragment {

    private RecyclerView recyclerView;
    private EveryoneRecyclerAdapter everyoneRecyclerAdapter;


    public EveryoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_everyone, container, false);

        recyclerView=view.findViewById(R.id.rv_everyone);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        everyoneRecyclerAdapter= new EveryoneRecyclerAdapter();
        recyclerView.setAdapter(everyoneRecyclerAdapter);
        return view;
    }

}
