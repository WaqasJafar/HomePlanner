package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class firstfloor extends AppCompatActivity {

    Spinner floorheight,roomdrop,roomdrop2,roomdrop3,kitchendrop,tvdrop,bathdrop,garagedrop;
    public int room1sq,room2sq,room3sq,kitchensq,tvsq,garagesq, bathsq,height,floorheightpos,room1dim,room2dim,room3dim,room1total,room2total,room3total,kitchendim,kitchentotaldim,tvdim,tvtotaldim,bathdim,bathtotaldim,garagedim,garagetotaldim;

    LinearLayout garageportion;
   TextView squarecalculate,kitcheninteger_number,roominteger_number,bathinteger_number,tvinteger_number,garageinteger_number,alertestimate,floortxt,roominteger_number2,roominteger_number3;
    Button roomdecrease,roomincrease,kitchendecrease,kitchenincrease,bathdecrease,bathincrease,tvincrease,tvdecrese,garageincrease,garagedecrease,estimate,btnafterestimate,roomdecrease2,roomincrease2,roomdecrease3,roomincrease3;
    public static final String My_Estimator_name="MyEstimator";

    public static final String[] roomdimension = {"10 x 12", "12 x 12", "12 x 14","14 x 14","12 x 15","15 x 15","12 x 16","14 x 16"};
    public static final String[] roomdimension2 = {"10 x 12", "12 x 12", "12 x 14","14 x 14","12 x 15","15 x 15","12 x 16","14 x 16"};
    public static final String[] roomdimension3 = {"10 x 12", "12 x 12", "12 x 14","14 x 14","12 x 15","15 x 15","12 x 16","14 x 16"};
    public static final String[] kitchendimension = {"6 x 6", "6 x 8", "5 x 7","8 x 8","8 x 10"};
    public static final String[] tvdimension = {"8 x 10", "12 x 10", "15 x 10","18 x 12","20 x 16","20 x 18","20 x 15"};
    public static final String[] bathdimension = {"5 x 5", "6 x 6", "6 x 8","5 x 10","6 x 10"};
    public static final String[] garagedimension = {"8 x 10", "12 x 10", "8 x 12","12 x 12","10 x 10"};
    public static final String[] floorheightdim = {"12 Ft", "11 ft", "10ft"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstfloor);

        floorheight=findViewById(R.id.floorheight);
        garageportion=findViewById(R.id.garageportion);
        roomdrop=findViewById(R.id.roomdrop);
        roomdrop2=findViewById(R.id.roomdrop2);
        roomdrop3=findViewById(R.id.roomdrop3);
        tvdrop=findViewById(R.id.tvdrop);
        kitchendrop=findViewById(R.id.kitchendrop);
        garagedrop=findViewById(R.id.garagedrop);
        bathdrop=findViewById(R.id.bathdrop);
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
        alertestimate=findViewById(R.id.alertestimate);
        btnafterestimate=findViewById(R.id.btnafterestimate);
        floortxt=findViewById(R.id.floortxt);
        roominteger_number2=findViewById(R.id.roominteger_number2);
        roominteger_number3=findViewById(R.id.roominteger_number3);
        roomincrease2=findViewById(R.id.roomincrease2);
        roomdecrease2=findViewById(R.id.roomdecrease2);
        roomincrease3=findViewById(R.id.roomincrease3);
        roomdecrease3=findViewById(R.id.roomdecrease3);


        Intent intent = getIntent();
        String FloorName = intent.getExtras().getString("FloorName");
        floortxt.setText(FloorName);
        Toast.makeText(this, ""+FloorName, Toast.LENGTH_SHORT).show();
        if (FloorName.equals("Enter the First Floor Dimensions")){
         garageportion.removeAllViews();
        }

        SharedPreferences preferences =firstfloor.this.getSharedPreferences(My_Estimator_name, Context.MODE_PRIVATE);
        int plotsquare=preferences.getInt("plotsquare",0);
        String plotsquarefeet=String.valueOf(plotsquare);
        Toast.makeText(this, ""+plotsquare, Toast.LENGTH_SHORT).show();
        squarecalculate.setText("Total Square Feet: "+plotsquarefeet);
//floorheight dropdown
        ArrayAdapter<String> flooradapter = new ArrayAdapter<String>(firstfloor.this,
                android.R.layout.simple_spinner_item,floorheightdim);
        flooradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floorheight.setAdapter(flooradapter);
        floorheight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                floorheightpos=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


//room1 dropdown
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(firstfloor.this,
                android.R.layout.simple_spinner_item,roomdimension);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomdrop.setAdapter(adapter);
        roomdrop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                room1dim=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

//room2 dropdown
        ArrayAdapter<String> roomadapter2 = new ArrayAdapter<String>(firstfloor.this,
                android.R.layout.simple_spinner_item,roomdimension2);
        roomadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomdrop2.setAdapter(roomadapter2);
        roomdrop2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                room2dim=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //room3 dropdown
        ArrayAdapter<String> roomadapter3 = new ArrayAdapter<String>(firstfloor.this,
                android.R.layout.simple_spinner_item,roomdimension3);
        roomadapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomdrop3.setAdapter(roomadapter3);
        roomdrop3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                room3dim=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //kitchen dropdown
        ArrayAdapter<String> kitchenadapter = new ArrayAdapter<String>(firstfloor.this,
                android.R.layout.simple_spinner_item,kitchendimension);
        kitchenadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kitchendrop.setAdapter(kitchenadapter);
        kitchendrop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                kitchendim=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //tv dropdown
        ArrayAdapter<String> tvadapter = new ArrayAdapter<String>(firstfloor.this,
                android.R.layout.simple_spinner_item,tvdimension);
        tvadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tvdrop.setAdapter(tvadapter);
        tvdrop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                tvdim=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //bath dropdown
        ArrayAdapter<String> bathadapter = new ArrayAdapter<String>(firstfloor.this,
                android.R.layout.simple_spinner_item,bathdimension);
        bathadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bathdrop.setAdapter(bathadapter);
        bathdrop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                bathdim=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //garage dropdown
        ArrayAdapter<String> garageadapter = new ArrayAdapter<String>(firstfloor.this,
                android.R.layout.simple_spinner_item,garagedimension);
        garageadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        garagedrop.setAdapter(garageadapter);
        garagedrop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                garagedim=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });



        roomincrease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int roominteger2=Integer.parseInt(roominteger_number2.getText().toString());
                int increase2=roominteger2+1;
                String increment2=String.valueOf(increase2);
                roominteger_number2.setText(increment2);
            }
        });
        roomdecrease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int roominteger2=Integer.parseInt(roominteger_number2.getText().toString());
                if (roominteger2>0){
                    int increase2=roominteger2-1;
                    String increment2=String.valueOf(increase2);
                    roominteger_number2.setText(increment2);
                }
                else{
                    Toast.makeText(firstfloor.this, "Room Value is Already 0", Toast.LENGTH_SHORT).show();
                }

            }
        });
        roomincrease3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int roominteger3=Integer.parseInt(roominteger_number3.getText().toString());
                int increase3=roominteger3+1;
                String increment3=String.valueOf(increase3);
                roominteger_number3.setText(increment3);
            }
        });

        roomdecrease3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int roominteger3=Integer.parseInt(roominteger_number3.getText().toString());
                if (roominteger3>0){
                    int increase3=roominteger3-1;
                    String increment3=String.valueOf(increase3);
                    roominteger_number3.setText(increment3);
                }
                else{
                    Toast.makeText(firstfloor.this, "Room Value is Already 0", Toast.LENGTH_SHORT).show();
                }

            }
        });




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
                    Toast.makeText(firstfloor.this, "Room Value is Already 0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(firstfloor.this, "Kitchen Value is Already 0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(firstfloor.this, "Bathroom Value is Already 0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(firstfloor.this, "TV Value is Already 0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(firstfloor.this, "Garage Value is Already 0", Toast.LENGTH_SHORT).show();
                }

            }
        });
        estimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (floorheightpos==0){
                    height=12;
                }
                if (floorheightpos==1){
                    height=11;
                }
                if (floorheightpos==2){
                    height=10;
                }
                if (room1dim==0){

                    int roominteger1=Integer.parseInt(roominteger_number.getText().toString());
                    int doorsquare=roominteger1*21;
                    room1sq=roominteger1*44;
                    int roomsquaretotal=room1sq*height;
                    room1total=roomsquaretotal-doorsquare;

                }

                if (room1dim==1){
                    int roominteger1=Integer.parseInt(roominteger_number.getText().toString());
                    int doorsquare=roominteger1*21;
                    room1sq=roominteger1*48;
                    int roomsquaretotal=room1sq*height;
                    room1total=roomsquaretotal-doorsquare;

                }

                if (room1dim==2){
                    int roominteger1=Integer.parseInt(roominteger_number.getText().toString());
                    int doorsquare=roominteger1*21;
                    room1sq=roominteger1*52;
                    int roomsquaretotal=room1sq*height;
                    room1total=roomsquaretotal-doorsquare;

                }
                if (room1dim==3){
                    int roominteger1=Integer.parseInt(roominteger_number.getText().toString());
                    int doorsquare=roominteger1*21;
                    room1sq=roominteger1*56;
                    int roomsquaretotal=room1sq*height;
                    room1total=roomsquaretotal-doorsquare;

                }

                if (room1dim==4){

                    int roominteger1=Integer.parseInt(roominteger_number.getText().toString());
                    int doorsquare=roominteger1*21;
                    room1sq=roominteger1*54;
                    int roomsquaretotal=room1sq*height;
                    room1total=roomsquaretotal-doorsquare;
                }


                if (room1dim==5){

                    int roominteger1=Integer.parseInt(roominteger_number.getText().toString());
                    int doorsquare=roominteger1*21;
                    room1sq=roominteger1*60;
                    int roomsquaretotal=room1sq*height;
                    room1total=roomsquaretotal-doorsquare;
                }

                if (room1dim==6){
                    int roominteger1=Integer.parseInt(roominteger_number.getText().toString());
                    int doorsquare=roominteger1*21;
                    room1sq=roominteger1*56;
                    int roomsquaretotal=room1sq*height;
                    room1total=roomsquaretotal-doorsquare;

                }

                if (room1dim==7){

                    int roominteger1=Integer.parseInt(roominteger_number.getText().toString());
                    int doorsquare=roominteger1*21;
                    room1sq=roominteger1*60;
                    int roomsquaretotal=room1sq*height;
                    room1total=roomsquaretotal-doorsquare;
                }



                //***** Room 2 calculation*********/



                if (room2dim==0){

                    int roominteger1=Integer.parseInt(roominteger_number2.getText().toString());
                    int doorsquare=roominteger1*21;
                    room2sq=roominteger1*44;
                    int roomsquaretotal=room2sq*height;
                    room2total=roomsquaretotal-doorsquare;


                }

                if (room2dim==1){
                    int roominteger1=Integer.parseInt(roominteger_number2.getText().toString());
                    int doorsquare=roominteger1*21;
                    room2sq=roominteger1*48;
                    int roomsquaretotal=room2sq*height;
                    room2total=roomsquaretotal-doorsquare;

                }

                if (room2dim==2){
                    int roominteger1=Integer.parseInt(roominteger_number2.getText().toString());
                    int doorsquare=roominteger1*21;
                    room2sq=roominteger1*52;
                    int roomsquaretotal=room2sq*height;
                    room2total=roomsquaretotal-doorsquare;

                }
                if (room2dim==3){
                    int roominteger1=Integer.parseInt(roominteger_number2.getText().toString());
                    int doorsquare=roominteger1*21;
                    room2sq=roominteger1*56;
                    int roomsquaretotal=room2sq*height;
                    room2total=roomsquaretotal-doorsquare;

                }

                if (room2dim==4){

                    int roominteger1=Integer.parseInt(roominteger_number2.getText().toString());
                    int doorsquare=roominteger1*21;
                    room2sq=roominteger1*54;
                    int roomsquaretotal=room2sq*height;
                    room2total=roomsquaretotal-doorsquare;
                }


                if (room2dim==5){

                    int roominteger1=Integer.parseInt(roominteger_number2.getText().toString());
                    int doorsquare=roominteger1*21;
                    room2sq=roominteger1*60;
                    int roomsquaretotal=room2sq*height;
                    room2total=roomsquaretotal-doorsquare;
                }

                if (room2dim==6){
                    int roominteger1=Integer.parseInt(roominteger_number2.getText().toString());
                    int doorsquare=roominteger1*21;
                    room2sq=roominteger1*56;
                    int roomsquaretotal=room2sq*height;
                    room2total=roomsquaretotal-doorsquare;

                }

                if (room2dim==7){

                    int roominteger1=Integer.parseInt(roominteger_number2.getText().toString());
                    int doorsquare=roominteger1*21;
                    room2sq=roominteger1*60;
                    int roomsquaretotal=room2sq*height;
                    room2total=roomsquaretotal-doorsquare;
                }
                ///room 3 calculation

                if (room3dim==0){

                    int roominteger1=Integer.parseInt(roominteger_number3.getText().toString());
                    int doorsquare=roominteger1*21;
                    room3sq=roominteger1*44;
                    int roomsquaretotal=room3sq*height;
                    room3total=roomsquaretotal-doorsquare;


                }

                if (room3dim==1){
                    int roominteger1=Integer.parseInt(roominteger_number3.getText().toString());
                    int doorsquare=roominteger1*21;
                    room3sq=roominteger1*48;
                    int roomsquaretotal=room3sq*height;
                    room3total=roomsquaretotal-doorsquare;

                }

                if (room3dim==2){
                    int roominteger1=Integer.parseInt(roominteger_number3.getText().toString());
                    int doorsquare=roominteger1*21;
                    room3sq=roominteger1*52;
                    int roomsquaretotal=room3sq*height;
                    room3total=roomsquaretotal-doorsquare;

                }
                if (room3dim==3){
                    int roominteger1=Integer.parseInt(roominteger_number3.getText().toString());
                    int doorsquare=roominteger1*21;
                    room3sq=roominteger1*56;
                    int roomsquaretotal=room3sq*height;
                    room3total=roomsquaretotal-doorsquare;

                }

                if (room3dim==4){

                    int roominteger1=Integer.parseInt(roominteger_number3.getText().toString());
                    int doorsquare=roominteger1*21;
                    room3sq=roominteger1*54;
                    int roomsquaretotal=room3sq*height;
                    room3total=roomsquaretotal-doorsquare;
                }


                if (room3dim==5){

                    int roominteger1=Integer.parseInt(roominteger_number3.getText().toString());
                    int doorsquare=roominteger1*21;
                    room3sq=roominteger1*60;
                    int roomsquaretotal=room3sq*height;
                    room3total=roomsquaretotal-doorsquare;
                }

                if (room3dim==6){
                    int roominteger1=Integer.parseInt(roominteger_number3.getText().toString());
                    int doorsquare=roominteger1*21;
                    room3sq=roominteger1*56;
                    int roomsquaretotal=room3sq*height;
                    room3total=roomsquaretotal-doorsquare;

                }

                if (room3dim==7){

                    int roominteger1=Integer.parseInt(roominteger_number3.getText().toString());
                    int doorsquare=roominteger1*21;
                    room3sq=roominteger1*60;
                    int roomsquaretotal=room3sq*height;
                    room3total=roomsquaretotal-doorsquare;
                }


                //kitchen calculation


                if (kitchendim==0){

                    int kitcheninteger=Integer.parseInt(kitcheninteger_number.getText().toString());
                    int doorsquare=kitcheninteger*21;
                    kitchensq=kitcheninteger*24;
                    int kitchenquaretotal=kitchensq*height;
                    kitchentotaldim=kitchenquaretotal-doorsquare;


                }

                if (kitchendim==1){
                    int kitcheninteger=Integer.parseInt(kitcheninteger_number.getText().toString());
                    int doorsquare=kitcheninteger*21;
                    kitchensq=kitcheninteger*28;
                    int kitchenquaretotal=kitchensq*height;
                    kitchentotaldim=kitchenquaretotal-doorsquare;

                }

                if (kitchendim==2){
                    int kitcheninteger=Integer.parseInt(kitcheninteger_number.getText().toString());
                    int doorsquare=kitcheninteger*21;
                    kitchensq=kitcheninteger*24;
                    int kitchenquaretotal=kitchensq*height;
                    kitchentotaldim=kitchenquaretotal-doorsquare;

                }
                if (kitchendim==3){
                    int kitcheninteger=Integer.parseInt(kitcheninteger_number.getText().toString());
                    int doorsquare=kitcheninteger*21;
                    kitchensq=kitcheninteger*32;
                    int kitchenquaretotal=kitchensq*height;
                    kitchentotaldim=kitchenquaretotal-doorsquare;

                }

                if (kitchendim==4){

                    int kitcheninteger=Integer.parseInt(kitcheninteger_number.getText().toString());
                    int doorsquare=kitcheninteger*21;
                    kitchensq=kitcheninteger*36;
                    int kitchenquaretotal=kitchensq*height;
                    kitchentotaldim=kitchenquaretotal-doorsquare;
                }

//bath estimate dimensions

                if (bathdim==0){

                    int bathinteger=Integer.parseInt(bathinteger_number.getText().toString());
                    int doorsquare=bathinteger*21;
                    bathsq=bathinteger*20;
                    int bathquaretotal=bathsq*height;
                    bathtotaldim=bathquaretotal-doorsquare;

                }

                if (bathdim==1){
                    int bathinteger=Integer.parseInt(bathinteger_number.getText().toString());
                    int doorsquare=bathinteger*21;
                    bathsq=bathinteger*24;
                    int bathquaretotal=bathsq*height;
                    bathtotaldim=bathquaretotal-doorsquare;

                }

                if (bathdim==2){
                    int bathinteger=Integer.parseInt(bathinteger_number.getText().toString());
                    int doorsquare=bathinteger*21;
                    bathsq=bathinteger*28;
                    int bathquaretotal=bathsq*height;
                    bathtotaldim=bathquaretotal-doorsquare;

                }
                if (bathdim==3){
                    int bathinteger=Integer.parseInt(bathinteger_number.getText().toString());
                    int doorsquare=bathinteger*21;
                    bathsq=bathinteger*30;
                    int bathquaretotal=bathsq*height;
                    bathtotaldim=bathquaretotal-doorsquare;

                }

                if (bathdim==4){

                    int bathinteger=Integer.parseInt(bathinteger_number.getText().toString());
                    int doorsquare=bathinteger*21;
                    bathsq=bathinteger*32;
                    int bathquaretotal=bathsq*height;
                    bathtotaldim=bathquaretotal-doorsquare;
                }


//tv dimension


                if (tvdim==0){

                    int tvinteger=Integer.parseInt(tvinteger_number.getText().toString());
                    int doorsquare=tvinteger*21;
                    tvsq=tvinteger*36;
                    int tvsquaretotal=tvsq*height;
                    tvtotaldim=tvsquaretotal-doorsquare;
                }

                if (tvdim==1){
                    int tvinteger=Integer.parseInt(tvinteger_number.getText().toString());
                    int doorsquare=tvinteger*21;
                    tvsq=tvinteger*44;
                    int tvsquaretotal=tvsq*height;
                    tvtotaldim=tvsquaretotal-doorsquare;

                }

                if (tvdim==2){
                    int tvinteger=Integer.parseInt(tvinteger_number.getText().toString());
                    int doorsquare=tvinteger*21;
                    tvsq=tvinteger*50;
                    int tvsquaretotal=tvsq*height;
                    tvtotaldim=tvsquaretotal-doorsquare;

                }
                if (tvdim==3){
                    int tvinteger=Integer.parseInt(tvinteger_number.getText().toString());
                    int doorsquare=tvinteger*21;
                    tvsq=tvinteger*60;
                    int tvsquaretotal=tvsq*height;
                    tvtotaldim=tvsquaretotal-doorsquare;

                }

                if (tvdim==4){

                    int tvinteger=Integer.parseInt(tvinteger_number.getText().toString());
                    int doorsquare=tvinteger*21;
                    tvsq=tvinteger*72;
                    int tvsquaretotal=tvsq*height;
                    tvtotaldim=tvsquaretotal-doorsquare;
                }


                if (tvdim==5){

                    int tvinteger=Integer.parseInt(tvinteger_number.getText().toString());
                    int doorsquare=tvinteger*21;
                    tvsq=tvinteger*76;
                    int tvsquaretotal=tvsq*height;
                    tvtotaldim=tvsquaretotal-doorsquare;
                }

                if (tvdim==6){
                    int tvinteger=Integer.parseInt(tvinteger_number.getText().toString());
                    int doorsquare=tvinteger*21;
                    tvsq=tvinteger*70;
                    int tvsquaretotal=tvsq*height;
                    tvtotaldim=tvsquaretotal-doorsquare;

                }
//garage


                if (garagedim==0){
                    int garageinteger=Integer.parseInt(garageinteger_number.getText().toString());
                    int doorsquare=garageinteger*21;
                    garagesq=garageinteger*36;
                    int tvsquaretotal=garagesq*height;
                    garagetotaldim=tvsquaretotal-doorsquare;


                }

                if (garagedim==1){
                    int garageinteger=Integer.parseInt(garageinteger_number.getText().toString());
                    int doorsquare=garageinteger*21;
                    garagesq=garageinteger*44;
                    int tvsquaretotal=garagesq*height;
                    garagetotaldim=tvsquaretotal-doorsquare;

                }

                if (garagedim==2){
                    int garageinteger=Integer.parseInt(garageinteger_number.getText().toString());
                    int doorsquare=garageinteger*21;
                    garagesq=garageinteger*40;
                    int tvsquaretotal=garagesq*height;
                    garagetotaldim=tvsquaretotal-doorsquare;

                }
                if (garagedim==3){
                    int garageinteger=Integer.parseInt(garageinteger_number.getText().toString());
                    int doorsquare=garageinteger*21;
                    garagesq=garageinteger*48;
                    int tvsquaretotal=garagesq*height;
                    garagetotaldim=tvsquaretotal-doorsquare;

                }

                if (garagedim==4){

                    int garageinteger=Integer.parseInt(garageinteger_number.getText().toString());
                    int doorsquare=garageinteger*21;
                    garagesq=garageinteger*40;
                    int tvsquaretotal=garagesq*height;
                    garagetotaldim=tvsquaretotal-doorsquare;
                }











//                    int roomleng = Integer.parseInt(rooml.getText().toString());
//                    int roomwid = Integer.parseInt(roomw.getText().toString());
//                    int roominteger = Integer.parseInt(roominteger_number.getText().toString());
//                    int roomtotal1 = roomleng * roomwid * roominteger;
//
//                    int roomleng2 = Integer.parseInt(rooml2.getText().toString());
//                    int roomwid2 = Integer.parseInt(roomw2.getText().toString());
//                    int roominteger2 = Integer.parseInt(roominteger_number2.getText().toString());
//                    int roomtotal2 = roomleng2 * roomwid2 * roominteger2;
//
//                    int roomleng3 = Integer.parseInt(rooml3.getText().toString());
//                    int roomwid3 = Integer.parseInt(roomw3.getText().toString());
//                    int roominteger3 = Integer.parseInt(roominteger_number3.getText().toString());
//                    int roomtotal3 = roomleng3 * roomwid3 * roominteger3;
                   int roomtotal=room1total+room2total+room3total;

                    Toast.makeText(firstfloor.this, ""+roomtotal, Toast.LENGTH_SHORT).show();
//                    //4.5inchwall
                    double roombrick= roomtotal*0.375*14;
                    double roomgraystructure=roomtotal*0.375*0.30;
                    double roomcement=roomgraystructure/5;
                    double roomsand=roomgraystructure-roomcement;
//
//
//
//            int kitchenleng = Integer.parseInt(kitchenl.getText().toString());
//            int kitchenwid = Integer.parseInt(kitchenw.getText().toString());
//            int kitcheninteger = Integer.parseInt(kitcheninteger_number.getText().toString());

              int kitchentotal = kitchentotaldim;
             double kitchenbrick= kitchentotal*0.375*14;
            double kitchengraystructure=kitchentotal*0.375*0.30;
            double kitchencement=kitchengraystructure/5;
            double kitchensand=kitchengraystructure-kitchencement;

//            int tvleng = Integer.parseInt(tvl.getText().toString());
//            int tvwid = Integer.parseInt(tvw.getText().toString());
//            int tvinteger = Integer.parseInt(tvinteger_number.getText().toString());
           int tvtotal = tvtotaldim;
            double tvbrick= tvtotal*0.375*14;
//cement calculation
            double tvgraystructure=tvtotal*0.375*0.30;
            double tvcement=tvgraystructure/5;
            double tvsand=tvgraystructure-tvcement;

//
//            int bathleng = Integer.parseInt(bathl.getText().toString());
//            int bathnwid = Integer.parseInt(bathw.getText().toString());
//            int bathinteger = Integer.parseInt(bathinteger_number.getText().toString());
            int bathtotal = bathtotaldim;
            double bathbrick= bathtotal*0.375*14;

            //cement calculation
            double bathgraystructure=bathtotal*0.375*0.30;
            double bathcement=bathgraystructure/5;
            double bathsand=bathgraystructure-bathcement;
//
//            int garageleng = Integer.parseInt(garagel.getText().toString());
//            int garagewid = Integer.parseInt(garagew.getText().toString());
            int garageinteger = Integer.parseInt(garageinteger_number.getText().toString());
            int garagetotal = garagetotaldim;
            double garagebrick= garagetotal*0.375*14;

            //cement calculation
            double garagegraystructure=garagetotal*0.375*0.30;
            double garagecement=garagegraystructure/5;
            double garagesand=garagegraystructure-garagecement;

            int alltotal = room1sq+room2sq+room3sq+tvsq+bathsq+kitchensq+garagesq ;
            double floorbrick=roombrick+kitchenbrick+tvbrick+bathbrick+garagebrick;
            double floorcement=roomcement+kitchencement+tvcement+bathcement+garagecement;
            double floorsand=roomsand+kitchensand+tvsand+bathsand+garagesand;

            if (alltotal > plotsquare) {
                alertestimate.setText("Your Estimated Square feet More Than Actual");
                btnafterestimate.setEnabled(false);
            } else {
                btnafterestimate.setEnabled(true);
                alertestimate.setText("Continue.........");


                SharedPreferences.Editor editor=(SharedPreferences.Editor) getSharedPreferences(My_Estimator_name,MODE_PRIVATE).edit();
                editor.putInt("firstfloorbrick", (int) floorbrick);
                editor.putInt("firstfloorcement",(int) floorcement);
                editor.putInt("firstfloorsand",(int) floorsand);
                editor.apply();
            }

            }
        });


        btnafterestimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(firstfloor.this,secoundfloor.class);
                intent.putExtra("FloorName", "Enter the Secound Floor Dimensions");
                startActivity(intent);

            }
        });
    }
}