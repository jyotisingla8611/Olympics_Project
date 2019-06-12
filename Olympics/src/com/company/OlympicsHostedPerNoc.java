package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class OlympicsHostedPerNoc {
    void Outcome(List<Athlete> athletes){

        //if we are counting each year as an one value only
        HashMap<String,HashSet<Integer>> results = new HashMap<>();

        for(int i = 0 ; i < athletes.size() ; i++){
            if(results.containsKey(athletes.get(i).noc)){
                HashSet<Integer> set = results.get(athletes.get(i).noc);
                set.add(athletes.get(i).year);
                results.put(athletes.get(i).noc, set);
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(athletes.get(i).year);
                results.put(athletes.get(i).noc,set);
            }
        }

        /*
           If Counting noc's per year with duplicates too
             HashMap<String,Integer>results = new HashMap<String,Integer>();
             for(int i = 0 ; i < athletes.size() ;i++){
               if(results.get(athletes.get(i).noc)
                 results.put(athletes.get(i).noc,results.get(athletes.get(i).noc) + 1);
                else
                  results.put(athletes.get(i).noc,1);
             }
         */

       
        for (Map.Entry<String, HashSet<Integer>> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().size());
        }
    }
}
