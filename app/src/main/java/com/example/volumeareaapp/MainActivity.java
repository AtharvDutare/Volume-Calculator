package com.example.volumeareaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    //data source ArrayList<Shape>
    ArrayList<Shape> shapeArrayList;
    //adapter
    MyCustomAdaptor adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridView);
        shapeArrayList=new ArrayList<>();
        Shape shape1=new Shape(R.drawable.cube,"cube");
        Shape shape2=new Shape(R.drawable.cylinder,"Cylinder");
        Shape shape3=new Shape(R.drawable.prism,"Prism");
        Shape shape4=new Shape(R.drawable.sphere,"shpere");
        shapeArrayList.add(shape1);
        shapeArrayList.add(shape2);
        shapeArrayList.add(shape3);
        shapeArrayList.add(shape4);


        adaptor=new MyCustomAdaptor(shapeArrayList,getApplicationContext());
        gridView.setAdapter(adaptor);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(), sphere.class);
                startActivity(i);
            }
        });

    }
}