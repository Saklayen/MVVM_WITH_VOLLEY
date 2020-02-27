package com.arena.srapp.viewmodels;

import android.app.Application;

import com.arena.srapp.models.User;
import com.arena.srapp.repositories.UserRepos;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    UserRepos userRepos;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepos = new UserRepos(application);
    }

    public LiveData<User[]> getAllUser(){
        return userRepos.getuUserData();
    }

}
