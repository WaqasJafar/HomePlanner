package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Contractordashbourd extends AppCompatActivity {
LinearLayout Reviews;
CardView cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractordashbourd);
        Reviews.findViewById(R.id.linearreview);
//        cardView=findViewById(R.id.cardreview);



    }
}