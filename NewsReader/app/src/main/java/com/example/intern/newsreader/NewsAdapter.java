package com.example.intern.newsreader;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.intern.newsreader.model.NewsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * @author Fawaz Ahmed
 * @date 11/07/2018
 *
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder> {


    //Data store
    List<NewsItem> mNewsItemList;


    @Inject
    Picasso picasso;


    //Handling Clicks
    public interface ListItemClickListener {

        void onListItemClick(NewsItem newsItem);

    }

    private ListItemClickListener mOnclickListener;

    @Inject
    public NewsAdapter(ListItemClickListener listener, Picasso picasso) {

        mOnclickListener = listener;

        this.picasso = picasso;


    }


    //ViewHolder Class for normal
    public class NewsAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Views
        public @BindView(R.id.announcement_title)
        TextView titleTextView;
        public @BindView(R.id.announcement_date)
        TextView dateTextView;
        public @BindView(R.id.coverImage)
        ImageView coverImage;


        public NewsItem newsItem;

        public NewsAdapterViewHolder(View view) {
            super(view);


            ButterKnife.bind(this, view);

            view.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            mOnclickListener.onListItemClick(mNewsItemList.get(position));

        }


    }


    @NonNull
    @Override
    public NewsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.news_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new NewsAdapterViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapterViewHolder holder, int position) {


        holder.newsItem = mNewsItemList.get(position);
        holder.titleTextView.setText(mNewsItemList.get(position).getAnnouncementTitle().getValue());
        holder.dateTextView.setText(mNewsItemList.get(position).getAnnouncementDate().getValue());

        //Image View Logic
        if (!TextUtils.isEmpty(mNewsItemList.get(position).getAnnouncementImageThumbnail().getValue())) {

            picasso.load(mNewsItemList.get(position).getAnnouncementImageThumbnail().getValue())
                    .placeholder((R.drawable.ic_launcher_background))
                    .fit()
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.coverImage);
        }


    }


    @Override
    public int getItemCount() {

        if (mNewsItemList == null)
            return 0;
        else
            return mNewsItemList.size();
    }


    public void setNewsItemsData(List<NewsItem> newsItemList) {
        mNewsItemList = newsItemList;
        notifyDataSetChanged();
    }


}