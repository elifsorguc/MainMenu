package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
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
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private SearchView searchView1;
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        books = new ArrayList<>();
        super.onCreate(savedInstanceState);
        searchView1 = findViewById(R.id.searchView);


        loadBooks();

        //viewBinding
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //mapping
        adapter = new ArrayAdapter(Search.this, android.R.layout.simple_list_item_1,
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

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Search.this.adapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Search.this.adapter.getFilter().filter(s);
                return false;
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
        genre1.add("history");
        this.book1 = new Book("The Godfather/ Mario Puzo","English", "English", "New York : G. P. Putnam's Sons, 1969.", genre1, "9781408294345", 12,R.drawable.ic_book);
        genre1.add("fantasy");
        this.book3 = new Book("The Lord of The Rings/ J. R. R. Tolkien", "English","English", "London : HalpertCollins, 1973.", genre1, "9780618129027", 12,R.drawable.ic_book);
        genre1.add("thriller");
        this.book4 = new Book("Shining / Stephen King", "English","English", "New York : A Signet Book, 1978.", genre1, "9780451193889", 12,R.drawable.ic_book);
        genre1.add("history");
        this.book5 = new Book("Shakespeare / Fido Martin", "English","English", "London ; New York : Hamlyn, 1984.", genre1, "9780600382553", 12,R.drawable.ic_book);
        books.add(book1);
        books.add(book3);
        books.add(book2);
        books.add(book4);
        books.add(book5);
    }
    private void createSpinner(){
        Spinner spinnerSort = findViewById(R.id.spinnerSort);
        ArrayAdapter<CharSequence> adapterSort = ArrayAdapter.createFromResource(this, R.array.sortOptions, android.R.layout.simple_spinner_item);
        adapterSort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSort.setAdapter(adapterSort);
        spinnerSort.setOnItemSelectedListener(this);
    }
}