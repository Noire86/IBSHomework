package ru.soular.ibs.homework2.util;

import java.util.*;

public class StatHandler {
    public static Map<String, Integer> getOverallStats(List<String> stringList) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : stringList){
            map.put(s, Collections.frequency(stringList, s));
        }

        return map;

    }

    public static List<String> getFrequent(Map<String, Integer> map){
        List<String> result = new ArrayList<>();
        int maxValue = Collections.max(map.values());

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == maxValue){
                result.add("Word: '" + entry.getKey() + "' Frequency: " + entry.getValue() + " times");
            }
        }
        return result;
    }
}
