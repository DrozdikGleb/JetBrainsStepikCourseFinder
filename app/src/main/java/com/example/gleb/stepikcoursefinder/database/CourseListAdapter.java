package com.example.gleb.stepikcoursefinder.database;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gleb.stepikcoursefinder.R;
import com.example.gleb.stepikcoursefinder.database.entity.Course;

import java.util.List;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseViewHolder> {

    private final LayoutInflater mInflater;
    private List<Course> mCourses;
    private CourseViewModel mCourseViewModel;


    public CourseListAdapter(Context context, CourseViewModel mCourseViewModel) {
        mInflater = LayoutInflater.from(context);
        this.mCourseViewModel = mCourseViewModel;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.row_favourite_course, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        Course current = mCourses.get(position);
        holder.courseItemView.setText(current.getCourseTitle());
        ImageButton addToFav = holder.deleteFromFavourite;
        addToFav.setOnClickListener(view -> {
            mCourseViewModel.delete(current);
        });
       /* byte []bitMapData = current.getImage();
        holder.courseImageView.setImageBitmap(BitmapFactory.decodeByteArray(bitMapData, 0, bitMapData.length));*/
    }

    public void setCourses(List<Course> courses) {
        mCourses = courses;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mCourses != null)
            return mCourses.size();
        else return 0;
    }

    class CourseViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseItemView;
        private ImageButton deleteFromFavourite;
        //private ImageView courseImageView;

        private CourseViewHolder(View itemView) {
            super(itemView);
            courseItemView = itemView.findViewById(R.id.tvFavouriteCourseTitle);
            deleteFromFavourite = itemView.findViewById(R.id.imageDeleteStarredButton);
            // courseImageView = itemView.findViewById(R.id.ivCourseImage);
        }
    }
}
