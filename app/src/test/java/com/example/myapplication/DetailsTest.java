package com.example.myapplication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DetailsTest {

    @Test
    void getName() {
//        assertEquals(5 + 2, 7);
        Details d=new Details("20","Female","Amrutha","Injections,Tablets","20BCE7391","Vaccinated");
        assertEquals("Amrutha","Amrutha");
    }

    @Test
    void getRegNum() {
        Details d=new Details("20","Female","Amrutha","Injections,Tablets","20BCE7391","Vaccinated");
        assertEquals("20BCE7391",d.getRegNum());
    }

    @Test
    void getOpt_vac() {
        Details d=new Details("20","Female","Amrutha","Injections,Tablets","20BCE7391","Vaccinated");
        assertEquals("Vaccinated",d.getOpt_vac());
    }

    @Test
    void getGender() {
        Details d=new Details("20","Female","Amrutha","Injections,Tablets","20BCE7391","Vaccinated");
        assertEquals("Female",d.getGender());
    }

    @Test
    void getAge() {
        Details d=new Details("20","Female","Amrutha","Injections,Tablets","20BCE7391","Vaccinated");
        assertEquals("20",d.getAge());
    }

    @Test
    void getPreferences() {
        Details d=new Details("20","Female","Amrutha","Injections,Tablets","20BCE7391","Vaccinated");
        assertEquals("Injections,Tablets",d.getPreferences());
    }

}