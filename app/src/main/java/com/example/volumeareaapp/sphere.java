package com.example.volumeareaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sphere extends AppCompatActivity {
    EditText sphere_radius;
    TextView title, result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        sphere_radius=findViewById(R.id.sphere_radius);
        title =findViewById(R.id.textView2);
        result=findViewById(R.id.textView3);

        btn=findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius =sphere_radius.getText().toString();
                // in edit text getText and setText are the method are used as getter and setter
                int r=Integer.parseInt(radius);

                double volume=(4/3)*3.14*(r*r*r);

                result.setText(" V= "+volume+" m^3");



            }
        });



    }
}