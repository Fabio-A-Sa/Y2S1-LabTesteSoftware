package com.g801.supaplex.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Colors {

    private static Colors colors;
    private static HashMap<Character, String> allColors;

    public Colors() {
        readColors();
    }

    private static void readColors() {

        allColors = new HashMap<>();

        try {
            File file = new File("src/main/resources/Colors.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                allColors.put(line.charAt(0), line.substring(2, 9));
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public HashMap<Character, String> getColors() {
        return allColors;
    }

    public String getColorString(Character ch) {
        return allColors.containsKey(ch) ? allColors.get(ch) : null;
    }

    public static Colors getInstance() {
        if (colors == null)
            colors = new Colors();
        return colors;
    }
}