package com.company;

import java.util.List;

public class BoxingAverage {
    public void getResults(List<Athlete> athlete_data) {
        int summerCount = 0;
        int winterCount = 0;
        int SummerValues = 0;
        int winterValues = 0;
        for(Athlete athlete : athlete_data){
            if(athlete.event.equals("Boxing Men's Heavyweight")) {
                if(athlete.season.equals("Summer")) {
                    summerCount++;
                    if(athlete.age != -1)
                    SummerValues += athlete.age;
                }else {
                    winterCount++;
                    if(athlete.age != -1)
                    winterValues += athlete.age;
                }
            }
        }

        float summerAverage = 0,winterAverage = 0;
        try {
              summerAverage =  (float)SummerValues/(float)summerCount;
              winterAverage =  (float)winterValues/(float)winterCount;
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException occured!");
        }

        System.out.println("\nThe Summer Average is as : " + summerAverage);
        System.out.println("The Winter Average is as : " + winterAverage + "\n");
    }
}
