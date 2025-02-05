package dev.Innocent.Section7.Collection.StoreInventorySystem;

import java.util.*;

public class Store {
    private static Random random = new Random();
    private Map<String, InventoryItem> inventory;
    private NavigableSet<Cart> carts = new TreeSet<>(Comparator.comparing(Cart::getId));
    private Map<Category, Map<String, InventoryItem>> aisleInventory;

    public static void main(String[] args) {

    }

    private void manageStoreCarts(){

    }

    private boolean checkOutCart(Cart cart){
        return false;
    }

    private void abandonCarts(){

    }

    private void listProductsByCategory(){

    }

    private void stockStore(){

    }

    private void stockAisles(){

    }
}
