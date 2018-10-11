package com.zhuyu.idouban.MovieDetail;

import com.zhuyu.idouban.beans.Movie;
import com.zhuyu.idouban.movie.MoviesContract;

import java.util.List;

/**
 * Name: MovieDetailPresenter
 * Author: zhu_yu
 * Email:
 * Comment: //TODO
 * Date: 2018-10-10 15:38
 */
public class MovieDetailPresenter implements MovieDetailContract.Presenter {

    private MovieDetailContract.View mView;
    private Movie mMovie;

    public MovieDetailPresenter(Movie movie, MovieDetailContract.View view) {
        mMovie = movie;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void loadMovieInfo() {



        StringBuilder movieInfo = new StringBuilder();
        movieInfo.append("导演：");
        List<Movie.DirectorsBean> directors = mMovie.getDirectors();
        if (directors != null && directors.size() > 0) {
            for (Movie.DirectorsBean director :
                    directors) {
                movieInfo.append(director.getName() + " ");
            }
        }
        movieInfo.append("\n" + "年份：");
        movieInfo.append(mMovie.getYear());
        movieInfo.append("\n" + "类型：");
        movieInfo.append(mMovie.getGenres().toString());
        movieInfo.append("\n" + "又名：");
        movieInfo.append(mMovie.getOriginal_title());
        movieInfo.append("\n" + "主演：");
        List<Movie.CastsBean> casts = mMovie.getCasts();
        if (casts != null && casts.size() > 0) {
            for (Movie.CastsBean cast :
                    casts) {
                movieInfo.append(cast.getName() + " ");
            }
        }
        mView.showMovieInfo(movieInfo.toString());


    }

    @Override
    public void loadMovieAlt() {

    }

    @Override
    public void start() {
        String url = mMovie.getImages().getLarge();
        mView.showImage(url);
        String title = mMovie.getTitle();
        mView.showCollapsingToolBarTitle(title);
    }
}
