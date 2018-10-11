package com.zhuyu.idouban.MovieDetail;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.zhuyu.idouban.R;
import com.zhuyu.idouban.beans.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailContract.View {
    private ImageView imageView;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewpager;
    private String mInfo = "";
    private String mAlt = "";

    private MovieDetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initPresenter();
        initView();
        mPresenter.start();

    }
    private void initPresenter(){
        new MovieDetailPresenter((Movie) getIntent().getExtras().get("movie"), this);

    }



    private void initView() {
        imageView = findViewById(R.id.imageView);
        toolbar = findViewById(R.id.toolbar);
        viewpager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout);
        mPresenter.loadMovieInfo();
        mPresenter.loadMovieAlt();

        MovieDetailFragment infoFragment = MovieDetailFragment.newInstance(mInfo, MovieDetailFragment.TYPE_INFO);
        MovieDetailFragment altFragment = MovieDetailFragment.newInstance(mAlt, MovieDetailFragment.TYPE_ALT);
        MovieDetailPagerAdapter adapter=new MovieDetailPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(infoFragment,"详情");
        adapter.addFragment(altFragment,"导演");
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);

    }

    private class MovieDetailPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragmentList = new ArrayList<>();
        private List<String> mTitles = new ArrayList<>();

        public MovieDetailPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mTitles.add(title);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }
    @Override
    public void showCollapsingToolBarTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public void showImage(String imagePath) {
        Glide.with(this).load(imagePath).into(imageView);
    }

    @Override
    public void showMovieInfo(String info) {
        mInfo = info;
    }

    @Override
    public void showMovieAlt(String alt) {
        mAlt = alt;
    }

    @Override
    public void setPresenter(MovieDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
