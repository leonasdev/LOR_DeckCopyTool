package com.example.lor_deckcopytool;

import android.media.Image;

public class Deck{
    public Deck(String Title, String Tier, String Region_1, String Region_2, String Type, String Description, String How,
                int Hero_1, int Hero_2, int Hero_1_2, int Hero_2_2, String HeroName1, String HeroName2, String Code, Card Card_1, Card Card_2) {
        title = Title;
        tier = Tier;
        region_1 = Region_1;
        region_2 = Region_2;
        type = Type;
        description = Description;
        how = How;
        hero_1 = Hero_1;
        hero_2 = Hero_2;
        hero_1_2 = Hero_1_2;
        hero_2_2 = Hero_2_2;
        heroname1 = HeroName1;
        heroname2 = HeroName2;
        code = Code;
        card_1 = Card_1;
        card_2 = Card_2;
    }
    public String GetTitle(){
        return title;
    }
    public String GetTier(){
        return tier;
    }
    public String GetRegion_1(){
        return region_1;
    }
    public String GetRegion_2(){
        return region_2;
    }
    public String GetType(){
        return type;
    }
    public String GetDescrp() { return  description; }
    public String GetHow() { return how; }
    public int GetHero_1(){return hero_1;}
    public int GetHero_2(){return hero_2;}
    public int GetHero_1_2(){return hero_1_2;}
    public int GetHero_2_2(){return hero_2_2;}
    public String GetHeroName_1(){return  heroname1;}
    public String GetHeroName_2(){return  heroname2;}
    public String GetCode(){return code;}
    public Card GetCard_1(){return card_1;}
    public Card GetCard_2(){return card_2;}

    private String title,tier,region_1,region_2,type,description,how,heroname1,heroname2,code;
    private int hero_1, hero_2, hero_1_2, hero_2_2;
    private Card card_1, card_2;


}