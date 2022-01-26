package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EstimatorMarla extends AppCompatActivity {
    public Spinner spinner,spinnercal;
    public static final String[] paths = {"Ground Floor", "1st Floor", "2nd Floor"};
    public static final String[] option = {"Estimation With Standard Sizes", "Estimation with Own Choice"};
    EditText marla;
    Button btngetmarla;
    public static int plotfloor,optionest,ironkg;
    double cementmaterial,sandmaterial,bajrimaterial;
    public static final String My_Estimator_name="MyEstimator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimator_marla);
        marla=findViewById(R.id.marla);
        btngetmarla=findViewById(R.id.btngetmarla);
        spinnercal=findViewById(R.id.spinnercal);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(EstimatorMarla.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
            plotfloor=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> optionadapter = new ArrayAdapter<String>(EstimatorMarla.this,
                android.R.layout.simple_spinner_item,option);

        optionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercal.setAdapter(optionadapter);

        spinnercal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                optionest=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        btngetmarla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String marlas=marla.getText().toString();
                if (marlas.equals("")){
                    Toast.makeText(EstimatorMarla.this, "Please Enter The Marla", Toast.LENGTH_SHORT).show();

                }
                else if(!marlas.equals(""))
                    {
                        int plotmarla=Integer.parseInt(marla.getText().toString());
                        int plotsquare=plotmarla*225;
                        int marlatxt= Integer.parseInt(marla.getText().toString());
                        SharedPreferences.Editor editor=(SharedPreferences.Editor) getSharedPreferences(My_Estimator_name,MODE_PRIVATE).edit();
                        editor.putInt("marla",marlatxt);
                        editor.putInt("plotsquare",plotsquare);
                        editor.putInt("floor",plotfloor);
                        editor.apply();

                        int totaliron=plotsquare*4;
                        //dry constrent 1.54
                        double ratiowet=plotsquare*0.5*1.54;

                        double cement=0.1428571429*ratiowet/1.25;
                        double sand=0.2857142857*ratiowet;
                        double bajri=0.5714285714*ratiowet;


                        if(plotfloor==0){
                            ironkg= totaliron*1;
                            cementmaterial=cement*1;
                            sandmaterial=sand*1;
                            bajrimaterial=bajri*1;

                            SharedPreferences.Editor e=(SharedPreferences.Editor) getSharedPreferences(My_Estimator_name,MODE_PRIVATE).edit();
                            e.putInt("ironroad",ironkg);
                            e.putInt("cementmaterial", (int) cementmaterial);
                            e.putInt("sandmaterial", (int) sandmaterial);
                            e.putInt("bajrimaterial", (int) bajrimaterial);
                            e.apply();
                            if (optionest==0) {
                                Intent intent = new Intent(EstimatorMarla.this, secoundfloor.class);
                                intent.putExtra("FloorName", "Enter the Ground Floor Dimensions");
                                startActivity(intent);
                            }
                            else
                            {
                                Intent intent = new Intent(EstimatorMarla.this, inputsecoundfloor.class);
                                intent.putExtra("FloorName", "Enter the Ground Floor Dimensions");
                                startActivity(intent);
                            }
                        }
                        if(plotfloor==1){
                            ironkg= totaliron*2;
                            cementmaterial=cement*2;
                            sandmaterial=sand*2;
                            bajrimaterial=bajri*2;
                            SharedPreferences.Editor e=(SharedPreferences.Editor) getSharedPreferences(My_Estimator_name,MODE_PRIVATE).edit();
                            e.putInt("ironroad",ironkg);
                            e.putInt("cementmaterial", (int) cementmaterial);
                            e.putInt("sandmaterial", (int) sandmaterial);
                            e.putInt("bajrimaterial", (int) bajrimaterial);
                            e.apply();

                            if (optionest==0){
                                Intent intent=new Intent(EstimatorMarla.this,firstfloor.class);
                                intent.putExtra("FloorName", "Enter the Ground Floor Dimensions");
                                startActivity(intent);
                            }
                            else{
                                Intent intent=new Intent(EstimatorMarla.this,inputfirstfloor.class);
                                intent.putExtra("FloorName", "Enter the Ground Floor Dimensions");
                                startActivity(intent);
                            }

                        }
                        if(plotfloor==2){

                            ironkg= totaliron*3;
                            cementmaterial=cement*3;
                            sandmaterial=sand*3;
                            bajrimaterial=bajri*3;
                            SharedPreferences.Editor e=(SharedPreferences.Editor) getSharedPreferences(My_Estimator_name,MODE_PRIVATE).edit();
                            e.putInt("ironroad",ironkg);
                            e.putInt("cementmaterial", (int) cementmaterial);
                            e.putInt("sandmaterial", (int) sandmaterial);
                            e.putInt("bajrimaterial", (int) bajrimaterial);
                            e.apply();
                            if (optionest==0) {
                                Intent intent = new Intent(EstimatorMarla.this, GroundFloor.class);
                                intent.putExtra("FloorName", "Enter the Ground Floor Dimensions");
                                startActivity(intent);
                            }
                            else {
                                Intent intent = new Intent(EstimatorMarla.this, inputgroundfloor.class);
                                intent.putExtra("FloorName", "Enter the Ground Floor Dimensions");
                                startActivity(intent);
                            }

                        }


                }


            }
        });

    }






}