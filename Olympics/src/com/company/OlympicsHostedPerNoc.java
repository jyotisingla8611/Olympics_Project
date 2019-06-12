package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class OlympicsHostedPerNoc {
    public static void find(List<Athlete> athletes) {

        //if we are counting each year as an one value only
        HashMap<String, HashSet<Integer>> results = new HashMap<>();

        for (int i = 0; i < athletes.size(); i++) {
            if(results.containsKey(athletes.get(i).getNoc())){
                HashSet<Integer> set = results.get(athletes.get(i).getNoc());
                set.add(athletes.get(i).getYear());
                results.put(athletes.get(i).getNoc(), set);
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(athletes.get(i).getYear());
                results.put(athletes.get(i).getNoc(),set);
            }
        }

        for (Map.Entry<String, HashSet<Integer>> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().size());
        }
    }
}
