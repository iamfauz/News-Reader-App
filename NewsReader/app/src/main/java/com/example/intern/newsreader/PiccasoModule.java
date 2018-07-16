package com.example.intern.newsreader;

import android.content.Context;

import com.example.intern.newsreader.ContextModule;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;


/**
 * @author Fawaz Ahmed
 * @date 11/07/2018
 *
 */

@Module(includes = ContextModule.class)
public class PiccasoModule {


    @Provides
    public Picasso picasso(Context context){
        return new Picasso.Builder(context).
                downloader(new OkHttp3Downloader(context)).
                build();
    }
}
