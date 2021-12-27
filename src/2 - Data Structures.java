// Created on October, 2021
// @author: Fábio Araújo de Sá

import java.util.*;

class DataStructures {

    /**
     * Nota:
     * os tipos primitivos são guardados como valor na memória
     * os objectos são guardados como referência na memória
     */

    public static void run() {

        // Usual
        Constants();
        Strings();
        Arrays();

        // Using Collections package
        Lists();
        Sets();
        Maps();
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

    public static void Lists() {

        List<String> names = new ArrayList<>();
        String sentence = "Faculdade de Engenharia da Universidade do Porto";
        for (String word : sentence.split(" ")) {
            names.add(word);
        }

        names.remove("Engenharia");
        names.remove(names.size()-1);

        for (String word : names) {
            System.out.print(word + " ");
        }

        names.clear();
    }

    public static void Sets() {

        Set<Point> numbers = new HashSet<Point>();
        numbers.add(new Point(1, 2));
        numbers.add(new Point(1, 2));
        numbers.add(new Point(1, 2));
        numbers.add(new Point(1, 2));
        numbers.add(new Point(1, 2));
        numbers.add(new Point(1, 2));

        /**
         * Prints 6 if hashCode() and equals() aren't implemented in class Point
         */
        System.out.println(numbers.size());

        System.out.println(numbers.contains(new Point(1, 2))); // true
        System.out.println(numbers.contains(new Point(2, 2))); // false
    }

    public static void Maps() {

        Map<String, Point> locations = new HashMap<String, Point>();

        locations.put("A", new Point(1, 2));
        locations.put("B", new Point(4, -5));
        locations.put("C", new Point(0, 21));

        locations.get("C");                                     // returns Point (0, 21)
        locations.get("F");                                     // returns null
        locations.remove("A");
        System.out.println(locations.containsKey("D"));         // false
        System.out.println(locations.containsKey("B"));         // true
        System.out.println(locations.size());                   // 2
    }
}

class Point {

    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Point S = (Point) o;
        return  this.getX() == S.getX() && this.getY() == S.getY() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}