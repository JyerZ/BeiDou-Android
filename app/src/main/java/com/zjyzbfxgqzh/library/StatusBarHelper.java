package com.zjyzbfxgqzh.library;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;

/**
 * Created by Jyer on 2016-12-18.
 */

public class StatusBarHelper {

    //4.4、5.x都不设置Status Bar颜色
    public static final int LEVEL_NONE = 0;

    //4.4设置透明状态栏
    public static final int LEVEL_19_TRANSLUCENT = 1;

    //5.x以上设置Status Bar颜色的方式。使用5.x自带的API。该方式适用于大部分的显示情况。
    public static final int LEVEL_21_NORMAL = 1;

    //5.x以上设置Status Bar颜色的方式。使用5.x自带的API，并且设置全屏。该方式适用于页面内容需要全屏显示的情况，比如一些显示图片的页面。
    public static final int LEVEL_21_NORMAL_FULL = 2;

    //5.x以上设置Status Bar颜色的方式。不使用5.x自带API，而是使用Kitkat的方式，添加一个View，该方式和{@link #LEVEL_21_NORMAL_FULL}相似，只是除了可以设置color外还可以设置drawable。
    public static final int LEVEL_21_VIEW = 3;

    private final StatusBarHelperImpl mImpl;

    public StatusBarHelper(Activity activity, int levelInKK) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            if (levelInKK == LEVEL_19_TRANSLUCENT) {
                mImpl = new StatusBarHelperImpl19(activity);
            } else {
                mImpl = new StatusBarHelperImplBase(activity);
            }
        } else {
            mImpl = new StatusBarHelperImplBase(activity);
        }

    }

    public void setColor(int color) {
        mImpl.setColor(color);
    }

    public void setDrawable(Drawable drawable) {
        mImpl.setDrawable(drawable);
    }

    public void setActivityRootLayoutFitSystemWindows(boolean fitSystemWindows) {
        mImpl.setActivityRootLayoutFitSystemWindows(fitSystemWindows);
    }

}
