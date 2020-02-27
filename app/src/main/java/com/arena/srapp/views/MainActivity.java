package com.arena.srapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.arena.srapp.R;
import com.arena.srapp.adapters.UserAdapter;
import com.arena.srapp.models.User;
import com.arena.srapp.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.mainRecycler);
        progressBar = findViewById(R.id.prog);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.getAllUser().observe(this, new Observer<User[]>() {
            @Override
            public void onChanged(User[] users) {
                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.setAdapter(new UserAdapter(users));

            }
        });
    }
}
