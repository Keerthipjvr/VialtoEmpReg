package com.example.vialtoemployeeregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class view extends AppCompatActivity {
    Button Dashboard, Employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Dashboard = findViewById(R.id.btndashboard);
        Employees = findViewById(R.id.btnEmployees);

        Dashboard.setOnClickListener(v-> startActivity(new Intent(getApplicationContext(), dashboard.class)));
        Employees.setOnClickListener(v-> startActivity(new Intent(getApplicationContext(), Admin.class)));
    }
}