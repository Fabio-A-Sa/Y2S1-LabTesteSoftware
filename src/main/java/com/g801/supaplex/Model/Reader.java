package com.g801.supaplex.Model;

import com.g801.supaplex.Model.Models.Sprite;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    public static void fillSprite (String type, Sprite sprite) {

        try {
            File file = new File("src/main/resources/Blocks/" + type + ".txt");
            Scanner reader = new Scanner(file);
            int i = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                for (int j = 0 ; j < line.length() ; j++) {
                    sprite.getBitmap()[i][j] = line.charAt(j);
                }
                i++;
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}