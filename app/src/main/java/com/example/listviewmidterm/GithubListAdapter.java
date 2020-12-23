package com.example.listviewmidterm;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class  GithubListAdapter extends BaseAdapter {

    private final Activity context;

    ArrayList<Name>  nameArrayList =new ArrayList<>();
    public GithubListAdapter(Activity context, ArrayList<Name> nameArrayList) {


        this.context = context;
        this.nameArrayList = nameArrayList;

    }

    @Override
    public int getCount() {
        return nameArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return nameArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listview = inflater.inflate(R.layout.github_list, null, true);

        TextView nameText = (TextView) listview.findViewById(R.id.name);
        TextView fullNameText = (TextView) listview.findViewById(R.id.ownerfullName);
       // nameText.setText(githubname.get(position).toString());
       // fullNameText.setText(githubowner.get(position).toString());
        nameText.setText(nameArrayList.get(position).getName());
        fullNameText.setText(nameArrayList.get(position).getLogin());
        return listview;

    }


}