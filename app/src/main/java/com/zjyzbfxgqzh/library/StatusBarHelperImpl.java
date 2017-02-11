package com.zjyzbfxgqzh.library;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jyer on 2016-12-18.
 */

abstract class StatusBarHelperImpl {

    final Activity mActivity;

    boolean mActivityRootLayoutFitSystemWindows = true;

    public StatusBarHelperImpl(Activity activity) {
        this.mActivity = activity;
    }

    protected int getStatusBarHeight() {
        int resourceId = mActivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return mActivity.getResources().getDimensionPixelSize(resourceId);
    }

    protected void setActivityRootLayoutFitSystemWindowsInternal() {
        ViewGroup contentLayout = (ViewGroup) mActivity.findViewById(android.R.id.content);
        contentLayout.getChildAt(0).setFitsSystemWindows(isActivityRootLayoutFitSystemWindows());
    }

    public void setActivityRootLayoutFitSystemWindows(boolean fitSystemWindows) {
        mActivityRootLayoutFitSystemWindows = fitSystemWindows;
    }

    public boolean isActivityRootLayoutFitSystemWindows() {
        return mActivityRootLayoutFitSystemWindows;
    }

    protected abstract void setColor(int color);

    protected abstract void setDrawable(Drawable drawable);

    protected abstract void destroy();

}
