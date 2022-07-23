package com.example.myapplication;

import java.util.ArrayList;

public class Details {
    private String Name,RegNum,opt_vac,Gender,Age,Preferences;
    private ArrayList<String> preference;
    public Details(){

    }
//    public Details(String Name,String RegNum,String optVac,String Gender,String Age,ArrayList<String> Preference){
    public Details(String Age,String Gender,String Name,String Preference,String RegNum,String optVac){
        this.Name=Name;
        this.RegNum=RegNum;
        this.opt_vac=optVac;
        this.Gender=Gender;
        this.Age=Age;
        this.Preferences=Preference;
//        Preferences="";
    }
    public String getName(){
        return Name;
    }
    public String getRegNum(){
        return RegNum;
    }
    public String getOpt_vac(){
        return opt_vac;
    }
    public String getGender(){
        return Gender;
    }
    public String getAge(){
        return Age;
    }
    public String getPreferences(){
//        for(int i=0;i<preference.size();i++){
//            Preferences=Preferences+","+preference.get(i);
//        }
        return Preferences;
    }
}
