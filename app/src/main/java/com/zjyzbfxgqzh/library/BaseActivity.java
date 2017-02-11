package com.zjyzbfxgqzh.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zjyzbfxgqzh.beidou.R;

/**
 * Created by Jyer on 2016-12-18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected StatusBarHelper mStatusBarHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        onTintStatusBar();
    }

    protected void onTintStatusBar() {
        if (mStatusBarHelper == null) {
            mStatusBarHelper = new StatusBarHelper(this, StatusBarHelper.LEVEL_19_TRANSLUCENT);
        }
        mStatusBarHelper.setColor(getResources().getColor(R.color.colorPrimary));
    }

    protected abstract int getLayoutResource();


}
