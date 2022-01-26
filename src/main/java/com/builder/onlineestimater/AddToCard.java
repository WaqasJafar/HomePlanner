package com.builder.onlineestimater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddToCard extends AppCompatActivity {
    Button btnconfirm;
    TextView cement,brick,sand,ironrod,bajri,totalprice;
    ProgressDialog progressDialog;
    static int brickprice,cementprice,sandprice,ironprice,bajriprice,totalpricematerial;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    public static final String My_profile_name="MyProfile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_card);

        brick=findViewById(R.id.brickprice);
        cement=findViewById(R.id.cementprice);
        sand=findViewById(R.id.sandprice);
        btnconfirm=findViewById(R.id.btnback);
        ironrod=findViewById(R.id.ironrod);
        bajri=findViewById(R.id.bajri);
        totalprice=findViewById(R.id.totalprice);


        int allbrick = getIntent().getIntExtra("brick",0);
        int allcement = getIntent().getIntExtra("cement",0);
        int allsand = getIntent().getIntExtra("sand",0);
        int bajrimaterial = getIntent().getIntExtra("bajri",0);
        int ironroad = getIntent().getIntExtra("ironroad",0);




        String type="admin";
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Materialcost");
        Query checkUser = reference.orderByChild("type").equalTo(type);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String bajricost = snapshot.child(type).child("bajri").getValue(String.class);
                    String brickcost = snapshot.child(type).child("brick").getValue(String.class);
                    String cementcost = snapshot.child(type).child("cement").getValue(String.class);
                    String ironrodcost = snapshot.child(type).child("ironrod").getValue(String.class);
                    String sandcost = snapshot.child(type).child("sand").getValue(String.class);


                    brickprice=Integer.parseInt(brickcost)*allbrick;
                     cementprice=Integer.parseInt(cementcost)*allcement;
                   sandprice=Integer.parseInt(sandcost)*allsand;
                    ironprice=Integer.parseInt(ironrodcost)*ironroad;
                    bajriprice=Integer.parseInt(bajricost)*bajrimaterial;

                     totalpricematerial=brickprice+cementprice+sandprice+ironprice+bajriprice;

                    brick.setText(""+brickprice);
                    cement.setText(""+cementprice);
                    sand.setText(""+sandprice);
                    ironrod.setText(""+ironprice);
                    bajri.setText(""+bajriprice);


                    totalprice.setText(""+totalpricematerial);
                    SharedPreferences.Editor editor=(SharedPreferences.Editor) getSharedPreferences(My_profile_name,MODE_PRIVATE).edit();
                    editor.putString("order","yes");
                    editor.apply();





                }
                else
                {
                    Toast.makeText(AddToCard.this, "Data Not Esist", Toast.LENGTH_SHORT).show();
                    brick.setText("Check Internet Connection");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AddToCard.this, "Please Check Internet Connection For Price Calculation", Toast.LENGTH_SHORT).show();
                brick.setText("Check Internet Connection");

            }

        });



        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddToCard.this, "Clicked Confirm Store in DB", Toast.LENGTH_SHORT).show();




                SharedPreferences preferences =AddToCard.this.getSharedPreferences(My_profile_name, Context.MODE_PRIVATE);

                final String user_name=preferences.getString("login_name","None");
                final String user_number=preferences.getString("login_number","None");

                String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());



                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Orders");
                Query checkUser = reference.orderByChild("type").equalTo("other");
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            Toast.makeText(AddToCard.this, "Phone Number Already Exists", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            rootNode=FirebaseDatabase.getInstance();
                            DatabaseReference  reference=rootNode.getReference("Orders");


                            Mystore mystore=new Mystore(brick.getText().toString(),cement.getText().toString(),sand.getText().toString(),ironrod.getText().toString(),bajri.getText().toString(),totalprice.getText().toString(),user_name,user_number,currentDate,currentTime);
                            reference.child(user_number).setValue(mystore);


                            Intent intent=new Intent(AddToCard.this,Mycard.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(AddToCard.this, "Check your internet Connection ", Toast.LENGTH_SHORT).show();

                    }
                });











            }
        });


    }
}