package com.mypokebase.Classes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class TypesDataClass implements Serializable {
    String ename;
    String jname;
    String cname;
    ArrayList<String> strongAgainst;
    ArrayList<String> weakAgainst;
    ArrayList<String> neutral;
    ArrayList<String> ineffective;
    public static ArrayList<TypesDataClass> types;

    public TypesDataClass(String ename, String jname, String cname, ArrayList<String> strong, ArrayList<String> weak, ArrayList<String> neut, ArrayList<String> ineff) {
        this.ename = ename;
        this.jname = jname;
        this.cname = cname;
        this.strongAgainst = strong;
        this.weakAgainst = weak;
        this.neutral = neut;
        this.ineffective = ineff;
    }

    public ArrayList<String> getStrongAgainst(){ return strongAgainst; }

    public ArrayList<String> getWeakAgainst() { return  weakAgainst; }

    public ArrayList<String> getNeutral() { return neutral; }

    public ArrayList<String> getIneffective() { return ineffective; }

    public String getEname() {
        return ename;
    }

    public String getJname() {
        return jname;
    }

    public String getCname() {
        return cname;
    }

    public static String translateType(String str){
        for(int i = 0; i < types.size(); i++){
            if(str.equals(types.get(i).getJname()) || str.equals(types.get(i).getCname()) || str.equals(types.get(i).getEname())){
                return types.get(i).getEname();
            }
            if(str.equals("超能力"))
                return "Psychic";
        }
        return "";
    }

    public static String translateCategory(String str){
        if(str.equals("物理")){
            return "Physical";
        }
        if(str.equals("特殊")){
            return "Special";
        }
        if(str.equals("变化")){
            return "Status";
        }
        return "";
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
                ArrayList<String> strong = new ArrayList<>();
                ArrayList<String> weak = new ArrayList<>();
                ArrayList<String> neutral = new ArrayList<>();
                ArrayList<String> ineffective = new ArrayList<>();
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

                try {
                    JSONArray strongArray = type.getJSONArray("effective");
                    for(int j = 0; j < strongArray.length(); j++){
                        strong.add((String)strongArray.get(j));
                    }
                }
                catch (JSONException e){
                    strong = null;
                }

                try {
                    JSONArray weakArray = type.getJSONArray("notVeryEffective");
                    for(int j = 0; j < weakArray.length(); j++){
                        weak.add((String)weakArray.get(j));
                    }
                }
                catch (JSONException e){
                    weak = null;
                }

                try {
                    JSONArray neutralArray = type.getJSONArray("normal");
                    for(int j = 0; j < neutralArray.length(); j++){
                        neutral.add((String)neutralArray.get(j));
                    }
                }
                catch (JSONException e){
                    neutral = null;
                }

                try {
                    JSONArray ineffectiveArray = type.getJSONArray("innefective");
                    for(int j = 0; j < ineffectiveArray.length(); j++){
                        ineffective.add((String)ineffectiveArray.get(j));
                    }
                }
                catch (JSONException e){
                    ineffective = null;
                }

                res.add(new TypesDataClass(ename, jname, cname, strong, weak, neutral, ineffective));
            }
        }
        catch (JSONException e){

        }
        return res;
    }
}
