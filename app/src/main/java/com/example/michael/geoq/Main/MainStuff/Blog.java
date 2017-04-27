package com.example.michael.geoq.Main.MainStuff;

/**
 * Created by panacointarbez on 27/04/2017.
 */

public class Blog {


        private String desc;
        private String title;



        private  String username;

        public Blog(){

        }

        public Blog(String desc, String title) {
            this.desc = desc;
            this.title = title;
            this.username = username;
        }
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

    }
