package com.builder.onlineestimater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MaterialPrice extends AppCompatActivity {
    TextView brick_cost,cement_cost,sand_cost,bajri_cost,iron_cost;

    ProgressDialog progressDialog;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_price);

        brick_cost=findViewById(R.id.brick_cost);
        cement_cost=findViewById(R.id.cement_cost);
        sand_cost=findViewById(R.id.sand_cost);
        bajri_cost=findViewById(R.id.bajri_cost);
        iron_cost=findViewById(R.id.iron_cost);

// firebase get data


        progressbar();
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



                    bajri_cost.setText(bajricost);
                    brick_cost.setText(brickcost);
                    cement_cost.setText(cementcost);
                    iron_cost.setText(ironrodcost);
                    sand_cost.setText(sandcost);



                }
                else
                {
                    Toast.makeText(MaterialPrice.this, "Data Not Esist", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MaterialPrice.this, "Please Check Internet Connection", Toast.LENGTH_SHORT).show();

            }

        });
    }
    private void progressbar() {

        progressDialog = new ProgressDialog(MaterialPrice.this);
        progressDialog.setMessage("Please Wait..."); // Setting Message
        progressDialog.setTitle("Material Cost Retrieving"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();
    }
}