package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class StudentStudyMultiMediaRooms extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinnerStudentStudyRooms;
    private Spinner spinnerMultimediaRooms;
    private ArrayAdapter<CharSequence> adapter1;
    private ArrayAdapter<CharSequence> adapter2;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mFireStore;
    private DocumentReference docRef;

    Button put1;
    Button put2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        mFireStore = FirebaseFirestore.getInstance();
        docRef = mFireStore.collection("study").document("rooms");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_study_multi_media_rooms);

        // Properties
        spinnerStudentStudyRooms = findViewById(R.id.spinnerStudyRooms);
        spinnerMultimediaRooms = findViewById(R.id.spinnerMultimediaRooms);
        put1 = findViewById(R.id.buttonQueue1);
        put2 = findViewById(R.id.buttonQueue2);


        // Adapters
        adapter1 = ArrayAdapter.createFromResource(StudentStudyMultiMediaRooms.this, R.array.studyRooms, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStudentStudyRooms.setAdapter(adapter1);
        spinnerStudentStudyRooms.setOnItemSelectedListener(StudentStudyMultiMediaRooms.this);

        adapter2 = ArrayAdapter.createFromResource(this, R.array.multimediaRooms, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMultimediaRooms.setAdapter(adapter2);
        spinnerMultimediaRooms.setOnItemSelectedListener(StudentStudyMultiMediaRooms.this);

        //study collectionı tanımla DATABASE

        put1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                docRef.get()
                        .addOnSuccessListener(StudentStudyMultiMediaRooms.this, new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists())
                                {
                                    boolean noPlace = true;
                                    for (int i = 1; i < 14; i++) {
                                        if (documentSnapshot.getData().get("room " + i) == "")
                                        {
                                            DocumentReference ref = mFireStore.collection("study").document("rooms");
                                            ref.update("room " + i, mAuth.getCurrentUser().getUid().toString());
                                            noPlace = false;
                                            Toast.makeText(StudentStudyMultiMediaRooms.this, "You borrowed study room " + i, Toast.LENGTH_SHORT).show();
                                            break;
                                        }
                                    }
                                    if (noPlace)
                                        Toast.makeText(StudentStudyMultiMediaRooms.this, "There is no available study room!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        put2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                docRef.get()
                        .addOnSuccessListener(StudentStudyMultiMediaRooms.this, new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists())
                                {
                                    boolean noPlace = true;
                                    for (int i = 14; i < 20; i++) {
                                        if (documentSnapshot.getData().get("room " + i) == "")
                                        {
                                            DocumentReference ref = mFireStore.collection("study").document("rooms");
                                            ref.update("room " + i, mAuth.getCurrentUser().getUid().toString());
                                            noPlace = false;
                                            Toast.makeText(StudentStudyMultiMediaRooms.this, "You borrowed multimedia room " + (i - 13), Toast.LENGTH_SHORT).show();
                                            break;
                                        }
                                    }
                                    if (noPlace)
                                        Toast.makeText(StudentStudyMultiMediaRooms.this, "There is no available multimedia room!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    // Overridden methods by interface
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public boolean isAvailable(){
        //mFireStore.collection("study").document("rooms")
        docRef.get()
                .addOnSuccessListener(this, new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists())
                        {
                            boolean noPlace = true;
                            for (int i = 1; i < 14; i++) {
                                if (documentSnapshot.getData().get("room " + i) == "")
                                {
                                    DocumentReference ref = mFireStore.collection("study").document("rooms");
                                    ref.update("room " + i, mAuth.getCurrentUser().getUid().toString());
                                    noPlace = false;
                                    Toast.makeText(StudentStudyMultiMediaRooms.this, "You borrowed room " + i, Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                            if (noPlace)
                                Toast.makeText(StudentStudyMultiMediaRooms.this, "There is no available study room!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // Database
        // Study roomların available olup olmamasını kontrol ediyor
        return true;
    }
}