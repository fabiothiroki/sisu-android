package com.test.sisu.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.test.sisu.R;
import com.test.sisu.services.CourseService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract {

    @BindView(R.id.main_content)
    View contentView;

    @BindView(R.id.main_loading)
    View loadingView;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupPresenter();

    }

    private void setupPresenter() {

        mainPresenter = new MainPresenter(this, new CourseService());
        mainPresenter.loadCourses();
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            loadingView.setVisibility(View.VISIBLE);
            contentView.setVisibility(View.GONE);
        } else {
            loadingView.setVisibility(View.GONE);
            contentView.setVisibility(View.VISIBLE);
        }
    }
}
