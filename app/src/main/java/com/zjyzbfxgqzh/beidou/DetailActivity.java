package com.zjyzbfxgqzh.beidou;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.TextView;

import com.zjyzbfxgqzh.library.BaseActivity;

/**
 * Created by Jyer on 2017-2-8.
 */

public class DetailActivity extends BaseActivity {

    private String Title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Item item = (Item)getIntent().getSerializableExtra("Item");
        TextView Detail = (TextView) findViewById(R.id.detail);
        Detail.setText(item.getContent());
        Title = item.getTitle();
        setupActionBar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(Title);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail;
    }
}
