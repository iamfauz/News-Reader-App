package com.example.intern.newsreader;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module(includes = PiccasoModule.class)
public class NewsAdapterModule {

    NewsAdapter.ListItemClickListener listener;

    @Provides
    public NewsAdapter newsAdapter(Picasso piccaso) {

        return new NewsAdapter(listener, piccaso);
    }

    public NewsAdapterModule(NewsAdapter.ListItemClickListener listener){

        this.listener = listener;


    }

}
