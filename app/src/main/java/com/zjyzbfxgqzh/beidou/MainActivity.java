package com.zjyzbfxgqzh.beidou;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zjyzbfxgqzh.library.BaseActivity;
import com.zjyzbfxgqzh.library.StatusBarHelper;

import java.util.Map;

public class MainActivity extends BaseActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private String[] function = new String[4];

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFunction();
        //setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final DialogInterface.OnClickListener oc = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                switch (which){
                    case Dialog.BUTTON_NEUTRAL:
                        dialog.cancel();
                    default:
                        dialog.cancel();
                        break;
                }
            }
        };
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new AlertDialog.Builder(MainActivity.this).setIcon(R.mipmap.ic_launcher).setTitle(R.string.about_app_title).setMessage(R.string.about_app_developer).setNeutralButton(R.string.about_app_button,oc).create();
                dialog.show();
            }
        });
    }

    public void getFunction(){
        function[0] = this.getString(R.string.about);
        function[1] = this.getString(R.string.application);
        function[2] = this.getString(R.string.news);
        function[3] = this.getString(R.string.intro2terms);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0) {
                About_PlaceholderFragment about_p = new About_PlaceholderFragment();
                return about_p.newInstance();
            }
            else if(position==1) {
                Application_PlaceholderFragment app_p = new Application_PlaceholderFragment();
                return app_p.newInstance();
            }
            else if(position==2) {
                News_PlaceholderFragment n_p = new News_PlaceholderFragment();
                return n_p.newInstance();
            }
            else{
                Intro2Terms_PlaceholderFragment i_p = new Intro2Terms_PlaceholderFragment();
                return i_p.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return function[0];
                case 1:
                    return function[1];
                case 2:
                    return function[2];
                case 3:
                    return function[3];
            }
            return null;
        }
    }

    @Override
    protected void onTintStatusBar() {
        if (mStatusBarHelper == null) {
            mStatusBarHelper = new StatusBarHelper(this, StatusBarHelper.LEVEL_19_TRANSLUCENT);
        }
        mStatusBarHelper.setActivityRootLayoutFitSystemWindows(false);
        mStatusBarHelper.setColor(Color.TRANSPARENT);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
