package com.builder.onlineestimater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

public class MobileNumber extends AppCompatActivity {
EditText mobilenumber,otptxt;
Button btnotpsend,verify,resendcode;
TextView timer;
FirebaseAuth auth;
private String verificationCode;

String mVerificationId;

PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_number);
        otptxt=findViewById(R.id.otptxt);
        mobilenumber=findViewById(R.id.mobilenumber);
        btnotpsend=findViewById(R.id.btnotpsend);
        verify=findViewById(R.id.verify);
        timer=findViewById(R.id.timer);
        resendcode=findViewById(R.id.resendcode);
        StartFirebaseLogin();





        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp=otptxt.getText().toString();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, otp);
                signInWithPhoneAuthCredential(credential);
            }
        });

        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) { ;
                Toast.makeText(MobileNumber.this, "onVerificationCompleted"+credential, Toast.LENGTH_SHORT).show();
                signInWithPhoneAuthCredential(credential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

                Toast.makeText(MobileNumber.this, "onVerificationFail"+e, Toast.LENGTH_SHORT).show();

                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                }

                // Show a message and update the UI
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {

                Toast.makeText(MobileNumber.this, "CodeSend", Toast.LENGTH_SHORT).show();

                // Save verification ID and resending token so we can use them later
                verificationCode = verificationId;
                PhoneAuthProvider.ForceResendingToken mResendToken = token;
            }
        };

        resendcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resendcode.setEnabled(false);

                String phoneNumber=  mobilenumber.getText().toString();

                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(auth)
                                .setPhoneNumber("+92"+phoneNumber)       // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(MobileNumber.this)                 // Activity (for callback binding)
                                .setCallbacks(mCallback)          // OnVerificationStateChangedCallbacks
                                .build();
                PhoneAuthProvider.verifyPhoneNumber(options);

                new CountDownTimer(30000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        timer.setText(" " + millisUntilFinished / 1000);

                    }

                    public void onFinish() {
                        timer.setText(" ");
                        resendcode.setEnabled(true);
                    }
                }.start();

            }
        });



        btnotpsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mobilenumber.setEnabled(false);

              String phoneNumber=  mobilenumber.getText().toString();

                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(auth)
                                .setPhoneNumber("+92"+phoneNumber)       // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(MobileNumber.this)                 // Activity (for callback binding)
                                .setCallbacks(mCallback)          // OnVerificationStateChangedCallbacks
                                .build();
                PhoneAuthProvider.verifyPhoneNumber(options);

                new CountDownTimer(30000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        timer.setText(" " + millisUntilFinished / 1000);

                    }

                    public void onFinish() {
                        timer.setText(" ");
                        resendcode.setEnabled(true);
                    }
                }.start();


            }
        });

    }



    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent=new Intent(MobileNumber.this,AdminAddContractor.class);
                            intent.putExtra("PhoneNumber",mobilenumber.getText().toString());
                            startActivity(intent);
                            //startActivity(new Intent(MobileNumber.this,AdminAddContractor.class));
                            finish();
                        } else {
                            Toast.makeText(MobileNumber.this,"Incorrect OTP",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



//    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
//        auth.signInWithCredential(credential)
//                .addOnCompleteListener(MobileNumber.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//
//                            Toast.makeText(MobileNumber.this, "Success", Toast.LENGTH_SHORT).show();
//                            FirebaseUser user = task.getResult().getUser();
//
//                        } else {
//                            Toast.makeText(MobileNumber.this, "Fail", Toast.LENGTH_SHORT).show();
//                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
//                                Toast.makeText(MobileNumber.this, "Incorrect", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//                });
//    }






    private void StartFirebaseLogin() {

        auth = FirebaseAuth.getInstance();
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                Toast.makeText(MobileNumber.this,"verification completed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(MobileNumber.this,"verification fialed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationCode = s;
                Toast.makeText(MobileNumber.this,"Code sent",Toast.LENGTH_SHORT).show();
            }
        };
    }

}