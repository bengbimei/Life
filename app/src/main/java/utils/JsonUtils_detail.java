package utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaa on 15-5-1.
 */
public class JsonUtils_detail {
    static List<Map<String, Object>> list;

    public static List<Map<String, Object>> getList_Detail(String path) {
        list = new ArrayList<Map<String, Object>>();
        try {
            JSONObject obj1 = new JSONObject(path);
            JSONObject obj2 = obj1.getJSONObject("yiji");
            JSONArray arr1 = obj2.getJSONArray("1");
            for (int i = 0; i < arr1.length(); i++) {
                Map<String, Object> map = new HashMap<String, Object>();
                JSONObject obj3 = arr1.getJSONObject(i);
                String title = obj3.getString("title");
                String desc = obj3.getString("desc");
                map.put("title", title);
                map.put("desc", desc);
                list.add(map);
            }
            JSONArray arr2 = obj2.getJSONArray("2");
            for (int i = 0; i < arr2.length(); i++) {
                Map<String, Object> map = new HashMap<String, Object>();
                JSONObject obj3 = arr2.getJSONObject(i);
                String title = obj3.getString("title");
                String desc = obj3.getString("desc");
                map.put("title", title);
                map.put("desc", desc);
                list.add(map);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int getsize(String path) {
        int i=0;
        JSONObject obj1 = null;
        try {
            obj1 = new JSONObject(path);
            JSONObject obj2 = obj1.getJSONObject("yiji");
            JSONArray arr1 = obj2.getJSONArray("1");
            i=arr1.length();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return i;
    }
}