package com.builder.onlineestimater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Mycard extends AppCompatActivity {
TextView brick,sand,cement,bajri,ironrod,total,ordertxt;
Button btnmain;

LinearLayout orderportion;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    public static final String My_profile_name="MyProfile";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycard);

        orderportion=findViewById(R.id.orderportion);
        btnmain=findViewById(R.id.btnmain);
        brick=findViewById(R.id.brick);
        sand=findViewById(R.id.sand);
        cement=findViewById(R.id.cement);
        bajri=findViewById(R.id.bajri);
        ironrod=findViewById(R.id.ironrod);
        total=findViewById(R.id.totalprice);
        ordertxt=findViewById(R.id.ordertxt);


        SharedPreferences preferences =Mycard.this.getSharedPreferences(My_profile_name, Context.MODE_PRIVATE);
        final String user_number=preferences.getString("login_number","None");
//        final String order=preferences.getString("order","no");



//        if (order.equals("yes")){
//            ordertxt.setText("    ");
//        }
//
//        if (order.equals("no")){
//            orderportion.removeAllViews();
//        }

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");
        Query checkUser = reference.orderByChild("number").equalTo(user_number);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Toast.makeText(Mycard.this, "Data Exist", Toast.LENGTH_SHORT).show();

                    String bajricost = snapshot.child(user_number).child("bajri").getValue(String.class);
                    String brickcost = snapshot.child(user_number).child("brick").getValue(String.class);
                    String cementcost = snapshot.child(user_number).child("cement").getValue(String.class);
                    String ironrodcost = snapshot.child(user_number).child("iron").getValue(String.class);
                    String sandcost = snapshot.child(user_number).child("sand").getValue(String.class);
                    String totalprice = snapshot.child(user_number).child("totalpricematerial").getValue(String.class);

//                    int brickprice=Integer.parseInt(brickcost)*allbrick;
//                    int cementprice=Integer.parseInt(cementcost)*allcement;
//                    int sandprice=Integer.parseInt(sandcost)*allsand;
//                    int ironprice=Integer.parseInt(ironrodcost)*ironroad;
//                    int bajriprice=Integer.parseInt(bajricost)*bajrimaterial;
//
//                    int totalpricematerial=brickprice+cementprice+sandprice+ironprice+bajriprice;

                    brick.setText(""+brickcost);
                    cement.setText(""+cementcost);
                    sand.setText(""+sandcost);
                    ironrod.setText(""+ironrodcost);
                    bajri.setText(""+bajricost);
                    total.setText(""+totalprice);



                }
                else
                {
                    Toast.makeText(Mycard.this, "Data Not Esist", Toast.LENGTH_SHORT).show();
                    brick.setText("Check Internet Connection");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Mycard.this, "Please Check Internet Connection For Price Calculation", Toast.LENGTH_SHORT).show();
                brick.setText("Check Internet Connection");

            }

        });

        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mycard.this,MainActivity.class);
                startActivity(intent);
            }
        });





    }
}