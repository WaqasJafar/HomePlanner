
package com.builder.onlineestimater;

import androidx.annotation.NonNull;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;



public class ContractorDetails extends AppCompatActivity {
TextView name,num,email,city,infotxt;
Button btncall,btnsms,btnrating;

//RatingBar rating;

    public static final String My_profile_name="MyProfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor_details);

            name=findViewById(R.id.name);
            num=findViewById(R.id.number);
            email=findViewById(R.id.email);
            city=findViewById(R.id.city);
             infotxt=findViewById(R.id.infotxt);
          //  rating=findViewById(R.id.rating);


            btncall=findViewById(R.id.call);
            btnrating=findViewById(R.id.btnrating);
            btnsms=findViewById(R.id.sms);












        String numberdb = getIntent().getStringExtra("contractornumber");
        String namedb = getIntent().getStringExtra("contractorname");
        String emaildb = getIntent().getStringExtra("contractoremail");
        String citydb = getIntent().getStringExtra("contractorcity");

        num.setText(numberdb);
        name.setText(""+namedb);
        email.setText(""+emaildb);
        city.setText(""+citydb);



        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Contractors");
        Query checkUser = reference.orderByChild("number").equalTo(numberdb);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    String profile=  snapshot.child(numberdb).child("Profile").child("contractor_profile").getValue(String.class);

                    infotxt.setText(""+profile);



                }
                else
                {
                    Toast.makeText(ContractorDetails.this, "Data Not Esist", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ContractorDetails.this, "Please Check Internet Connection For Price Calculation", Toast.LENGTH_SHORT).show();


            }

        });







        SharedPreferences.Editor editor=(SharedPreferences.Editor) getSharedPreferences(My_profile_name,MODE_PRIVATE).edit();
        editor.putString("contractor_number",numberdb);
        editor.putString("contractor_name",namedb);
        editor.apply();


        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + num.getText().toString()));
             startActivity(intent);



//                if (ActivityCompat.checkSelfPermission(ContractorDetails.this,
//                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    return;
//                }
//                startActivity(intent);


            }
        });


        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", num.getText().toString());
                smsIntent.putExtra("sms_body","Hello Sir I want to hire you please contact us as soon as possible");
                startActivity(smsIntent);

            }
        });

        btnrating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent intent=new Intent(ContractorDetails.this,Ratingpage.class);
            startActivity(intent);



            }
        });










//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Contractors");
//
//        Query checkUser = reference.orderByChild("number").equalTo(number);
//        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    String passFromDB = snapshot.child(number).child("name").getValue(String.class);
//
//                        String numberFromDB = snapshot.child(number).child("number").getValue(String.class);
//                        String namefromDB=snapshot.child(number).child("name").getValue(String.class);
//                        String emailfromDB= snapshot.child(number).child("email").getValue(String.class);
//                       String cityfromDB= snapshot.child(number).child("city").getValue(String.class);
//
//                    Toast.makeText(ContractorDetails.this, ""+namefromDB, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(ContractorDetails.this, ""+emailfromDB, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(ContractorDetails.this, ""+cityfromDB, Toast.LENGTH_SHORT).show();
//
//
//
////                    name.setText(""+namefromDB);
////                    email.setText(""+emailfromDB);
////                    city.setText(""+cityfromDB);
//
//
//
//
//                }
//                else {
////                    Toast.makeText(Login.this, "No such user", Toast.LENGTH_SHORT).show();
//
//
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(ContractorDetails.this, "Check your internet Connection ", Toast.LENGTH_SHORT).show();
//
//            }
//        });



    }



}