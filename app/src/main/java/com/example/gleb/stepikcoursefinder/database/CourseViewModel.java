package com.example.gleb.stepikcoursefinder.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.gleb.stepikcoursefinder.database.entity.Course;

import java.util.List;

public class CourseViewModel extends AndroidViewModel {

    private CourseRepository mRepository;

    private LiveData<List<Course>> mAllFavouritesCourses;

    public CourseViewModel(Application application) {
        super(application);
        mRepository = new CourseRepository(application);
        mAllFavouritesCourses = mRepository.getAllFavouritesCourses();
    }

    public LiveData<List<Course>> getAllFavouritesCourses() {
        return mAllFavouritesCourses;
    }

    public void insert(Course course) {
        mRepository.insert(course);
    }

    public void delete(Course course) {
        mRepository.delete(course);
    }

}
