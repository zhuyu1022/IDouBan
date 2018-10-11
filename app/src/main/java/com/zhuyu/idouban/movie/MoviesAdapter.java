package com.zhuyu.idouban.movie;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuyu.idouban.MovieDetail.MovieDetailActivity;
import com.zhuyu.idouban.MovieDetail.MovieDetailPresenter;
import com.zhuyu.idouban.R;
import com.zhuyu.idouban.beans.Movie;

import java.util.List;

/**
 * Name: MoviesAdapter
 * Author: zhu_yu
 * Email:
 * Comment: //TODO
 * Date: 2018-10-08 16:36
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private Context mContext;
    @LayoutRes
    private int layoutResID;

    public MoviesAdapter(List<Movie> movies, Context mContext, int layoutResId) {
        this.movies = movies;
        this.mContext = mContext;
        this.layoutResID = layoutResId;
    }

    @NonNull
    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(mContext).inflate(layoutResID, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        if (holder == null) {
            return;
        }
        holder.updateMovie(movies.get(position));
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTv;
        TextView scoreTv;
        ImageView imageView;
        RatingBar ratingBar;
        Movie movie;


        public MovieViewHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.movie_item_titleTv);
            scoreTv = itemView.findViewById(R.id.movie_item_scoreTv);
            imageView = itemView.findViewById(R.id.movie_item_imageView);
            ratingBar = itemView.findViewById(R.id.movie_item_ratingBar);
            itemView.setOnClickListener(this);
        }

        /**
         * 展示页面数据
         *
         * @param movie
         */
        public void updateMovie(Movie movie) {
            this.movie = movie;
            titleTv.setText(movie.getTitle());
            scoreTv.setText(movie.getRating().getAverage() + "");
            Glide.with(itemView.getContext()).load(movie.getImages().getLarge()).into(imageView);
            ratingBar.setRating((float) movie.getRating().getAverage() / 2);
        }


        @Override
        public void onClick(View view) {
            if (movie == null);
            Intent intent=new Intent(itemView.getContext(),MovieDetailActivity.class);
           intent.putExtra("movie",  movie);
            itemView.getContext().startActivity(intent );

        }
    }


}
