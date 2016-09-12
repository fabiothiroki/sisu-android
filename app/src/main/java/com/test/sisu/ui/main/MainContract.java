package com.test.sisu.ui.main;

import com.test.sisu.models.CourseResponse;

/**
 * Created by Indigo on 9/10/16.
 */
public interface MainContract {

    void showProgress(boolean show);

    void showRequestErrorMessage(String message);

    void performCourseSearch(String course, CourseResponse courseResponse);
}
