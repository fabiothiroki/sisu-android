package com.test.sisu.ui.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.test.sisu.R;
import com.test.sisu.models.CourseResponse;
import com.test.sisu.services.CourseService;
import com.test.sisu.ui.search.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract {

    @BindView(R.id.main_content)
    View contentView;

    @BindView(R.id.main_loading)
    View loadingView;

    @BindView(R.id.search_course)
    EditText searchCourse;

    @BindView(R.id.search_institution)
    EditText searchInstitution;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupPresenter();
        setupEditTexts();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mainPresenter.onDestroy();
    }

    private void setupPresenter() {

        mainPresenter = new MainPresenter(this, new CourseService(), this);
        mainPresenter.loadCourses();
    }

    private void setupEditTexts() {
        searchCourse.setOnEditorActionListener(mainPresenter.onCourseSubmitAction());
    }

    @Override
    public void showProgress(final boolean show) {
        if (show) {
            loadingView.setVisibility(View.VISIBLE);
            contentView.setVisibility(View.GONE);
        } else {
            loadingView.setVisibility(View.GONE);
            contentView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showRequestErrorMessage(final String message) {

        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.request_try_again, mainPresenter.snackbarClicked())
                .setActionTextColor(Color.RED)
                .show();
    }

    @Override
    public void performCourseSearch(final String course, final CourseResponse response) {

        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra(SearchActivity.BUNDLE_COURSE, course);
        intent.putExtra(SearchActivity.BUNDLE_ALL_COURSES, new Gson().toJson(response));
        startActivity(intent);

    }


}
