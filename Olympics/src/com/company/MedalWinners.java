package com.company;
//119 7
import java.util.ArrayList;
import java.util.List;

public class MedalWinners {
    ArrayList<String>summerList = new ArrayList<>();
    ArrayList<String>winterList = new ArrayList<>();

    void getResults(List<Athlete>athletes){
        for(int i = 0 ; i < athletes.size() ; i++){
            if( athletes.get(i).noc.equals("IND") && !athletes.get(i).medal.equals("NA")) {
                if (athletes.get(i).season.equals("Summer")) {
                    summerList.add(athletes.get(i).name);
                } else {
                    winterList.add(athletes.get(i).name);
                }
            }
        }

        System.out.println("\nThe medalist who played in summer are : ");
        System.out.println(summerList);

        System.out.println("\nThe medalist who played in winter are : ");
        System.out.println(winterList);

    }
}
