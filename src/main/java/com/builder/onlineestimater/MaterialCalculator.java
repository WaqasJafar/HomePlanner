package com.builder.onlineestimater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MaterialCalculator extends AppCompatActivity {
TextView cement,brick,sand,btnprice,ironroads,bajri;

public static final String My_Estimator_name="MyEstimator";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_calculator);
        brick=findViewById(R.id.brick);
        cement=findViewById(R.id.cement);
        sand=findViewById(R.id.sand);
        btnprice=findViewById(R.id.btnprice);
        ironroads=findViewById(R.id.ironroad);
        bajri=findViewById(R.id.bajri);


        SharedPreferences preferences =MaterialCalculator.this.getSharedPreferences(My_Estimator_name, Context.MODE_PRIVATE);
       int floor1brick= preferences.getInt("firstfloorbrick", 0);
        int floor1cement= preferences.getInt("firstfloorcement", 0);
        int floor1sand= preferences.getInt("firstfloorsand", 0);

        int floor2brick= preferences.getInt("groundfloorbrick", 0);
        int floor2cement= preferences.getInt("groundfloorcement", 0);
        int floor2sand= preferences.getInt("groundfloorsand", 0);

        int floor3brick= preferences.getInt("secoundfloorbrick", 0);
        int floor3cement= preferences.getInt("secoundfloorcement", 0);
        int floor3sand= preferences.getInt("secoundfloorsand", 0);
        int ironroad=preferences.getInt("ironroad",0);
        int cementmaterial=preferences.getInt("cementmaterial",0);
        int sandmaterial=preferences.getInt("sandmaterial",0);
        int bajrimaterial=preferences.getInt("bajrimaterial",0);


        int allbrick=floor1brick+floor2brick+floor3brick;
        int allcement=floor1cement+floor2cement+floor3cement+cementmaterial;
        int allsand=floor1sand+floor2sand+floor3sand+sandmaterial;

        brick.setText(""+allbrick);
        cement.setText(""+allcement);
        sand.setText(""+allsand);
        ironroads.setText(""+ironroad);
        bajri.setText(""+bajrimaterial);



        SharedPreferences.Editor editor=(SharedPreferences.Editor) getSharedPreferences(My_Estimator_name,MODE_PRIVATE).edit();
        editor.putInt("allbrick", (int) allbrick);
        editor.putInt("allcement",(int) allcement);
        editor.putInt("allsand",(int) allsand);


        editor.apply();

        btnprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MaterialCalculator.this,Priceofallmaterial.class);
                startActivity(intent);
            }
        });
    }
}