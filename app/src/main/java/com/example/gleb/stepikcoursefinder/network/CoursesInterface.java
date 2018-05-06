package com.example.gleb.stepikcoursefinder.network;

import com.example.gleb.stepikcoursefinder.models.CoursesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface CoursesInterface {
    @GET("search-results")
    Observable<CoursesResponse> getAllCourses();
    @GET("search-results")
    Observable<CoursesResponse> getCoursesByName(@Query("query") String name);
}
