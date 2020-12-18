package com.example.listviewmidterm;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class  GithubListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList githubname;
    private final ArrayList githubowner;

    public GithubListAdapter(Activity context, ArrayList name, ArrayList ownerfullname) {
        super(context, R.layout.github_list, name);

        this.context = context;
        this.githubname = name;
        this.githubowner = ownerfullname;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listview = inflater.inflate(R.layout.github_list, null, true);

        TextView nameText = (TextView) listview.findViewById(R.id.name);
        TextView fullNameText = (TextView) listview.findViewById(R.id.ownerfullName);
        nameText.setText(githubname.get(position).toString());
        fullNameText.setText(githubowner.get(position).toString());

        return listview;

    }


}