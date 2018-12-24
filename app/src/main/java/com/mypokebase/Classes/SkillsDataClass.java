package com.mypokebase.Classes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class SkillsDataClass implements Serializable {

    String ename;
    String jname;
    String cname;
    String category;
    String type;
    Integer pp;
    Integer accuracy;
    Integer id;
    Integer power;

    public SkillsDataClass(String ename, String jname, String cname, String category, String type, Integer pp, Integer accuracy, Integer id, Integer power) {
        this.ename = ename;
        this.jname = jname;
        this.cname = cname;
        this.category = category;
        this.type = type;
        this.pp = pp;
        this.accuracy = accuracy;
        this.id = id;
        this.power = power;
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

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public Integer getPp() {
        return pp;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPower() {
        return power;
    }

    public static ArrayList<SkillsDataClass> JSONToSkillList(JSONObject json){
        ArrayList<SkillsDataClass> res = null;
        try{
            JSONArray skills = json.getJSONArray("Skills");
            res = new ArrayList<SkillsDataClass>();
            for(int i = 0; i < skills.length(); i++){
                JSONObject skill = skills.getJSONObject(i);
                String ename = "";
                String cname = "";
                String jname = "";
                String category = "";
                String type = "";
                Integer pp = 0;
                Integer accuracy = 0;
                Integer id = 0;
                Integer power = 0;
                try{
                    ename = skill.getString("ename");
                }
                catch (JSONException e){
                    ename = "";
                }
                try {
                    cname = skill.getString("cname");
                }
                catch (JSONException e){
                    cname = "";
                }
                try{
                    jname = skill.getString("jname");
                }
                catch (JSONException e){
                    jname = "";
                }
                try{
                    category = skill.getString("category");
                }
                catch (JSONException e){
                    category = "";
                }
                try {
                    type = skill.getString("type");
                }
                catch (JSONException e){
                    type = "";
                }
                try{
                    pp = skill.getInt("pp");
                }
                catch (JSONException e){
                    pp = 0;
                }
                try{
                    accuracy = skill.getInt("accuracy");
                }
                catch (JSONException e){
                    accuracy = 0;
                }
                try{
                    id = skill.getInt("id");
                }
                catch (JSONException e){
                    id = 0;
                }
                try{
                    power = skill.getInt("power");
                }
                catch (JSONException e){
                    power = 0;
                }
                res.add(new SkillsDataClass(ename, jname, cname, category, type, pp, accuracy, id, power));
            }
        }
        catch(JSONException e){

        }
        return res;
    }
}
