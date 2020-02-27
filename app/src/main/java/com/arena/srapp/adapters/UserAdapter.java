package com.arena.srapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arena.srapp.R;
import com.arena.srapp.models.User;
import com.bumptech.glide.Glide;

import java.awt.font.TextAttribute;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    User[] users;

    public UserAdapter(User[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Glide.with(holder.imageView.getContext()).load(users[position].getAvatarUrl()).into(holder.imageView);
        holder.textView.setText(users[position].getLogin());

    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
            imageView = itemView.findViewById(R.id.img);

        }
    }
}
