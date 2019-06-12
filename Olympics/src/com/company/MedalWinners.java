package com.company;
//119 7

import java.util.ArrayList;
import java.util.List;

public class MedalWinners {

    public static final String INDIA = "IND";
    public static final String SUMMER = "Summer";
    public static final String NA = "NA";
    static ArrayList<String> summerList = new ArrayList<>();
    static ArrayList<String> winterList = new ArrayList<>();

    static void getResults(List<Athlete> athleteData) {
        for (int i = 0; i < athleteData.size(); i++) {
            if (athleteData.get(i).getNoc().equals(INDIA) && !athleteData.get(i).getMedal().equals(NA)) {
                if (athleteData.get(i).getSeason().equals(SUMMER)) {
                    summerList.add(athleteData.get(i).getName());
                } else {
                    winterList.add(athleteData.get(i).getName());
                }
            }
        }

        System.out.println("\nThe medalist who played in summer are : ");
        System.out.println(summerList);

        System.out.println("\nThe medalist who played in winter are : ");
        System.out.println(winterList);

    }
}
