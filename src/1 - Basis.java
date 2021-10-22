import java.util.Scanner; // To scan user inputs

class Basis {

    public static void run () {
        HelloWorld();
        Inputs();
    }

    public static void HelloWorld () {
        System.out.println("Hello World!");
    }

    public static void Inputs () {

        Scanner input = new Scanner(System.in);
        System.out.print("Your name: ");
        String name = input.nextLine();
        System.out.print("Your age: ");
        int age = input.nextInt();
        System.out.println("Your name is " + name + " and you have " + age + " years!");

    }


}