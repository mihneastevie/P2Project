package com.example.michael.geoq.Main.CategoriesTutorials;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.michael.geoq.Main.MainStuff.Upload_Activity;
import com.example.michael.geoq.R;

public class Categories extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRepair;
    private Button buttonFood;
    private Button buttonClean;
    private Button buttonAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        buttonRepair = (Button) findViewById(R.id.buttonRepair);
        buttonFood = (Button) findViewById(R.id.buttonFood);
        buttonClean = (Button) findViewById(R.id.buttonClean);
        buttonAdd = (Button) findViewById(R.id.add_btn);

        buttonRepair.setOnClickListener(this);
        buttonFood.setOnClickListener(this);
        buttonClean.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
    }





    @Override
    public void onClick(View view) {
        if (view == buttonRepair) {
            finish();
            startActivity(new Intent(this, Repair.class));
        }
        else if (view == buttonFood) {
            finish();
            startActivity(new Intent(this, Food.class));
        }
        else if (view == buttonClean) {
            finish();
            startActivity(new Intent(this, Clean.class));
        }
        else if (view == buttonAdd) {
            finish();
            startActivity(new Intent(this, Upload_Activity.class));
        }


    }


}
