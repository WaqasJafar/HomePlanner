package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Estimatorsqfeet extends AppCompatActivity {

    EditText marlalength,marlawidth,floor;
    Button squarecal;
    public static final String My_Estimator_name="MyEstimator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimatorsqfeet);

        marlalength=findViewById(R.id.plotlength);
        marlawidth=findViewById(R.id.plotwidth);
        squarecal=findViewById(R.id.btnsquarecalculate);
        floor=findViewById(R.id.floor);


        squarecal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!marlalength.getText().toString().equals("") && !marlawidth.getText().toString().equals("")&&!floor.getText().toString().equals("")){

                    int plotwidth= Integer.parseInt(marlawidth.getText().toString());
                    int plotlength= Integer.parseInt(marlalength.getText().toString());
                    int plotfloor=Integer.parseInt(floor.getText().toString());
                    int plotsquare=plotwidth*plotlength;


                    SharedPreferences.Editor editor=(SharedPreferences.Editor) getSharedPreferences(My_Estimator_name,MODE_PRIVATE).edit();
                    editor.putInt("plotwidth",plotwidth);
                    editor.putInt("plotlength",plotlength);
                    editor.putInt("plotsquare",plotsquare);
                    editor.putInt("floor",plotfloor);
                    editor.apply();
//                    Intent intent=new Intent(Estimatorsqfeet.this,BuildingStructure.class);
//                    startActivity(intent);

                    if(plotfloor==1){
                Intent intent=new Intent(Estimatorsqfeet.this,secoundfloor.class);
                intent.putExtra("FloorName", "Enter the Ground Floor Dimensions");
                startActivity(intent);
                    }
                    if(plotfloor==2){
                        Intent intent=new Intent(Estimatorsqfeet.this,firstfloor.class);
                        intent.putExtra("FloorName", "Enter the Ground Floor Dimensions");
                        startActivity(intent);

                    }
                    if(plotfloor==3){
                        Intent intent=new Intent(Estimatorsqfeet.this,GroundFloor.class);
                        intent.putExtra("FloorName", "Enter the Ground Floor Dimensions");
                        startActivity(intent);
                    }
                    if(plotfloor>3||plotfloor<=0){
                        Toast.makeText(Estimatorsqfeet.this, "Please Enter Floor Size between 1-3", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(marlalength.getText().toString().equals("") || marlawidth.getText().toString().equals("")||floor.getText().toString().equals(""))
                {

                    Toast.makeText(Estimatorsqfeet.this, "Please Fill Both Fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}