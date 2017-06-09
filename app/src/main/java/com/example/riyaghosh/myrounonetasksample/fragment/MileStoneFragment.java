package com.example.riyaghosh.myrounonetasksample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riyaghosh.myrounonetasksample.R;
import com.example.riyaghosh.myrounonetasksample.adapter.ImageRecyclerviewadapter;

/**
 * Created by Riya Ghosh on 09-06-2017.
 */

public class MileStoneFragment extends Fragment {
    RecyclerView my_image_recycler_view;
    private ImageRecyclerviewadapter imageRecyclerviewadapter;
    private LinearLayoutManager imageLayoutManager;
    public MileStoneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.milestone_tab_layout, container, false);
        my_image_recycler_view= (RecyclerView) view.findViewById(R.id.my_image_recycler_view);
        imageLayoutManager = new LinearLayoutManager(getActivity());
        my_image_recycler_view.setLayoutManager(imageLayoutManager);
        imageRecyclerviewadapter=new ImageRecyclerviewadapter(getActivity());
        my_image_recycler_view.setAdapter(imageRecyclerviewadapter);
        return view;
    }
}
