package com.example.contactmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.viewHolder> {
    Context context;
    ArrayList<String> name,number;

    public adapter(Context context, ArrayList<String> name, ArrayList<String> number) {
        this.context = context;
        this.name = name;
        this.number = number;
    }

    @NonNull
    @Override
    public adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.viewHolder holder, int position) {
         holder.txtName.setText(name.get(position));
         holder.txtNumber.setText(number.get(position));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtNumber;
        CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
            txtNumber=itemView.findViewById(R.id.txtNumber);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
