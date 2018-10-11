package com.zhuyu.idouban.movie;

import com.zhuyu.idouban.BasePresnenter;
import com.zhuyu.idouban.BaseView;
import com.zhuyu.idouban.beans.Movie;

import java.util.List;

/**
 * MVP合约类
 * Name: MoviesContract
 * Author: zhu_yu
 * Email:
 * Comment: //TODO
 * Date: 2018-10-09 15:27
 */
public interface MoviesContract {

    interface  View extends BaseView<Presenter>{
        /**展示电影数据**/
        void showMovies(List<Movie> movies);
        /**无数据**/
        void showNoMovies();
        /***显示加载圈圈*/
        void showLoading(boolean active);
    }

    interface  Presenter extends BasePresnenter{

        /**加载电影**/
        void loadMovies();
    }


}
