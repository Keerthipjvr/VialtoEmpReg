package com.example.vialtoemployeeregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText name, address, skill, contact, email, location;
    Button save, cancel;
    String Name,Address,Skill,Contact,Email,Location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.etName);
        address = findViewById(R.id.etAddress);
        skill = findViewById(R.id.etSkill);
        contact = findViewById(R.id.etContact);
        email = findViewById(R.id.etEmail);
        location = findViewById(R.id.etLocation);

        save = findViewById(R.id.btnSave);
        cancel = findViewById(R.id.btnCancel);

        Database DB;

        cancel.setOnClickListener(v-> startActivity(new Intent(getApplicationContext(), MainActivity.class)));


        DB = new Database(this);


        save.setOnClickListener(v-> {

            Name = name.getText().toString();
            Address = address.getText().toString();
            Skill = skill.getText().toString();
            Contact = contact.getText().toString();
            Email = email.getText().toString();
            Location = location.getText().toString();

            validate();

               Boolean checkInsertEmp = DB.insertEmp(Name, Address, Skill, Contact, Email, Location);
               if(checkInsertEmp)
               {
                   Toast.makeText(Register.this,"Data Saved Successfully", Toast.LENGTH_SHORT).show();                }
               else
               {
                   Toast.makeText(Register.this, "Data not saved. Try again!!", Toast.LENGTH_SHORT).show();
               }
        });

    }
    private void validate(){
        if(Name.isEmpty()){
            name.setError("Name can't be empty");
        }else if (Address.isEmpty()){
            address.setError("Fill Adress field!! ");
        }else if (Skill.isEmpty()){
            skill.setError("Mention your Skill");
        }else if (Contact.isEmpty()){
            contact.setError("Give your Contact number");
        }else if(Contact.length()!=10)
            contact.setError("Contact number must have 10 digits");
        else if (Email.isEmpty()) {
            email.setError("Email is required");
        }else if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            email.setError("Please enter valid email address");
        }else if (Location.isEmpty()){
            location.setError("You forget to type Location");
        } else
            startActivity(new Intent(getApplicationContext(),MainActivity.class));

    }
}