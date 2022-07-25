package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class AdminnRoomController extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminn_room_controller);

        // Properties
        Button availabilityButton1 = findViewById(R.id.buttonAvailability1);
        Button availabilityButton2 = findViewById(R.id.buttonAvailability2);

        Spinner spinnerStudyRooms = findViewById(R.id.spinnerStudyRooms);
        Spinner spinnerMultimediaRooms = findViewById(R.id.spinnerMultimediaRooms);


        // Adapters
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.studyRooms, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStudyRooms.setAdapter(adapter1);
        spinnerStudyRooms.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.multimediaRooms, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMultimediaRooms.setAdapter(adapter2);
        spinnerMultimediaRooms.setOnItemSelectedListener(this);

        // ClickListeners
        availabilityButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Database
            }
        });

        availabilityButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Database
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
        // Database
        // Study roomların available olup olmamasını kontrol ediyor
        return true;
    }
}