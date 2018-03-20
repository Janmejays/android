package com.example.janmejay.meete.helper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.janmejay.meete.R;

import java.util.ArrayList;

/**
 * Created by fluper on 14/3/18.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyholderView> {

    ArrayList<User> userArrayList;

    public MyRecycleAdapter(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
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
        return 6;
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