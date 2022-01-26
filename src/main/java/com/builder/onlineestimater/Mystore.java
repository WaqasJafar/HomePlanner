package com.builder.onlineestimater;

public class Mystore {
    String brick;

    Mystore(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    String name;

    public String getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(String currentdate) {
        this.currentdate = currentdate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    String number;

    String currentdate,currentTime;



    public String getTotalpricematerial() {
        return totalpricematerial;
    }

    public void setTotalpricematerial(String totalpricematerial) {
        this.totalpricematerial = totalpricematerial;
    }

    String totalpricematerial;

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

    public String getIron() {
        return iron;
    }

    public void setIron(String iron) {
        this.iron = iron;
    }

    public String getBajri() {
        return bajri;
    }

    public void setBajri(String bajri) {
        this.bajri = bajri;
    }

    String cement;

    public Mystore(String brick, String cement, String sand, String iron, String bajri , String totalpricematerial, String name , String number, String currentdate , String currentTime) {
        this.brick = brick;
        this.cement = cement;
        this.sand = sand;
        this.iron = iron;
        this.bajri = bajri;
        this.totalpricematerial=totalpricematerial;
        this.name = name;
        this.number=number;
        this.currentTime = currentTime;
        this.currentdate = currentdate;
        this.number=number;


    }

    String sand;
    String iron;
    String bajri;


}

