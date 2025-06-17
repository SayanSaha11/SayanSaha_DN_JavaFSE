package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Instance 1 is created.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Instance 2 is created.");

        if(logger1 == logger2){
            System.out.println("Both the logger instances are same.\nHence singleton confirmed.");
        }
        else{
            System.out.println("Different instances have in created.\nHence Singleton is broken.");
        }

    }
}