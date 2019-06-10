package com.company;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.nio.*;

class Athlete{

    List<Athlete> athlete_Data = new ArrayList<>();

    int id;
    String name;
    String sex;
    int age;
    int height;
    double weight;
    String team;
    String noc;
    String game;
    int year;
    String season;
    String city;
    String sport;
    String event;
    String medal;

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
    public void readAtOnce(String file)
    {
       /* FileReader filereader = null;
        try {
            filereader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/


       // BufferedReader bufferreader = new BufferedReader(filereader);
        try (BufferedReader bufferreader = Files.newBufferedReader(Paths.get(file), StandardCharsets.US_ASCII)) {

            String line = bufferreader.readLine();
            line = bufferreader.readLine();
            while (line != null) {
                String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                for(int i = 0 ;i < attributes.length ; i++){
                    //attributes[i] = attributes[i].substring(1, attributes[i].length()-1);
                    attributes[i] = attributes[i].replace("\"", "");
                }
                Athlete athlete = createAthlete(attributes);
                athlete_Data.add(athlete);
                line = bufferreader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    static boolean isNA(String str){
        boolean ans = str.equals("NA");
        return ans;
    }
   /* static void isString(String[] data){
        try{
            if(!(data[3].equals("NA"))){
                int i =Integer.parseInt(data[3]);
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }*/
    private static Athlete createAthlete(String[] data) {
       // isString(data);
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        String sex = data[2];
        boolean ag = isNA(data[3]);
        int age = ag ? -1 : Integer.parseInt(data[3]);
        boolean hgt = isNA(data[4]);
        int height = hgt ? -1 : Integer.parseInt(data[4]);
        boolean wt = isNA(data[5]);
        double weight =  wt ? -1 : Double.parseDouble(data[5]);;
        String team = data[6];
        String noc = data[7];
        String game = data[8];
        boolean yr = isNA(data[9]);
        int year = yr ? -1 : Integer.parseInt(data[9]);
        String season = data[10];
        String city = data[11];
        String sport = data[12];
        String event = data[13];
        String medal = data[14];

        return (new Athlete(id,name,sex,age,height,weight,team,noc,game,year,season,city,sport,event,medal));
    }

}

class  Noc{
    List<Noc>noc_data = new ArrayList<Noc>();
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        String athlete_file = "/home/lenovo/MyProjects/Olympics/src/athlete_events.csv";
        Athlete athlete_object = new Athlete();
        athlete_object.readAtOnce(athlete_file);
        System.out.println("Size is athlete_events : "  + athlete_object.athlete_Data.size());
        String noc_file = "/home/lenovo/MyProjects/Olympics/src/noc_regions.csv";
        Noc noc_object = new Noc();

    }
}
