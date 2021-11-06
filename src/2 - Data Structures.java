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

        System.out.println("\nArrayList:");
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Cão");
        animals.add("Gato");
        animals.add("Peixe");
        for (String animal : animals) {
            System.out.println(animal);
        }

        System.out.println("\nClasses:");
        Student me = new Student("Fabio", 19, 'M', 202007658, 10);
        me.Presentation();
        me.setAge(10);
        me.setGrade(15.6);
        me.setName("Fabio Sá");
        me.Presentation();
        System.out.println("Gender = " + me.getGender());

    }
}
