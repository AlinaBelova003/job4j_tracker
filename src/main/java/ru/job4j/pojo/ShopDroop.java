package ru.job4j.pojo;

public class ShopDroop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            if (products[products.length - 1] == null) {
                products[i] = products[i + 1];
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int index = 0; index < products.length; index++) {
            Product product = products[index];
            System.out.println(product.getName());
        }
        System.out.println();
        products[1] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}
