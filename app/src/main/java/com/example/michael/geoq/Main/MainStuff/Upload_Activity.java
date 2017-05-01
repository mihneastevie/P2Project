package com.example.michael.geoq.Main.MainStuff;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.michael.geoq.Main.CategoriesTutorials.Categories;
import com.example.michael.geoq.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Upload_Activity extends AppCompatActivity {

    private EditText TutName;
    private EditText writeText;

    private  Button Uploadbtn;
    private ImageButton UploadPic;
    private DatabaseReference mDataBase;

    private StorageReference mStrorage;
    private static final int GALLERY_REQUEST = 1;

    private Uri mImageUri = null;
    private ProgressDialog mProgress;

    private CheckBox foodCheckBox, cleanCheckBox, repairCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_);

        mStrorage = FirebaseStorage.getInstance().getReference();
        mDataBase = FirebaseDatabase.getInstance().getReference().child("Tutorial_up/FOOD");

        TutName = (EditText) findViewById(R.id.TutName);
        writeText = (EditText) findViewById(R.id.writeText);

        foodCheckBox= (CheckBox) findViewById(R.id.foodCheckBox);
        cleanCheckBox= (CheckBox) findViewById(R.id.cleanCheckBox);
        repairCheckBox= (CheckBox) findViewById(R.id.repairCheckBox);


        Uploadbtn = (Button) findViewById(R.id.Uploadbtn);
        UploadPic = (ImageButton) findViewById(R.id.UploadPic);

        mProgress = new ProgressDialog(this);

        Uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startPosting();
            }
        });

        foodCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (foodCheckBox.isChecked()) {
                    cleanCheckBox.setChecked(false);
                    repairCheckBox.setChecked(false);

                }
            }
        });

        cleanCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanCheckBox.isChecked()){
                    foodCheckBox.setChecked(false);
                    repairCheckBox.setChecked(false);
                }
            }
        });
        repairCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (repairCheckBox.isChecked()) {
                    foodCheckBox.setChecked(false);
                    cleanCheckBox.setChecked(false);
                }
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

            mImageUri = data.getData();
            UploadPic.setImageURI(mImageUri);
        }
    }


    private void startPosting() {
        mProgress.setMessage("Posting...");
        mProgress.show();

        final String title_val = TutName.getText().toString().trim();
        final String desc_val = writeText.getText().toString().trim();

        if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && mImageUri != null){

            StorageReference filepath = mStrorage.child("Blog Images").child(mImageUri.getLastPathSegment());
            filepath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {



                    @SuppressWarnings("VisibleForTests") Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    DatabaseReference newPost = mDataBase.push();
                    newPost.child("title").setValue(title_val);
                    newPost.child("Desc").setValue(desc_val);
                    newPost.child("image").setValue(downloadUrl.toString());

                    mProgress.dismiss();

                    startActivity(new Intent(Upload_Activity.this, Categories.class));
                }
            });

        }
    }




}

