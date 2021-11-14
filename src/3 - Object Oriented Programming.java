// Created on November, 2021
// @author: Fábio Araújo de Sá

import java.util.Objects;

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

    @Override
    /**
     * Override da função equals da STL. Compara dois objectos.
     * Nota: convém reescrever esta função sempre que se cria uma nova classe (aula 11/11/2021, gravação em @00:06:31)
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Student S = (Student) o;
        return  this.gender == S.getGender() &&
                this.up == S.getUp() &&
                this.age == S.getAge() &&
                this.name == S.getName() &&
                this.grade == S.getGrade() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, up, age, grade);
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