package com.example.charles.lab2;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

public class ClistAdapter extends RecyclerView.Adapter<ClistAdapter.ViewHolder>{
    private static final String TAG = "ListAdapter";
    private final List<CData> clist;


    public ClistAdapter(List<CData> clist) {

        this.clist = clist;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: In onCreayeViewHolder");
        @SuppressLint("ResourceType")
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.clist_item,viewGroup, false);
        ClistAdapter.ViewHolder holder = new ClistAdapter.ViewHolder(view);

        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull ClistAdapter.ViewHolder holder, int i) {
        Log.d(TAG, "onBindViewHolder: called.");

            String name = clist.get(i).getName();
            String nickname = clist.get(i).getNick_name();
            String country = clist.get(i).getCountry();

            holder.name.setText(name);
            holder.nickname.setText(nickname);
            holder.country.setText(country);

    }



    @Override
    public int getItemCount() {
        return clist.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView name, nickname, country;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.cname);
            nickname = itemView.findViewById(R.id.cnick);
            country = itemView.findViewById(R.id.country);
            relativeLayout = itemView.findViewById(R.id.clist_layout);

            name.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    Snackbar snackbar = Snackbar.make(view,name.getText().toString()+" || "+country.getText().toString(),Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            });


        }
    }
}
