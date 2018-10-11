package com.zhuyu.idouban.MovieDetail;

import android.support.design.widget.CollapsingToolbarLayout;

import com.zhuyu.idouban.BasePresnenter;
import com.zhuyu.idouban.BaseView;

/**
 * Name: MovieDetailContract
 * Author: zhu_yu
 * Email:
 * Comment: //TODO
 * Date: 2018-10-10 15:15
 */
public interface MovieDetailContract {

    interface  View extends BaseView<Presenter>{
        void  showCollapsingToolBarTitle(String title);
        void showImage(String imagePath);
        void showMovieInfo(String info);
        void showMovieAlt(String alt);
    }
    interface  Presenter extends BasePresnenter{
        void loadMovieInfo();
        void loadMovieAlt();
    }

}
