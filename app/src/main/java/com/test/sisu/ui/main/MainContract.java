package com.test.sisu.ui.main;

/**
 * Created by Indigo on 9/10/16.
 */
public interface MainContract {

    void showProgress(boolean show);

    void showRequestErrorMessage(String message);

    void performCourseSearch(String course);
}
