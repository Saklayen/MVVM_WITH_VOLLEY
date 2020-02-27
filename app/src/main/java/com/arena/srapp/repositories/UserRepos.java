package com.arena.srapp.repositories;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.arena.srapp.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import androidx.lifecycle.MutableLiveData;

public class UserRepos {

    String url ="https://api.github.com/users";
    Application application;
    User[] users;
    MutableLiveData<User[]> mutableLiveData;

    public UserRepos(Application application) {
        this.application = application;
    }

    public MutableLiveData<User[]> getuUserData(){

        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
        }


        RequestQueue queue = Volley.newRequestQueue(application);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();

                        users = gson.fromJson(response, User[].class);
                        mutableLiveData.setValue(users);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);

        return mutableLiveData;

    }

//    add(){
//
//    }
//
//    getid(int id)
}
