package com.example.volumeareaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdaptor extends ArrayAdapter<Shape> {
    private ArrayList<Shape> arrayList;
    Context context;
     //Interface to global information about an application environment
    // used to access resourse globally



    public MyCustomAdaptor(ArrayList<Shape> arrayList, Context context) {
        super(context, R.layout.grid_item_layout,arrayList);
        // base class of ArrayAdapter and we use super of call parameter constructor
        this.arrayList = arrayList;
        this.context = context;
    }

    private static class MyViewHolder{
        TextView shapeName;
        ImageView shapeImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Shape shape =getItem(position);
        MyViewHolder myViewHolder;

        if(convertView==null){
            myViewHolder=new MyViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false
            );
            myViewHolder.shapeImage=(ImageView) convertView.findViewById(R.id.imageView);
            myViewHolder.shapeName=(TextView) convertView.findViewById(R.id.shapeName);


            convertView.setTag(myViewHolder);

        }
        else{
//            a view went off screen -->re use it
                myViewHolder=(MyViewHolder)convertView.getTag();


        }

//        getting the data from modal class(shape)
        myViewHolder.shapeName.setText(shape.getName());
        myViewHolder.shapeImage.setImageResource(shape.getImage());

        return convertView;
    }
}
