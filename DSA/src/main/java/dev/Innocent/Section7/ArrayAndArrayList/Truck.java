package dev.Innocent.Section7.ArrayAndArrayList;

public class Truck implements Trackable{
    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + " 's coordinates recorded");
    }
}
