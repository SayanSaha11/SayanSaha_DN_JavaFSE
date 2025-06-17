package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Map<Integer,Double> memoizedData = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the principal amount : ");
        Double amount = scanner.nextDouble();

        System.out.println("Enter the growth rate (in %) : ");
        Double growthRatePercentage = scanner.nextDouble();
        Double growthRate = growthRatePercentage / 100;

        System.out.println("Enter the number of years to forecast : ");
        Integer years = scanner.nextInt();

        Long startRecursive = System.nanoTime();
        Double futureValueRecursive = forecastRecursive(amount,growthRate,years);
        Long endRecursive = System.nanoTime();

        System.out.println("Recursive forecast result :");
        System.out.println("Forecast after "+years+" years is "+futureValueRecursive);
        System.out.println("Time taken for recursive forecast is " + (endRecursive-startRecursive) + " ns");

        Long startMemoization = System.nanoTime();
        Double futureValueMemoization = forecastMemoization(amount,growthRate,years);
        Long endMemoization = System.nanoTime();

        System.out.println("\nMemoization forecast result :");
        System.out.println("Forecast after "+years+" years is "+futureValueMemoization);
        System.out.println("Time taken for Memoization forecast is " + (endMemoization-startMemoization) + " ns");

        String os = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String arch = System.getProperty("os.arch");
        String user = System.getProperty("user.name");
        String javaVersion = System.getProperty("java.version");

        String systemId = os + "-" + osVersion + "-" + arch + "-" + user + "-" + javaVersion;
        System.out.println("\nPseudo-Unique System ID: " + systemId);

        scanner.close();

    }

    public static double forecastRecursive(double amount, double rate, int years){
        if(years==0) return amount;
        return forecastRecursive(amount,rate,years-1)*(1+rate);
    }

    public static double forecastMemoization(double amount, double rate, int years){
        if(years==0) return amount;
        if(memoizedData.containsKey(years)) return memoizedData.get(years);
        double result = forecastMemoization(amount,rate,years-1)*(1+rate);
        memoizedData.put(years,result);
        return result;
    }
}