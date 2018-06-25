package com.sir.app.pager.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sir.library.base.help.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 广告适配器
 * Created by zhuyinan on 2018/6/25.
 * Contact by 445181052@qq.com
 */
public class AdvertisingAdapter extends PagerAdapter {

    List<String> mData;

    private Context mContext;

    private OnItemClickListener itemClickListener;

    public AdvertisingAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView photoView = new ImageView(container.getContext());
        photoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        Glide.with(mContext)
                .load(mData.get(position))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(photoView);

        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(null, position);
                }
            }
        });
        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        itemClickListener = listener;
    }

    public void addData(List<String> data) {
        mData = data;
    }

    public void addData(String data) {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        mData.add(data);
    }
}
