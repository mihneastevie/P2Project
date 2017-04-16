package com.example.michael.geoq.Main.CategoriesTutorials;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.michael.geoq.Main.MainStuff.Profile;
import com.example.michael.geoq.R;

public class Repair extends AppCompatActivity implements View.OnClickListener{


private Button buttonTutorial1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);

        buttonTutorial1 = (Button) findViewById(R.id.buttonTutorial1);

        buttonTutorial1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == buttonTutorial1) {
            finish();
            startActivity(new Intent(this, Profile.class));
        }

    }
}
