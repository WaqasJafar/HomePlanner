package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User_OrderPage extends AppCompatActivity {


    RecyclerView recyclerView;
    //    ArrayList<AddContractorHelper> list;
    CustomAdapter_of_UserOrder customAdapter;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__order_page);

        recyclerView=findViewById(R.id.recycler);
//        list = new ArrayList<>();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Mystore> options=
                new FirebaseRecyclerOptions.Builder<Mystore>()
                        .setQuery(FirebaseDatabase.getInstance().getInstance().getReference().child("Orders"),Mystore.class)
                        .build();

        customAdapter=new CustomAdapter_of_UserOrder(options);
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