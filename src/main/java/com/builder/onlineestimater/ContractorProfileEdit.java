package com.builder.onlineestimater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class ContractorProfileEdit extends AppCompatActivity {
EditText contractordes;
Button btnupload;
FirebaseDatabase rootNode;

    public static final String My_profile_name="MyProfile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor_profile_edit);

        contractordes=findViewById(R.id.contractordes);
        btnupload=findViewById(R.id.btnupload);


        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences =ContractorProfileEdit.this.getSharedPreferences(My_profile_name, Context.MODE_PRIVATE);

                final String Login_number=preferences.getString("login_number","None");

                String profileinfo=contractordes.getText().toString();

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Contractors");
                Query checkUser = reference.orderByChild("type").equalTo("other");
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {

                        }
                        else {
                            rootNode=FirebaseDatabase.getInstance();
                            DatabaseReference  reference=rootNode.getReference("Contractors");
                            AddContractorHelper addContractorHelper=new AddContractorHelper(profileinfo);
                            reference.child(Login_number).child("Profile").setValue(addContractorHelper);


                            Toast.makeText(ContractorProfileEdit.this, "Profile Uploaded ", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(ContractorProfileEdit.this,Contractordashbourd.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(ContractorProfileEdit.this, "Check your internet Connection ", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

    }
}