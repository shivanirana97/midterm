package com.example.mobileapplication1;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class
MyListAdapter extends ArrayAdapter<String> {


    private final Activity context;
    private final String[] name;
    private final String[] ownerLoginName;

    public MyListAdapter(Activity context, String[] name, String[] fullname) {
        super(context, R.layout.custom_list, name);

        this.context=context;
        this.name=name;
        this.ownerLoginName=fullname;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listview=inflater.inflate(R.layout.custom_list, null,true);

        TextView nameText = (TextView) listview.findViewById(R.id.name);
        TextView fullNameText = (TextView) listview.findViewById(R.id.fullName);
        nameText.setText(name[position]);
        fullNameText.setText(ownerLoginName[position]);

        return listview;

    };
}