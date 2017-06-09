package com.example.riyaghosh.myrounonetasksample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.riyaghosh.myrounonetasksample.R;

/**
 * Created by Riya Ghosh on 09-06-2017.
 */

public class ImageRecyclerviewadapter extends RecyclerView.Adapter<ImageRecyclerviewadapter.ViewHolder>{

    String[] SubjectValues;
    Context context;
    View view1;
    ImageRecyclerviewadapter.ViewHolder viewHolder1;
    TextView textView;
    int width;
    int height;

    public ImageRecyclerviewadapter(Context context1){

        // SubjectValues = SubjectValues1;

        context = context1;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;

    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public LinearLayout layout;

        public ViewHolder(View v){

            super(v);


            //  textView = (TextView)v.findViewById(R.id.subject_textview);
//            layout=(LinearLayout)v.findViewById(R.id.row_layout);
//            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams((width/3),
//                    LinearLayout.LayoutParams.WRAP_CONTENT);
//            layout.setLayoutParams(lp);

        }
    }

    @Override
    public ImageRecyclerviewadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        view1 = LayoutInflater.from(context).inflate(R.layout.image_card_layout,parent,false);
        //view1.setLayoutParams(new RecyclerView.LayoutParams(width/3, height));
        viewHolder1 = new ImageRecyclerviewadapter.ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ImageRecyclerviewadapter.ViewHolder holder, int position){

        //     holder.textView.setText(SubjectValues[position]);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

//    @Override
//    public int getItemCount(){
//
////        return SubjectValues.length;
//    }
}

