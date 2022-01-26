package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AdminDashbourd extends AppCompatActivity {
LinearLayout addcontractor,user,materialcost,order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashbourd);
    addcontractor=findViewById(R.id.addcontractor);
        user=findViewById(R.id.users);
        materialcost=findViewById(R.id.materialcost);
        order=findViewById(R.id.order);


    addcontractor.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent=new Intent(AdminDashbourd.this,Contractor.class);
            startActivity(intent);

        }
    });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashbourd.this,All_Users.class);
                startActivity(intent);
            }
        });


        materialcost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(AdminDashbourd.this,AdminMaterial.class);
                startActivity(intent);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AdminDashbourd.this,User_OrderPage.class);
                startActivity(intent);


            }
        });


    }
}