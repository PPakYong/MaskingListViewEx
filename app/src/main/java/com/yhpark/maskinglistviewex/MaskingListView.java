package com.yhpark.maskinglistviewex;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yhpark on 2017-04-04.
 */

public class MaskingListView extends FrameLayout implements AbsListView.OnScrollListener {
    public ListView getListView() {
        return listView;
    }

    public View getTopMask() {
        return topMask;
    }

    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.topMask)
    View topMask;

    public MaskingListView(Context context) {
        super(context);
        addView(LayoutInflater.from(context).inflate(R.layout.masking_listview, null));
        ButterKnife.bind(this);
        listView.setOnScrollListener(this);
    }

    public MaskingListView(Context context, AttributeSet attr) {
        super(context, attr);
        addView(LayoutInflater.from(context).inflate(R.layout.masking_listview, null));
        ButterKnife.bind(this);
        listView.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        topMask.setVisibility(absListView.getScrollX() == 0 ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem != 0) {
            topMask.setVisibility(View.VISIBLE);
        }
    }
}
