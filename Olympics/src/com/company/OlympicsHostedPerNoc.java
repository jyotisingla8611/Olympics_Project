package com.company;

import java.util.*;

public class OlympicsHostedPerNoc {
    void Outcome(List<Athlete> athletes){
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

        Iterator<Map.Entry<String, HashSet<Integer>>> itr1 = results.entrySet().iterator();
        Iterator<Integer> itr2 = itr1.next().getValue().iterator();
        while (itr1.hasNext()) {
            System.out.println(itr1.next().getKey());
            while (itr2.hasNext()) {
                System.out.println(itr2.next());
            }
        }
    }
}
