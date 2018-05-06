package com.example.gleb.stepikcoursefinder.ui.main;

import android.app.SearchManager;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gleb.stepikcoursefinder.R;
import com.example.gleb.stepikcoursefinder.adapters.CoursesAdapter;
import com.example.gleb.stepikcoursefinder.database.CourseViewModel;
import com.example.gleb.stepikcoursefinder.models.CoursesResponse;
import com.example.gleb.stepikcoursefinder.ui.favourites.FavouriteActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    private static final String TAG = "MainActivity";
    @BindView(R.id.rvCourses)
    RecyclerView rvCourses;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    RecyclerView.Adapter adapter;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupMVP();
        setupViews();
    }

    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void setupViews() {
        setSupportActionBar(toolbar);
        rvCourses.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void displayCourses(CoursesResponse coursesResponse) {
        if (coursesResponse != null) {
            adapter = new CoursesAdapter(coursesResponse.getSearchResults(), MainActivity.this, ViewModelProviders.of(this).get(CourseViewModel.class));
            rvCourses.setAdapter(adapter);
        } else {
            Log.d(TAG, "Courses response null");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Введите название курса");
        mainPresenter.getResultsBasedOnQuery(searchView);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        } else if (id == R.id.action_go_to_favourites) {
            Intent intent = new Intent(MainActivity.this, FavouriteActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
