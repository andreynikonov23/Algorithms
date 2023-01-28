package org.example;

import java.util.*;

public class Graph {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("you", new ArrayList<>(Arrays.asList("alice", "bob", "claire")));
        graph.put("bob", new ArrayList<>(Arrays.asList("anuj", "peggy")));
        graph.put("alice", new ArrayList<>(List.of("peggy")));
        graph.put("claire", new ArrayList<>(Arrays.asList("thom", "jonny")));
        graph.put("anuj", new ArrayList<>());
        graph.put("peggy", new ArrayList<>());
        graph.put("thom", new ArrayList<>());
        graph.put("jonny", new ArrayList<>());


        searchMangoSeller(graph);
    }
    public static boolean searchMangoSeller(HashMap<String, ArrayList<String>> graph){
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.addAll(graph.get("you"));

        ArrayList<String> searched = new ArrayList<>();
        while (true){
            String person = queue.poll();
            if (person != null){
                if (personIsSeller(person) && !(searched.contains(person))){
                    searched.add(person);
                    System.out.println(person + " is mango seller");
                    return true;
                } else {
                    searched.add(person);
                    queue.addAll(graph.get(person));
                }
            } else
                break;
        }
        return false;
    }

    public static boolean personIsSeller(String person){
        if (person.charAt(person.length() - 1) == 'm'){
            return true;
        }
        return false;
    }
}
