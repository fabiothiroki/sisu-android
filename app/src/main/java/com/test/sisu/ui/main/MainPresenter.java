package com.test.sisu.ui.main;

import android.util.Log;

import com.test.sisu.models.CourseResponse;
import com.test.sisu.services.CourseService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Indigo on 9/10/16.
 */
public class MainPresenter {

    private MainActivity view;
    private CourseService service;

    public MainPresenter(MainActivity view, CourseService service) {
        this.view = view;
        this.service = service;
    }

    public void loadCourses(){

        // TODO: loading state

        Call<CourseResponse> responseCall = this.service.getApi().getCourses();


        responseCall.enqueue(new Callback<CourseResponse>() {
            @Override
            public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {

                Log.e(">>", response.body().toString());

            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {

            }
        });

    }
}
