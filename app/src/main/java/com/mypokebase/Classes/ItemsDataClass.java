package com.mypokebase.Classes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ItemsDataClass {
    String ename;
    String jname;
    String cname;

    public ItemsDataClass(String ename, String jname, String cname) {
        this.ename = ename;
        this.jname = jname;
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public String getJname() {
        return jname;
    }

    public String getCname() {
        return cname;
    }

    public static ArrayList<ItemsDataClass> JSONToItemList(JSONObject json){
        ArrayList<ItemsDataClass> res = null;
        try{
            JSONArray items = json.getJSONArray("Items");
            res = new ArrayList<ItemsDataClass>();
            for(int i = 0; i < items.length(); i++){
                JSONObject item = items.getJSONObject(i);
                String ename = "";
                String cname = "";
                String jname = "";
                try{
                    ename = item.getString("ename");
                }
                catch (JSONException e){
                    ename = "";
                }
                try{
                    cname = item.getString("cname");
                }
                catch (JSONException e){
                    cname = "";
                }
                try {
                    jname = item.getString("jname");
                }
                catch (JSONException e){
                    jname = "";
                }
                res.add(new ItemsDataClass(ename, jname, cname));
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return  res;
    }
}
