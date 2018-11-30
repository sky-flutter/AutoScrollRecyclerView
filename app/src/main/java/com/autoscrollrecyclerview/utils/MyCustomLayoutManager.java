package com.autoscrollrecyclerview.utils;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;

public class MyCustomLayoutManager extends StaggeredGridLayoutManager {
    Context mContext;
    int spanCount;
    private static final float MILLISECONDS_PER_INCH = 1000f;


    public MyCustomLayoutManager(int spanCount, int orientation, Context mContext) {
        super(spanCount, orientation);
        this.mContext = mContext;
        this.spanCount = spanCount;

    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        super.smoothScrollToPosition(recyclerView, state, position);
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(mContext) {
            @Nullable
            @Override
            public PointF computeScrollVectorForPosition(int targetPosition) {
                return MyCustomLayoutManager.this.computeScrollVectorForPosition(targetPosition);
            }

            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
            }
        };

        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);

    }
}
