package com.example.mock_cgv.src.main.event;

import android.content.Context;
import android.media.Image;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.mock_cgv.R;
import com.github.demono.AutoScrollViewPager;
import com.github.demono.adapter.InfinitePagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class AutoScrollAdapter extends InfinitePagerAdapter {
    private List<String> mData;
    private Context mContext;

    public AutoScrollAdapter(List<String> data, Context context) {
        this.mData = data;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup container) {
        ((ViewGroup) container.getParent()).removeView(convertView);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.event_auto_viewpager, null);
        ImageView image_container = (ImageView) convertView.findViewById(R.id.image_container);
        Glide.with(mContext).load(mData.get(position)).into(image_container);
        ((ViewGroup) container.getParent()).removeView(convertView);
        container.addView(convertView);
        container.removeView(convertView);

        return convertView;
    }
}
