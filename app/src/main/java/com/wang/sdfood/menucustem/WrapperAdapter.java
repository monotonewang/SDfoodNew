package com.wang.sdfood.menucustem;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

import com.wang.sdfood.ActivityHomeCollect;
import com.wang.sdfood.ActivityHomeDiscuss;

import java.util.Map;

/**
 * Created by user on 2016/3/6.
 */
public abstract class WrapperAdapter implements WrapperListAdapter, com.wang.sdfood.menucustem.ItemMainLayout.OnItemSlideListenerProxy, View.OnClickListener,
        AbsListView.OnScrollListener, com.wang.sdfood.menucustem.ItemMainLayout.OnItemDeleteListenerProxy {
    private static final int TAG_LEFT = 3 << 24;
    private static final int TAG_RIGHT = 4 << 24;
    private static final String TAG ="WrapperAdapter" ;
    /* 上下文 */
    private Context mContext;
    /* 适配器 */
    private ListAdapter mAdapter;
    /* 用户自定义参数 */
    private Map<Integer, Menu> mMenuMap;
    /* SDLV */
    private com.wang.sdfood.menucustem.SlideAndDragListView mListView;
    /* 当前滑动的item的位置 */
    private int mSlideItemPosition = -1;
    /* 监听器 */
    private OnAdapterSlideListenerProxy mOnAdapterSlideListenerProxy;
    private OnAdapterMenuClickListenerProxy mOnAdapterMenuClickListenerProxy;
//     OnMenuStartActivityListener onMenuStartActivityListener;
//     OnMenuStartActivityListener2 onMenuStartActivityListener2;
    public WrapperAdapter(Context context, com.wang.sdfood.menucustem.SlideAndDragListView listView, ListAdapter adapter, Map<Integer, Menu> map) {
        mContext = context;
        mListView = listView;
        mListView.setOnScrollListener(this);
        mAdapter = adapter;
        mMenuMap = map;
    }

    @Override
    public ListAdapter getWrappedAdapter() {
        return mAdapter;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return mAdapter.areAllItemsEnabled();
    }

    @Override
    public boolean isEnabled(int position) {
        return mAdapter.isEnabled(position);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        mAdapter.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mAdapter.unregisterDataSetObserver(observer);
    }

    @Override
    public int getCount() {
        return mAdapter.getCount();
    }

    @Override
    public Object getItem(int position) {
        return mAdapter.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return mAdapter.getItemId(position);
    }

    @Override
    public boolean hasStableIds() {
        return mAdapter.hasStableIds();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        com.wang.sdfood.menucustem.ItemMainLayout itemMainLayout = null;
        if (convertView == null) {
            View contentView = mAdapter.getView(position, convertView, parent);
            itemMainLayout = new com.wang.sdfood.menucustem.ItemMainLayout(mContext);
            int type = mAdapter.getItemViewType(position);
            Menu menu = mMenuMap.get(type);
            if (menu == null) {
                throw new IllegalArgumentException("没有这个ViewType");
            }
            itemMainLayout.setParams(menu.getTotalBtnLength(MenuItem.DIRECTION_LEFT),
                    menu.getTotalBtnLength(MenuItem.DIRECTION_RIGHT), menu.isWannaOver());
            createMenu(menu, itemMainLayout);
            itemMainLayout.getItemCustomLayout().saveBackground(menu.getItemBackGroundDrawable());
            itemMainLayout.setOnItemSlideListenerProxy(this);
            itemMainLayout.getItemCustomLayout().addCustomView(contentView);
        } else {
            itemMainLayout = (com.wang.sdfood.menucustem.ItemMainLayout) convertView;
            mAdapter.getView(position, itemMainLayout.getItemCustomLayout().getCustomView(), parent);
        }
        return itemMainLayout;
    }

    /**
     * 创建Menu
     *
     * @param itemMainLayout
     */
    private void createMenu(Menu menu, com.wang.sdfood.menucustem.ItemMainLayout itemMainLayout) {
        if (menu.getTotalBtnLength(MenuItem.DIRECTION_LEFT) > 0) {
            com.wang.sdfood.menucustem.Compat.setBackgroundDrawable(itemMainLayout.getItemLeftBackGroundLayout().getBackGroundImage(), menu.getItemBackGroundDrawable());
            for (int i = 0; i < menu.getMenuItems(MenuItem.DIRECTION_LEFT).size(); i++) {
                View v = itemMainLayout.getItemLeftBackGroundLayout().addMenuItem(menu.getMenuItems(MenuItem.DIRECTION_LEFT).get(i));
                v.setOnClickListener(this);
                v.setClickable(false);
                v.setTag(TAG_LEFT, i);
            }
        } else {
            itemMainLayout.getItemLeftBackGroundLayout().setVisibility(View.GONE);
        }
        if (menu.getTotalBtnLength(MenuItem.DIRECTION_RIGHT) > 0) {
            com.wang.sdfood.menucustem.Compat.setBackgroundDrawable(itemMainLayout.getItemRightBackGroundLayout().getBackGroundImage(), menu.getItemBackGroundDrawable());
            for (int i = 0; i < menu.getMenuItems(MenuItem.DIRECTION_RIGHT).size(); i++) {
                View v = itemMainLayout.getItemRightBackGroundLayout().addMenuItem(menu.getMenuItems(MenuItem.DIRECTION_RIGHT).get(i));
                v.setOnClickListener(this);
                v.setClickable(false);
                v.setTag(TAG_RIGHT, i);
            }
        } else {
            itemMainLayout.getItemRightBackGroundLayout().setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mAdapter.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return mAdapter.getViewTypeCount();
    }

    @Override
    public boolean isEmpty() {
        return mAdapter.isEmpty();
    }

    /**
     * 设置slide滑开的item的位置
     *
     * @param position
     */
    protected void setSlideItemPosition(int position) {
        if (mSlideItemPosition != -1 && mSlideItemPosition != position) {
            returnSlideItemPosition();
        }
        if (mSlideItemPosition == position) {//已经执行过下面的操作了，就不要再去操作了。
            return;
        }
        mSlideItemPosition = position;
        com.wang.sdfood.menucustem.ItemMainLayout itemMainLayout = (com.wang.sdfood.menucustem.ItemMainLayout) mListView.getChildAt(mSlideItemPosition - mListView.getFirstVisiblePosition());
        for (View v : itemMainLayout.getItemLeftBackGroundLayout().getBtnViews()) {
            v.setClickable(true);
        }
        for (View v : itemMainLayout.getItemRightBackGroundLayout().getBtnViews()) {
            v.setClickable(true);
        }
    }

    /**
     * 得到当前滑开的item的位置
     *
     * @return
     */
    protected int getSlideItemPosition() {
        return mSlideItemPosition;
    }

    /**
     * 归位mSlideItemPosition，button不可点击
     */
    public void returnSlideItemPosition() {
        if (mSlideItemPosition != -1) {
            com.wang.sdfood.menucustem.ItemMainLayout itemMainLayout = (com.wang.sdfood.menucustem.ItemMainLayout) mListView.getChildAt(mSlideItemPosition - mListView.getFirstVisiblePosition());
            if (itemMainLayout != null) {
                itemMainLayout.scrollBack();
                for (View v : itemMainLayout.getItemLeftBackGroundLayout().getBtnViews()) {
                    v.setClickable(false);
                }
                for (View v : itemMainLayout.getItemRightBackGroundLayout().getBtnViews()) {
                    v.setClickable(false);
                }
            }
            mSlideItemPosition = -1;
        }
    }

    /**
     * @param x
     * @return 是否滑动归位了
     */
    public int returnSlideItemPosition(float x) {
        if (mSlideItemPosition != -1) {
            com.wang.sdfood.menucustem.ItemMainLayout itemMainLayout = (com.wang.sdfood.menucustem.ItemMainLayout) mListView.getChildAt(mSlideItemPosition - mListView.getFirstVisiblePosition());
            if (itemMainLayout != null) {
                int scrollBackSituation = itemMainLayout.scrollBack(x);
                switch (scrollBackSituation) {
                    case com.wang.sdfood.menucustem.ItemMainLayout.SCROLL_BACK_ALREADY_CLOSED:
                    case com.wang.sdfood.menucustem.ItemMainLayout.SCROLL_BACK_CLICK_OWN:
                        for (View v : itemMainLayout.getItemLeftBackGroundLayout().getBtnViews()) {
                            v.setClickable(false);
                        }
                        for (View v : itemMainLayout.getItemRightBackGroundLayout().getBtnViews()) {
                            v.setClickable(false);
                        }
                        break;
                    case com.wang.sdfood.menucustem.ItemMainLayout.SCROLL_BACK_CLICK_MENU_BUTTON:
                        break;
                }
                return scrollBackSituation;
            }
            mSlideItemPosition = -1;
            return com.wang.sdfood.menucustem.ItemMainLayout.SCROLL_BACK_CLICK_NOTHING;
        }
        return com.wang.sdfood.menucustem.ItemMainLayout.SCROLL_BACK_CLICK_NOTHING;
    }

    /**
     * 设置监听器
     *
     * @param onAdapterSlideListenerProxy
     */
    public void setOnAdapterSlideListenerProxy(OnAdapterSlideListenerProxy onAdapterSlideListenerProxy) {
        mOnAdapterSlideListenerProxy = onAdapterSlideListenerProxy;
    }

    @Override
    public void onSlideOpen(View view, int direction) {
        if (mOnAdapterSlideListenerProxy != null) {
            mOnAdapterSlideListenerProxy.onSlideOpen(view, mSlideItemPosition, direction);
        }
    }

    @Override
    public void onSlideClose(View view, int direction) {
        if (mOnAdapterSlideListenerProxy != null) {
            mOnAdapterSlideListenerProxy.onSlideClose(view, mSlideItemPosition, direction);
        }
        //归位
        returnSlideItemPosition();
    }

    /**
     * 设置监听器
     *
     * @param onAdapterMenuClickListenerProxy
     */
    public void setOnAdapterMenuClickListenerProxy(OnAdapterMenuClickListenerProxy onAdapterMenuClickListenerProxy) {
        mOnAdapterMenuClickListenerProxy = onAdapterMenuClickListenerProxy;
    }

    @Override
    public void onClick(View v) {
        if (mOnAdapterMenuClickListenerProxy != null) {
            int scroll = mOnAdapterMenuClickListenerProxy.onMenuItemClick(v, mSlideItemPosition,
                    (Integer) (v.getTag(TAG_LEFT) != null ? v.getTag(TAG_LEFT) : v.getTag(TAG_RIGHT)),
                    v.getTag(TAG_LEFT) != null ? MenuItem.DIRECTION_LEFT : MenuItem.DIRECTION_RIGHT);
            switch (scroll) {
                case Menu.ITEM_NOTHING:
                    break;
                case Menu.ITEM_SCROLL_BACK:
                    //归位
                    returnSlideItemPosition();
                    break;
                case Menu.ITEM_DELETE_FROM_BOTTOM_TO_TOP:
                    if (mSlideItemPosition != -1) {
                        com.wang.sdfood.menucustem.ItemMainLayout itemMainLayout = (com.wang.sdfood.menucustem.ItemMainLayout) mListView.getChildAt(mSlideItemPosition - mListView.getFirstVisiblePosition());
                        if (itemMainLayout != null) {
                            for (View v1 : itemMainLayout.getItemLeftBackGroundLayout().getBtnViews()) {
                                v1.setClickable(false);
                            }
                            for (View v1 : itemMainLayout.getItemRightBackGroundLayout().getBtnViews()) {
                                v1.setClickable(false);
                            }
                            itemMainLayout.deleteItem(this);
                        }
                    }
                    break;
                case Menu.ITEM_START_ACTIVITY:
                    Intent intent=new Intent(mContext, ActivityHomeDiscuss.class);
                    mContext.startActivity(intent);
                    break;
                case Menu.ITEM_START_ACTIVITY2:
                       Intent intent1=new Intent(mContext,ActivityHomeCollect.class);
                    mContext.startActivity(intent1);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //当发生滑动的时候归位
        if (scrollState != AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
            returnSlideItemPosition();
        }
        onScrollStateChangedProxy(view, scrollState);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        onScrollProxy(view, firstVisibleItem, visibleItemCount, totalItemCount);
    }

    @Override
    public void onDelete(View view) {
        int position = mSlideItemPosition;
        if (mSlideItemPosition != -1) {
            onItemDelete(view, position);
            mSlideItemPosition = -1;
        }
    }

    /*public interface OnMenuStartActivityListener{
        void OnMenuStartActivity(int position);
    }

    public interface OnMenuStartActivityListener2{
        void OnMenuStartActivity2(int position);
    }

    public void SetOnMenuStartActivityListener(OnMenuStartActivityListener onMenuStartActivityListener){
        this.onMenuStartActivityListener=onMenuStartActivityListener;
    }

    public void SetOnMenuStartActivityListener2(OnMenuStartActivityListener2 onMenuStartActivityListener2){
        this.onMenuStartActivityListener2=onMenuStartActivityListener2;
    }*/
    public interface OnAdapterMenuClickListenerProxy {
        int onMenuItemClick(View v, int itemPosition, int buttonPosition, int direction);
    }

    public interface OnAdapterSlideListenerProxy {
        void onSlideOpen(View view, int position, int direction);

        void onSlideClose(View view, int position, int direction);
    }

    public abstract void onScrollStateChangedProxy(AbsListView view, int scrollState);

    public abstract void onScrollProxy(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount);

    public abstract void onItemDelete(View view, int position);

}


