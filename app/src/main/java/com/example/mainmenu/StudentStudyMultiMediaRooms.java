package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class StudentStudyMultiMediaRooms extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

        private Spinner spinnerStudentStudyRooms;
        private Spinner spinnerMultimediaRooms;
        private ArrayAdapter<CharSequence> adapter1;
        private ArrayAdapter<CharSequence> adapter2;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_study_multi_media_rooms);


            // Properties
            spinnerStudentStudyRooms = findViewById(R.id.spinnerStudyRooms);
            spinnerMultimediaRooms = findViewById(R.id.spinnerMultimediaRooms);


            // Adapters
            adapter1 = ArrayAdapter.createFromResource(StudentStudyMultiMediaRooms.this, R.array.studyRooms, android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerStudentStudyRooms.setAdapter(adapter1);
            spinnerStudentStudyRooms.setOnItemSelectedListener(StudentStudyMultiMediaRooms.this);

            adapter2 = ArrayAdapter.createFromResource(this, R.array.multimediaRooms, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerMultimediaRooms.setAdapter(adapter2);
            spinnerMultimediaRooms.setOnItemSelectedListener(StudentStudyMultiMediaRooms.this);
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
            // Database
            // Study roomların available olup olmamasını kontrol ediyor
            return true;
        }
    }