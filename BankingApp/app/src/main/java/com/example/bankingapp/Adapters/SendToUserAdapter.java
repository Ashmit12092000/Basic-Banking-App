package com.example.bankingapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bankingapp.Activities.SendUser;
import com.example.bankingapp.Model.Model;
import com.example.bankingapp.R;

import java.util.ArrayList;
import java.util.List;

public class SendToUserAdapter extends RecyclerView.Adapter<ViewHolderAdapter> {

    SendUser SendtoUser;
    List<Model> modelList;

    public SendToUserAdapter(SendUser sentoUser, List<Model> modelList) {
        this.SendtoUser = sentoUser;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.userslist, parent, false);

        ViewHolderAdapter viewHolder = new ViewHolderAdapter(itemView);
        viewHolder.setOnClickListener((view, position) -> SendtoUser.selectuser(position));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapter holder, int position) {
        holder.mName.setText(modelList.get(position).getName());
        holder.mPhonenumber.setText(modelList.get(position).getPhoneno());
        holder.mBalance.setText(modelList.get(position).getBalance());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void setFilter(ArrayList<Model> newList){
        modelList = new ArrayList<>();
        modelList.addAll(newList);
        notifyDataSetChanged();
    }
}