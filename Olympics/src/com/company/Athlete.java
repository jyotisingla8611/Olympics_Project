package com.company;

import java.util.*;

class Athlete{

    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int SEX = 2;
    public static final int AGE = 3;
    public static final int HEIGHT = 4;
    public static final int WEIGHT = 5;
    public static final int TEAM = 6;
    public static final int NOC = 7;
    public static final int GAME = 8;
    public static final int YEAR = 9;
    public static final int SEASON = 10;
    public static final int CITY = 11;
    public static final int SPORT = 12;
    public static final int EVENT = 13;
    public static final int MEDAL = 14;

    private static List<Athlete> athletes = new ArrayList<>();

    private int id;
    private String name;
    private String sex;
    private int age;
    private int height;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getTeam() {
        return team;
    }

    public String getNoc() {
        return noc;
    }

    public String getGame() {
        return game;
    }

    public int getYear() {
        return year;
    }

    public String getSeason() {
        return season;
    }

    public String getCity() {
        return city;
    }

    public String getSport() {
        return sport;
    }

    public String getEvent() {
        return event;
    }

    public String getMedal() {
        return medal;
    }

    private double weight;
    private String team;
    private String noc;
    private String game;
    private int year;
    private String season;
    private String city;
    private String sport;
    private String event;
    private String medal;

    Athlete(){

    }

    Athlete(int id,String name,String sex,int age,int height,double weight,String team,String noc,String game,
            int year,String season,String city, String sport,String event,String medal){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.team = team;
        this.noc = noc;
        this.game = game;
        this.year = year;
        this.season = season;
        this.city = city;
        this.sport = sport;
        this.event = event;
        this.medal = medal;
    }

    public static List<Athlete> getAthletes() {
        return athletes;
    }
}
