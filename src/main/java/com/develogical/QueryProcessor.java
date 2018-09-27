package com.develogical;

import java.util.*;
import java.util.stream.Collectors;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespear (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if(query.toLowerCase().contains("what is your name")) {
            return "awesome";
        }  else if(query.toLowerCase().contains("plus")) {
            return calculate(query);
        }
        else if(query.toLowerCase().contains("largest")) {
            return findMax(query);
        } else if(query.toLowerCase().contains("multiplied")) {
            return findMulitply(query);
        } else if(query.toLowerCase().contains("divide")) {
            return findDivide(query);
        }
        return "";
    }

    private String findDivide(String query) {
        return null;
    }

    private String findMulitply(String query) {
        return null;
    }

    private String calculate(String query) {
        String[] s = query.split("\\:");
        String s1 = s[1].replaceAll("[^-?0-9]+", " ");

        List<String> numbers = Arrays.asList(s1.trim().split(" "));
        List<Integer> integers =
            numbers.stream().map(Integer::parseInt).collect(Collectors.toList());

        return String.valueOf((integers.get(0) + integers.get(1)));

    }

    private String findMax(String query){
        String[] split =
            query.split("largest:")[1].split(",");//.chars().filter(Character::isDigit).max();
        List<Integer> items = new ArrayList<>();

        for(String item: split){
            int i = Integer.parseInt(item.trim());
            items.add(i);
        }
        return Collections.max(items).toString();
    }
}
