package com.example.vialtoemployeeregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnReg, btnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReg=findViewById(R.id.btn1);
        btnReg.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Register.class)));

        btnAdmin=findViewById(R.id.btn2);
        btnAdmin.setOnClickListener(v-> startActivity(new Intent(getApplicationContext(), view.class)));



        }

    }
