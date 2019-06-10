package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OlympicsHostedPerNoc {
    void Outcome(List<Athlete> athletes, List<Noc_regions> noc_regions){
        HashMap<String,Integer> results = new HashMap<>();
        for(int i = 0 ; i  < athletes.size() ;i++){
            if(results.containsKey(athletes.get(i).noc))
                results.put(athletes.get(i).noc , results.get(athletes.get(i).noc) + 1);
            else
                results.put(athletes.get(i).noc,1);
        }

        for(Map.Entry<String, Integer> entry: results.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }
}
