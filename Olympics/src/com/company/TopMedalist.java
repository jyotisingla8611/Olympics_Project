package com.company;

import java.util.*;

public class TopMedalist {
    public static final String MEDAL_SILVER = "Silver";
    public static final String MEDAL_BRONZE = "Bronze";
    public static final String MEDAL_GOLD = "Gold";
    public static final String NA = "NA";
    static HashMap<String, Integer> gold = new HashMap<String, Integer>();
    static HashMap<String, Integer> silver = new HashMap<String, Integer>();
    static  HashMap<String, Integer> bronze = new HashMap<String, Integer>();

    public static void getResults(List<Athlete> athlete_data) {
        for (int i = 0; i < athlete_data.size(); i++) {
            if(athlete_data.get(i).getYear() > 2000 && athlete_data.get(i).getMedal().equals(NA) == false) {
                if (athlete_data.get(i).getMedal().equals(MEDAL_SILVER)) {
                    AddValue(silver,athlete_data.get(i));
                } else if (athlete_data.get(i).getMedal().equals(MEDAL_BRONZE)) {
                    AddValue(bronze, athlete_data.get(i));
                } else {
                    AddValue(gold, athlete_data.get(i));
                }
            }
        }
        print();
    }

    private static void AddValue(HashMap<String, Integer> temp, Athlete athlete) {
        if(temp.containsKey(athlete.getNoc())) {
            temp.put(athlete.getNoc(),temp.get(athlete.getNoc())+1);
        } else {
            temp.put(athlete.getNoc(),1);
        }
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    static void print() {
        System.out.println("\nTop 10 Gold medalist Countries Are : ");
        HashMap<String,Integer>goldVal = sortByValue(gold);
        int count = 0;
        for(Map.Entry<String,Integer> entry : goldVal.entrySet()) {
            if(count == 10)
                break;
            System.out.println(entry.getKey() + " : " + entry.getValue());
            count++;
        }
        System.out.println("\nTop 10 Silver medalist Countries Are : ");
        HashMap<String,Integer>silverVal = sortByValue(silver);
        count = 0;
        for(Map.Entry<String,Integer> entry : silverVal.entrySet()) {
            if(count == 10)
                break;
            System.out.println(entry.getKey() + " : " + entry.getValue());
            count++;
        }
        System.out.println("\nTop 10 Bronze medalist Countries Are : ");
        HashMap<String,Integer>bronzeVal = sortByValue(bronze);
        count = 0;
        for(Map.Entry<String,Integer> entry : bronzeVal.entrySet()) {
            if(count == 10)
                break;
            System.out.println(entry.getKey() + " : " + entry.getValue());
            count++;
        }
    }
}
