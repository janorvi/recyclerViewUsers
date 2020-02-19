package com.example.android.pruebassi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ViewHolderAdapter> {
    private List<User> usersList;
    public ListUserAdapter(List<User> usersList)
    {
        this.usersList = usersList;
    }
    @NonNull
    @Override
    public ListUserAdapter.ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserAdapter.ViewHolderAdapter holder, int position) {
        holder.nameTextView.setText(usersList.get(position).getName());
        holder.passwordTextView.setText(usersList.get(position).getPassword());
    }

    @Override
    public int getItemCount() {

        return usersList.size();
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView passwordTextView;
        public ViewHolderAdapter(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_edit_text);
            passwordTextView = itemView.findViewById(R.id.password_edit_text);
        }
    }
}
