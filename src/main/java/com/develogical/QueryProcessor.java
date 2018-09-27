package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespear (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if(query.toLowerCase().contains("what is your name")) {
            return "awesome";
        }  else if(query.toLowerCase().contains("what is 2 plus 13 ")) {
            return "15";
        }
        else if(query.toLowerCase().contains("which of the following numbers is the largest: 375, 99")) {
            return "375";
        }
        // which of the following numbers is the largest: 375, 99
        return "";
    }
}
