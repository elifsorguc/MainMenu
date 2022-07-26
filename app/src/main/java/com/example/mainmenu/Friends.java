package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mainmenu.databinding.ActivityFriendsBinding;
import com.example.mainmenu.databinding.ActivitySearchBinding;

import java.util.ArrayList;

public class Friends extends AppCompatActivity {
    private ArrayList<User> friends;
   private ActivityFriendsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //viewBinding
        binding = ActivityFriendsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        friends = new ArrayList<>();





    }


}