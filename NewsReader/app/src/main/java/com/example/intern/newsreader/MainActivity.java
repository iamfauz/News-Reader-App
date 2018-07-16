package com.example.intern.newsreader;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.intern.newsreader.model.NewsItem;
import com.github.florent37.longshadow.LongShadow;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @author Fawaz Ahmed
 * @date 11/07/2018
 *
 */

public class MainActivity extends AppCompatActivity implements NewsAdapter.ListItemClickListener, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.recyclerview_newsItems)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tool_bar)
    android.support.v7.widget.Toolbar toolbar;


    List<NewsItem> newsItemsList;
    NewsAdapter mNewsAdapter;
    NewsItemAPI service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //(Data Binding with ButterKnife
        ButterKnife.bind(this);

        //Setting Collapsable toolbar title
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Dagger 2 ( Dependency Injection )
        NewsItemComponent daggerNewsItemComponent = DaggerNewsItemComponent.builder().contextModule(new ContextModule(this)).newsAdapterModule(new NewsAdapterModule(this)).build();
        service = daggerNewsItemComponent.getNewsItemService();
        mNewsAdapter = daggerNewsItemComponent.getNewsAdapter();

        //Initialize RecyclerView
        initRecyclerView();

        mSwipeRefreshLayout.setOnRefreshListener(this);
        /**
         * Showing Swipe Refresh animation on activity create
         * As animation won't start on onCreate, post runnable is used
         */
        mSwipeRefreshLayout.post(new Runnable() {

            @Override
            public void run() {

                mSwipeRefreshLayout.setRefreshing(true);


                // Fetching data from server
                loadDataToRecyclerView();
            }
        });

    }


    /**
     * This method is called when swipe refresh is pulled down
     */
    @Override
    public void onRefresh() {

        // Fetching data from server
        loadDataToRecyclerView();
    }


    /**
     * Method to initialize recyclerView
     */
    public void initRecyclerView() {

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);

        //Improving performance
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(20);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);


        mRecyclerView.setAdapter(mNewsAdapter);


    }


    @Override
    public void onListItemClick(NewsItem newsItem) {

        Intent intent = new Intent(getApplicationContext(), NewsItemActivity.class);
        intent.putExtra("content", newsItem.getAnnouncementHTML().getValue());
        startActivity(intent);


    }

    /**
     * Method that makes network call (Retrofit 2) and populates recyclerView
     */
    public void loadDataToRecyclerView() {

        // Showing refresh animation before making http call
        mSwipeRefreshLayout.setRefreshing(true);

        Call<List<NewsItem>> call = service.getAllNewsItems();
        call.enqueue(new Callback<List<NewsItem>>() {

            @Override
            public void onResponse(Call<List<NewsItem>> call, Response<List<NewsItem>> response) {


                newsItemsList = response.body();
                // Stopping swipe refresh
                mSwipeRefreshLayout.setRefreshing(false);

                mNewsAdapter.setNewsItemsData(newsItemsList);

            }

            @Override
            public void onFailure(Call<List<NewsItem>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Couldn't refresh feed.", Toast.LENGTH_LONG).show();
                mSwipeRefreshLayout.setRefreshing(false);



            }
        });


    }


}
