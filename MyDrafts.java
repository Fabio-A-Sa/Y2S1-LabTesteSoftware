// Created on October, 2021
// @author: Fábio Araújo de Sá

public class Main {

    public static void main (String[] args) {
        //InputOutput.run();
        //DataStructures.run();
        OOP.run();
    }
}

import java.util.Scanner; // To scan user inputs

class InputOutput {

    public static void run() {
        HelloWorld();
        Inputs();
        Calculator();
    }

    public static void HelloWorld() {
        System.out.println("Hello World!");
    }

    public static void Inputs() {

        Scanner input = new Scanner(System.in);
        System.out.print("Your name: ");
        String name = input.nextLine();
        System.out.print("Your age: ");
        int age = 0;

        while (age <= 0 || age > 120) {
            try {
                age = input.nextInt();
                if (age <= 0 || age > 120) {
                    System.out.print("Error. Please try again:\nYour age: ");
                }
            } catch (Exception exception) {
                input.nextLine();
                System.out.print("Error. Please try again:\nYour age: ");
            }
        }

        input.nextLine();
        System.out.println("Your name is " + name + " and you have " + age + " years old!");

    }

    public static void Calculator() {

        boolean exit = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to your simple calculator:");

        while (!exit) {

            System.out.print("'1' - Calculate something\n'0' - Exit\nYour choice: ");
            int option = input.nextInt();
            input.nextLine();

            if (option != 1 && option != 0) {
                System.out.println("Input error. Please try again:");
            } else if (option == 1) {

                System.out.println("Choose a operation:\n1 - Addition\n2 - Subtraction\n3 - Multiplication\n4 - Division\n5 - SquareRoot\nYour choice: ");
                int operation = input.nextInt(), operand1, operand2;
                input.nextLine();

                if (operation != 5) {
                    System.out.print("Operand 1: ");
                    operand1 = input.nextInt();
                    input.nextLine();
                    System.out.print("Operand 2: ");
                    operand2 = input.nextInt();
                } else {
                    System.out.print("Operand: ");
                    operand1 = input.nextInt();
                    operand2 = 0;
                }
                input.nextLine();

                switch (operation) {

                    case 1: {
                        int result = operand1 + operand2;
                        System.out.println(operand1 + " + " + operand2 + " = " + result);
                        break;
                    }
                    case 2: {
                        int result = operand1 - operand2;
                        System.out.println(operand1 + " - " + operand2 + " = " + result);
                        break;
                    }
                    case 3: {
                        long result = operand1 * operand2;
                        System.out.println(operand1 + " * " + operand2 + " = " + result);
                        break;
                    }
                    case 4: {
                        double result = operand1 / operand2;
                        System.out.println(operand1 + " / " + operand2 + " = " + result);
                        break;
                    }
                    case 5: {
                        double result = Math.sqrt(operand1);
                        System.out.println("SquareRoot(" + operand1 + ") = " + result);
                        break;
                    }
                    default: {
                        System.out.println("Input error!");
                    }
                }

            } else {
                exit = !exit;
            }
        }
        System.out.println("Goodbye!");
    }
}

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

class OOP {

    public static void run() {

        createStudents();
        Heritance();
    }

    public static void createStudents() {

        Student a = new Student();
        a.setName("Araújo");
        Student b = new Student("Fabio", 19, 'M', 202007658, 15.0);
        System.out.println();
        a.Presentation();
        String answer = a == b ? " is equal to " : " isn't equal to ";
        System.out.println(a.getName() + answer + b.getName() + '\n');
    }

    public static void Heritance() {

        Bike myBike = new Bike("BMX", 2017);
        String answer = myBike.haveWindows() ? "My bike has windows" : "My bike has not windows";
        System.out.println(answer);

        Car myCar = new Car("Ferrari", 2021);
        myCar.Run();
        myCar.Stop();
        System.out.println("My car has " + myCar.getWheels() + " wheels\n");
    }
}

class Student {

    private String name;
    private char gender;
    public int up, age;
    private double grade;

    Student () {
        this.name = "UNKNOWN";
        this.age = 0;
        this.gender = 'U';
        this.up = 999999999;
        this.grade = 0.0;
    }

    Student (String name, int age, char gender, int up, double grade) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.up = up;
        this.grade = grade;
    }

    public void setName(String name) { this.name = name; }
    public void setUp(int up) { this.up = up; }
    public void setAge(int age) { this.age = age; }
    public void setGender(char gender) { this.gender = gender; }
    public void setGrade(double grade) { this.grade = grade; }

    public String getName() { return name; }
    public int getUp() { return up; }
    public int getAge() { return age; }
    public char getGender() { return gender; }
    public double getGrade() { return grade; }

    public void Presentation() {
        System.out.println(name + " have " + age + " years old, with upCode = " + up + " and grade " + grade + " values!");
    }
}

// Abstract class --> only child classes can be implemented
// Interface --> .h files in C++, it declares some methods that will be implemented later in classes

interface Components {
    public int getWheels();
    public boolean haveWindows();
}

abstract class Vehicle {

    private String name;
    private int year;

    Vehicle () {
        this.name = "UNKNOWN";
        this.year = 0000;
    }

    Vehicle (String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void Run () { System.out.println("The vehicle is moving"); }
    public void Stop () { System.out.println("The vehicle is stopped"); }
}

class Car extends Vehicle implements Components {

    public int wheels = 4 ;

    Car (String name, int year) {
        super(name, year);
    }

    public int getWheels() { return this.wheels; }
    public boolean haveWindows() { return true; }
}

class Bike extends Vehicle {

    public int windows = 0 ;

    Bike (String name, int year) {
        super(name, year);
    }

    public boolean haveWindows() { return windows > 0 ; }
}
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

class Exceptions {

    public static void run() {
        System.out.println("Run");
    }
}

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

class usingThreads {

    public static void run() {

        Model m = new Model();
        View v = new View();

        new Thread() {
            public void run () {
                while (m.a < 1000) {
                    m.increment();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (m.a < 1000) {
                    v.draw(m);
                }
            }
        }.start();
    }
}

class Model {
    int a = 0, b = 0;
    public void increment() {
        a++;
        b++;
    }
}

class View {
    public void draw (Model m) {
        System.out.println(m.a + " " + m.b);
    }
}

abstract class Fruta {

    String nome;
    int tamanho;
    public Fruta (String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }
}

class Banana extends Fruta {

    String qualidade;
    public Banana (String nome, int tamanho, String qualidade) {
        super(nome, tamanho);
        this.qualidade = qualidade;
    }
}

public class DivisibleByFilter implements GenericListFilter {

    @Override
    public boolean accept(Integer number) {
        return number != 0 ;
    }
}

public interface GenericListDeduplicator {
    public List<Integer> deduplicate(List<Integer> list, GenericListSorter genericListSorter);
}

public interface GenericListFilter {

    public boolean accept(Integer number);
}

public interface GenericListSorter {

    public List<Integer> sort(List<Integer> list);
}

/**
 * A utility class that aggregates list of numbers
 * into a single integer using various functions.
 */
public class ListAggregator {

    /**
     * Sums all numbers in a list.
     * @return The sum of all the values in the list.
     */
    public Integer sum(List<Integer> list) {
        int sum = 0;
        for (Integer number : list) sum += number;
        return sum;
    }

    /**
     * Calculates the maximum value in a list.
     * @return The maximum value in the list.
     */
    public Integer max(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer number : list) if (number > max) max = number;
        return max;
    }

    /**
     * Calculates the minimum value in a list.
     * @return The minimum value in the list.
     */
    public Integer min(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (Integer number : list) if (number < min) min = number;
        return min;
    }

    /**
     * Counts the number of distinct numbers in a list.
     * @return The number of distinct numbers.
     */
    public int distinct(List<Integer> list, GenericListDeduplicator genericListDeduplicator) {
        ListSorter listSorter = new ListSorter();
        List<Integer> distinct = genericListDeduplicator.deduplicate(list, listSorter);
        return distinct.size();
    }
}

/**
 * A utility class that removes duplicate numbers from a list.
 */
public class ListDeduplicator implements GenericListDeduplicator {

    /**
     * Removes duplicate numbers from a list.
     * @return A list having the same numbers as the original
     * but without duplicates. The order of the numbers might
     * change.
     */
    @Override
    public List<Integer> deduplicate(List<Integer> list, GenericListSorter genericListSorter) {
        List<Integer> sorted = genericListSorter.sort(list);
        List<Integer> unique = new ArrayList<>();

        Integer last = null;

        for (Integer number : sorted)
            if (!number.equals(last)) {
                last = number;
                unique.add(number);
            }

        return unique;
    }
}

public class ListFilter {

    private GenericListFilter filter;

    public ListFilter(GenericListFilter filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list) {

        List<Integer> result = new ArrayList<>();
        for (Integer number : list) {
            if (filter.accept(number)) {
                result.add(number);
            }
        }
        return result;
    }
}

/**
 * An utility class to sort list of numbers.
 */
public class ListSorter implements GenericListSorter {

    /**
     * Really stupid way to sort a list.
     * @return A sorted version of the list.
     */
    @Override
    public List<Integer> sort(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>();
        for (Integer number : list)
            sorted.add(number);

        for (int i = 0; i < sorted.size() - 1; i++)
            for (int j = i + 1 ; j < sorted.size() ; j++)
                if (sorted.get(i) > sorted.get(j))
                    Collections.swap(sorted, i, j);

        return sorted;
    }
}

public class Notifier {

    String s;

    public Notifier(String s) { this.s = s; }
    void notify(String x) {};
}

public class PositiveFilter implements GenericListFilter {

    @Override
    public boolean accept(Integer number) {
        return number >= 0 ;
    }
}

class FirstSpecification extends Specification {

    def "one plus one should equal to" () {
        expect:
        1 + 1 == 2
    }

    def "two plus two should equal four" () {
        given:
        int left = 2
        int right = 2
        when:
        int result = left + right
        then:
        result == 4
    }

    def "Should be able to remove from list" () {
        given:
        def list = [1, 2, 3, 4]
        when:
        list.remove(0)
        then:
        list == [2, 3, 4]
        // list == [1, 2, 4] --> error
    }

    def "Should get an index out of bounds when removing a nonexistent item" () {
        given:
        def list = [1, 2, 3, 4]
        when:
        list.remove(20)
        then:
        thrown(IndexOutOfBoundsException)
        list.size() == 4
    }

    def "numbers to the power of two" (int a, int b, int c) {
        expect:
        Math.pow(a, b) == c
        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
    }

    def "Bug 8726 in Deduplicator" () {
        given:
        def deduplicator = Mock(GenericListDeduplicator)
        def sorter = Mock(GenericListSorter)
        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2), sorter)
        then:
        result == null
    }

    def "Using Stubs with Spock" () {
        given:
        def sorter = Mock(GenericListSorter)
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2), sorter) >> Arrays.asList(1, 2, 4)
        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
        deduplicator.deduplicate(_) >>> [Arrays.asList(1, 2, 4), Arrays.asList(6, 7)]
        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2), sorter)
        then:
        result == Arrays.asList(1, 2, 4)
    }

    def "Should verify notify was called"() {

        given:
        def notifier = Mock(Notifier)
        when:
        notifier.notify('foo')
        then:
        // 1 * notifier.notify(_)
        1 * notifier.notify('foo')
    }
}

public class DivisibleByFilterTest {

    @Test
    public void test() {

        DivisibleByFilter divisibleByFilter = new DivisibleByFilter();
        Assert.assertEquals(false, divisibleByFilter.accept(0));
        Assert.assertEquals(true, divisibleByFilter.accept(-2));
        Assert.assertEquals(true, divisibleByFilter.accept(3));
        Assert.assertEquals(false, divisibleByFilter.accept(0));
        Assert.assertEquals(true, divisibleByFilter.accept(2342));


    }
}

public class ListAggregatorTest {

    class StubDeduplicator implements GenericListDeduplicator {
        @Override
        public List<Integer> deduplicate(List<Integer> list, GenericListSorter genericListSorter) {
            List<Integer> unique = Arrays.asList(1, 2, 4);
            return unique;
        }
    }

    public List<Integer> helper() {

        List<Integer> list = Arrays.asList(1,2,4,2,5);
        return list;
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(helper());

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(helper());

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(helper());

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListDeduplicator deduplicator = new ListDeduplicator();
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(helper(), deduplicator);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {

        ListAggregator aggregator = new ListAggregator();
        List<Integer> list = Arrays.asList(-5, -2, -1, -4);
        Integer result = aggregator.max(list);

        Assertions.assertEquals(-1, result);
    }

    @Test
    public void distinct_bug_8726() {

        // Passo 5 -> StubDeduplicator stub = new StubDeduplicator();

        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        // Passo 6 -> Se o deduplicate receber qualquer lista, retorna (1, 2, 4)
        Mockito.when(deduplicator.deduplicate(Mockito.anyList(), Mockito.any(GenericListSorter.class)))
                .thenReturn(Arrays.asList(1, 2, 4));

        ListAggregator aggregator = new ListAggregator();
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        Integer result = aggregator.distinct(list, deduplicator); // o deduplicator injectado só retorna (1, 2, 4)

        Assertions.assertEquals(3, result);
    }
}

public class ListDeduplicatorTest {

    /**
     *  Não quero que o resultado de "deduplicate" dependa da classe sorter()
     *  Então o deduplicate recebe um GenericListSorted, que tanto pode ser um objecto manipulado (stub) ou não
     */
    class StubSorter implements GenericListSorter {
        @Override
        public List<Integer> sort(List<Integer> list) {
            List<Integer> stub = Arrays.asList(1, 2, 2, 4);
            return stub;
        }
    }

    @Test
    public void deduplicate() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected = Arrays.asList(1, 2, 4);

        ListDeduplicator deduplicator = new ListDeduplicator();
        StubSorter stub = new StubSorter();
        List<Integer> distinct = deduplicator.deduplicate(list, stub);

        Assertions.assertEquals(expected, distinct);
    }
}

public class ListFilterTest {

    @Test
    public void filter() {

        List<Integer> numbers = Arrays.asList(-3, 2, 0, -5, 2, 6, -5, 0, 2, -2, -6, 0);
        ListFilter positiveFilter = new ListFilter(new PositiveFilter());
        ListFilter divisibleFilter = new ListFilter(new DivisibleByFilter());

        List<Integer> resultPositive = positiveFilter.filter(numbers);
        List<Integer> expectedPositive = Arrays.asList(2, 0, 2, 6, 0, 2, 0);
        Assertions.assertEquals(resultPositive, expectedPositive);

        List<Integer> resultNotNull = divisibleFilter.filter(numbers);
        List<Integer> expectedNotNull = Arrays.asList(-3, 2, -5, 2, 6, -5, 2, -2, -6);
        Assertions.assertEquals(resultNotNull, expectedNotNull);

    }

    @Test
    public void usingStubs() {

        PositiveFilter positiveFilter = Mockito.mock(PositiveFilter.class);
        Mockito.when(positiveFilter.accept(Mockito.anyInt()))
                .thenReturn(false);

        ListFilter listFilter = new ListFilter(positiveFilter);
        List<Integer> numbers = Arrays.asList(3, 2, 0, 5, 2, 6, 5, 0, 2, 2, 6, 0);
        List<Integer> expected = Arrays.asList();

        // é independente do valor do filtro --> só está a analisar a função do listFilter()
        List<Integer> result = listFilter.filter(numbers);

        Assertions.assertEquals(result, expected);
    }
}

public class ListSorterTest {

    @Test
    public void sort() {
        List<Integer> list = Arrays.asList(3, 2, 6, 1, 4, 5, 7);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
}

public class PositiveFilterTest {

    @Test
    public void test() {

        PositiveFilter positiveFilter = new PositiveFilter();
        Assert.assertEquals(true, positiveFilter.accept(0));
        Assert.assertEquals(false, positiveFilter.accept(-1));
        Assert.assertEquals(true, positiveFilter.accept(2323));
        Assert.assertEquals(false, positiveFilter.accept(-134));
    }
}

public abstract class AlienClient implements Client {

    private OrderingStrategy strategy;

    public AlienClient() {
        this.strategy = createOrderingStrategy();
    }

    @Override
    public void happyHourStarted(Bar bar) {
        strategy.happyHourStarted((StringBar) bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {
        strategy.happyHourEnded((StringBar) bar);
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        strategy.wants(drink, recipe, bar);
    }

    protected abstract OrderingStrategy createOrderingStrategy();
}

public abstract class Bar {

    private boolean happyHour;
    private List<BarObserver> observers;

    public Bar () {
        this.happyHour = false;
        this.observers = new ArrayList<>();
    }

    public boolean isHappyHour() {
        return happyHour;
    }

    public void startHappyHour() {
        this.happyHour = true;
        notifyObservers();
    }

    public void endHappyHour() {
        this.happyHour = false;
        notifyObservers();
    }

    public void addObserver(BarObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers) {
            if (isHappyHour()) {
                observer.happyHourStarted(this);
            }  else {
                observer.happyHourEnded(this);
            }
        }
    }
}

public interface BarObserver {

    void happyHourStarted(Bar bar);
    void happyHourEnded(Bar bar);
}
