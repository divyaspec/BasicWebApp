package com.develogical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

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
        }
        // which of the following numbers is the largest: 375, 99
        return "";
    }

    private String calculate(String query) {
        String s = query.replaceAll("[^0-9]", "");

        return null;
    }

    private String findMax(String query){
        String[] split =
            query.split("\\:")[1].split(",");//.chars().filter(Character::isDigit).max();
        List<Integer> items = new ArrayList<>();

        for(String item: split){
            int i = Integer.parseInt(item.trim());
            items.add(i);
        }
        return Collections.max(items).toString();
    }
}
