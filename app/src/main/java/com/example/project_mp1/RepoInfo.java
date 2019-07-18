package com.example.project_mp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RepoInfo extends AppCompatActivity {

    ImageView ownimg;
    TextView repname, ownname, replang, repdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_info);

        ownimg = findViewById(R.id.ownerimg);
        repname = findViewById(R.id.reponame);
        ownname = findViewById(R.id.ownername);
        replang = findViewById(R.id.repolang);
        repdesc = findViewById(R.id.repodesc);

        Intent i = getIntent();
        final Parcablerepositories rep = i.getParcelableExtra("rdetails");

        Picasso.get().load(rep.getCustomerimage()).into(ownimg);
        repname.setText(rep.getRepname());
        ownname.setText(rep.getCustomername());
        replang.setText(rep.getLang());
        repdesc.setText(rep.getDes());

        repname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(RepoInfo.this,OwnerInfo.class);
                intent1.putExtra("owner", (Parcelable) rep);
                startActivity(intent1);
            }
        });
    }
}
