// Created on November, 2021
// @author: Fábio Araújo de Sá

class playWithExceptions {

    public static void run() {

        try {
            System.out.println(simpleDivision(9, 3));
            System.out.println(simpleDivision(5, 3));
            System.out.println(simpleDivision(9, 9));
            System.out.println(simpleDivision(9, -1));
            System.out.println(simpleDivision(133, 0));
            System.out.println(simpleDivision(133, 231));

        } catch (MyException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Stop");
        }
    }

    public static int simpleDivision(int x, int y) throws MyException {

        if (y != 0) {
            int result = x / y;
            return result;
        } else {
            throw new MyException("My Exception Error");
        }
    }
}

class MyException extends Exception {

    public MyException() {
        super();
    }

    public MyException(String message) {
        super();
        System.out.println(message);
    }
}