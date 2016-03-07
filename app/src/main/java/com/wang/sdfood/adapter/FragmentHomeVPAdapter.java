package com.wang.sdfood.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wang.sdfood.model.MoreCookBooksEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/3/6.
 */
public class FragmentHomeVPAdapter extends PagerAdapter {
    private Context context;
    private  List<MoreCookBooksEntity.DataEntity.AdvertsEntity> adverts;
    private List<SimpleDraweeView> simpleDraweeView;
    public FragmentHomeVPAdapter(Context context, List<MoreCookBooksEntity.DataEntity.AdvertsEntity> adverts) {
        this.context=context;
        this.adverts=adverts;
        simpleDraweeView=new ArrayList<>();
        for (int i=0;i<adverts.size();i++){
            SimpleDraweeView s=new SimpleDraweeView(context);
            s.setLayoutParams(new ViewGroup.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT));
            s.setImageURI(Uri.parse(adverts.get(i).getImageUrl()));
            simpleDraweeView.add(s);
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(simpleDraweeView.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      container.addView(simpleDraweeView.get(position));
        return simpleDraweeView.get(position);
    }

    @Override
    public int getCount() {
        return adverts.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
