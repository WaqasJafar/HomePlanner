package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
LinearLayout Estimator, Contractor,materialcalculator,material,store;
    public static final String My_Estimator_name="MyEstimator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Estimator=findViewById(R.id.estimater);
        Contractor=findViewById(R.id.contractor);
        materialcalculator=findViewById(R.id.materialcalculator);
        material=findViewById(R.id.material);
        store=findViewById(R.id.store);

        SharedPreferences editor=getSharedPreferences(My_Estimator_name,MODE_PRIVATE);

        editor.edit().clear().commit();

        Estimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,EstimatorMarla.class);
                startActivity(intent);
            }
        });


        Contractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Contractor.class);
                startActivity(intent);
            }
        });

        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,MaterialPrice.class);
                startActivity(intent);
            }
        });


        materialcalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MaterialCalculatorPage.class);
                startActivity(intent);
            }
        });

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,StorePage.class);
                startActivity(intent);
            }
        });


    }
}