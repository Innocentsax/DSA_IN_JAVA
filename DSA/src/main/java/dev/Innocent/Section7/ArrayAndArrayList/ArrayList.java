package dev.Innocent.Section7.ArrayAndArrayList;

record GroceryItem(String name, String type, int count){

    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString(){
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}

public class ArrayList {
    public static void main(String[] args) {

    }
}
