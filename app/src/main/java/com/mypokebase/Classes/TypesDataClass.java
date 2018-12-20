package com.mypokebase.Classes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TypesDataClass {
    String ename;
    String jname;
    String cname;

    public TypesDataClass(String ename, String jname, String cname) {
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

    public static ArrayList<TypesDataClass> JSONToTypeList(JSONObject json){
        ArrayList<TypesDataClass> res = null;
        try{
            JSONArray types = json.getJSONArray("Types");
            res = new ArrayList<TypesDataClass>();
            for(int i = 0; i < types.length(); i++){
                JSONObject type = types.getJSONObject(i);
                String ename = "";
                String cname = "";
                String jname = "";
                try{
                    ename = type.getString("ename");
                }
                catch (JSONException e){
                    ename = "";
                }
                try{
                    cname = type.getString("cname");
                }
                catch (JSONException e){
                    cname = "";
                }
                try {
                    jname = type.getString("jname");
                }
                catch (JSONException e){
                    jname = "";
                }
                res.add(new TypesDataClass(ename, jname, cname));
            }
        }
        catch (JSONException e){

        }
        return res;
    }
}
