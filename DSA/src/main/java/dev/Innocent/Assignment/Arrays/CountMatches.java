package dev.Innocent.Assignment.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CountMatches {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "lenovo"));
        items.add(Arrays.asList("phone", "gold", "iphone"));

        String ruleKey = "color";  // You can change this to "name" for name matching
        String ruleValue = "silver";

        // Call the countMatches method
        CountMatches counter = new CountMatches();  // Create an instance
        int matchingItems = counter.countMatches(items, ruleKey, ruleValue);

        System.out.println("Number of items matching " + ruleKey + " '" + ruleValue + "': " + matchingItems);
    }
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int searchIndex = 0;
        int count = 0;
        if(ruleKey.equals("color")){
            searchIndex = 1;
        }
        if(ruleKey.equals("name")){
            searchIndex = 2;
        }
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).get(searchIndex).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}