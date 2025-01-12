package dev.Innocent.Section7.Collection;

import java.util.*;

public class SetOperationChallenge {
    public static void main(String[] args) {
        Set<Task> task = TaskData.getTasks("all");
        sortAndPrint("All Tasks", task);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);

        Set<Task> annsTask = TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks", annsTask, sortByPriority);
    }

    private static void sortAndPrint(String header, Collection<Task> collection){
        sortAndPrint(header, collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter){
        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }
}
