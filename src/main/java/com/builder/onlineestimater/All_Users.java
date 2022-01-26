package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class All_Users extends AppCompatActivity {
    RecyclerView recyclerView;
    //    ArrayList<AddContractorHelper> list;
    CustomAdapter_of_recycleview customAdapter;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__users);



        recyclerView=findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AddContractorHelper> options=
                new FirebaseRecyclerOptions.Builder<AddContractorHelper>()
                        .setQuery(FirebaseDatabase.getInstance().getInstance().getReference().child("User"),AddContractorHelper.class)
                        .build();

        customAdapter=new CustomAdapter_of_recycleview(options);
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