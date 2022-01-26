package com.builder.onlineestimater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AdminAddContractor extends AppCompatActivity {
    EditText u_name,u_email,u_city,u_pasword;
    TextView u_no;
    Button btn_done;
    ProgressDialog progressDialog;
    FirebaseDatabase rootNode;
    RadioButton user,contreactor;
    RadioGroup accounttype;

    public static int option=0;
    public  static String a_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_contractor);

        u_no=findViewById(R.id.u_no);
        u_name=findViewById(R.id.username);
        u_email=findViewById(R.id.u_email);
        u_city=findViewById(R.id.u_city);
        u_pasword=findViewById(R.id.u_pasword);
        btn_done=findViewById(R.id.btn_done);
        user=findViewById(R.id.user);
        contreactor=findViewById(R.id.contractor);
        accounttype=findViewById(R.id.a_type);

        String numberuser = getIntent().getStringExtra("PhoneNumber");
        u_no.setText(numberuser);


//        String email = u_email.getText().toString().trim();
//        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        accounttype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId) {
                    case R.id.user:

                        option=1;
                        a_type="User";
                        Toast.makeText(AdminAddContractor.this, ""+option, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.contractor:
                        option=2;
                        a_type="Contractors";
                        Toast.makeText(AdminAddContractor.this, ""+option, Toast.LENGTH_SHORT).show();

                        break;
                }
            }
        });




        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_no=u_no.getText().toString();
                String user_name=u_name.getText().toString();
                String user_email=u_email.getText().toString();
                String user_pass=u_pasword.getText().toString();
                String user_city=u_city.getText().toString();



                if (user_no.equals("")|user_name.equals("")|user_email.equals("")|user_pass.equals("")|user_city.equals("")|option==0)
                {
                    Toast.makeText(AdminAddContractor.this, "Please Fill all fields", Toast.LENGTH_SHORT).show();
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(u_email.getText().toString()).matches()) {
                    Toast.makeText(AdminAddContractor.this,"Please Enter Valid email address",Toast.LENGTH_SHORT).show();

                }



               if(!u_no.getText().toString().equals("") && !u_name.getText().toString().equals("") && !u_email.getText().toString().equals("") && !u_pasword.getText().toString().equals("") && !u_city.getText().toString().equals("") && option!=0 && Patterns.EMAIL_ADDRESS.matcher(u_email.getText().toString()).matches()){

//                }
//                else{

                    progressbar();
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference(a_type);
                    Query checkUser = reference.orderByChild("number").equalTo(user_no);
                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                Toast.makeText(AdminAddContractor.this, "Phone Number Already Exists", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                rootNode=FirebaseDatabase.getInstance();
                                DatabaseReference  reference=rootNode.getReference(a_type);

                                AddContractorHelper addContractorHelper=new AddContractorHelper(user_no,user_name,user_email,user_city,user_pass,a_type);
                                reference.child(user_no).setValue(addContractorHelper);


                                Intent intent=new Intent(AdminAddContractor.this,Login.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(AdminAddContractor.this, "Check your internet Connection ", Toast.LENGTH_SHORT).show();

                        }
                    });



                }

            }
        });


    }

    private void progressbar() {

        progressDialog = new ProgressDialog(AdminAddContractor.this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("Create Account"); // Setting Title
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