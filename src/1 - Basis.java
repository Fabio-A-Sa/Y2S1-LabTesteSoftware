
import java.util.Scanner;                   // To scan user inputs
import java.util.ArrayList;                 // To use ArrayList data structure
import java.io.File;                        // To use files
import java.io.FileReader;                  // To read a file content
import java.io.FileNotFoundException;       // To raise an exception
import java.io.IOException;                 // To raise an exception too

class Basis {

    public static void run () {
        //HelloWorld();
        //Inputs();
        //Calculator();
        //SomeDataStructures();\
        //Inheritance();
        UsingFiles();
    }

    public static void HelloWorld () {
        System.out.println("Hello World!");
    }

    public static void Inputs () {

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
                    System.out.print("Operand 1: "); operand1 = input.nextInt(); input.nextLine();
                    System.out.print("Operand 2: "); operand2 = input.nextInt();
                } else {
                    System.out.print("Operand: "); operand1 = input.nextInt(); operand2 = 0;
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
        System.out.println("Good bye!");
    }

    public static void SomeDataStructures() {

        final double PI = 3.14159;
        System.out.println("Contants: " + PI);

        System.out.println("Arrays and 2D arrays:");
        String[][] myName = {   {"F", "á", "b", "i", "o"},
                                {"A", "r", "a", "ú", "j", "o"},
                                {"d", "e"},
                                {"S", "á"}                          };
        for (int i = 0 ; i < myName.length ; i++ ) {
            for (int j = 0 ; j < myName[i].length ; j++ ) {
                System.out.print(myName[i][j]);
            }
            System.out.print(" ");
        }

        System.out.println("\nArrayList:");
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Cão");
        animals.add("Gato");
        animals.add("Peixe");
        for (String animal : animals) { System.out.println(animal) ; }

        System.out.println("\nClasses:");
        Student me = new Student("Fabio", 19, 'M', 202007658, 10);
        me.Presentation();
        me.setAge(10); me.setGrade(15.6); me.setName("Fabio Sá");
        me.Presentation();
        System.out.println("Gender = " + me.getGender());

    }

    public static void Inheritance () {

        Car myCar = new Car("my", 2018);
        System.out.print(myCar.getWheels());

    }

    public static void UsingFiles () {

        String name = "Lusiadas.txt";
        File file = new File(name);
        if (file.exists()) {
            System.out.println("File " + name + " exists");

            // Extracts data and show content
            try {
                FileReader reader = new FileReader(name);
                int data = reader.read();
                while (data != -1) {
                    System.out.println((char)data);
                    data = reader.read();
                }
                reader.close();
            } catch


        } else {
            System.out.println("File not found");
        }
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

    // all set methods
    public void setName(String name) { this.name = name; }
    public void setUp(int up) { this.up = up; }
    public void setAge(int age) { this.age = age; }
    public void setGender(char gender) { this.gender = gender; }
    public void setGrade(double grade) { this.grade = grade; }

    // all get methods
    public String getName() { return name; }
    public int getUp() { return up; }
    public int getAge() { return age; }
    public char getGender() { return gender; }
    public double getGrade() { return grade; }

    // other methods
    public void Presentation() {
        System.out.println(name + " have " + age + " years old, with upCode = " + up + " and grade " + grade + " values!");
    }
}

class Vehicle {

    public String name;
    public int year;

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

class Car extends Vehicle {

    public int wheels = 4 ;
    Car(String name, int year) {
        super(name, year);          // to use a parent class
    }
    public int getWheels() { return this.wheels; }
}

class Bike extends Vehicle {

    public int windows = 0 ;
    public boolean haveWindows() { return windows > 0 ; }
}