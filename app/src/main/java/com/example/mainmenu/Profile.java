package com.example.mainmenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;
    private FirebaseUser mUser;
    private Button bookLists;
    private Button pastBooks;
    private Button favorites;
    private Button borrowed;
    private TextView name;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mFirestore = FirebaseFirestore.getInstance();
        bookLists = findViewById(R.id.booklists_btn);
        bookLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, BookList.class);
                startActivity(intent);
            }
        });




        name = findViewById(R.id.nameSurname);
        name.setText(mAuth.getCurrentUser().getEmail().substring(0,(mAuth.getCurrentUser().getEmail()).indexOf('@')));

        email = findViewById(R.id.emailtxt);
        email.setText(mAuth.getCurrentUser().getEmail());



    }


}