package com.mypokebase.Classes;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PokemonDataClass implements Serializable {

    public static ArrayList<PokemonDataClass> pokemons = null;

    int attack;
    int defense;
    int hp;
    int spAttack;
    int spDefense;
    int speed;
    String id;
    String chineseName;
    String englishName;
    String japaneseName;
    Bitmap thm;
    Bitmap spr;
    Bitmap img;
    ArrayList<Integer> eggMovesID;
    ArrayList<Integer> levelUpMovesID;
    ArrayList<Integer> tmMovesID;
    ArrayList<Integer> transferMovesID;
    ArrayList<Integer> tutorMovesID;
    ArrayList<Integer> preEvolutionMovesID;
    ArrayList<String> typesJapanese;

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHp() {
        return hp;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public String getId() {
        return id;
    }

    public String getChineseName() {
        return chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public ArrayList<Integer> getEggMovesID() {
        return eggMovesID;
    }

    public ArrayList<Integer> getLevelUpMovesID() {
        return levelUpMovesID;
    }

    public ArrayList<Integer> getTmMovesID() {
        return tmMovesID;
    }

    public ArrayList<Integer> getTransferMovesID() {
        return transferMovesID;
    }

    public ArrayList<Integer> getTutorMovesID() {
        return tutorMovesID;
    }

    public ArrayList<Integer> getPreEvolutionMovesID() {
        return preEvolutionMovesID;
    }

    public ArrayList<String> getTypesJapanese() {
        return typesJapanese;
    }

    public Bitmap getThm() { return thm; }

    public Bitmap getSpr() { return spr; }

    public Bitmap getImg() { return img; }

    public void setSpr (Bitmap bm) { spr = bm; }

    public void setImg (Bitmap bm) { img = bm; }

    public void setThm (Bitmap bm) { thm = bm; }


    public PokemonDataClass(int attack, int defense, int hp, int spAttack, int spDefense, int speed, String id, String chineseName, String englishName, String japaneseName, ArrayList<Integer> eggMovesID, ArrayList<Integer> levelUpMovesID, ArrayList<Integer> tmMovesID, ArrayList<Integer> transferMovesID, ArrayList<Integer> tutorMovesID, ArrayList<Integer> preEvolutionMovesID, ArrayList<String> typesJapanese) {
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.id = id;
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.japaneseName = japaneseName;
        this.eggMovesID = eggMovesID;
        this.levelUpMovesID = levelUpMovesID;
        this.tmMovesID = tmMovesID;
        this.transferMovesID = transferMovesID;
        this.tutorMovesID = tutorMovesID;
        this.preEvolutionMovesID = preEvolutionMovesID;
        this.typesJapanese = typesJapanese;
    }

    public static ArrayList<PokemonDataClass> JSONToPokemonList(JSONObject json){
        ArrayList<PokemonDataClass> res = null;
        try {
            JSONArray pokemonArray = json.getJSONArray("Pokémons");
            res = new ArrayList<PokemonDataClass>();
            for(int i = 0; i < pokemonArray.length(); i++){
                JSONObject pokemon = pokemonArray.getJSONObject(i);
                JSONObject base;
                JSONObject skills;
                JSONArray preEvolution;
                JSONArray transfer;
                JSONArray egg;
                JSONArray levelUp;
                JSONArray tm;
                JSONArray tutor;
                JSONArray types;
                String ename;
                String cname;
                String jname;
                String id = "";
                Integer attack = 0;
                Integer defense = 0;
                Integer hp = 0;
                Integer spatk = 0;
                Integer spdef = 0;
                Integer speed = 0;
                ArrayList<String> typesList = new ArrayList<String>();
                ArrayList<Integer> preEvolutionList = new ArrayList<Integer>();
                ArrayList<Integer> transferList = new ArrayList<Integer>();
                ArrayList<Integer> eggList = new ArrayList<Integer>();
                ArrayList<Integer> levelUpList = new ArrayList<Integer>();
                ArrayList<Integer> tmList = new ArrayList<Integer>();
                ArrayList<Integer> tutorList = new ArrayList<Integer>();
                try{
                    ename = pokemon.getString("ename");
                }
                catch (JSONException e){
                    ename = "";
                }
                try{
                    cname = pokemon.getString("cname");
                }
                catch (JSONException e){
                    cname = "";
                }
                try{
                    jname = pokemon.getString("jname");
                }
                catch (JSONException e){
                    jname = "";
                }
                try{
                    id = pokemon.getString("id");
                }
                catch (JSONException e){
                    pokemon.getString("id");
                }
                try{
                    base = pokemon.getJSONObject("base");
                    try {
                        attack = base.getInt("Attack");
                    }
                    catch (JSONException e){
                        attack = 0;
                    }
                    try {
                        defense = base.getInt("Defense");
                    }
                    catch (JSONException e){
                         defense = 0;
                    }
                    try {
                        hp = base.getInt("HP");
                    }
                    catch (JSONException e){
                        hp = 0;
                    }
                    try {
                        spatk = base.getInt("SpAtk");
                    }
                    catch (JSONException e){
                        spatk = 0;
                    }
                    try {
                        spdef = base.getInt("SpDef");
                    }
                    catch (Exception e){
                        spdef = 0;
                    }
                    try {
                        speed = base.getInt("Speed");
                    }
                    catch (JSONException e){
                        speed = 0;
                    }
                }
                catch (JSONException e){
                    base = null;
                }
                try{
                    skills = pokemon.getJSONObject("skills");
                    try{
                        preEvolution = skills.getJSONArray("pre-evolution");
                        for (int j = 0; j < preEvolution.length(); j++) {
                            preEvolutionList.add(preEvolution.getInt(j));
                        }
                    }
                    catch (JSONException e){
                        preEvolution = null;
                        preEvolutionList = null;
                    }
                    try{
                        transfer = skills.getJSONArray("transfer");
                        for(int j = 0; j < transfer.length(); j++){
                            transferList.add(transfer.getInt(j));
                        }

                    }
                    catch (JSONException e){
                        transfer = null;
                        transferList = null;
                    }
                    try{
                        egg = skills.getJSONArray("egg");
                        for(int j = 0; j < egg.length(); j++){
                            eggList.add(egg.getInt(j));
                        }
                    }
                    catch (JSONException e){
                        egg = null;
                        eggList = null;
                    }
                    try{
                        levelUp = skills.getJSONArray("level_up");
                        for(int j = 0; j < levelUp.length(); j++){
                            levelUpList.add(levelUp.getInt(j));
                        }
                    }
                    catch (JSONException e){
                        levelUp = null;
                        levelUpList = null;
                    }
                    try{
                        tm = skills.getJSONArray("tm");
                        for(int j = 0; j < tm.length(); j++){
                            tmList.add(tm.getInt(j));
                        }
                    }
                    catch (JSONException e){
                        tm = null;
                        tmList = null;
                    }
                    try{
                        tutor = skills.getJSONArray("tutor");
                        for(int j = 0; j < tutor.length(); j++){
                            tutorList.add(tutor.getInt(j));
                        }
                    }
                    catch (JSONException e){
                        tutor = null;
                        tutorList = null;
                    }
                }
                catch (JSONException e){
                    skills = null;
                }
                try{
                    types = pokemon.getJSONArray("type");
                    for(int j = 0; j < types.length(); j++){
                        typesList.add((String) types.get(i));
                    }
                }
                catch (JSONException e){
                    types = null;
                    typesList = null;
                }
                res.add(new PokemonDataClass(attack, defense, hp, spatk, spdef, speed, id, cname, ename, jname, eggList, levelUpList, tmList, transferList, tutorList, preEvolutionList, typesList));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static ArrayList<String> JSONToThumbnailPathList(JSONObject json){
        ArrayList<String> res = null;
        try{
            JSONArray pathArray = json.getJSONArray("Paths");
            res = new ArrayList<String>();
            for(int i = 0; i < pathArray.length(); i++){
                JSONObject pathObj = pathArray.getJSONObject(i);
                String pathStr;
                try{
                    pathStr = pathObj.getString("Path");
                }
                catch (JSONException e){
                    pathStr = "";
                }
                res.add(pathStr);
            }
        }
        catch (JSONException e){

        }
        return res;
    }
}
