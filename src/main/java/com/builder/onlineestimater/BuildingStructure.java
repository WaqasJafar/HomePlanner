package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class BuildingStructure extends AppCompatActivity {
TextView squarecalculate,kitcheninteger_number,roominteger_number,bathinteger_number,tvinteger_number,garageinteger_number,alertestimate;
EditText kitchenl,kitchenw,rooml,roomw,bathl,bathw,tvl,tvw,garagel,garagew;
Button roomdecrease,roomincrease,kitchendecrease,kitchenincrease,bathdecrease,bathincrease,tvincrease,tvdecrese,garageincrease,garagedecrease,estimate,btnafterestimate;
    public static final String My_Estimator_name="MyEstimator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_structure);
        squarecalculate=findViewById(R.id.squarecalculate);
        roomdecrease=findViewById(R.id.roomdecrease);
        roomincrease=findViewById(R.id.roomincrease);
        kitchendecrease=findViewById(R.id.kitchendecrease);
        kitchenincrease=findViewById(R.id.kitchenincrease);
        roominteger_number=findViewById(R.id.roominteger_number);
        kitcheninteger_number=findViewById(R.id.kitcheninteger_number);
        bathinteger_number=findViewById(R.id.bathroominteger_number);
        tvinteger_number=findViewById(R.id.tvinteger_number);
        garageinteger_number=findViewById(R.id.garageinteger_number);
        bathdecrease=findViewById(R.id.bathroomdecrease);
        bathincrease=findViewById(R.id.bathroomincrease);
        tvdecrese=findViewById(R.id.tvdecrease);
        tvincrease=findViewById(R.id.tvincrease);
        garagedecrease=findViewById(R.id.garagedecrease);
        garageincrease=findViewById(R.id.garageincrease);
        estimate=findViewById(R.id.estimate);
        kitchenl=findViewById(R.id.kitchenlength);
        kitchenw=findViewById(R.id.kitchenwidth);
        rooml=findViewById(R.id.roomlength);
        roomw=findViewById(R.id.roomwidth);
        bathl=findViewById(R.id.bathroomlength);
        bathw=findViewById(R.id.bathroomwidth);
        garagel=findViewById(R.id.garagelength);
        garagew=findViewById(R.id.garagewidth);
        tvl=findViewById(R.id.tvlength);
        tvw=findViewById(R.id.tvwidth);
        alertestimate=findViewById(R.id.alertestimate);
        btnafterestimate=findViewById(R.id.btnafterestimate);


        SharedPreferences preferences =BuildingStructure.this.getSharedPreferences(My_Estimator_name, Context.MODE_PRIVATE);
       int plotsquare=preferences.getInt("plotsquare",0);
        String plotsquarefeet=String.valueOf(plotsquare);
        Toast.makeText(this, ""+plotsquare, Toast.LENGTH_SHORT).show();
        squarecalculate.setText("Total Square Feet: "+plotsquarefeet);


        roomincrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int roominteger=Integer.parseInt(roominteger_number.getText().toString());
                int increase=roominteger+1;
                String increment=String.valueOf(increase);
                roominteger_number.setText(increment);
            }
        });

        roomdecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int roominteger=Integer.parseInt(roominteger_number.getText().toString());
                if (roominteger>0){
                    int increase=roominteger-1;
                    String increment=String.valueOf(increase);
                    roominteger_number.setText(increment);
                }
                else{
                    Toast.makeText(BuildingStructure.this, "Room Value is Already 0", Toast.LENGTH_SHORT).show();
                }

            }
        });

        kitchendecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int kicheninteger=Integer.parseInt(kitcheninteger_number.getText().toString());
                if (kicheninteger>0){
                    int increase=kicheninteger-1;
                    String increment=String.valueOf(increase);
                    kitcheninteger_number.setText(increment);
                }
                else{
                    Toast.makeText(BuildingStructure.this, "Kitchen Value is Already 0", Toast.LENGTH_SHORT).show();
                }
            }
        });

        kitchenincrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kicheninteger=Integer.parseInt(kitcheninteger_number.getText().toString());
                int increase=kicheninteger+1;
                String increment=String.valueOf(increase);
                kitcheninteger_number.setText(increment);
            }
        });

        bathincrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bathinteger=Integer.parseInt(bathinteger_number.getText().toString());
                int increase=bathinteger+1;
                String increment=String.valueOf(increase);
                bathinteger_number.setText(increment);
            }
        });

        bathdecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int bathinteger=Integer.parseInt(bathinteger_number.getText().toString());
                if (bathinteger>0){
                    int increase=bathinteger-1;
                    String increment=String.valueOf(increase);
                    bathinteger_number.setText(increment);
                }
                else{
                    Toast.makeText(BuildingStructure.this, "Bathroom Value is Already 0", Toast.LENGTH_SHORT).show();
                }

            }
        });


        tvincrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tvinteger=Integer.parseInt(tvinteger_number.getText().toString());
                int increase=tvinteger+1;
                String increment=String.valueOf(increase);
                tvinteger_number.setText(increment);
            }
        });

        tvdecrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int tvinteger=Integer.parseInt(tvinteger_number.getText().toString());
                if (tvinteger>0){
                    int increase=tvinteger-1;
                    String increment=String.valueOf(increase);
                    tvinteger_number.setText(increment);
                }
                else{
                    Toast.makeText(BuildingStructure.this, "TV Value is Already 0", Toast.LENGTH_SHORT).show();
                }

            }
        });

        garageincrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int garageinteger=Integer.parseInt(garageinteger_number.getText().toString());
                int increase=garageinteger+1;
                String increment=String.valueOf(increase);
                garageinteger_number.setText(increment);
            }
        });

        garagedecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int garageinteger=Integer.parseInt(garageinteger_number.getText().toString());
                if (garageinteger>0){
                    int increase=garageinteger-1;
                    String increment=String.valueOf(increase);
                    garageinteger_number.setText(increment);
                }
                else{
                    Toast.makeText(BuildingStructure.this, "Garage Value is Already 0", Toast.LENGTH_SHORT).show();
                }

            }
        });
        estimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               int roomleng=Integer.parseInt(rooml.getText().toString());
                int roomwid=Integer.parseInt(roomw.getText().toString());
                int roominteger=Integer.parseInt(roominteger_number.getText().toString());
                int roomtotal=roomleng*roomwid*roominteger;


                int kitchenleng=Integer.parseInt(kitchenl.getText().toString());
                int kitchenwid=Integer.parseInt(kitchenw.getText().toString());
                int kitcheninteger=Integer.parseInt(kitcheninteger_number.getText().toString());
                int kitchentotal=kitchenleng*kitchenwid*kitcheninteger;

                int tvleng=Integer.parseInt(tvl.getText().toString());
                int tvwid=Integer.parseInt(tvw.getText().toString());
                int tvinteger=Integer.parseInt(tvinteger_number.getText().toString());
                int tvtotal=tvleng*tvwid*tvinteger;

                int bathleng=Integer.parseInt(bathl.getText().toString());
                int bathnwid=Integer.parseInt(bathw.getText().toString());
                int bathinteger=Integer.parseInt(bathinteger_number.getText().toString());
                int bathtotal=bathleng*bathnwid*bathinteger;


                int garageleng=Integer.parseInt(garagel.getText().toString());
                int garagewid=Integer.parseInt(garagew.getText().toString());
                int garageinteger=Integer.parseInt(garageinteger_number.getText().toString());
                int garagetotal=garageleng*garagewid*garageinteger;


                int alltotal=roomtotal+kitchentotal+tvtotal+bathtotal+garagetotal;


                if (alltotal>plotsquare){
                alertestimate.setText("Your Estimated Square feet More Than Actual");
                btnafterestimate.setEnabled(false);
                }

                else {
                    btnafterestimate.setEnabled(true);
                }
            }
        });


        btnafterestimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuildingStructure.this, "Working ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}