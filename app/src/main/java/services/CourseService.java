package services;

/**
 * Created by Indigo on 9/10/16.
 */
public class CourseService {

    private final String BASE_URL = "http://enem-wbgsixqvxv.prod.gkn.io"
    private

    public CourseService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();
    }


    interface CourseApi {

    }
}
