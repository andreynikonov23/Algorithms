package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DijkstrasAlgorithm {
    private static final ArrayList<Map.Entry<String, Double>> PROCESSED = new ArrayList<>();
    public static void main(String[] args) {
        //Graph realisation
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        graph.put("start", new HashMap<>(Map.of("a", 6d, "b", 2d)));
        graph.put("a", new HashMap<>(Map.of("fin", 1d)));
        graph.put("b", new HashMap<>(Map.of("a", 3d, "fin", 5d)));
        graph.put("fin", new HashMap<>());

        //costs hashMap
        double infinity = Double.POSITIVE_INFINITY;
        HashMap<String, Double> costs = new HashMap<>();
        costs.put("a", 6d);
        costs.put("b", 2d);
        costs.put("fin", infinity);

        //parents hashMap
        HashMap<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);


        //Dijkstra's Algorithm
        for (int i = 0; i < costs.size(); i++) {
            Map.Entry<String, Double> node = findLowestCostNode(costs);
            double cost = node.getValue();
            HashMap<String, Double> neighbors = graph.get(node.getKey());
            for (Map.Entry<String, Double> entry : neighbors.entrySet()){
                String value = entry.getKey();
                double newCost = cost + entry.getValue();
                if (costs.get(value) > newCost){
                    costs.put(value, newCost);
                    parents.put(value, node.getKey());
                }
            }
            PROCESSED.add(node);
        }
        //Result
        System.out.println("Fin = " + costs.get("fin"));
    }

    public static Map.Entry<String, Double> findLowestCostNode(HashMap<String, Double> costs){
        double lowestCost = Double.POSITIVE_INFINITY;
        Map.Entry<String, Double> lowestCostNode = null;
        for (Map.Entry<String, Double> node : costs.entrySet()){
            double cost = node.getValue();
            if (cost < lowestCost && !(PROCESSED.contains(node))){
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }

}
