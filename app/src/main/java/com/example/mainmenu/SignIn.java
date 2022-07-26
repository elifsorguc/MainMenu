package com.example.mainmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignIn extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private TextView email;
    private TextView password;
    private Button signinbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();
        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);

        signinbtn = (Button) findViewById(R.id.signinbtn);

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(email.getText()) && !TextUtils.isEmpty(password.getText())){
                    String e_mail = email.getText().toString();
                    String pwd = password.getText().toString();

                    // checking if the email is a Bilkent mail address

                    if(!e_mail.contains("bilkent") || !e_mail.contains("@")){
                        Toast.makeText(getApplicationContext(), "You haven't entered a Bilkent mail address." , Toast.LENGTH_LONG).show();
                        return;
                    }
                    mAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                            .addOnSuccessListener(SignIn.this, new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    mUser = mAuth.getCurrentUser();
                                    System.out.println("User Email: " + mUser.getEmail() );
                                    Toast.makeText(SignIn.this, "Successful!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(SignIn.this, MainActivity.class);
                                    startActivity(intent);

                                }
                            }).addOnFailureListener(SignIn.this, new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SignIn.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }); {

                            };


                }
                else
                    Toast.makeText(SignIn.this, "Email and password cannot be empty!", Toast.LENGTH_SHORT).show();


                /*
                //DATABASE
                if(username.getText().toString().equals("gazal") && password.getText().toString().equals("gazal")){
                    Toast.makeText(SignIn.this, "You have Succesfully Signed In!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SignIn.this,"Sign In Unsuccesful!",Toast.LENGTH_SHORT).show();
                }
                */

            }
        });
    }
    private boolean bilkentMailChecker(String email) {
        boolean check = true;
        int start = email.indexOf('@');
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        }
        if (!email.substring(start).equals("@ug.bilkent.edu.tr")) {
            check = false;
        }
        return check;
    }
}