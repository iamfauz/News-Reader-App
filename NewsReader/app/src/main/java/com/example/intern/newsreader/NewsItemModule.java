package com.example.intern.newsreader;


import com.example.intern.newsreader.NewsItemAPI;
import com.example.intern.newsreader.NewsItemApplicationScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author Fawaz Ahmed
 * @date 11/07/2018
 *
 */

@Module
public class NewsItemModule {

    private static final String BASE_URL = "http://94.56.199.34/EMC/IPDP/";

    @NewsItemApplicationScope
    @Provides
    public NewsItemAPI newsItemAPI(Retrofit retrofit){
        return retrofit.create(NewsItemAPI.class);
    }

    @NewsItemApplicationScope
    @Provides
    public Retrofit retrofit(GsonConverterFactory gsonConverterFactory, Gson gson){

        return new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }


}
