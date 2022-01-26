package com.builder.onlineestimater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Contractor extends AppCompatActivity {
    RecyclerView recyclerView;
//    ArrayList<AddContractorHelper> list;
    CustomAdapter_of_recycleview customAdapter;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor);

        recyclerView=findViewById(R.id.recycler);
//        list = new ArrayList<>();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AddContractorHelper> options=
                new FirebaseRecyclerOptions.Builder<AddContractorHelper>()
                .setQuery(FirebaseDatabase.getInstance().getInstance().getReference().child("Contractors"),AddContractorHelper.class)
                .build();

        customAdapter=new CustomAdapter_of_recycleview(options);
        recyclerView.setAdapter(customAdapter);
//        customAdapter=new CustomAdapter_of_recycleview(Contractor.this,this,list);
//        //  customAdapter = new CustomAdapter_of_recycleview(with_driver_cars.this,this, );
//        recyclerView.setAdapter(customAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(Contractor.this));
//
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Contractors");
//
//
//        list.add(new AddContractorHelper("03240010719","Usama","usama@gmail.com","Lahore","76732"));
//        list.add(new AddContractorHelper("032303282398","Ehtasham","ehtasham@gmail.com","Lahore","76732"));



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