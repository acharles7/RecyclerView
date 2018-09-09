package com.example.charles.lab2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private static final String TAG = "ListAdapter";

    private ArrayList<String> mImg = new ArrayList<>();
    private ArrayList<String> mImg_name = new ArrayList<>();
    private Context mContext;

    public ListAdapter(ArrayList<String> mImg, ArrayList<String> mImg_name, Context mContext) {
        this.mImg = mImg;
        this.mImg_name = mImg_name;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        @SuppressLint("ResourceType")
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Log.d(TAG, "onBindViewHolder: called.");


        Glide.with(mContext)
                .asBitmap()
                .load(mImg.get(i))
                .into(holder.img1);
        holder.textView.setText(mImg_name.get(i));
        //holder.img.setImageURI(Uri.parse(mImg.get(i)));
                
    }

    @Override
    public int getItemCount() {
        return mImg.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img1;
        TextView textView, subTitle;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.img_name);
            subTitle = itemView.findViewById(R.id.extra);
            relativeLayout = itemView.findViewById(R.id.list_layout);
        }
    }
}