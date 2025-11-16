package org.java.builder;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        new MultiExecutor(List.of(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Task 1");
                    }
                },
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Task 2");
                    }
                },
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Task 3");
                    }
                }
        ));


    }
}