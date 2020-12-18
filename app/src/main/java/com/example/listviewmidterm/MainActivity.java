package com.example.listviewmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadGithubData();

    }

    private void loadGithubData() {
        try {
            LoadNames loadData = new LoadNames(MainActivity.this);
            loadData.execute("https://api.github.com/repositories");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}