package com.example.project_mp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class OwnerInfo extends AppCompatActivity {

    ImageView ownimg;
    TextView ownnm, ownfollowers, ownfollowing, repcnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_info);

        ownimg = findViewById(R.id.ownimg);
        ownnm = findViewById(R.id.ownername);
        ownfollowers = findViewById(R.id.ownfollowers);
        ownfollowing = findViewById(R.id.ownfollowing);
        repcnt = findViewById(R.id.repocnt);

        Intent intent1 = getIntent();
        Parcablerepositories rep = intent1.getParcelableExtra("owner");

        System.out.println("Repo: " + rep.getCustomerimage());

        Picasso.get().load(rep.getCustomerimage()).into(ownimg);

        ownnm.setText(rep.getRepname());
        ownfollowers.setText(rep.getFollower());
        ownfollowing.setText(rep.getFollow());
        repcnt.setText(rep.getUserrepos());
    }
}
