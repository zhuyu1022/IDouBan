package com.zhuyu.idouban;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zhuyu.idouban.book.BooksFragment;
import com.zhuyu.idouban.movie.MoviesFragment;
import com.zhuyu.idouban.movie.MoviesPresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        initView( );
    }


    private void initView( ) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ViewPager viewPager = findViewById(R.id.home_viewPager);
        TabLayout tabLayout = findViewById(R.id.home_tablayout);
        tabLayout.setupWithViewPager(viewPager);
        DouBanPagerAdapter adapter = new DouBanPagerAdapter(getSupportFragmentManager());
        MoviesFragment movieFragment = new MoviesFragment();
        BooksFragment bookFragment = new BooksFragment();
        adapter.addFragment(movieFragment, "电影");
        adapter.addFragment(bookFragment, "书籍");
        viewPager.setAdapter(adapter);

        //初始化presenter，传入view进行关联
         new MoviesPresenter(movieFragment);
    }






    private class DouBanPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragmentList = new ArrayList<>();
        private List<String> mTitles = new ArrayList<>();

        public DouBanPagerAdapter(FragmentManager fm) {
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

}
