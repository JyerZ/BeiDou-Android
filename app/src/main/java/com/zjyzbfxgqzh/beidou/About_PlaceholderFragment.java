package com.zjyzbfxgqzh.beidou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jyer on 2017-1-24.
 */

public class About_PlaceholderFragment extends Fragment {
    public About_PlaceholderFragment() {
    }

    public About_PlaceholderFragment newInstance() {
        About_PlaceholderFragment fragment = new About_PlaceholderFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        return rootView;
    }
}
