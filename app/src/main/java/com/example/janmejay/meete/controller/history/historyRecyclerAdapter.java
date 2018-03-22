package com.example.janmejay.meete.controller.history;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.janmejay.meete.R;
import com.example.janmejay.meete.helper.User;

import java.util.ArrayList;

/**
 * Created by fluper on 14/3/18.
 */
public class historyRecyclerAdapter extends RecyclerView.Adapter<historyRecyclerAdapter.MyholderView> {



    public historyRecyclerAdapter() {

    }

    @Override
    public MyholderView onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_single_row,
                parent,false);

        return new MyholderView(view);
    }

    @Override
    public void onBindViewHolder(MyholderView holder, int position) {
        /*User user= userArrayList.get(position);
        holder.tvName.setText(user.getName());
        holder.tvContact.setText(user.getContact());
        holder.tvAddress.setText(user.getAddress());*/
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyholderView extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvContact;
        private TextView tvAddress;

        public MyholderView(View itemView) {
            super(itemView);

        }
    }



}