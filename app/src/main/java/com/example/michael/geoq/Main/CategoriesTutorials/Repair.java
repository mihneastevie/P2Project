package com.example.michael.geoq.Main.CategoriesTutorials;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.michael.geoq.Main.MainStuff.Profile;
import com.example.michael.geoq.R;

public class Repair extends AppCompatActivity implements View.OnClickListener{


private Button buttonTutorial1;
    public static class Post {

        public String author;
        public String title;

        public Post(String author, String title) {
            // ...
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference ref = database.getReference("https://p2project-36a2e.firebaseio.com/Tutorial_up/REPAIR");
//        ref.child("REPAIR").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//
//                Post post = dataSnapshot.getValue(Post.class);
//                System.out.println(post);
//
//
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        buttonTutorial1 = (Button) findViewById(R.id.buttonTutorial1);

        buttonTutorial1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == buttonTutorial1) {
            startActivity(new Intent(this, Profile.class));

        }

    }
}
