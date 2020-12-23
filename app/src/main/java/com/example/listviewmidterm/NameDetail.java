package com.example.listviewmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NameDetail extends AppCompatActivity {

    TextView name;
    TextView login;
    TextView hook;
    TextView team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_detail);

        name=findViewById(R.id.name);
        login=findViewById(R.id.login);
        hook=findViewById(R.id.hook);
        team=findViewById(R.id.team);


        Intent intent=getIntent();
        Name contact=intent.getParcelableExtra("nameDetail");
        name.setText(contact.getName());
        login.setText(contact.getLogin());
        hook.setText(contact.getHooksurl());
        team.setText(contact.getTeamsurl());

    }
}