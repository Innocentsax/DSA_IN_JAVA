package dev.Innocent.Section7.Collection;

import java.time.LocalDate;

record Course(String courseId, String name, String subject){}

record Purchase(String courseId, int studentId, double price, int yr, int dayOfYear){
    public LocalDate purchaseDate(){
        return LocalDate.ofYearDay(yr, dayOfYear);
    }
}

public class Student {
}
