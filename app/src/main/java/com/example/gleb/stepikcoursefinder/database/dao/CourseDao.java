package com.example.gleb.stepikcoursefinder.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.gleb.stepikcoursefinder.database.entity.Course;

import java.util.List;

@Dao
public interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Course course);

    @Delete
    void delete(Course course);

    @Query("SELECT * FROM favourites_courses WHERE title LIKE :arg0")
    List<Course> getCourseByName(String arg0);

    @Query("DELETE FROM favourites_courses")
    void deleteAll();

    @Query("SELECT * from favourites_courses ORDER BY title ASC")
    LiveData<List<Course>> getAllCourses();
}
