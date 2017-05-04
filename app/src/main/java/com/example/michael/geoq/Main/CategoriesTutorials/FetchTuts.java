package com.example.michael.geoq.Main.CategoriesTutorials;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.michael.geoq.Main.MainStuff.Blog;
import com.example.michael.geoq.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FetchTuts extends AppCompatActivity {

    private RecyclerView mTutsList;
    private DatabaseReference mDatabase;
    private static final String ROOT_PATH="Tutorial_up/";
    private static final String FOOD_PATH="FOOD";
    private static final String CLEAN_PATH="CLEAN";
    private static final String REPAIR_PATH="REPAIR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_tutts);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Tutorial_up");

        mTutsList = (RecyclerView) findViewById(R.id.FetchTuts);
        mTutsList.setHasFixedSize(true);
        mTutsList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Blog, BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Blog, BlogViewHolder>(

                Blog.class,
                R.layout.blog_row,
                BlogViewHolder.class,
                mDatabase



        ) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Blog model, int position) {

                viewHolder.setTilte(model.getTitle());
                viewHolder.setDesc(model.getDesc());

            }
        };

        mTutsList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder{

        View mView;


        public BlogViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setTilte(String tilte){

            TextView post_title = (TextView) mView.findViewById(R.id.post_title);
            post_title.setText(tilte);

        }

        public void setDesc(String Desc){

            TextView post_desc = (TextView) mView.findViewById(R.id.post_desc);
            post_desc.setText(Desc);
        }
    }
}
