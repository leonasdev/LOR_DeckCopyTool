package com.example.lor_deckcopytool;

import java.io.Serializable;

public class Card implements Serializable {
    public Card(String Title, String Region, String Description, int Img) {
        title = Title;
        region = Region;
        description = Description;
        img = Img;
    }
    public String GetTitle(){
        return title;
    }
    public String GetRegion(){
        return region;
    }
    public String GetDescrp() { return  description; }
    public int GetImg(){ return img;}
    private String title,region,description;
    private int img;
    private static final long serialVersionUID = -7060210544600464481L;
}
