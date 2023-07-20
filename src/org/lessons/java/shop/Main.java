package org.lessons.java.shop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Prompt scanner = new Prompt();
        ArrayList<Product> myProducts = new ArrayList<>();
        ArrayList<Category> myCategories = new ArrayList<>();

        String addMoreProducts;
        System.out.println("Add products to your list.");
        do {
            Product myProduct = new Product();


            myProduct.setName(scanner.ask("Choose a name: "));
            myProduct.setDescription(scanner.ask("Write a description: "));
            myProduct.setPrice(scanner.askDouble("Choose price: "));
            myProduct.setVat(scanner.askDouble("Choose VAT: "));


            String addMoreCategories;
            do {
                Category myCategory = null;

                String name = scanner.ask("Choose a category: ");

                boolean categoryIsAlreadyPresent = false;

                //Check if product alreay has this category.
                for (Category category : myProduct.getCategories()) {
                    if (category.name.equalsIgnoreCase(name)) {
                        categoryIsAlreadyPresent = true;
                        break;
                    }
                }

                if (categoryIsAlreadyPresent) {
                    System.out.println(name + " is already present in this product categories.");
                    addMoreCategories = "Y";
                    continue;
                }

                // Check if category is never seen before.
                for (Category category : myCategories) {
                    if (category.name.equalsIgnoreCase(name)) {
                        myCategory = category;
                        break;
                    }
                }

                if (myCategory == null) {
                    myCategory = new Category(name);
                    myCategory.setDescription(scanner.ask("Write a description of the category: "));
                    myCategories.add(myCategory);
                }

                myProduct.addCategory(myCategory);

                addMoreCategories = scanner.ask("Do you want to add more categories to your list? (Y|N)");
            } while (addMoreCategories.equalsIgnoreCase("y"));

            System.out.println(myProduct.getProductName() + " has been added to your list.");
            System.out.println();
            System.out.println("***********************************");
            System.out.println("Name: " + myProduct.getName());
            System.out.println("Description: " + myProduct.getDescription());
            System.out.println("Code: " + myProduct.getCode());
            System.out.println("ProductName (Code-Name): " + myProduct.getProductName());
            System.out.println("Categories: " + myProduct.getCategories());
            System.out.println("Price: " + myProduct.getPrice() + "€");
            System.out.println("Vat: " + myProduct.getVat() + "%");
            System.out.println("***********************************");


            myProducts.add(myProduct);

            addMoreProducts = scanner.ask("Do you want to add more products to your list? (Y|N)");
        } while (addMoreProducts.equalsIgnoreCase("y"));

        System.out.println("Your products: ");
        System.out.println(myProducts);
    }
}