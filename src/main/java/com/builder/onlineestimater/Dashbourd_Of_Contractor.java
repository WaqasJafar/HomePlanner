package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Dashbourd_Of_Contractor extends AppCompatActivity {
LinearLayout Reviews,info;
public static final String My_profile_name="MyProfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbourd__of__contractor);
        Reviews=findViewById(R.id.Reviews);
        info=findViewById(R.id.info);


        Reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashbourd_Of_Contractor.this,Ratingpage.class);
                startActivity(intent);
            }
        });


        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent intent=new Intent(Dashbourd_Of_Contractor.this,ContractorProfileEdit.class);
            startActivity(intent);

            }
        });
    }
}