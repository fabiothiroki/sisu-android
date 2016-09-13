package com.test.sisu.ui.search;

import com.test.sisu.models.Course;
import com.test.sisu.models.CourseResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Indigo on 9/12/16.
 */
public class SearchPresenter {

    private SearchContract searchContract;
    private CourseResponse courseResponse;

    public SearchPresenter(SearchContract searchContract, CourseResponse courseResponse) {
        this.searchContract = searchContract;
        this.courseResponse = courseResponse;
    }

    public void onDestroy() {
        this.searchContract = null;
    }

    public void onSearchStringChanged(String searchString) {

        CourseResponse newReponse = new CourseResponse();
        newReponse.courses = new ArrayList<>();

        for (Course course : courseResponse.courses) {

            if (course.name.toLowerCase().startsWith(searchString.toLowerCase())) {
                newReponse.courses.add(course);
            }
        }

        Collections.sort(newReponse.courses, new Comparator<Course>() {
            @Override
            public int compare(Course course1, Course course2) {
                return course1.name.compareTo(course2.name);
            }
        });

        searchContract.setNewDataSource(newReponse);
    }
}
