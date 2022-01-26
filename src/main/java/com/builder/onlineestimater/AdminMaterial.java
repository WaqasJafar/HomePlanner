package com.builder.onlineestimater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AdminMaterial extends AppCompatActivity {
EditText brick_cost,cement_cost,sand_cost,bajri_cost,iron_cost;
Button btn_cost_done;
ProgressDialog progressDialog;
FirebaseDatabase rootNode;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_material);


        brick_cost=findViewById(R.id.brick_cost);
        cement_cost=findViewById(R.id.cement_cost);
        sand_cost=findViewById(R.id.sand_cost);
        bajri_cost=findViewById(R.id.bajri_cost);
        iron_cost=findViewById(R.id.iron_cost);
        btn_cost_done=findViewById(R.id.btn_cost_done);

        btn_cost_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String brick_costrs=brick_cost.getText().toString();
                String cement_costrs=cement_cost.getText().toString();
                String sand_costrs=sand_cost.getText().toString();
                String bajri_costrs=bajri_cost.getText().toString();
                String iron_costrs=iron_cost.getText().toString();


                if (brick_costrs.equals("")|cement_costrs.equals("")|sand_costrs.equals("")|bajri_costrs.equals("")|iron_costrs.equals(""))
                {
                    Toast.makeText(AdminMaterial.this, "Please Fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    progressbar();
//firebaseconnection

                    String type="admin";
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Materialcost");
                    Query checkUser = reference.orderByChild("type").equalTo("other");
                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                Toast.makeText(AdminMaterial.this, "Phone Number Already Exists", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                rootNode=FirebaseDatabase.getInstance();
                                DatabaseReference  reference=rootNode.getReference("Materialcost");

                                MaterialHelper materialHelper=new MaterialHelper(brick_costrs,cement_costrs,sand_costrs,iron_costrs,bajri_costrs,type);
                                reference.child(type).setValue(materialHelper);

                                Toast.makeText(AdminMaterial.this, "Data Updated ", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(AdminMaterial.this,MainActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(AdminMaterial.this, "Check your internet Connection ", Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            }
        });


    }
    private void progressbar() {

        progressDialog = new ProgressDialog(AdminMaterial.this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("Material Cost Added"); // Setting Title
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