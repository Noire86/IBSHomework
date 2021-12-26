package ru.soular.ibs.homework2.util;

import java.util.*;

public class StatHandler {
    private static Map<String, Integer> getStatsMap(List<String> stringList) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : stringList) {
            map.put(s, Collections.frequency(stringList, s));
        }
        return map;

    }

    private static List<String> getStatsList(Map<String, Integer> map, boolean frequent) {
        List<String> result = new ArrayList<>();
        int maxValue = Collections.max(map.values());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (frequent) {
                if (entry.getValue() == maxValue) {
                    result.add("Word: '" + entry.getKey() + "' Frequency: " + entry.getValue() + " times");
                }
            } else {
                result.add("Word: '" + entry.getKey() + "' Frequency: " + entry.getValue() + " times");
            }
        }


        result.sort(String::compareToIgnoreCase);
        return result;
    }

    public static void printStats(List<String> list, boolean frequent) {
        List<String> resultList = getStatsList(getStatsMap(list), frequent);
        for (String s : resultList) {
            System.out.println(s);
        }
    }
}
