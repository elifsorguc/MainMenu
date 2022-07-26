package com.example.mainmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;

public class StudentSignUp extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DocumentReference docRef;
    private FirebaseFirestore mFirestore;
    private HashMap<String, Object> mData;
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText ID;
    private Student student;

    private Button signUpBtn;
    private Button goSignInPage;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);

        name = (EditText) findViewById(R.id.name_field);
        email = (EditText) findViewById(R.id.email_field);
        password = (EditText) findViewById(R.id.password_field);

        ID = (EditText) findViewById(R.id.bilkentID_field);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mFirestore = FirebaseFirestore.getInstance();

        student = new Student(email.toString(), password.toString() , "22003786", false,name.toString(), "pinar", true, "cs", true,false,false,false);
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
                if (!TextUtils.isEmpty(email.getText()) && !TextUtils.isEmpty(password.getText()) &&!TextUtils.isEmpty(name.getText()) && !TextUtils.isEmpty(ID.getText())) {

                    String e_mail = email.getText().toString();
                    String pwd = password.getText().toString();

                    // checking if the email is a Bilkent mail address

                    if(!e_mail.contains("bilkent") || !e_mail.contains("@")){
                        Toast.makeText(getApplicationContext(), "You haven't entered a Bilkent mail address." , Toast.LENGTH_LONG).show();
                        return;
                    }

                    // checking if bilkent ID has passed as a numeric value
                    try {
                        long bilkent_id = Integer.parseInt(ID.getText().toString());
                        Log.e("ID_KON>TROL","" + bilkent_id);
                    }
                    catch(Exception err){
                        Toast.makeText(getApplicationContext(), "Bilkent ID should be a numeric value." , Toast.LENGTH_LONG).show();
                        return;
                    }

                    // checking if the password is at least 6 digit long

                    if(pwd.length() < 6){
                        Toast.makeText(getApplicationContext(), "Your password should be at least 6 digit long." , Toast.LENGTH_LONG).show();
                        return;
                    }

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
                                        mData.put("genres", student.getGenres());
                                        mData.put("currentBook", student.getCurrentBook());
                                        mData.put("surname", student.getSurname());
                                        mData.put("department", student.getDepartment());
                                        mData.put("isProfileVisible", student.getProfileVisibility());
                                        mData.put("isStatusVisible", student.getStatusVisibility());
                                        mData.put("isBooklistVisible", student.getListVisibility());
                                        mData.put("isAtLibrary", student.getIsAtLibrary());
                                        mData.put("friends", (student.getFriends()));

                                        mFirestore.collection("user").document(mUser.getUid())
                                                .set(mData);
                                        System.out.println("Veri!");
                                    }


                                }




                            });
                    Intent intent = new Intent(StudentSignUp.this, GenreSelection.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "You need to enter email, id, name and password to sign up" , Toast.LENGTH_LONG).show();
                }





            }
        });
    }

    private boolean bilkentMailChecker(String email){
        boolean check=true;
        int start=email.indexOf('@');
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            return false;
        }
        if(!email.substring(start).equals("@ug.bilkent.edu.tr"))
        {
            check=false;
        }
        return check;
    }
    public void createCollections()
    {
        docRef = mFirestore.collection("study").document("rooms");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (!document.exists()) {
                        HashMap<String, Object> mata = new HashMap<>();
                        mata.put("room 1", "");
                        mata.put("room 2", "");
                        mata.put("room 3", "");
                        mata.put("room 4", "");
                        mata.put("room 5", "");
                        mata.put("room 6", "");
                        mata.put("room 7", "");
                        mata.put("room 8", "");
                        mata.put("room 9", "");
                        mata.put("room 10", "");
                        mata.put("room 11", "");
                        mata.put("room 12", "");
                        mata.put("room 13", "");
                        mata.put("room 14", "");
                        mata.put("room 15", "");
                        mata.put("room 16", "");
                        mata.put("room 17", "");
                        mata.put("room 18", "");
                        mata.put("room 19", "");
                                        /*mFirestore.collection("users")
                                                .add(mData);*/
                        mFirestore.collection("study").document("rooms").set(mata);
                    }
                }
                else {
                    HashMap<String, Object> mata = new HashMap<>();
                    mata.put("room 1", "");
                    mata.put("room 2", "");
                    mata.put("room 3", "");
                    mata.put("room 4", "");
                    mata.put("room 5", "");
                    mata.put("room 6", "");
                    mata.put("room 7", "");
                    mata.put("room 8", "");
                    mata.put("room 9", "");
                    mata.put("room 10", "");
                    mata.put("room 11", "");
                    mata.put("room 12", "");
                    mata.put("room 13", "");
                    mata.put("room 14", "");
                    mata.put("room 15", "");
                    mata.put("room 16", "");
                    mata.put("room 17", "");
                    mata.put("room 18", "");
                    mata.put("room 19", "");
                                        /*mFirestore.collection("users")
                                                .add(mData);*/
                    mFirestore.collection("study").document("rooms").set(mata);
                }
            }
        });
        HashMap<String, Object> mat = new HashMap<>();
        mat.put("bookUid", "");
        mat.put("ownerUid", "");
        mat.put("booklistName", "");
        mFirestore.collection("booklist").document("placeholder").set(mat);
    }
}