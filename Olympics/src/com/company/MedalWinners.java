package com.company;
//119 7

import java.util.ArrayList;
import java.util.List;

public class MedalWinners {
    
    ArrayList<String> summerList = new ArrayList<>();
    ArrayList<String> winterList = new ArrayList<>();

    void getResults(List<Athlete> athleteData) {
        for (int i = 0; i < athleteData.size(); i++) {
            if (athleteData.get(i).noc.equals("IND") && !athleteData.get(i).medal.equals("NA")) {
                if (athleteData.get(i).season.equals("Summer")) {
                    summerList.add(athleteData.get(i).name);
                } else {
                    winterList.add(athleteData.get(i).name);
                }
            }
        }

        System.out.println("\nThe medalist who played in summer are : ");
        System.out.println(summerList);

        System.out.println("\nThe medalist who played in winter are : ");
        System.out.println(winterList);

    }
}
