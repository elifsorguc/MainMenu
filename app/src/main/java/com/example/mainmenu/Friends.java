package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.mainmenu.databinding.ActivityFriendsBinding;
import com.example.mainmenu.databinding.ActivitySearchBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Friends extends AppCompatActivity {
    private ArrayList<User> friends;
    private ActivityFriendsBinding binding;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private Student student5;
    private Student student6;
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //viewBinding
        binding = ActivityFriendsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        friends = new ArrayList<>();
        loadFriends();

        adapter = new ArrayAdapter(Friends.this, android.R.layout.simple_list_item_1,
                friends.stream().map(student -> student.getName()).collect(Collectors.toList())
        );
        binding.friendsListView.setAdapter(adapter);
        /*binding.friendsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(Friends.this, books.get(i).getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Friends.this, Book.class);
                intent.putExtra("bookSelected", books.get(i));
                startActivity(intent);
            }
        });*/


    }

    private void loadFriends(){
        //DATABASE
        student1 = new Student("elifpinar@bilkent", "123456" , "22003786", false,"elif pınar balbal ", "sorguç", true, "cs", true,false,false,false);
        student2 = new Student("elifpinar@bilkent", "123456" , "22003786", false,"konur alp ", "sorguç", true, "cs", true,false,false,false);
        student3 = new Student("elifpinar@bilkent", "123456" , "22003786", false,"habibe yılmaz", "sorguç", true, "cs", true,false,false,false);
        student4 = new Student("elifpinar@bilkent", "123456" , "22003786", false,"gazel", "sorguç", true, "cs", true,false,false,false);
        student5 = new Student("elifpinar@bilkent", "123456" , "22003786", false,"tevfik emre sungur ", "sorguç", true, "cs", true,false,false,false);
        student6 = new Student("elifpinar@bilkent", "123456" , "22003786", false,"tuna saygın", "sorguç", true, "cs", true,false,false,false);
        friends.add(student1);
        friends.add(student2);
        friends.add(student3);
        friends.add(student4);
        friends.add(student5);
        friends.add(student6);

    }
}