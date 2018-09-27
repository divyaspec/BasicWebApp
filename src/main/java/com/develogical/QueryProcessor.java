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
        }else if(query.toLowerCase().contains("minus")) {
            return findMinus(query);
        } else if(query.toLowerCase().contains("eiffel tower")) {
            return "Paris";
        } else if(query.toLowerCase().contains("who played james bond in the film dr no")){
            return "Sean Connery";
        } else if(query.toLowerCase().contains("")){
            return findBothSquareAndCube(query);
        }
        return "";
    }

    private String findBothSquareAndCube(String query) {
        List<Integer> integers = getNumberForSquareAndCube(query);
        Integer one = integers.get(0);
        Integer two = integers.get(1);
        if(!isCube(one) && !isSquare(one)){
           return two.toString();
        } else {
            return one.toString();
        }
    }

    private String findMinus(String query) {
        List<Integer> integers = getNumbers(query);
        return String.valueOf((integers.get(0) - integers.get(1)));
    }


    private String findMulitply(String query) {
        List<Integer> integers = getNumbers(query);

        return String.valueOf((integers.get(0) * integers.get(1)));
    }

    private String calculate(String query) {
        List<Integer> integers = getNumbers(query);

        return String.valueOf((integers.get(0) + integers.get(1)));

    }

    private List<Integer> getNumbers(String query) {
        String[] s = query.split("\\:");
        String s1 = s[1].replaceAll("[^-?0-9]+", " ");

        List<String> numbers = Arrays.asList(s1.trim().split(" "));
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private List<Integer> getNumberForSquareAndCube(String query) {
        String[] s = query.split("\\:");
        String s1 = s[2].replaceAll("[^-?0-9]+", " ");

        List<String> numbers = Arrays.asList(s1.trim().split(" "));
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
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



    private boolean isCube(long input) {
        double cubeRoot = Math.cbrt(input);
        long intRoot = Math.round(cubeRoot);
        return (intRoot*intRoot*intRoot) == input;
    }

    private boolean isSquare(long input) {
        double cubeRoot = Math.sqrt(input);
        long intRoot = Math.round(cubeRoot);
        return (intRoot*intRoot*intRoot) == input;
    }
}
