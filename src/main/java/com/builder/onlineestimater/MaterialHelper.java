package com.builder.onlineestimater;

public class MaterialHelper {
    String brick,cement,sand,ironrod,bajri,type;

    public MaterialHelper(String brick, String cement, String sand, String ironrod, String bajri,String type) {
        this.brick = brick;
        this.cement = cement;
        this.sand = sand;
        this.ironrod = ironrod;
        this.bajri = bajri;
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrick() {
        return brick;
    }

    public void setBrick(String brick) {
        this.brick = brick;
    }

    public String getCement() {
        return cement;
    }

    public void setCement(String cement) {
        this.cement = cement;
    }

    public String getSand() {
        return sand;
    }

    public void setSand(String sand) {
        this.sand = sand;
    }

    public String getIronrod() {
        return ironrod;
    }

    public void setIronrod(String ironrod) {
        this.ironrod = ironrod;
    }

    public String getBajri() {
        return bajri;
    }

    public void setBajri(String bajri) {
        this.bajri = bajri;
    }
}
