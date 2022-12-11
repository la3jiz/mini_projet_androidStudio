package com.example.mini_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mini_projet.R;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edit_name = findViewById(R.id.edit_name);
        final EditText edit_position = findViewById(R.id.edit_position);
        final EditText edit_email = findViewById(R.id.edit_email);
        final EditText edit_imageurl = findViewById(R.id.edit_imageurl);
        final com.google.android.material.floatingactionbutton.FloatingActionButton fab=findViewById(R.id.fab) ;
        Button btn = findViewById(R.id.btn_submit);
        Button btn_open = findViewById(R.id.btn_open);

        btn_open.setOnClickListener(v->
        {
            Intent intent =new Intent(MainActivity.this, RVActivity.class);
            startActivity(intent);
        });
        DAOEmployee dao =new DAOEmployee();
        Employee emp_edit = (Employee)getIntent().getSerializableExtra("EDIT");
        if(emp_edit !=null)
        {
            btn.setText("UPDATE");
            edit_name.setText(emp_edit.getName());
            edit_position.setText(emp_edit.getPosition());
            edit_email.setText(emp_edit.getEmail());
            edit_imageurl.setText(emp_edit.getImageurl());
            btn_open.setVisibility(View.GONE);
        }
        else
        {
            btn.setText("ADD");
            btn_open.setVisibility(View.VISIBLE);
        }


        btn.setOnClickListener(v->
        {
            Employee emp = new Employee(edit_name.getText().toString(), edit_email.getText().toString(),edit_position.getText().toString(),edit_imageurl.getText().toString());
            if(emp_edit==null)
            {
                dao.add(emp).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
                    edit_name.getText().clear();
                    edit_position.getText().clear();
                    edit_email.getText().clear();
                    edit_imageurl.getText().clear();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
            else
            {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", edit_name.getText().toString());
                hashMap.put("position", edit_position.getText().toString());
                hashMap.put("email", edit_email.getText().toString());
                hashMap.put("imageurl", edit_imageurl.getText().toString());

                dao.update(emp_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Record is updated", Toast.LENGTH_SHORT).show();
                    finish();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });

        fab.setOnClickListener(v->{
            Intent i=new Intent(this,MapsActivity.class);
            startActivity(i);
        });

    }
}
