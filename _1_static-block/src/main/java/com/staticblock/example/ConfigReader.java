package com.staticblock.example;

public class ConfigReader {
    // static variable to hold configuration data
    public static String configValue;

    // static block to initialize static variable
    static {
        // code to simulate reading the configuration file
        System.out.println("Static block executed. Reading configuration file!");
        configValue = "Database connection string loaded";
    }

    // Constructor
    public ConfigReader() {
        System.out.println("ConfigReader object created");
    }

    // Main method to demonstrate the execution of the program
    public static void main(String[] args) {
        System.out.println("Main method started");

        // Accessing the static variable without creating the object
        System.out.println("Config value: "+ConfigReader.configValue);

        // creating the object of the class
        ConfigReader obj = new ConfigReader();

        System.out.println("Main method ended...");
    }
}
