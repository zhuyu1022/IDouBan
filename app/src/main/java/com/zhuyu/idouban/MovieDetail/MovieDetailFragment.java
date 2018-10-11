package com.zhuyu.idouban.MovieDetail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhuyu.idouban.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {
    private String mType = "";
public static final String TYPE_ALT="1";
    public static final String TYPE_INFO="2";
    public MovieDetailFragment() {

    }
    TextView infoTv;
    public static MovieDetailFragment newInstance(String info,String type) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putString("info", info);
        args.putString("type", type);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        initView(view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String info=getArguments().getString("info");
        mType=getArguments().getString("type");
        infoTv.setText(info);

    }

    private void initView(View view) {
        infoTv= view.findViewById(R.id.infoTv);
        infoTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TYPE_ALT.equals(mType)){

                }
            }
        });
    }


}
