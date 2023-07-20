package org.lessons.java.shop;

import java.util.Scanner;

public class Prompt {
    private final Scanner scanner;

    Prompt() {
        this.scanner = new Scanner(System.in);
    }

    public String ask(String prompt) {
        System.out.print(prompt);
        return this.scanner.nextLine();
    }

    public int askInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(this.scanner.nextLine());
    }

    public double askDouble(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(this.scanner.nextLine());
    }
}
