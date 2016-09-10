package com.test.sisu.services;

import com.test.sisu.models.CourseResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Indigo on 9/10/16.
 */
public class CourseService {

    private final String BASE_URL = "http://enem-wbgsixqvxv.prod.gkn.io/";
    private CourseApi courseApi;

    public CourseService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        courseApi = retrofit.create(CourseApi.class);
    }

    public CourseApi getApi() {
        return courseApi;
    }


    public interface CourseApi {

        @GET("courses/")
        Call<CourseResponse> getCourses();

    }
}
