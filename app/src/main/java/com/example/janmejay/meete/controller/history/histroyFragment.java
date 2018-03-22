package com.example.janmejay.meete.controller.history;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.janmejay.meete.R;
import com.example.janmejay.meete.helper.MyRecycleAdapter;

public class histroyFragment extends Fragment {
     private RecyclerView recyclerView;
     private historyRecyclerAdapter hRecycler;

    public histroyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_histroy, container, false);

        recyclerView=view.findViewById(R.id.rv_history);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), numberOfColumns));
        hRecycler= new historyRecyclerAdapter();
        recyclerView.setAdapter(hRecycler);
        return view;
    }

}
