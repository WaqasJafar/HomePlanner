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
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ratingdialog extends AppCompatActivity {
RatingBar rating;
Button Ratingsubmit;
EditText ratingtext;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    public static final String My_profile_name="MyProfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingdialog);

        rating=findViewById(R.id.rating);
        Ratingsubmit=findViewById(R.id.ratingsubmit);
        ratingtext=findViewById(R.id.ratingtext);


        SharedPreferences preferences =ratingdialog.this.getSharedPreferences(My_profile_name, Context.MODE_PRIVATE);

        final String user_name=preferences.getString("login_name","None");
        final String user_number=preferences.getString("login_number","None");


        final String contractor_name=preferences.getString("contractor_name","None");
        final String contractor_number=preferences.getString("contractor_number","None");




        Ratingsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int s= (int) rating.getRating();
                Toast.makeText(ratingdialog.this, "rating"+s, Toast.LENGTH_SHORT).show();


                String ratingtxt= ratingtext.getText().toString();
                Toast.makeText(ratingdialog.this, ""+ratingtxt, Toast.LENGTH_SHORT).show();









                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Contractors");
                Query checkUser = reference.orderByChild("type").equalTo("other");
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            Toast.makeText(ratingdialog.this, "Phone Number Already Exists", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            rootNode=FirebaseDatabase.getInstance();
                            DatabaseReference  reference=rootNode.getReference("Contractors");

                            ratinghelper ratinghelper=new ratinghelper(contractor_number,contractor_name,user_number,user_name,s,ratingtxt);
                            reference.child(contractor_number).child("reviews").child(user_number).setValue(ratinghelper);

                            Toast.makeText(ratingdialog.this, "Review Submitted Done ", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(ratingdialog.this,Contractor.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(ratingdialog.this, "Check your internet Connection ", Toast.LENGTH_SHORT).show();

                    }
                });














            }
        });




    }
}