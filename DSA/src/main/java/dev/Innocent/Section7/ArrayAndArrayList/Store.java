package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.ArrayList;

record OrderItem(int qty, ProductForSale product){}

public class Store {
    private static ArrayList<ProductForSale> productForSales = new ArrayList<>();
    public static void main(String[] args) {
        productForSales.add(new ArtObject("kilishi", 249, "wewe"));
        productForSales.add(new ArtObject("Suya", 3434, "Iban"));

        listProduct();

        System.out.println("\nOrder");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);
    }

    public static void listProduct(){
        for(var product : productForSales){
            System.out.println("-".repeat(30));
            product.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty){
        order.add(new OrderItem(qty, productForSales.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order){
        double saleTotal = 0;
        for(var item : order){
            item.product().printPricedItem(item.qty());
            saleTotal += item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales Total = $%6.2f %n", saleTotal);
    }
}
