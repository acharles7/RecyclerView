package com.example.charles.lab2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View myView = inflater.inflate(R.layout.home_fragment,container,false);

        initData();

        RecyclerView recyclerView = (RecyclerView) myView.findViewById(R.id.recycleView);
        ListAdapter listAdapter = new ListAdapter(mImageUrls, mNames,getContext());
        Log.d(TAG, "onCreateView: before setListAdapter");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(listAdapter);
        Log.d(TAG, "onCreateView: After setListAdapter");
        return myView;
    }

    private void initData(){
        //Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://scontent-sjc3-1.xx.fbcdn.net/v/t31.0-8/22792405_1823705877658683_7257591843292910154_o.jpg?_nc_cat=0&oh=35b2d031134fcf0d269a3c551f024ead&oe=5C236052");
        mNames.add("Charles Patel");

        mImageUrls.add("https://orig00.deviantart.net/4934/f/2012/124/5/6/toderici_nicoleta_by_mixmyphotoshop-d4yk2yz.jpg");
        mNames.add("Havasu Falina");

        mImageUrls.add("https://ctd-thechristianpost.netdna-ssl.com/en/full/34885/dwayne-johnson-the-rock.jpg?w=347&h=237");
        mNames.add("The Rock");

        mImageUrls.add("https://pbs.twimg.com/profile_images/822547732376207360/5g0FC8XX_400x400.jpg");
        mNames.add("B. Obama");

        mImageUrls.add("https://i.pinimg.com/originals/db/f6/b6/dbf6b6d0ddef3f40af8cedf1d89d9635.jpg");
        mNames.add("Zayen Vardey");


        mImageUrls.add("https://dialogueireland.files.wordpress.com/2013/03/tc-g.jpg");
        mNames.add("Tom Cruise");

        mImageUrls.add("https://www.quickanddirtytips.com/sites/default/files/styles/host_in_header/public/Laura%20Adams%20Headshot%20-%20Final.png?itok=kZgayt_x");
        mNames.add("B. Cumberwitch");


        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg");
        mNames.add("Narendra Modi");

        mImageUrls.add("https://i2-prod.mirror.co.uk/incoming/article3274395.ece/ALTERNATES/s615/Zac-Efron.jpg");
        mNames.add("Zac Effron");

        mImageUrls.add("https://beaconstreetusa.com/wp/wp-content/uploads/2016/09/04-billgates.jpg");
        mNames.add("Bill Gates");

        //initRecyclerView();
    }



}
