package com.example.intern.newsreader;

import com.example.intern.newsreader.model.NewsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsItemAPI {

    @GET("ipdpb.ashx?TemplateName=Promotions_ipad.htm&p=Common.Announcements&Handler=News&AppName=EMC&Type=News&F=J")
    Call<List<NewsItem>> getAllNewsItems();

}
