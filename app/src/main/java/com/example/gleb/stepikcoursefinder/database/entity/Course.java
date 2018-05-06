package com.example.gleb.stepikcoursefinder.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "favourites_courses")
public class Course {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    private String courseTitle;

    //для добавления картинки
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    public Course(@NonNull String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @NonNull
    public String getCourseTitle() {
        return courseTitle;
    }

    public byte[] getImage() {
        return image;
    }
}
