package com.example.mainmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;

public class StudentSignUp extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseFirestore mFirestore;
    private HashMap<String, Object> mData;
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText username;
    private EditText ID;
    private Student student;

    private Button signUpBtn;
    private Button goSignInPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);

        name = (EditText) findViewById(R.id.name_field);
        email = (EditText) findViewById(R.id.email_field);
        password = (EditText) findViewById(R.id.password_field);
        username = (EditText) findViewById(R.id.username_field);
        ID = (EditText) findViewById(R.id.bilkentID_field);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mFirestore = FirebaseFirestore.getInstance();
        student = new Student();
        signUpBtn = (Button) findViewById(R.id.signupbtn);
        goSignInPage = (Button) findViewById(R.id.signInPage);

        goSignInPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentSignUp.this, SignIn.class);
                startActivity(intent);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(email.getText()) && !TextUtils.isEmpty(password.getText())) {
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(StudentSignUp.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        mData = new HashMap<>();
                                        mData.put("isAdmin", student.isAdmin);
                                        mData.put("userUid", mUser.getUid());
                                        mData.put("id", student.getID());
                                        mData.put("name", student.getName());
                                        mData.put("password", student.getPassword());
                                        mData.put("mail", student.getEmail());
                                        mData.put("genres", Arrays.asList(student.getGenres()));
                                        mData.put("currentBook", Arrays.asList(student.getCurrentBook()));
                                        mData.put("surname", student.getSurname());
                                        mData.put("department", student.getDepartment());
                                        mData.put("isProfileVisible", student.getProfileVisibility());
                                        mData.put("isStatusVisible", student.getStatusVisibility());
                                        mData.put("isBooklistVisible", student.getListVisibility());
                                        mData.put("isAtLibrary", student.getIsAtLibrary());
                                        mData.put("friends", Arrays.asList(student.getFriends()));

                                        mFirestore.collection("Users").document(mUser.getUid())
                                                .set(mData);
                                        System.out.println("Veri!");
                                    }


                                }




                            });
                }
                Intent intent = new Intent(StudentSignUp.this, GenreSelection.class);
                startActivity(intent);




            }
        });
    }


}