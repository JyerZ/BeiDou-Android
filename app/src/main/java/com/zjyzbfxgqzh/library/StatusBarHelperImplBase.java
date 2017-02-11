package com.zjyzbfxgqzh.library;

import android.app.Activity;
import android.graphics.drawable.Drawable;

/**
 * Created by Jyer on 2016-12-18.
 */

class StatusBarHelperImplBase extends StatusBarHelperImpl {

    public StatusBarHelperImplBase(Activity activity) {
        super(activity);
    }

    @Override
    protected void setColor(int color) {
        // do nothing
    }

    @Override
    protected void setDrawable(Drawable drawable) {
        // do nothing
    }

    @Override
    protected void destroy() {
        // do nothing
    }

}
