package com.zhuyu.idouban.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Name: DoubanManager
 * Author: zhu_yu
 * Email:
 * Comment: //TODO
 * Date: 2018-10-08 15:05
 */
public class DoubanManager {

    private static DoubanService mDoubanService;

    public static DoubanService createDoubanService() {
        if (mDoubanService == null) {
            Retrofit retrofit = createRetrofit();
            mDoubanService=retrofit.create(DoubanService.class);
        }
        return mDoubanService;
    }



    private static Retrofit createRetrofit(){


        /*********************************OkHttp配置**********************************/
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        //设置超时
        okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(30, TimeUnit.SECONDS);
        //错误重连
        okHttpBuilder.retryOnConnectionFailure(true);


        //拦截器配置会按照添加的顺序执行，所以添加的时候注意顺序
        // 1、添加无网络情况的拦截器
       // okHttpBuilder.addInterceptor(new PreHandlerNoNetInterceptor());
        //2、自动追加  url参数 拦截器 这条内容实际很少使用，不用添加
        //  okHttpBuilder.addInterceptor(new AppendUrlParamInterceptor());
        //3、自动追加header参数 拦截器
        //  okHttpBuilder.addInterceptor(new AppendHeaderParamInterceptor());
        //4、okhttp信息拦截器 ，用于输出日志，一般也不使用
       HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
       okHttpBuilder.addInterceptor(httpLoggingInterceptor);


        /******************************************************************************/

        //step1：首先获取retrofit实例
        return new Retrofit.Builder()
                .baseUrl(DoubanService.BASE_URL)
                //gson解析库，可直接以实体形式拿到返回值
                .addConverterFactory(GsonConverterFactory.create())
                //支持rxjava2
               // .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //传入自定义的okhttpclient实例
                .client(okHttpBuilder.build())
                .build();
    }
}
