// Created on October, 2021
// @author: Fábio Araújo de Sá

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