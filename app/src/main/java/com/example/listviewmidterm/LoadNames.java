package com.example.listviewmidterm;


import android.app.Activity;
        import android.app.ProgressDialog;
        import android.content.Context;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.IOException;
        import java.util.ArrayList;


class LoadNames extends AsyncTask<String,Integer,String> implements AdapterView.OnItemClickListener {
    Context mainContext;
    ListView githublist;
    Activity context;
    ArrayList<Name> nameArrayList =new ArrayList<>();


    public LoadNames(MainActivity mainActivity) {
        context=mainActivity;
        mainContext=mainActivity;
        githublist = (ListView) mainActivity.findViewById(R.id.githublist);
        githublist.setOnItemClickListener(this);
    }

    @Override
    protected void onPreExecute() {
        Log.e("onPreExecutive","Control is here ...");
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings)
    {
        Log.e("doInBackground","Control is here ...");
        String s = strings[0];
        String instance = "";

        RemoteConnection url = new RemoteConnection();
        try {
            instance = url.remoteInstance(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    protected void onPostExecute(String link) {
        Log.e("onPostExecute","Control is here ...");
                 fetchData(link);


        super.onPostExecute(link);
    }

    private void fetchData(String link) {

        try {
            JSONArray mainGithubList = new JSONArray(link);

            for(int i =0; i<mainGithubList.length();i++)
            {
                JSONObject contacts = mainGithubList.getJSONObject(i);
                 String gitHubName = contacts.getString("name");
                String gitHooksUrl = contacts.getString("hooks_url");
                String gitTeamUrl = contacts.getString("teams_url");

                JSONObject objectOwner = contacts.getJSONObject("owner");

                String githubLoginNameOwner = objectOwner.getString("login");



                nameArrayList.add(new Name(gitHubName,githubLoginNameOwner,gitHooksUrl,gitTeamUrl));

            }

            GithubListAdapter adapter=new GithubListAdapter(context, nameArrayList);
            githublist.setAdapter(adapter);

        } catch (JSONException e) {

            e.printStackTrace();

        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        Intent intent = new Intent(mainContext,NameDetail.class);
        intent.putExtra("nameDetail",nameArrayList.get(i));
        mainContext.startActivity(intent);
    }
}

