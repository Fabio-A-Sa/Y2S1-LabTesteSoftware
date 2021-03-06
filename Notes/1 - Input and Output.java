// Created on October, 2021
// @author: Fábio Araújo de Sá

/**
 * Nesta secção:
 * - Diferença entre JVM, JDK e JRE
 * - Exemplos de input e validação de input
 * - Exemplos de flows, if, else, do, while, for, switch
 */

/**
 * JVM - Java Virtual Machine, compreende linguagem bytecode (.class) gerada através de ficheiros .java
 * JDK - Java Development Kit, para compilação e execução de scripts, em cada sistema operativo
 * JRE - Java Runtime Environment, só para executar o script
 */

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