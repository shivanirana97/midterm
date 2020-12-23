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
        Name namedata=intent.getParcelableExtra("nameDetail");

        name.setText(namedata.getName());
        login.setText(namedata.getLogin());
        hook.setText(namedata.getHooksurl());
        team.setText(namedata.getTeamsurl());

    }
}