import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Files {

    public static void run() {
        UsingFiles();
    }

    public static void UsingFiles () {

        String name = "Lusiadas.txt";
        File file = new File(name);
        if (file.exists()) {
            System.out.println("\n\nFile " + name + " exists");

            // Extracts data and show content
            try {
                FileReader reader = new FileReader(name);
                int data = reader.read();

                System.out.println("\n" + name + ": \n");
                while (data != -1) {
                    System.out.print((char)data);
                    data = reader.read();
                }
                reader.close();
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        } else {
            System.out.println("File not found");
        }
    }
}
