package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Order_Detail extends AppCompatActivity {
TextView name,number,date,time,brick,sand,cement,bajri,ironrod,total;
Button btnmain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__detail);

        btnmain=findViewById(R.id.btnmain);
        name=findViewById(R.id.name);
        number=findViewById(R.id.number);

        brick=findViewById(R.id.brick);
        sand=findViewById(R.id.sand);
        cement=findViewById(R.id.cement);
        bajri=findViewById(R.id.bajri);
        ironrod=findViewById(R.id.ironrod);
        total=findViewById(R.id.totalprice);

        date=findViewById(R.id.date);
        time=findViewById(R.id.time);




        String numberu = getIntent().getStringExtra("number");
        String nameu = getIntent().getStringExtra("name");
        String dateu = getIntent().getStringExtra("date");
        String priceu = getIntent().getStringExtra("price");
        String timeu = getIntent().getStringExtra("time");
        String bricku = getIntent().getStringExtra("brick");
        String cementu = getIntent().getStringExtra("cement");
        String ironu = getIntent().getStringExtra("iron");
        String bajriu = getIntent().getStringExtra("bajri");
        String sandu = getIntent().getStringExtra("sand");

        number.setText(numberu);
        name.setText(nameu);
        date.setText(dateu);
        total.setText(priceu);
        time.setText(timeu);
        brick.setText(bricku);
        cement.setText(cementu);
        ironrod.setText(ironu);
        bajri.setText(bajriu);
        sand.setText(sandu);


        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Order_Detail.this,AdminDashbourd.class);
                startActivity(intent);
            }
        });






    }
}