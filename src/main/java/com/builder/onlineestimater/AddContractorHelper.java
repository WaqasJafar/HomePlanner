package com.builder.onlineestimater;

public class AddContractorHelper {

    String number;
    String name;
    String ac_type;
    String contractor_profile;
AddContractorHelper(){

}

    public AddContractorHelper(String contractor_profile) {
        this.contractor_profile = contractor_profile;
    }

    public String getContractor_profile() {
        return contractor_profile;
    }

    public void setContractor_profile(String contractor_profile) {
        this.contractor_profile = contractor_profile;
    }

    public AddContractorHelper(String number, String name, String email, String city, String pasword, String ac_type) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.city = city;
        this.pasword = pasword;
        this.ac_type=ac_type;
    }

    public String getAc_type() {
        return ac_type;
    }

    public void setAc_type(String ac_type) {
        this.ac_type = ac_type;
    }

    String email;
    String city;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    String pasword;
}
