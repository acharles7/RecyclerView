package com.example.charles.lab2;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class LikeFragment extends Fragment {

    ChaDbSchema chaDbSchema;
    TextView tx1,tx2,tx3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ChaDbSchema chaDbSchema = new ChaDbSchema(getContext());

        List<CData> clist = chaDbSchema.allData();


        View myView = inflater.inflate(R.layout.like_fragment,container,false);

        RecyclerView recyclerView = (RecyclerView) myView.findViewById(R.id.recycleView);
        ClistAdapter clistAdapter = new ClistAdapter(clist);
        Log.d(TAG, "onCreateView: before setListAdapter");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(clistAdapter);
        Log.d(TAG, "onCreateView: After setListAdapter");

        return myView;



    }
}
