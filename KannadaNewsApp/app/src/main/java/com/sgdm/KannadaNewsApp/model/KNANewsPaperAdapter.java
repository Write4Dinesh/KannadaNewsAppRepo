package com.sgdm.KannadaNewsApp.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sgdm.KannadaNewsApp.R;
import com.sgdm.KannadaNewsApp.analytics.KNAGAEventsData;
import com.sgdm.KannadaNewsApp.analytics.KNAGoogleAnalytics;
import com.sgdm.KannadaNewsApp.ui.KNABrowserActivity;

import java.util.List;

public class KNANewsPaperAdapter extends RecyclerView.Adapter<KNANewsPaperAdapter.NewsViewHolder> {

    private List<KNANewsPaper> mNewsPapers;
    private Context mContext;

    public KNANewsPaperAdapter(List<KNANewsPaper> newsPapers, Context context) {
        this.mNewsPapers = newsPapers;
        mContext = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_paper_item_template, parent, false);
        NewsViewHolder viewHolder = new NewsViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        final KNANewsPaper currentNewsPaper = mNewsPapers.get(position);
        holder.mNameTv.setText(currentNewsPaper.getName());
        holder.mNameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(KNAUtils.isConnected(mContext)) {
                    launchBrowser(currentNewsPaper.getName(), currentNewsPaper.getUrl());
                }else {
                    KNAUtils.showDialog(mContext, mContext.getString(R.string.error_not_connected), mContext.getString(R.string.alert_button_label));
                }
            }
        });
    }

    private void launchBrowser(String title, String url) {
        KNAGoogleAnalytics.sendCustomEvent(KNAGAEventsData.CUSTOM_EVENT_CATEGORY_LAUNCH_NEWS, title);
        Intent browserIntent = new Intent(mContext, KNABrowserActivity.class);
        browserIntent.putExtra(KNAConstants.INTENT_EXTRA_URL, url);
        browserIntent.putExtra(KNAConstants.INTENT_EXTRA_TITLE, title);
        mContext.startActivity(browserIntent);
    }
    @Override
    public int getItemCount() {
        if (mNewsPapers != null) {
            return mNewsPapers.size();
        }
        return 0;
    }
    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView mNameTv;
        View mItemView;

        NewsViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            mNameTv = mItemView.findViewById(R.id.np_name_tv);

        }
    }
}
