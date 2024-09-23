package com.staticblock.example;

public class StaticBlockExample {
    static {
        System.out.println("This is static block executed only once irrespective of number of objects created when the class loader loads the class into JVM memory");
    }
    static {
        System.out.println("This is static block 2 which is executed after above one..");
    }
    static {
        System.out.println("This is static block 3 which is executed after 2nd static block execution ended.");
    }

    void sum(int ...arr) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        System.out.println("sum of values is: " + sum);
    }

    public static void main(String[] args) {
        System.out.println("main started...");

        StaticBlockExample sbe1 = new StaticBlockExample();
        StaticBlockExample sbe2 = new StaticBlockExample();
        StaticBlockExample sbe3 = new StaticBlockExample();

        sbe1.sum(10,20,30);
        sbe2.sum(10,20,30,40);
        sbe3.sum(10,20,30,40,50);

        System.out.println("main ended...");
    }
}
