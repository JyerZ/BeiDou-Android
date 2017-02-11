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

public class Intro2Terms_PlaceholderFragment extends Fragment {

    private ListView listv;
    ArrayList<Map<String, String>> items = new ArrayList<Map<String, java.lang.String>>();

    public Intro2Terms_PlaceholderFragment() {
    }

    public Intro2Terms_PlaceholderFragment newInstance() {
        Intro2Terms_PlaceholderFragment fragment = new Intro2Terms_PlaceholderFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_intro2terms, container, false);
        listv = (ListView)rootView.findViewById(R.id.listv_intro2terms);
        PlistReader plistReader = new PlistReader();
        items = plistReader.ReadPlistFrom(this.getContext(),"intro2terms",false);
        SimpleAdapter adapter=new SimpleAdapter(rootView.getContext(), items, R.layout.lin, new String[]
                {"Title"}, new int[]{R.id.tv_title});
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(getActivity(), DetailActivity.class);
                Bundle bundle = new Bundle();
                Map<String, String> map = ((Map<String, String>)parent.getItemAtPosition(position));
                String Title = map.get("Title");
                String Content = map.get("Content");
                Item s = new Item(Title,"",Content);
                bundle.putSerializable("Item",s);
                in.putExtras(bundle);
                startActivity(in);
            }
        });
        return rootView;
    }
}
