package com.builder.onlineestimater;

public class ratinghelper {

    ratinghelper(){

    }


    String contractornumber;
    String contractorname;

    public String getPersonnumber() {
        return personnumber;
    }

    public void setPersonnumber(String personnumber) {
        this.personnumber = personnumber;
    }

    public String getRatingtxt() {
        return ratingtxt;
    }

    public void setRatingtxt(String ratingtxt) {
        this.ratingtxt = ratingtxt;
    }

    String personnumber;
    String ratingtxt;

    public ratinghelper(String contractornumber, String contractorname, String personnumber, String personname, int rating,String ratingtxt) {
        this.contractornumber = contractornumber;
        this.contractorname = contractorname;
        this.personnumber = personnumber;
        this.ratingtxt = ratingtxt;
        this.personname = personname;
        this.rating = rating;
    }

    String personname;
    int rating;

    public String getContractornumber() {
        return contractornumber;
    }

    public void setContractornumber(String contractornumber) {
        this.contractornumber = contractornumber;
    }

    public String getContractorname() {
        return contractorname;
    }

    public void setContractorname(String contractorname) {
        this.contractorname = contractorname;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
