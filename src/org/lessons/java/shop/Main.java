package org.lessons.java.shop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Prompt scanner = new Prompt();
        ArrayList<Product> myProducts = new ArrayList<>();
        String addMoreProducts;

        System.out.println("Add products to your list.");

        do {
            Product myProduct = new Product();

            myProduct.setName(scanner.ask("Choose a name: "));
            myProduct.setDescription(scanner.ask("Write a description: "));
            myProduct.setPrice(scanner.askDouble("Choose price: "));
            myProduct.setVat(scanner.askDouble("Choose VAT: "));

            String addMoreCategories;
            ArrayList<Category> myProductCategories = new ArrayList<>();
            do {
                Category myCategory = new Category();

                myCategory.setName(scanner.ask("Choose a category: "));
                myCategory.setDescription(scanner.ask("Write a description of the category: "));

                myProductCategories.add(myCategory);

                addMoreCategories = scanner.ask("Do you want to add more categories to your list? (Y|N)");
            } while (addMoreCategories.equalsIgnoreCase("y"));

            myProduct.setCategories(myProductCategories);

            System.out.println(myProduct.getProductName() + " has been added to your list.");

            myProducts.add(myProduct);

            addMoreProducts = scanner.ask("Do you want to add more products to your list? (Y|N)");
        } while (addMoreProducts.equalsIgnoreCase("y"));

        System.out.println("Your products: ");
        System.out.println(myProducts);
    }
}