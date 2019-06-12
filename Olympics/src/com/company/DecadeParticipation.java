package com.company;

import java.util.ArrayList;
import java.util.List;

class YearRatio {
    
    int year;
    int female;
    int male;

    public YearRatio(int year, int female, int male) {
        this.year = year;
        this.female = female;
        this.male = male;
    }
}

public class DecadeParticipation {

    public static final String FEMALE = "F";

    static int check(ArrayList<YearRatio> res, int yr) {
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).year == yr)
                return i;
        }
        return -1;
    }

    public static void getResults(List<Athlete> athleteData) {
        ArrayList<YearRatio> result = new ArrayList<>();

        for (int i = 0; i < athleteData.size(); i++) {
            int ind = check(result, athleteData.get(i).getYear());
            if (ind != -1) {
                YearRatio temp = result.get(ind);
                if (athleteData.get(i).getSex().equals(FEMALE)) {
                    temp.female = temp.female + 1;
                    result.set(ind, temp);
                } else {
                    temp.male = temp.male + 1;
                    result.set(ind, temp);
                }
            } else {
                if (athleteData.get(i).getSex().equals(FEMALE))
                    result.add(new YearRatio(athleteData.get(i).getYear(), 1, 0));
                else
                    result.add(new YearRatio(athleteData.get(i).getYear(), 0, 1));
            }

        }

        System.out.println("\nDecade participation results as Ration of M:F is as : ");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).year + "  :  " + ((float) result.get(i).male / (float) result.get(i).female));
        }
    }
}


