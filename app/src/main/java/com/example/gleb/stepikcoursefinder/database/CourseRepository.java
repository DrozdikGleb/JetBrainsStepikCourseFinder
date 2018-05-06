package com.example.gleb.stepikcoursefinder.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.gleb.stepikcoursefinder.database.dao.CourseDao;
import com.example.gleb.stepikcoursefinder.database.entity.Course;

import java.util.List;


public class CourseRepository {
    private CourseDao courseDao;
    private LiveData<List<Course>> mAllFavouritesCourses;

    CourseRepository(Application application) {
        CourseRoomDatabase db = CourseRoomDatabase.getDatabase(application);
        courseDao = db.courseDao();
        mAllFavouritesCourses = courseDao.getAllCourses();
    }

    LiveData<List<Course>> getAllFavouritesCourses() {
        return mAllFavouritesCourses;
    }

    public void insert(Course course) {
        new insertAsyncTask(courseDao).execute(course);
    }

    public void delete(Course course) {
        new deleteAsyncTask(courseDao).execute(course);
    }

    private static class insertAsyncTask extends AsyncTask<Course, Void, Void> {

        private CourseDao mAsyncTaskDao;

        insertAsyncTask(CourseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Course... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Course, Void, Void> {

        private CourseDao mAsyncTaskDao;

        deleteAsyncTask(CourseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Course... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }
}
