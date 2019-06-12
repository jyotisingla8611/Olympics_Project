package com.company;

import java.util.ArrayList;
import java.util.List;

class yearRatio {
    
    int year;
    int female;
    int male;

    yearRatio(int year, int female, int male) {
        this.year = year;
        this.female = female;
        this.male = male;
    }
}

public class DecadeParticipation {

    int check(ArrayList<yearRatio> res, int yr) {
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).year == yr)
                return i;
        }
        return -1;
    }

    public void getResults(List<Athlete> athleteData) {

        ArrayList<yearRatio> result = new ArrayList<>();

        for (int i = 0; i < athleteData.size(); i++) {
            int ind = check(result, athleteData.get(i).year);
            if (ind != -1) {
                yearRatio temp = result.get(ind);
                if (athleteData.get(i).sex.equals("F")) {
                    temp.female = temp.female + 1;
                    result.set(ind, temp);
                } else {
                    temp.male = temp.male + 1;
                    result.set(ind, temp);
                }
            } else {
                if (athleteData.get(i).sex.equals("F"))
                    result.add(new yearRatio(athleteData.get(i).year, 1, 0));
                else
                    result.add(new yearRatio(athleteData.get(i).year, 0, 1));
            }

        }

        System.out.println("Decade participation results as Ration of M:F is as : ");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).year + "  :  " + ((float) result.get(i).male / (float) result.get(i).female));
        }
    }
}


