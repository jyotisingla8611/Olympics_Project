package com.company;

import java.util.*;

public class TopMedalist {
    HashMap<String,Integer>gold = new HashMap<String, Integer>();
    HashMap<String,Integer>silver = new HashMap<String, Integer>();
    HashMap<String,Integer>bronze = new HashMap<String, Integer>();

    public void getResults(List<Athlete> athlete_data) {

        for(int i = 0 ; i < athlete_data.size() ;i++){
            if(athlete_data.get(i).year > 2000 && athlete_data.get(i).medal.equals("NA") == false){
                if (athlete_data.get(i).medal.equals("Silver")){
                    AddValue(silver,athlete_data.get(i));
                }else if(athlete_data.get(i).medal.equals("Bronze")){
                    AddValue(bronze, athlete_data.get(i));
                }else{
                    AddValue(gold, athlete_data.get(i));
                }
            }
        }
        print();
    }

    private void AddValue(HashMap<String, Integer> temp, Athlete athlete) {
        if(temp.containsKey(athlete.noc)) {
            temp.put(athlete.noc,temp.get(athlete.noc)+1);
        }else {
            temp.put(athlete.noc,1);
        }
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    void print(){
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
