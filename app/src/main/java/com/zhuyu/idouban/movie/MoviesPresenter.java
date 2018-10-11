package com.zhuyu.idouban.movie;

import android.util.Log;

import com.zhuyu.idouban.api.DoubanManager;
import com.zhuyu.idouban.api.DoubanService;
import com.zhuyu.idouban.beans.Movie;
import com.zhuyu.idouban.beans.MoviesInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Name: MoviesPresenter
 * Author: zhu_yu
 * Email:
 * Comment: //TODO
 * Date: 2018-10-09 15:40
 */
public class MoviesPresenter implements MoviesContract.Presenter {
    private static final String TAG = MoviesPresenter.class.getSimpleName();

    private MoviesContract.View mMoviesView;

    public MoviesPresenter(MoviesContract.View moviesView) {

        this.mMoviesView = moviesView;
         moviesView.setPresenter(this);
    }


    @Override
    public void loadMovies() {
        mMoviesView.showLoading(true);
        loadMoviesFromNet();
    }

    @Override
    public void start() {
        loadMoviesFromNet();
    }

    private void loadMoviesFromNet() {
        DoubanService service = DoubanManager.createDoubanService();
        service.searchMovies().enqueue(new Callback<MoviesInfo>() {
            @Override
            public void onResponse(Call<MoviesInfo> call, Response<MoviesInfo> response) {
                mMoviesView.showLoading(false);
                List<Movie> movies = response.body().getMovies();
                if (movies != null && movies.size() > 0) {
                    mMoviesView.showMovies(movies);
                } else {
                    mMoviesView.showNoMovies();
                }
            }

            @Override
            public void onFailure(Call<MoviesInfo> call, Throwable t) {
                Log.d(TAG, "onFailure: ===>" + Thread.currentThread().getId() + "error:" + t.getMessage());
                mMoviesView.showLoading(false);
                mMoviesView.showNoMovies();
            }
        });
    }



}
