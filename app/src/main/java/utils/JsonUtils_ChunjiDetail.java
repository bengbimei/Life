package utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by aaa on 15-5-1.
 */
public class JsonUtils_ChunjiDetail {
    static List<Map<String, Object>> list;
    static Map<String,Object>map;
    public  static List<Map<String, Object>> getList(String JsonString){
        list = new ArrayList<Map<String, Object>>();
        try {
            JSONObject obj1=new JSONObject(JsonString);
            JSONArray arr1=obj1.getJSONArray("lists");
            for (int i = 0; i <arr1.length() ; i++) {
                JSONObject obj_item=arr1.getJSONObject(i);
                Map<String,Object>map_title=new HashMap<String,Object>();
                String title=obj_item.getString("listTitle");
                map_title.put("title",title);
                list.add(map_title);
                JSONArray arr2=obj_item.getJSONArray("items");
                for (int j = 0; j <arr2.length() ; j++) {
                    Map<String,Object>map_item=new HashMap<String,Object>();
                    JSONObject obj3=arr2.getJSONObject(j);
                    String imageUrl=obj3.getString("imageUrl");
                    String itemTitle=obj3.getString("itemTitle");
                    String itemDesc=obj3.getString("itemDesc");
                    map_item.put("imageUrl",imageUrl);
                    map_item.put("itemTitle",itemTitle);
                    map_item.put("itemDesc",itemDesc);
                    list.add(map_item);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Map<String,Object> gettop(String jsonString){
        map=new HashMap<String,Object>();
        try {
            JSONObject obj1=new JSONObject(jsonString);
            String sceneImageUrl=obj1.getString("sceneImageUrl");
            String sceneImageTitelUrl=obj1.getString("sceneTitleImageUrl");
            String sceneDesc=obj1.getString("sceneDesc");
            map.put("sceneImageUrl",sceneImageUrl);
            map.put("sceneImageTitleUrl",sceneImageTitelUrl);
            map.put("sceneDesc",sceneDesc);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }
}
