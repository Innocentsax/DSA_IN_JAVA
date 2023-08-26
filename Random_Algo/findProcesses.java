/*
For this challenge, you will be finding the most efficient set of steps to get from one item to another.

Inputs
You will write a function which will be provided with a set of processes that each convert from one item to another.

These will be provided as an array, with each process in the form of "process_name:from_item:to_item". For example, you might have a process named "smelt" that converts ore into a metal, like this: "smelt:ore:metal".

You will also be passed in the initial start item and desired end item for the overall workflow.

Note: For simplicity, all processes and items will be simple alphanumeric strings.

Output
Given these three inputs, your task is to determine which processes will complete the task in the shortest number of steps. Once you have done so, return the names of these processes, in order, as an array.

If no steps are needed (because the start and end item is the same), or if you cannot find a valid set of processes to get from the start to the end, return an empty array.

Specification
Challenge.findProcesses(startItem, endItem, tasks)
Parameters
startItem: String - Item to start with

endItem: String - Item to try to reach

tasks: String[] - A mapping of strings from one item to another in the format "process_name:from_item:to_item"

Return Value
String[] - A list of processes that convert start item to end item, if it exists
*/

import java.util.*;

public class Challenge {

    public static List<String> findProcesses(
        String startItem,
        String endItem,
        List<String> tasks
    ) {
        Map<String, List<ProcessItem>> itemToProcesses = new HashMap<>();

        // Populate the map with processes for each item
        for (String task : tasks) {
            String[] parts = task.split(":");
            String process = parts[0];
            String fromItem = parts[1];
            String toItem = parts[2];
            itemToProcesses.putIfAbsent(fromItem, new ArrayList<>());
            itemToProcesses.get(fromItem).add(new ProcessItem(process, toItem));
        }

        // Perform BFS to find the shortest path from startItem to endItem
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startItem, new ArrayList<>()));

        Set<String> visited = new HashSet<>();
        visited.add(startItem);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String currentItem = pair.item;
            List<String> processes = pair.processes;

            if (currentItem.equals(endItem)) {
                return processes;
            }

            List<ProcessItem> nextProcesses = itemToProcesses.getOrDefault(currentItem, new ArrayList<>());
            for (ProcessItem processItem : nextProcesses) {
                String nextItem = processItem.item;
                if (!visited.contains(nextItem)) {
                    List<String> nextProcessesList = new ArrayList<>(processes);
                    nextProcessesList.add(processItem.process);
                    queue.add(new Pair(nextItem, nextProcessesList));
                    visited.add(nextItem);
                }
            }
        }

        return Collections.emptyList(); // If no valid set of processes is found
    }

    private static class ProcessItem {
        String process;
        String item;

        public ProcessItem(String process, String item) {
            this.process = process;
            this.item = item;
        }
    }

    private static class Pair {
        String item;
        List<String> processes;

        public Pair(String item, List<String> processes) {
            this.item = item;
            this.processes = processes;
        }
    }

    // Test cases
    public static void main(String[] args) {
        List<String> tasks = Arrays.asList("smelt:ore:metal");
        List<String> result1 = findProcesses("ore", "metal", tasks);
        System.out.println(result1); // Output: [smelt]

        tasks = Arrays.asList("smelt:ore:metal", "refine:metal:gold");
        List<String> result2 = findProcesses("ore", "gold", tasks);
        System.out.println(result2); // Output: [smelt, refine]

        tasks = Arrays.asList("cut:wood:plank", "assemble:plank:table");
        List<String> result3 = findProcesses("wood", "table", tasks);
        System.out.println(result3); // Output: [cut, assemble]

        tasks = new ArrayList<>();
        List<String> result4 = findProcesses("ore", "ore", tasks);
        System.out.println(result4); // Output: [] (Start and end item are the same)

        tasks = Arrays.asList("smelt:ore:metal", "refine:metal:iron");
        List<String> result5 = findProcesses("ore", "gold", tasks);
        System.out.println(result5); // Output: [] (No valid set of processes)
    }
}
