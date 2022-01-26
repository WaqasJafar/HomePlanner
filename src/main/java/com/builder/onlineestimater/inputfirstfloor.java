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

public class inputfirstfloor extends AppCompatActivity {
    LinearLayout garageportion;
    Spinner floorheight;
    public int floorheightpos,height;

    public static final String[] floorheightdim = {"12 Ft", "11 ft", "10ft"};
    TextView squarecalculate,kitcheninteger_number,roominteger_number,bathinteger_number,tvinteger_number,garageinteger_number,alertestimate,floortxt,roominteger_number2,roominteger_number3;
    EditText kitchenl,kitchenw,rooml,roomw,bathl,bathw,tvl,tvw,garagel,garagew,rooml2,roomw2,rooml3,roomw3;
    Button roomdecrease,roomincrease,kitchendecrease,kitchenincrease,bathdecrease,bathincrease,tvincrease,tvdecrese,garageincrease,garagedecrease,estimate,btnafterestimate,roomdecrease2,roomincrease2,roomdecrease3,roomincrease3;
    public static final String My_Estimator_name="MyEstimator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputfirstfloor);
        floorheight=findViewById(R.id.floorheight);

        garageportion=findViewById(R.id.garageportion);
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
        floortxt=findViewById(R.id.floortxt);

        roominteger_number2=findViewById(R.id.roominteger_number2);
        roominteger_number3=findViewById(R.id.roominteger_number3);
        rooml2=findViewById(R.id.roomlength2);
        roomw2=findViewById(R.id.roomwidth2);
        rooml3=findViewById(R.id.roomlength3);
        roomw3=findViewById(R.id.roomwidth3);
        roomincrease2=findViewById(R.id.roomincrease2);
        roomdecrease2=findViewById(R.id.roomdecrease2);
        roomincrease3=findViewById(R.id.roomincrease3);
        roomdecrease3=findViewById(R.id.roomdecrease3);

        Intent intent = getIntent();
        String FloorName = intent.getExtras().getString("FloorName");
        floortxt.setText(FloorName);

        if (FloorName.equals("Enter the First Floor Dimensions")){
            garageportion.removeAllViews();
        }

        SharedPreferences preferences =inputfirstfloor.this.getSharedPreferences(My_Estimator_name, Context.MODE_PRIVATE);
        int plotsquare=preferences.getInt("plotsquare",0);

        String plotsquarefeet=String.valueOf(plotsquare);
        squarecalculate.setText("Total Square Feet: "+plotsquarefeet);

//floorheight dropdown
        ArrayAdapter<String> flooradapter = new ArrayAdapter<String>(inputfirstfloor.this,
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
                    Toast.makeText(inputfirstfloor.this, "Room Value is Already 0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(inputfirstfloor.this, "Room Value is Already 0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(inputfirstfloor.this, "Room Value is Already 0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(inputfirstfloor.this, "Kitchen Value is Already 0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(inputfirstfloor.this, "Bathroom Value is Already 0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(inputfirstfloor.this, "TV Value is Already 0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(inputfirstfloor.this, "Garage Value is Already 0", Toast.LENGTH_SHORT).show();
                }

            }
        });
        estimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (kitchenl.getText().toString().equals("") | kitchenw.getText().toString().equals("") | rooml.getText().toString().equals("") | roomw.getText().toString().equals("") | bathl.getText().toString().equals("") | bathw.getText().toString().equals("") | tvl.getText().toString().equals("") | tvw.getText().toString().equals("") | garagel.getText().toString().equals("") | garagew.getText().toString().equals("")| rooml2.getText().toString().equals("") | roomw2.getText().toString().equals("")| rooml3.getText().toString().equals("") | roomw3.getText().toString().equals("")) {
                    Toast.makeText(inputfirstfloor.this, "Please Fill All the Inputs if you want ignore something place 0 ", Toast.LENGTH_SHORT).show();
                }
                if (!kitchenl.getText().toString().equals("") && !kitchenw.getText().toString().equals("") && !rooml.getText().toString().equals("") && !roomw.getText().toString().equals("") && !bathl.getText().toString().equals("") && !bathw.getText().toString().equals("") && !tvl.getText().toString().equals("") && !tvw.getText().toString().equals("") && !garagel.getText().toString().equals("") && !garagew.getText().toString().equals("")&& !rooml2.getText().toString().equals("") && !roomw2.getText().toString().equals("")&& !rooml3.getText().toString().equals("") && !roomw3.getText().toString().equals("")) {

                    if (floorheightpos==0){
                        height=12;
                    }
                    if (floorheightpos==1){
                        height=11;
                    }
                    if (floorheightpos==2){
                        height=10;
                    }

                    int roomleng = Integer.parseInt(rooml.getText().toString())*2*height;
                    int roomwid = Integer.parseInt(roomw.getText().toString())*2*height;
                    int roominteger = Integer.parseInt(roominteger_number.getText().toString());
                    int roomdoor=21*roominteger;
                    int roomtotal1 =  roominteger*(roomleng + roomwid -roomdoor);


                    int roomleng2 = Integer.parseInt(rooml2.getText().toString())*2*height;
                    int roomwid2 = Integer.parseInt(roomw2.getText().toString())*2*height;
                    int roominteger2 = Integer.parseInt(roominteger_number2.getText().toString());
                    int roomdoor2=21*roominteger2;
                    int roomtotal2 = (roomleng2 + roomwid2 -roomdoor2)* roominteger2;

                    int roomleng3 = Integer.parseInt(rooml3.getText().toString())*2*height;
                    int roomwid3 = Integer.parseInt(roomw3.getText().toString())*2*height;
                    int roominteger3 = Integer.parseInt(roominteger_number3.getText().toString());
                    int roomdoor3=21*roominteger3;
                    int roomtotal3 = (roomleng3 + roomwid3 -roomdoor3)* roominteger3;
                    int roomtotal=roomtotal1+roomtotal2+roomtotal3;

                    //4.5inchwall
                    double roombrick= roomtotal*0.375*14;
                    double roomgraystructure=roomtotal*0.375*0.30;
                    double roomcement=roomgraystructure/5;
                    double roomsand=roomgraystructure-roomcement;

                    int kitchenleng = Integer.parseInt(kitchenl.getText().toString())*2*height;
                    int kitchenwid = Integer.parseInt(kitchenw.getText().toString())*2*height;
                    int kitcheninteger = Integer.parseInt(kitcheninteger_number.getText().toString());
                    int doorkitchen=21*kitcheninteger;
                    int kitchentotal = (kitchenleng + kitchenwid -doorkitchen)* kitcheninteger;

                    double kitchenbrick= kitchentotal*0.375*14;
                    double kitchengraystructure=kitchentotal*0.375*0.30;
                    double kitchencement=kitchengraystructure/5;
                    double kitchensand=kitchengraystructure-kitchencement;


                    int tvleng = Integer.parseInt(tvl.getText().toString())*2*height;
                    int tvwid = Integer.parseInt(tvw.getText().toString())*2*height;
                    int tvinteger = Integer.parseInt(tvinteger_number.getText().toString());
                    int doortv=21*tvinteger;
                    int tvtotal = (tvleng + tvwid -doortv)* tvinteger;
                    double tvbrick= tvtotal*0.375*14;
//cement calculation
                    double tvgraystructure=tvtotal*0.375*0.30;
                    double tvcement=tvgraystructure/5;
                    double tvsand=tvgraystructure-tvcement;


                    int bathleng = Integer.parseInt(bathl.getText().toString())*2*height;
                    int bathnwid = Integer.parseInt(bathw.getText().toString())*2*height;
                    int bathinteger = Integer.parseInt(bathinteger_number.getText().toString());
                    int bathdoor=21*bathinteger;
                    int bathtotal = (bathleng + bathnwid -bathdoor)* bathinteger;
                    double bathbrick= bathtotal*0.375*14;

                    //cement calculation
                    double bathgraystructure=bathtotal*0.375*0.30;
                    double bathcement=bathgraystructure/5;
                    double bathsand=bathgraystructure-bathcement;

                    int garageleng = Integer.parseInt(garagel.getText().toString())*2*height;
                    int garagewid = Integer.parseInt(garagew.getText().toString())*2*height;
                    int garageinteger = Integer.parseInt(garageinteger_number.getText().toString());
                    int garagedoor=21*garageinteger;
                    int garagetotal = (garageleng + garagewid -garagedoor)* garageinteger;
                    double garagebrick= garagetotal*0.375*14;

                    //cement calculation
                    double garagegraystructure=garagetotal*0.375*0.30;
                    double garagecement=garagegraystructure/5;
                    double garagesand=garagegraystructure-garagecement;


                    int alltotal = (Integer.parseInt(garagel.getText().toString())*Integer.parseInt(garagew.getText().toString())*Integer.parseInt(garageinteger_number.getText().toString()))+(Integer.parseInt(kitcheninteger_number.getText().toString())*Integer.parseInt(kitchenw.getText().toString())*Integer.parseInt(kitchenl.getText().toString()))+(Integer.parseInt(tvinteger_number.getText().toString())*Integer.parseInt(tvl.getText().toString())*Integer.parseInt(tvw.getText().toString()))+(Integer.parseInt(bathinteger_number.getText().toString())*Integer.parseInt(bathw.getText().toString())*Integer.parseInt(bathl.getText().toString())) +(Integer.parseInt(roominteger_number.getText().toString())*Integer.parseInt(roomw.getText().toString()) *Integer.parseInt(rooml.getText().toString()))+(Integer.parseInt(roominteger_number2.getText().toString())*Integer.parseInt(rooml2.getText().toString())*Integer.parseInt(roomw2.getText().toString())) +(Integer.parseInt(roominteger_number3.getText().toString())*Integer.parseInt(rooml3.getText().toString())*Integer.parseInt(roomw3.getText().toString()));
                    double floorbrick=roombrick+kitchenbrick+tvbrick+bathbrick+garagebrick;
                    double floorcement=roomcement+kitchencement+tvcement+bathcement+garagecement;
                    double floorsand=roomsand+kitchensand+tvsand+bathsand+garagesand;


                    if (alltotal > plotsquare) {
                        alertestimate.setText("Your Estimated Square feet More Than Actual");
                        btnafterestimate.setEnabled(false);
                    } else {
                        btnafterestimate.setEnabled(true);
                        alertestimate.setText("Continue.........");

//                        totalbrick=floorbrickg+floorbrick1+floorbrick;
//                        totalcement=floorcementg+floorcement1+floorcement;

                        SharedPreferences.Editor editor=(SharedPreferences.Editor) getSharedPreferences(My_Estimator_name,MODE_PRIVATE).edit();
                        editor.putInt("firstfloorbrick", (int) floorbrick);
                        editor.putInt("firstfloorcement",(int) floorcement);
                        editor.putInt("firstfloorsand",(int) floorsand);
                        editor.apply();
                    }
                }
            }
        });


        btnafterestimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(inputfirstfloor.this,inputsecoundfloor.class);
                intent1.putExtra("FloorName", "Enter the Secound Floor Dimensions");
                startActivity(intent1);
            }
        });
    }
}
