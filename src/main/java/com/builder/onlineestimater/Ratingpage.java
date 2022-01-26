package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Ratingpage extends AppCompatActivity {
Button rating;
RecyclerView recyclerView;
Custome_rating_adapter customAdapter;
public static final String My_profile_name="MyProfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingpage);

        recyclerView=findViewById(R.id.recycler);
        rating=findViewById(R.id.rating);


        SharedPreferences preferences =Ratingpage.this.getSharedPreferences(My_profile_name, Context.MODE_PRIVATE);

        final String contractor_number=preferences.getString("contractor_number","None");
        final String Login_number=preferences.getString("login_number","None");

        if (contractor_number.equals(Login_number)){
            rating.setEnabled(false);
        }

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Ratingpage.this,ratingdialog.class);
                startActivity(intent);
            }
        });



        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ratinghelper> options=
                new FirebaseRecyclerOptions.Builder<ratinghelper>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Contractors").child(contractor_number).child("reviews"),ratinghelper.class)
                        .build();

//        mDatabase.child("users").child(UserID).child("profile").child("username").getValue().toString()
        customAdapter=new Custome_rating_adapter(options);
        recyclerView.setAdapter(customAdapter);




    }


    @Override
    protected void onStart() {
        super.onStart();
        customAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        customAdapter.stopListening();
    }
}