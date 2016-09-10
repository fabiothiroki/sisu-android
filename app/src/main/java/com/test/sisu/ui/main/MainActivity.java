package com.test.sisu.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.test.sisu.R;
import com.test.sisu.services.CourseService;

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

    private void setupPresenter() {

        mainPresenter = new MainPresenter(this, new CourseService());
        mainPresenter.loadCourses();
    }

    private void setupEditTexts() {

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


}
