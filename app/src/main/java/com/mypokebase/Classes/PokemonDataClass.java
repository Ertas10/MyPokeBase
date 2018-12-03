package com.mypokebase.Classes;

import java.util.ArrayList;
import java.util.List;

public class PokemonDataClass {

    int attack;
    int defense;
    int hp;
    int spAttack;
    int spDefense;
    int speed;
    int id;
    String chineseName;
    String englishName;
    String japaneseName;
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

    public int getId() {
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

    public PokemonDataClass(int attack, int defense, int hp, int spAttack, int spDefense, int speed, int id, String chineseName, String englishName, String japaneseName, ArrayList<Integer> eggMovesID, ArrayList<Integer> levelUpMovesID, ArrayList<Integer> tmMovesID, ArrayList<Integer> transferMovesID, ArrayList<Integer> tutorMovesID, ArrayList<Integer> preEvolutionMovesID, ArrayList<String> typesJapanese) {
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
}
