package com.zjyzbfxgqzh.beidou;

import android.content.Context;

import com.zjyzbfxgqzh.xml.plist.PListXMLHandler;
import com.zjyzbfxgqzh.xml.plist.PListXMLParser;
import com.zjyzbfxgqzh.xml.plist.domain.Array;
import com.zjyzbfxgqzh.xml.plist.domain.Dict;
import com.zjyzbfxgqzh.xml.plist.domain.PList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jyer on 2017-2-8.
 */

public class PlistReader {

    private ArrayList<Map<String, String>> items = new ArrayList<Map<String, java.lang.String>>();

    public ArrayList<Map<String, String>> ReadPlistFrom (Context context, String fileName, boolean cas){
        PListXMLParser parser = new PListXMLParser();
        PListXMLHandler handler = new PListXMLHandler();
        parser.setHandler(handler);

        try {
            parser.parse(context.getResources().getAssets().open(fileName+".plist"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        PList actualPList = ((PListXMLHandler) parser.getHandler()).getPlist();
        Dict root = (Dict) actualPList.getRootElement();

        Array times;
        if (cas){
            times = root.getConfigurationArray("times");
        }else{
            times = null;
        }
        Array contents = root.getConfigurationArray(fileName);
        int count = contents.size();
        ArrayList<Item> array = new ArrayList<Item>();
        for (int i=0;i<count;i++){
            String time = "";
            if (cas){
                Dict dict_time = (Dict)times.get(i);
                time = dict_time.getConfiguration("time").getValue();
            }
            Dict dict_content = (Dict)contents.get(i);
            String title = dict_content.getConfiguration("title").getValue();
            String content = dict_content.getConfiguration("content").getValue();
            Item item = new Item(title,time,content);
            array.add(item);
        }
        for(Item i:array){
            Map<String, String> itm = new HashMap<String, String>();
            itm.put("Title",i.getTitle());
            itm.put("Date", i.getDate());
            itm.put("Content",i.getContent());
            items.add(itm);
        }
        return items;
    }
}
