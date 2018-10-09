package com.zhuyu.idouban.movie;

import com.zhuyu.idouban.BasePresnenter;
import com.zhuyu.idouban.BaseView;
import com.zhuyu.idouban.beans.Movie;

import java.util.List;

/**
 * Name: MoviesContract
 * Author: zhu_yu
 * Email:
 * Comment: //TODO
 * Date: 2018-10-09 15:27
 */
public interface MoviesContract {

    interface  View extends BaseView<Presenter>{
        void showMovies(List<Movie> movies);
        void showNoMovies();
        void showLoading(boolean active);
    }

    interface  Presenter extends BasePresnenter{
        void loadMovies();
    }


}
