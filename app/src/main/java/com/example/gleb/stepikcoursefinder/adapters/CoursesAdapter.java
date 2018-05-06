package com.example.gleb.stepikcoursefinder.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gleb.stepikcoursefinder.R;
import com.example.gleb.stepikcoursefinder.database.CourseViewModel;
import com.example.gleb.stepikcoursefinder.database.entity.Course;
import com.example.gleb.stepikcoursefinder.models.SearchResult;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CoursesHolder> {
    private List<SearchResult> coursesList;
    private Context context;
    private CourseViewModel mCourseViewModel;

    public CoursesAdapter(List<SearchResult> coursesList, Context context, CourseViewModel mCourseViewModel) {
        this.coursesList = coursesList;
        this.context = context;
        this.mCourseViewModel = mCourseViewModel;
    }

    @Override
    public CoursesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_course, parent, false);
        return new CoursesHolder(v);
    }

    @Override
    public void onBindViewHolder(CoursesHolder holder, int position) {
        String courseTitle = coursesList.get(position).getCourseTitle();
        holder.tvTitle.setText(courseTitle);
        String imageUri = coursesList.get(position).getCourseCover();
        Glide.with(context).load(imageUri).into(holder.ivCourse);
        ImageButton addToFav = holder.btnAddToFavourite;
        addToFav.setOnClickListener(view -> {
            mCourseViewModel.insert(new Course(coursesList.get(position).getCourseTitle()));
            Toast.makeText(context,"Курс - " + courseTitle + " добавлен в избранное", Toast.LENGTH_SHORT).show();
            Log.d("Database", coursesList.get(position).getCourseTitle());
        });
    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }

    public class CoursesHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView ivCourse;
        ImageButton btnAddToFavourite;

        public CoursesHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvCourseTitle);
            ivCourse = view.findViewById(R.id.ivCourseImage);
            btnAddToFavourite = view.findViewById(R.id.imageStarredButton);
        }
    }
}
