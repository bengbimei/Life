package com.qf.www.life.ParesUtils;

import android.util.Log;

import com.qf.www.life.Beans.Scenes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2015/4/30.
 */
public class BeautifulLife_parser {
    //谷雨节气的集合
    public static List<Scenes> gyjqiList = new ArrayList<Scenes>();
    //健康选择的集合
    public static List<Scenes> jkxzList = new ArrayList<Scenes>();
    //健康食品的集合
    public static List<Scenes> jkshpiList = new ArrayList<Scenes>();

    //解析数据的方法，一次解析出三个集合，用静态集合存放
    public static void getResult(String json) {
        if (json != null) {
            try {
                JSONObject object = new JSONObject(json);
                JSONObject sceneList = object.getJSONObject("sceneList");
                //得到各标题的 数组
                JSONArray sections = sceneList.getJSONArray("sections");
                for (int i = 0; i < sections.length(); i++) {
                    JSONObject object1 = sections.getJSONObject(i);
                    if (i == 0) {
                        gyjqiList = tool(object1);
                        System.out.println("-----" + gyjqiList.toString());
                    } else if (i == 1) {
                        jkxzList = tool(object1);
                        System.out.println("-----" + jkxzList.toString());
                    } else if (i == 2) {
                        jkshpiList = tool(object1);
                        System.out.println("-----"  + jkshpiList.toString());
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    static List<Scenes> tool(JSONObject object1) {
        List<Scenes> result = new ArrayList<Scenes>();
        try {

            JSONArray rows = object1.getJSONArray("rows");
            for (int j = 0; j < rows.length(); j++) {
                JSONObject o1 = rows.getJSONObject(j);
                JSONArray scenes = o1.getJSONArray("scenes");
                for (int k = 0; k < scenes.length(); k++) {
                    Scenes s = new Scenes();
                    JSONObject b = scenes.getJSONObject(k);
                    s.setSceneTitle(b.getString("sceneTitle"));
                    s.setSceneDescription(b.getString("sceneDescription"));
                    s.setSceneTitleImage(b.getString("sceneTitleImage"));
                    s.setSceneBackgroundImage(b.getString("sceneBackgroundImage"));
                    result.add(s);
                }
            }
        } catch (JSONException e) {

            e.printStackTrace();
        }
        return result;
    }
}
