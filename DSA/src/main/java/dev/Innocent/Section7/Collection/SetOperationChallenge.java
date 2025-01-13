package dev.Innocent.Section7.Collection;

import java.util.*;

public class SetOperationChallenge {
    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All Tasks", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);

        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        Set<Task> carolsTasks = TaskData.getTasks("Carol");
        List<Set<Task>> sets = List.of(annsTasks, bobsTasks, carolsTasks);

        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrint("Assigned Tasks", assignedTasks);

        Set<Task> everyTask = getUnion(List.of(tasks, assignedTasks));
        sortAndPrint("The True All Task", everyTask);

        Set<Task> missingTask = getDifference(everyTask, tasks);
        sortAndPrint("Missing Task", missingTask);

        Set<Task> unassignedTask = getDifference(tasks, assignedTasks);
        sortAndPrint("Unassigned Task", unassignedTask, sortByPriority);

        Set<Task> overLap = getUnion(List.of(
                getIntersect(annsTasks, bobsTasks),
                getIntersect(carolsTasks, bobsTasks),
                getIntersect(annsTasks, carolsTasks)));
        sortAndPrint("Assigned to Multiple", overLap);

        List<Task> overlapping = new ArrayList<>();
        for(Set<Task> set : sets){
            Set<Task> dupes = getIntersect(set, overLap);
            overlapping.addAll(dupes);
        }
        Comparator<Task> priorityNatural = sortByPriority.thenComparing(
                Comparator.naturalOrder());
        sortAndPrint("OverLapping", overlapping,priorityNatural);
    }

    private static void sortAndPrint(String header, Collection<Task> collection) {
        sortAndPrint(header, collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter) {

        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }

    private static Set<Task> getUnion(List<Set<Task>> sets) {

        Set<Task> union = new HashSet<>();
        for (var taskSet : sets) {
            union.addAll(taskSet);
        }
        return union;
    }

    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b) {

        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> a, Set<Task> b) {

        Set<Task> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }
}
