package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mainmenu.databinding.ActivitySearchBinding;
import com.example.mainmenu.databinding.ActivityStudentBookBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Search extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ArrayList<Book> books = new ArrayList<>();
    private ListView search;
    private ArrayAdapter<Book> adapters;
    private ActivitySearchBinding binding;
    private Book book;
    private Book book2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        books = new ArrayList<>();
        super.onCreate(savedInstanceState);

        loadBooks();

        //viewBinding
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        search = (ListView) findViewById(R.id.search_book);

        //mapping
        ArrayAdapter adapter = new ArrayAdapter(Search.this, android.R.layout.simple_list_item_1,
                books.stream().map(book -> book.getName()).collect(Collectors.toList())
        );

        binding.searchBook.setAdapter(adapter);
        binding.searchBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(Search.this, books.get(i).getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Search.this, Book.class);
                intent.putExtra("bookSelected", books.get(i));
                startActivity(intent);
            }
        });


        createSpinner();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void loadBooks(){
        //DATABASE
        //!!!!!!!!!!!!!!!!!!!
        ArrayList<String> genre1 = new ArrayList<>();
        ArrayList<String> genre2 = new ArrayList<>();
        genre1.add("horror");
        genre2.add("comedy");
        this.book2 = new Book("The science of Harry Potter : how magic really works / Roger Highfield.", "English", "Highfield, J.R.L. (John Roger Loxdale)", "London : Headline, 2003.", genre1, "0755311515", 20,R.drawable.ic_book);
        this.book = new Book("The science of Harry Potter : how magic really works / Roger Highfield.", "English", "Highfield, J.R.L. (John Roger Loxdale)", "London : Headline, 2003.", genre2, "0755311515", 12,R.drawable.ic_book);
        books.add(book);
        books.add(book2);
    }
    private void createSpinner(){
        Spinner spinnerSort = findViewById(R.id.spinnerSort);
        ArrayAdapter<CharSequence> adapterSort = ArrayAdapter.createFromResource(this, R.array.sortOptions, android.R.layout.simple_spinner_item);
        adapterSort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSort.setAdapter(adapterSort);
        spinnerSort.setOnItemSelectedListener(this);
    }
}