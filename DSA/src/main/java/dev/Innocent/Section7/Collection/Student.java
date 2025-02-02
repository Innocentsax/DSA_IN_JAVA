package dev.Innocent.Section7.Collection;

import java.time.LocalDate;
import java.util.*;

record Course(String courseId, String name, String subject){}

record Purchase(String courseId, int studentId, double price, int yr, int dayOfYear){
    public LocalDate purchaseDate(){
        return LocalDate.ofYearDay(yr, dayOfYear);
    }
}

public class Student {
    private static int lastId = 1;
    private String name;
    private int id;
    private List<Course> courseList;

    public Student(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
        id = lastId++;
    }

    public Student(String name, Course course) {
        this(name, new ArrayList<>(List.of(course)));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course){
        courseList.add(course);
    }

    @Override
    public String toString() {
        String[] courseNames = new String[courseList.size()];
        Arrays.setAll(courseNames, i -> courseList.get(i).name());
        return "[%d] : %s".formatted(id, String.join(", ", courseNames));
    }

    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String, Student> students = new TreeMap<>();

    public static void main(String[] args) {
        Course jmc = new Course("jmc101", "Java Master Class", "Java");
        Course python = new Course("Pyt101", "Python Master Class", "Python");

        addPurchase("Mary Martin", jmc, 129.90);
        addPurchase("Andy Martin", jmc, 139.99);
        addPurchase("Mary Martin", python, 149.99);
        addPurchase("Joe Jones", jmc, 149.99);
        addPurchase("Bill Brown", python, 119.99);

        addPurchase("Chuck Cheese", python, 119.99);
        addPurchase("Davey Jones", jmc, 139.99);
        addPurchase("Eva East", python, 139.99);
        addPurchase("Fred Forker", jmc, 139.99);
        addPurchase("Greg Brady", python, 129.99);


        purchases.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("-------------------------------------");
        students.forEach((key, value) -> System.out.println(key + ": " + value));


        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();

        for(Purchase p : purchases.values()){
            datedPurchases.compute(p.purchaseDate(), (pdate, plist) -> {
                List<Purchase> list = (plist == null) ? new ArrayList<>() : plist;
                list.add(p);
                return list;
            });
        }
        datedPurchases.forEach((key, value) -> System.out.println(key + ": " + value));

        int currentYear = LocalDate.now().getYear();
        LocalDate firstDay = LocalDate.ofYearDay(currentYear, 1);
        LocalDate week1 = firstDay.plusDays(7);
        Map<LocalDate, List<Purchase>> week1Purchases = datedPurchases.headMap(week1);
        Map<LocalDate, List<Purchase>> week2Purchases = datedPurchases.tailMap(week1);

        System.out.println("-----------------------------------------------");
        week1Purchases.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("-----------------------------------------------");
        week2Purchases.forEach((key, value) -> System.out.println(key + ": " + value));

        displayStats(1, week1Purchases);
        displayStats(2, week2Purchases);

        System.out.println("----------------------------------------------");
        LocalDate localDate = datedPurchases.lastKey();
        var previousEntry = datedPurchases.lastEntry();

        while (previousEntry != null){
            List<Purchase> lastDaysData = previousEntry.getValue();
            System.out.println(localDate + " purchases : " + lastDaysData.size());

            LocalDate prevDate = datedPurchases.floorKey(localDate);
            previousEntry = datedPurchases.floorEntry(localDate);
            localDate = prevDate;
        }

        System.out.println("--------------------------------------------");
        var reversed = datedPurchases.descendingMap();

        LocalDate firstDate = reversed.firstKey();
        var nextEntry = reversed.firstEntry();

        while(nextEntry != null){
            List<Purchase> lastDaysData = nextEntry.getValue();
            System.out.println(firstDate + " purchases : " + lastDaysData.size());

            LocalDate nextDate = reversed.higherKey(firstDate);
            nextEntry = reversed.higherEntry(firstDate);
            firstDate = nextDate;
        }

        System.out.println("----------------------------------------");
        datedPurchases.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void addPurchase(String name, Course course, double price){
        Student existingStudent = students.get(name);
        if(existingStudent == null){
            existingStudent = new Student(name, course);
            students.put(name, existingStudent);
        }else {
            existingStudent.addCourse(course);
        }

        int day = new Random().nextInt(1, 15);
        String key = course.courseId() + "_" + existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(), existingStudent.getId(),
                price, year, day);
        purchases.put(key, purchase);
    }

    private static void displayStats(int period, Map<LocalDate, List<Purchase>> periodData){
        System.out.println("--------------------------------------------");
        Map<String, Integer> weeklyCounts = new TreeMap<>();
        periodData.forEach((key, value) -> {
            System.out.println(key + ": " + value);
            for(Purchase p : value){
                weeklyCounts.merge(p.courseId(), 1, (prev, current) -> {
                    return prev + current;
                });
            }
        });
        System.out.printf("Week %d Purchases = %s%n", period, weeklyCounts);
    }
}
