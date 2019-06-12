package com.company;

import java.util.List;

public class BoxingAverage {

    public static final String BOXING_MEN_S_HEAVYWEIGHT = "Boxing Men's Heavyweight";
    public static final String SUMMER = "Summer";

    public static void getResults(List<Athlete> athlete_data) {
        int summerCount = 0;
        int winterCount = 0;
        int summerValues = 0;
        int winterValues = 0;
        for (Athlete athlete : athlete_data) {
            if (athlete.getEvent().equals(BOXING_MEN_S_HEAVYWEIGHT)) {
                if (athlete.getSeason().equals(SUMMER)) {
                    summerCount++;
                    if (athlete.getAge() != -1)
                        summerValues += athlete.getAge();
                } else {
                    winterCount++;
                    if (athlete.getAge() != -1)
                        winterValues += athlete.getAge();
                }
            }
        }

        float summerAverage = 0, winterAverage = 0;
        try {
            summerAverage = (float) summerValues / (float) summerCount;
            winterAverage = (float) winterValues / (float) winterCount;
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException occured!");
        }

        System.out.println("\nThe Summer Average is as : " + summerAverage);
        System.out.println("The Winter Average is as : " + winterAverage + "\n");
    }
}
