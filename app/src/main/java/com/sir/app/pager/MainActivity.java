package com.sir.app.pager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;

import com.sir.app.pager.adapter.AdvertisingAdapter;
import com.sir.library.base.BaseActivity;
import com.sir.library.base.help.OnItemClickListener;
import com.sir.library.base.help.ViewHolder;
import com.sir.library.ultra.UltraViewPager;
import com.sir.library.ultra.transformer.UltraDepthScaleTransformer;
import com.sir.library.ultra.transformer.UltraScaleTransformer;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.ultra_view_pager_a)
    UltraViewPager ultraViewPagerA;

    @BindView(R.id.ultra_view_pager_b)
    UltraViewPager ultraViewPagerB;

    @BindView(R.id.ultra_view_pager_c)
    UltraViewPager ultraViewPagerC;

    AdvertisingAdapter advertisingAdapter;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        advertisingAdapter = new AdvertisingAdapter(this);
        advertisingAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewHolder holder, int position) {

            }
        });
        advertisingAdapter.addData("http://bpic.588ku.com/back_pic/02/65/71/51578894965d2d8.jpg!r850/fw/800");
        advertisingAdapter.addData("http://bpic.588ku.com/back_pic/02/67/14/06578c9be38661f.jpg!r850/fw/800");
        advertisingAdapter.addData("http://bpic.588ku.com/back_pic/03/60/68/7657a66cd7051ea.jpg!r850/fw/800");
        advertisingAdapter.addData("http://bpic.588ku.com/back_pic/17/05/11/0aca186a485b75a765a4562b7d48ed4c.jpg!r850/fw/800");

    }

    @Override
    public void doBusiness(Context mContext) {
        intiViewPagerA();
        intiViewPagerB();
        intiViewPagerC();
    }


    private void intiViewPagerA() {
        ultraViewPagerA.setAdapter(advertisingAdapter);
        ultraViewPagerA.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        ultraViewPagerA.setMultiScreen(0.8f);//设置多屏幕
        ultraViewPagerA.setInfiniteLoop(true);//设置无限循环
        ultraViewPagerA.setAutoScroll(2000);//设置自动滚动


        ultraViewPagerA.initIndicator();
        ultraViewPagerA.getIndicator().setOrientation(UltraViewPager.Orientation.HORIZONTAL);
        ultraViewPagerA.getIndicator().setGravity(Gravity.BOTTOM);
        ultraViewPagerA.getIndicator().setFocusColor(Color.GREEN).setNormalColor(Color.GRAY);
        ultraViewPagerA.getIndicator().setMargin(20, 10, 10, 10);
        ultraViewPagerA.getIndicator().setRadius(14);
        ultraViewPagerA.getIndicator().build();
    }

    private void intiViewPagerB() {
        ultraViewPagerB.setAdapter(advertisingAdapter);
        ultraViewPagerB.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        ultraViewPagerB.setInfiniteLoop(true);//设置无限循环
        ultraViewPagerB.setAutoScroll(3000);//设置自动滚动


        ultraViewPagerB.initIndicator();
        ultraViewPagerB.getIndicator().setOrientation(UltraViewPager.Orientation.VERTICAL);
        ultraViewPagerB.getIndicator().setGravity(Gravity.BOTTOM | Gravity.RIGHT);
        ultraViewPagerB.getIndicator().setFocusColor(Color.GRAY).setNormalColor(Color.LTGRAY);
        ultraViewPagerB.getIndicator().setMargin(0, 0, 60, 20);
        ultraViewPagerB.getIndicator().setRadius(14);
        ultraViewPagerB.getIndicator().build();
    }

    private void intiViewPagerC() {
        ultraViewPagerC.setAdapter(advertisingAdapter);
        ultraViewPagerC.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        ultraViewPagerC.setInfiniteLoop(true);//设置无限循环
        ultraViewPagerC.setAutoScroll(4000);//设置自动滚动
        ultraViewPagerC.setPageTransformer(true, new UltraScaleTransformer());


        ultraViewPagerC.initIndicator();
        ultraViewPagerC.getIndicator().setOrientation(UltraViewPager.Orientation.HORIZONTAL);
        ultraViewPagerC.getIndicator().setGravity(Gravity.BOTTOM | Gravity.RIGHT);
        ultraViewPagerC.getIndicator().setFocusColor(Color.MAGENTA).setNormalColor(Color.GRAY);
        ultraViewPagerC.getIndicator().setMargin(0, 0, 30, 20);
        ultraViewPagerC.getIndicator().setRadius(14);
        ultraViewPagerC.getIndicator().build();
    }
}
