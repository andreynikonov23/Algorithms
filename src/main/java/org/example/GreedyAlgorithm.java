package org.example;

import java.util.*;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        //Init Stations and States
        HashSet<String> statesNeeded = new HashSet<>(Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        HashMap<String, HashSet<String>> stations = new HashMap<>();
        stations.put("kone", new HashSet<>(Set.of("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Set.of("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Set.of("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Set.of("nv", "ut")));
        stations.put("kfive", new HashSet<>(Set.of("ca", "az")));
        HashSet<String> finalStations = new HashSet<>();

        //Algorithm
        while (statesNeeded.size() > 0){
            String bestStation = "";
            HashSet<String> statesCovered = new HashSet<>();
            for(Map.Entry<String, HashSet<String>> entry : stations.entrySet()){
                String station = entry.getKey();
                HashSet<String> states = entry.getValue();
                HashSet<String> covered = new HashSet<>(statesNeeded);
                covered.retainAll(states);
                if (covered.size() > statesCovered.size()){
                    bestStation = station;
                    statesCovered = covered;
                }
            }
            statesNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);
        }
        System.out.println(finalStations);
    }
}
