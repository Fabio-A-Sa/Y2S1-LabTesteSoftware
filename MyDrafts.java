// Created on October, 2021
// @author: Fábio Araújo de Sá

public class Main {

    public static void main (String[] args) {
        //InputOutput.run();
        //DataStructures.run();
        OOP.run();
    }
}

import java.util.Scanner; // To scan user inputs

class InputOutput {

    public static void run() {
        HelloWorld();
        Inputs();
        Calculator();
    }

    public static void HelloWorld() {
        System.out.println("Hello World!");
    }

    public static void Inputs() {

        Scanner input = new Scanner(System.in);
        System.out.print("Your name: ");
        String name = input.nextLine();
        System.out.print("Your age: ");
        int age = 0;

        while (age <= 0 || age > 120) {
            try {
                age = input.nextInt();
                if (age <= 0 || age > 120) {
                    System.out.print("Error. Please try again:\nYour age: ");
                }
            } catch (Exception exception) {
                input.nextLine();
                System.out.print("Error. Please try again:\nYour age: ");
            }
        }

        input.nextLine();
        System.out.println("Your name is " + name + " and you have " + age + " years old!");

    }

    public static void Calculator() {

        boolean exit = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to your simple calculator:");

        while (!exit) {

            System.out.print("'1' - Calculate something\n'0' - Exit\nYour choice: ");
            int option = input.nextInt();
            input.nextLine();

            if (option != 1 && option != 0) {
                System.out.println("Input error. Please try again:");
            } else if (option == 1) {

                System.out.println("Choose a operation:\n1 - Addition\n2 - Subtraction\n3 - Multiplication\n4 - Division\n5 - SquareRoot\nYour choice: ");
                int operation = input.nextInt(), operand1, operand2;
                input.nextLine();

                if (operation != 5) {
                    System.out.print("Operand 1: ");
                    operand1 = input.nextInt();
                    input.nextLine();
                    System.out.print("Operand 2: ");
                    operand2 = input.nextInt();
                } else {
                    System.out.print("Operand: ");
                    operand1 = input.nextInt();
                    operand2 = 0;
                }
                input.nextLine();

                switch (operation) {

                    case 1: {
                        int result = operand1 + operand2;
                        System.out.println(operand1 + " + " + operand2 + " = " + result);
                        break;
                    }
                    case 2: {
                        int result = operand1 - operand2;
                        System.out.println(operand1 + " - " + operand2 + " = " + result);
                        break;
                    }
                    case 3: {
                        long result = operand1 * operand2;
                        System.out.println(operand1 + " * " + operand2 + " = " + result);
                        break;
                    }
                    case 4: {
                        double result = operand1 / operand2;
                        System.out.println(operand1 + " / " + operand2 + " = " + result);
                        break;
                    }
                    case 5: {
                        double result = Math.sqrt(operand1);
                        System.out.println("SquareRoot(" + operand1 + ") = " + result);
                        break;
                    }
                    default: {
                        System.out.println("Input error!");
                    }
                }

            } else {
                exit = !exit;
            }
        }
        System.out.println("Goodbye!");
    }
}

class DataStructures {

    public static void run() {
        Constants();
        Strings();
        Arrays();
    }

    public static void Constants() {

        final double PI = 3.14159;
        final double PHI = 1.612;
        System.out.println("\nPI = " + PI + " and PHI = " + PHI + "\n");
    }

    public static void Strings() {

        String FEUP = "Faculdade de Engenharia da Universidade do Porto";
        String[] words = FEUP.replace(" ", "-").split("-");
        for (String word : words) {
            System.out.println(word.toUpperCase() + " " + word.toLowerCase());
        }
        System.out.println();
    }

    public static void Arrays() {

        System.out.println("Arrays and 2D arrays:");
        String[][] myName = {{"F", "á", "b", "i", "o"},
                {"A", "r", "a", "ú", "j", "o"},
                {"d", "e"},
                {"S", "á"}};

        for (int i = 0; i < myName.length; i++) {
            for (int j = 0; j < myName[i].length; j++) {
                System.out.print(myName[i][j]);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}

class OOP {

    public static void run() {

        createStudents();
        Heritance();
    }

    public static void createStudents() {

        Student a = new Student();
        a.setName("Araújo");
        Student b = new Student("Fabio", 19, 'M', 202007658, 15.0);
        System.out.println();
        a.Presentation();
        String answer = a == b ? " is equal to " : " isn't equal to ";
        System.out.println(a.getName() + answer + b.getName() + '\n');
    }

    public static void Heritance() {

        Bike myBike = new Bike("BMX", 2017);
        String answer = myBike.haveWindows() ? "My bike has windows" : "My bike has not windows";
        System.out.println(answer);

        Car myCar = new Car("Ferrari", 2021);
        myCar.Run();
        myCar.Stop();
        System.out.println("My car has " + myCar.getWheels() + " wheels\n");
    }
}

class Student {

    private String name;
    private char gender;
    public int up, age;
    private double grade;

    Student () {
        this.name = "UNKNOWN";
        this.age = 0;
        this.gender = 'U';
        this.up = 999999999;
        this.grade = 0.0;
    }

    Student (String name, int age, char gender, int up, double grade) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.up = up;
        this.grade = grade;
    }

    public void setName(String name) { this.name = name; }
    public void setUp(int up) { this.up = up; }
    public void setAge(int age) { this.age = age; }
    public void setGender(char gender) { this.gender = gender; }
    public void setGrade(double grade) { this.grade = grade; }

    public String getName() { return name; }
    public int getUp() { return up; }
    public int getAge() { return age; }
    public char getGender() { return gender; }
    public double getGrade() { return grade; }

    public void Presentation() {
        System.out.println(name + " have " + age + " years old, with upCode = " + up + " and grade " + grade + " values!");
    }
}

// Abstract class --> only child classes can be implemented
// Interface --> .h files in C++, it declares some methods that will be implemented later in classes

interface Components {
    public int getWheels();
    public boolean haveWindows();
}

abstract class Vehicle {

    private String name;
    private int year;

    Vehicle () {
        this.name = "UNKNOWN";
        this.year = 0000;
    }

    Vehicle (String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void Run () { System.out.println("The vehicle is moving"); }
    public void Stop () { System.out.println("The vehicle is stopped"); }
}

class Car extends Vehicle implements Components {

    public int wheels = 4 ;

    Car (String name, int year) {
        super(name, year);
    }

    public int getWheels() { return this.wheels; }
    public boolean haveWindows() { return true; }
}

class Bike extends Vehicle {

    public int windows = 0 ;

    Bike (String name, int year) {
        super(name, year);
    }

    public boolean haveWindows() { return windows > 0 ; }
}
import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;

class Files {

    public static void run() {
        UsingFiles();
    }

    public static void UsingFiles () {

        String name = "Lusiadas.txt";
        File file = new File(name);
        if (file.exists()) {
            System.out.println("\n\nFile " + name + " exists");

            // Extracts data and show content
            try {
                FileReader reader = new FileReader(name);
                int data = reader.read();

                System.out.println("\n" + name + ": \n");
                while (data != -1) {
                    System.out.print((char)data);
                    data = reader.read();
                }
                reader.close();
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        } else {
            System.out.println("File not found");
        }
    }
}