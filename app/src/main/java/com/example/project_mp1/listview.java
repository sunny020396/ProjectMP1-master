package com.example.project_mp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class listview extends AppCompatActivity {

    ArrayList<Parcablerepositories> repositories;
    ListView list;
    Listadapt listadapat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        repositories = new ArrayList<>();
        list = findViewById(R.id.textlist);

        String link = "https://api.github.com/repositories";

        try {
            String repJson = new Synchronize().execute(link).get();

            System.out.println(" Json :" + repJson);

            JSONArray Array;
            Array = new JSONArray(repJson);

            for (int i = 0; i < 26; i++) {
                JSONObject childObj = Array.getJSONObject(i);
                String repname = childObj.getString("name");
                String customername = childObj.getJSONObject("owner").getString("login");
                String customerimage = childObj.getJSONObject("owner").getString("avatar_url");
                String lang = childObj.getString("languages_url");
                String des = childObj.getString("description");
                String follower = childObj.getJSONObject("owner").getString("followers_url");
                String follow = childObj.getJSONObject("owner").getString("following_url");
                String company = childObj.getJSONObject("owner").getString("organizations_url");
                String userrepos = childObj.getJSONObject("owner").getString("repos_url");

                System.out.println(" Repository Array: " + customername);

                repositories.add(new Parcablerepositories(repname, customername, customerimage, lang, des, follower, follow, company, userrepos));

            }


            listadapat = new Listadapt(getApplicationContext(), repositories);
            list.setAdapter(listadapat);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(listview.this, RepoInfo.class);
                    intent.putExtra("rdetails", repositories.get(i));
                    startActivity(intent);
                }
            });

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}



