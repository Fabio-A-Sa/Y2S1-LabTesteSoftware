package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Configuration;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadLevelBuild {

    private static final ArrayList<String> map = new ArrayList<>();

    public LoadLevelBuild(int lvl) throws FileNotFoundException {

        map.clear();
        Configuration confs = Configuration.getInstance();

        String level = lvl < 10 ? "0" + lvl : String.valueOf(lvl);
        File file = new File("src/main/resources/Levels/Level" + level + ".txt");
        Scanner reader = new Scanner(file);
        int i = 0;
        String line = "";
        while(reader.hasNextLine()){
            line = reader.nextLine();
            map.add(line);
            i++;
        }

        confs.setMapBounds(line.length(), i);
        reader.close();
    }

    public ArrayList<String> getLevelMap(){
        return map;
    }
}
