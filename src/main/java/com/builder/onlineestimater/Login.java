package com.builder.onlineestimater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class Login extends AppCompatActivity {
    Button login;
    TextView register;
    EditText user_no,user_pasword;
    ProgressDialog progressDialog;
    public static final String My_profile_name="MyProfile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        user_no=findViewById(R.id.u_number);
        user_pasword=findViewById(R.id.u_pasword);
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            Intent intent=new Intent(Login.this,AdminAddContractor.class);
        Intent intent=new Intent(Login.this,MobileNumber.class);
            startActivity(intent);

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String no=user_no.getText().toString();
                final String pass=user_pasword.getText().toString();

                if (no.equals("")|pass.equals("")){
                    Toast.makeText(Login.this, "Please Fill the Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    progressbar();
                  //  userlogincheck(no,pass);

                    if (no.equals("11223344556")&& pass.equals("12345678")){
                        Intent intent=new Intent(Login.this,AdminDashbourd.class);
                        startActivity(intent);
                    }
                    else{
                        userlogincheck(no,pass);
                    }


//
//                    else {
//                        Toast.makeText(Login.this, "Incorrect User", Toast.LENGTH_SHORT).show();
//                    }
                }
            }
        });
    }


    public void contractorlogincheck(String userEnterednumber,String userEnteredpass ){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Contractors");
        Query checkUser = reference.orderByChild("number").equalTo(userEnterednumber);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String passFromDB = snapshot.child(userEnterednumber).child("pasword").getValue(String.class);
                    if (passFromDB.equals(userEnteredpass)) {

                        Toast.makeText(Login.this, "login sucessfully", Toast.LENGTH_SHORT).show();
                        String numberFromDB = snapshot.child(userEnterednumber).child("number").getValue(String.class);
                        String nameFromDB = snapshot.child(userEnterednumber).child("name").getValue(String.class);

                        SharedPreferences.Editor editor=(SharedPreferences.Editor) getSharedPreferences(My_profile_name,MODE_PRIVATE).edit();
                        editor.putString("login_number",userEnterednumber);
                        editor.putString("login_name",nameFromDB);
                        editor.putString("login","done");
                        editor.putString("contractor_number",userEnterednumber);
                        editor.putString("contractor_name",nameFromDB);
                        editor.apply();


                        Intent intent = new Intent(getApplicationContext(), Dashbourd_Of_Contractor.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "Wrong pasword", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Login.this, "No such user", Toast.LENGTH_SHORT).show();



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Login.this, "Check your internet Connection ", Toast.LENGTH_SHORT).show();

            }
        });

    }







    public void userlogincheck(String userEnterednumber,String userEnteredpass ) {


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
        Query checkUser = reference.orderByChild("number").equalTo(userEnterednumber);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String passFromDB = snapshot.child(userEnterednumber).child("pasword").getValue(String.class);
                    if (passFromDB.equals(userEnteredpass)) {

                        Toast.makeText(Login.this, "login sucessfully", Toast.LENGTH_SHORT).show();
                        String numberFromDB = snapshot.child(userEnterednumber).child("number").getValue(String.class);
                        String nameFromDB = snapshot.child(userEnterednumber).child("name").getValue(String.class);

                        SharedPreferences.Editor editor=(SharedPreferences.Editor) getSharedPreferences(My_profile_name,MODE_PRIVATE).edit();
                        editor.putString("login_number",userEnterednumber);
                        editor.putString("login_name",nameFromDB);
                        editor.putString("login","done");
                        editor.apply();




                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "Wrong pasword", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
//                    Toast.makeText(Login.this, "No such user", Toast.LENGTH_SHORT).show();
                    contractorlogincheck(userEnterednumber,userEnteredpass);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Login.this, "Check your internet Connection ", Toast.LENGTH_SHORT).show();

            }
        });

    }




    private void progressbar() {

        progressDialog = new ProgressDialog(Login.this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("Account Login"); // Setting Title
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