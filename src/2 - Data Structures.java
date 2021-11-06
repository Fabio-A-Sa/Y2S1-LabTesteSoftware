class DataStructures {

    public static void run() {
        Constants();
        Strings();
        Arrays();
    }

    public static void Constants() {

        final double PI = 3.14159;
        final double PHI = 1.612;
        System.out.println("PI = " + PI + " and PHI = " + PHI);
    }

    public static void Strings() {

        String Feup = "Faculdade de Engenharia da Universidade do Porto";
        
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
    }
}
