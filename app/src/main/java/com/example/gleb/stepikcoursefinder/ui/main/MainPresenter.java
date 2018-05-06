package com.example.gleb.stepikcoursefinder.ui.main;

import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.Toast;

import com.example.gleb.stepikcoursefinder.models.CoursesResponse;
import com.example.gleb.stepikcoursefinder.network.CoursesClient;
import com.example.gleb.stepikcoursefinder.network.CoursesInterface;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class MainPresenter implements MainPresenterInterface {
    MainViewInterface mainViewInterface;
    private String TAG = "MainPresenter";

    public MainPresenter(MainViewInterface mainViewInterface) {
        this.mainViewInterface = mainViewInterface;
    }

    @Override
    public void getResultsBasedOnQuery(SearchView searchView) {
        getObservableQuery(searchView)
                .filter(s -> !s.equals(""))
                .debounce(2, TimeUnit.SECONDS)
                .distinctUntilChanged()
                .switchMap(s -> CoursesClient.getRetrofit().create(CoursesInterface.class)
                        .getCoursesByName(s))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver());
    }

    private Observable<String> getObservableQuery(SearchView searchView) {

        final PublishSubject<String> publishSubject = PublishSubject.create();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                publishSubject.onNext(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                publishSubject.onNext(newText);
                return true;
            }
        });

        return publishSubject;
    }

    public DisposableObserver<CoursesResponse> getObserver() {
        return new DisposableObserver<CoursesResponse>() {

            @Override
            public void onNext(@NonNull CoursesResponse coursesResponse) {
                Log.d(TAG, "OnNext" + coursesResponse.getSearchResults());
                mainViewInterface.displayCourses(coursesResponse);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Error" + e);
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };
    }
}
