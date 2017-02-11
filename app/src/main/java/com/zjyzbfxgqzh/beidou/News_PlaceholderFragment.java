package com.zjyzbfxgqzh.beidou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Jyer on 2017-1-24.
 */

public class News_PlaceholderFragment extends Fragment {

    private ListView listv;
    ArrayList<Map<String, String>> items = new ArrayList<Map<String, java.lang.String>>();

    public News_PlaceholderFragment() {
    }

    public News_PlaceholderFragment newInstance() {
        News_PlaceholderFragment fragment = new News_PlaceholderFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        listv = (ListView)rootView.findViewById(R.id.listv_news);
        PlistReader plistReader = new PlistReader();
        items = plistReader.ReadPlistFrom(this.getContext(),"news",true);
        SimpleAdapter adapter=new SimpleAdapter(rootView.getContext(), items, R.layout.line, new String[]
                {"Title","Date"}, new int[]{R.id.tvTitle,R.id.tvTime});
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(getActivity(), DetailActivity.class);
                Bundle bundle = new Bundle();
                Map<String, String> map = ((Map<String, String>)parent.getItemAtPosition(position));
                String Title = map.get("Title");
                String Date = map.get("Date");
                String Content = map.get("Content");
                Item s = new Item(Title,Date,Content);
                bundle.putSerializable("Item",s);
                in.putExtras(bundle);
                startActivity(in);
            }
        });
        return rootView;
    }
}
