package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.ArrayList;

public class Store {
    private static ArrayList<ProductForSale> productForSales = new ArrayList<>();
    public static void main(String[] args) {
        productForSales.add(new ArtObject("kilishi", 249, "wewe"));
        productForSales.add(new ArtObject("Suya", 3434, "Iban"));

        listProduct();
    }

    public static void listProduct(){
        for(var product : productForSales){
            System.out.println("-".repeat(30));
            product.showDetails();
        }
    }
}
