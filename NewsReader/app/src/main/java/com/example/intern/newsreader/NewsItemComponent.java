package com.example.intern.newsreader;


import dagger.Component;

@NewsItemApplicationScope
@Component(modules = {NewsItemModule.class, NewsAdapterModule.class})
public interface NewsItemComponent {

    NewsItemAPI getNewsItemService();
    NewsAdapter getNewsAdapter();


}
