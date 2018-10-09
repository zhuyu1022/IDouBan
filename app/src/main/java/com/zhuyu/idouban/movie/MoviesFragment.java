package com.zhuyu.idouban.movie;


import android.content.Context;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zhuyu.idouban.R;
import com.zhuyu.idouban.api.DoubanManager;
import com.zhuyu.idouban.api.DoubanService;
import com.zhuyu.idouban.beans.Movie;
import com.zhuyu.idouban.beans.MoviesInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment implements  MoviesContract.View{
    private static final String TAG = MoviesFragment.class.getSimpleName();

    public MoviesFragment() {
        // Required empty public constructor
    }

    private List<Movie> mMovies=new ArrayList<>() ;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    MoviesAdapter mAdapter;
    MoviesPresenter mPresenter;
    private Context mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        mRecyclerView = view.findViewById(R.id.movie_recyclerView);
        mProgressBar = view.findViewById(R.id.movie_progressBar);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity().getApplicationContext(),2);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new MoviesAdapter(mMovies, getActivity().getApplicationContext(), R.layout.recyclerview_movies_item);
        mRecyclerView.setAdapter(mAdapter);
        createPresenter();

    }


    private void createPresenter(){
        mPresenter=new MoviesPresenter(this);
        mPresenter.loadMovies();
    }


    @Override
    public void showMovies(List<Movie> movies) {
        mMovies.clear();
        mMovies.addAll(movies);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNoMovies() {
        Toast.makeText(mContext, "没有数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(boolean active) {
            if(active){
                mProgressBar.setVisibility(View.VISIBLE);
            }else{
                mProgressBar.setVisibility(View.INVISIBLE);
            }
    }

    @Override
    public void setPresenter(MoviesContract.Presenter presenter) {

    }
}
