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

public class Priceofallmaterial extends AppCompatActivity {
    TextView cement,brick,sand,ironrod,bajri,totalprice;
    ProgressDialog progressDialog;
    Button btncontrator;
    public static final String My_Estimator_name="MyEstimator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priceofallmaterial);
        brick=findViewById(R.id.brickprice);
        cement=findViewById(R.id.cementprice);
        sand=findViewById(R.id.sandprice);
        btncontrator=findViewById(R.id.btncontrator);
        ironrod=findViewById(R.id.ironrod);
        bajri=findViewById(R.id.bajri);
        totalprice=findViewById(R.id.totalprice);

        progressbar();
        
        SharedPreferences preferences =Priceofallmaterial.this.getSharedPreferences(My_Estimator_name, Context.MODE_PRIVATE);
        int ironroad=preferences.getInt("ironroad",0);
        int allbrick= preferences.getInt("allbrick", 0);
        int allcement= preferences.getInt("allcement", 0);
        int allsand= preferences.getInt("allsand", 0);
        int bajrimaterial= preferences.getInt("bajrimaterial", 0);


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


                    int brickprice=Integer.parseInt(brickcost)*allbrick;
                    int cementprice=Integer.parseInt(cementcost)*allcement;
                    int sandprice=Integer.parseInt(sandcost)*allsand;
                    int ironprice=Integer.parseInt(ironrodcost)*ironroad;
                    int bajriprice=Integer.parseInt(bajricost)*bajrimaterial;

                    int totalpricematerial=brickprice+cementprice+sandprice+ironprice+bajriprice;



                    brick.setText(""+brickprice);
                    cement.setText(""+cementprice);
                    sand.setText(""+sandprice);
                    ironrod.setText(""+ironprice);
                    bajri.setText(""+bajriprice);

                    totalprice.setText(""+totalpricematerial);


                }
                else
                {
                    Toast.makeText(Priceofallmaterial.this, "Data Not Esist", Toast.LENGTH_SHORT).show();
                    brick.setText("Check Internet Connection");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Priceofallmaterial.this, "Please Check Internet Connection For Price Calculation", Toast.LENGTH_SHORT).show();
                brick.setText("Check Internet Connection");

            }

        });

        btncontrator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Priceofallmaterial.this,Contractor.class);
                startActivity(intent);

            }
        });

    }

    private void progressbar() {
        progressDialog = new ProgressDialog(Priceofallmaterial.this);
        progressDialog.setMessage("Please Wait..."); // Setting Message
        progressDialog.setTitle("Calculating The Price"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();
    }
}