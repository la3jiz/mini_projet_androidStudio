package com.example.mini_projet;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mini_projet.R;

public class EmployeeVH extends RecyclerView.ViewHolder
{
    public TextView txt_name,txt_position,txt_email,txt_option;
    public ImageView img_emp;
    public EmployeeVH(@NonNull View itemView)
    {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_position = itemView.findViewById(R.id.txt_position);
        txt_email= itemView.findViewById(R.id.txt_email);
        img_emp= itemView.findViewById(R.id.img_emp);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}
