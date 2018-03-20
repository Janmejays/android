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
public class FriendFragment extends Fragment {
    private ArrayList<User> UserArrayList;
    private RecyclerView recyclerView;
    private FriendRecyclerAdapter friendRecyclerAdapter;

    public FriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_friend, container, false);
        UserArrayList= getUserList();
        recyclerView=view.findViewById(R.id.rv_friend);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        friendRecyclerAdapter= new FriendRecyclerAdapter(UserArrayList);
        recyclerView.setAdapter(friendRecyclerAdapter);
        return view;
    }
    public ArrayList<User> getUserList() {
        ArrayList<User> UserArrayList = new ArrayList<>();
        User User1 = new User("Raj Ghat", "10 km", "Delhi");
        User User2 = new User("India Gate", "15 km", "New Delhi");
        User User3 = new User("Purana Qila", "16 km", "New Delhi");

        UserArrayList.add(User1);
        UserArrayList.add(User2);
        UserArrayList.add(User3);
        return UserArrayList;
    }
}
