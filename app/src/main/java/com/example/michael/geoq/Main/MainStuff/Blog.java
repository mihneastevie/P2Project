package com.example.michael.geoq.Main.MainStuff;

/**
 * Created by panacointarbez on 27/04/2017.
 */

public class Blog {


    private String Desc;
    private String image;
    private String title;

    public Blog(){


    }


    public Blog(String desc, String image, String title) {
        Desc = desc;
        this.image = image;
        this.title = title;
    }



    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    }
