package com.test.sisu.ui.main;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.test.sisu.models.CourseResponse;
import com.test.sisu.services.CourseService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Indigo on 9/10/16.
 */
public class MainPresenter {

    private MainContract view;
    private CourseService service;
    private Context context;

    private CourseResponse courseResponse;

    public MainPresenter(MainContract view, CourseService service, Context context) {
        this.view = view;
        this.service = service;
        this.context = context;
    }

    public void onDestroy() {
        view = null;
        context = null;
    }


    public void loadCourses(){

        view.showProgress(true);

        Call<CourseResponse> responseCall = this.service.getApi().getCourses();


        responseCall.enqueue(new Callback<CourseResponse>() {
            @Override
           public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {

                courseResponse = response.body();
                view.showProgress(false);

            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {

                view.showRequestErrorMessage(t.getLocalizedMessage());

            }
        });
    }

    public View.OnClickListener snackbarClicked() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCourses();
            }
        };

    }

    public EditText.OnEditorActionListener onCourseSubmitAction() {

        return new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                    InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(textView.getWindowToken(), 0);
                    view.performCourseSearch(textView.getText().toString(), courseResponse);

                    return true;
                }

                return false;
            }
        };

    }
}
