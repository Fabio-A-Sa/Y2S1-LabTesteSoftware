class OOP {

    public static void run() {
        System.out.println("Run");
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