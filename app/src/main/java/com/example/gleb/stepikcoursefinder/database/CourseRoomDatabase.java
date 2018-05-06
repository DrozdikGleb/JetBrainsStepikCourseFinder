package com.example.gleb.stepikcoursefinder.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.gleb.stepikcoursefinder.database.dao.CourseDao;
import com.example.gleb.stepikcoursefinder.database.entity.Course;

@Database(entities = {Course.class}, version = 1)
public abstract class CourseRoomDatabase extends RoomDatabase {

    private static CourseRoomDatabase INSTANCE;

    static CourseRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CourseRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CourseRoomDatabase.class, "favourites_courses")
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    public abstract CourseDao courseDao();

}
