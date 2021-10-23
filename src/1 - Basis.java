
import java.util.Scanner;       // To scan user inputs
import java.util.ArrayList;     // To use ArrayList data structure

class Basis {

    public static void run () {
        //HelloWorld();
        //Inputs();
        //Calculator();
        SomeDataStructures();
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
        Student me = new Student();

    }
}

class Student {

    String name;
    char gender;
    int up, age;
    double grade;

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
    public String getName(String name) { return name; }
    public int getUp(int up) { return up; }
    public int getAge(int age) { return age; }
    public char getGender(char gender) { return gender; }
    public double getGrade(double grade) { return grade; }

    // other methods

    public void Presentation() {

    }
}