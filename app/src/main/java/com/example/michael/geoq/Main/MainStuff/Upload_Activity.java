package com.example.michael.geoq.Main.MainStuff;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.michael.geoq.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Upload_Activity extends AppCompatActivity {

    private EditText TutName;
    private EditText writeText;

    private  Button Uploadbtn;
    private ImageButton UploadPic;

    private StorageReference mStrorage;
    private static final int GALLERY_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_);

        mStrorage = FirebaseStorage.getInstance().getReference();

        TutName = (EditText) findViewById(R.id.TutName);
        writeText = (EditText) findViewById(R.id.writeText);

        Uploadbtn = (Button) findViewById(R.id.Uploadbtn);
        UploadPic = (ImageButton) findViewById(R.id.UploadPic);

        Uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startPosting();
            }
        });

        UploadPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){

            Uri imageUri = data.getData();
            UploadPic.setImageURI(imageUri);
        }
    }

    private void startPosting() {

        String title_val = TutName.getText().toString().trim();
        String desc_val = writeText.getText().toString().trim();

        if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val)){

        }
    }




}

