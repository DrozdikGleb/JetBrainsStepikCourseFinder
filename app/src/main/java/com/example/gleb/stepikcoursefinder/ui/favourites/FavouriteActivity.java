package com.example.gleb.stepikcoursefinder.ui.favourites;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.gleb.stepikcoursefinder.R;
import com.example.gleb.stepikcoursefinder.database.CourseListAdapter;
import com.example.gleb.stepikcoursefinder.database.CourseViewModel;

public class FavouriteActivity extends AppCompatActivity {
    private CourseViewModel mCourseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        Toolbar toolbar = findViewById(R.id.toolbar_favourites);
        toolbar.setTitle("Избранные курсы");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.rvFavouritesCourses);
        mCourseViewModel = ViewModelProviders.of(this).get(CourseViewModel.class);
        final CourseListAdapter adapter = new CourseListAdapter(this, mCourseViewModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCourseViewModel.getAllFavouritesCourses().observe(this, adapter::setCourses);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
