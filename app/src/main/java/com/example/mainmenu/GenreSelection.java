package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import java.util.ArrayList;
public class GenreSelection extends AppCompatActivity {

    private CheckBox thriller;
    private CheckBox cooking;
    private CheckBox history;
    private CheckBox fantasy;
    private CheckBox horror;
    private CheckBox romance;
    private CheckBox scifi;
    private CheckBox comedy;

    private Button mainBtn;

    ArrayList<String> genres = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thriller = (CheckBox) findViewById(R.id.thrillers_check);
        cooking = (CheckBox) findViewById(R.id.cooking_check);
        history = (CheckBox) findViewById(R.id.history_check);
        fantasy = (CheckBox) findViewById(R.id.fantasy_check);
        horror = (CheckBox) findViewById(R.id.horror_check);
        romance = (CheckBox) findViewById(R.id.romance_check);
        scifi = (CheckBox) findViewById(R.id.sci_checks);
        comedy = (CheckBox) findViewById(R.id.comedy_check);

        mainBtn = (Button) findViewById(R.id.main_btn);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (thriller.isChecked()){
                    genres.add(thriller.getText().toString());
                }
                if (cooking.isChecked()){
                    genres.add(cooking.getText().toString());
                }
                if (history.isChecked()) {
                    genres.add(history.getText().toString());
                }
                if (fantasy.isChecked()) {
                    genres.add(fantasy.getText().toString());
                }
                if(horror.isChecked()) {
                    genres.add(horror.getText().toString());
                }
                if(romance.isChecked()) {
                    genres.add(romance.getText().toString());
                }
                if (scifi.isChecked()) {
                    genres.add(scifi.getText().toString());
                }
                if (comedy.isChecked()) {
                    genres.add(comedy.getText().toString());
                }
                Toast.makeText(getApplicationContext(), "Welcome to the main page with genres: " + genres.toString(), Toast.LENGTH_LONG).show();

            }
        });


    }
}