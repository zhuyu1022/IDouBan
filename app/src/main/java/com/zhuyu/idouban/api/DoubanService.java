package com.zhuyu.idouban.api;

import com.zhuyu.idouban.beans.MoviesInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Name: DoubanService
 * Author: zhu_yu
 * Email:
 * Comment: //TODO
 * Date: 2018-10-08 15:05
 */
public interface DoubanService {
    String BASE_URL="http://api.douban.com/v2/";


    @GET("movie/in_theaters")
    Call<MoviesInfo> searchMovies();

}
