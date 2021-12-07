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

public interface Client extends BarObserver {

    void wants (StringDrink drink, StringRecipe recipe, StringBar bar);
}

public class FerengiClient extends AlienClient {

    private OrderingStrategy strategy;

    protected OrderingStrategy createOrderingStrategy() {
        return new SmartStrategy();
    }

    public FerengiClient() {
        super();
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
}

public class HumanClient implements Client {

    private OrderingStrategy strategy;
    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;

    public HumanClient() {
        super();
    }

    public HumanClient(OrderingStrategy strategy) {
        super();
        this.strategy = strategy;
    }

    public void wants (StringDrink drink, StringRecipe recipe, StringBar bar) {
        strategy.wants(drink, recipe, bar);
        this.recipe = recipe;
        this.bar = bar;
        this.drink = drink;
    }

    public void happyHourStarted(Bar bar) {
        this.recipe.mix(this.drink);
    }

    public void happyHourEnded(Bar bar) {
        bar.endHappyHour();
    }
}

public class ImpatientStrategy implements OrderingStrategy {

    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;

    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.drink = drink;
        this.recipe = recipe;
        this.bar = bar;
        recipe.mix(drink);
    }

    public void happyHourStarted(StringBar bar) {
        System.out.println("Not applicable");
    }

    public void happyHourEnded(StringBar bar) {
        System.out.println("Not applicable");
    }
}

public interface OrderingStrategy {

    void wants(StringDrink drink, StringRecipe recipe, StringBar bar);
    void happyHourStarted(StringBar bar);
    void happyHourEnded(StringBar bar);
}

public class RomulanClient extends AlienClient {

    private OrderingStrategy strategy;

    protected OrderingStrategy createOrderingStrategy() {
        return new ImpatientStrategy();
    }

    public RomulanClient() {
        super();
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

}

public class SmartStrategy implements OrderingStrategy {

    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;

    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {

        this.drink = drink;
        this.recipe = recipe;
        this.bar = bar;

        if (bar.isHappyHour()) {
            this.recipe.mix(this.drink);
        }
    }

    public void happyHourStarted(StringBar bar) {
        this.recipe.mix(this.drink);
    }

    public void happyHourEnded(StringBar bar) {
        System.out.println("Not applicable");
    }

}

public class StringBar extends Bar {

    public StringBar() {
        super();
    }

    public StringRecipe getRecipe() {

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');

        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        transformers.add(sr);

        StringRecipe recipe = new StringRecipe(transformers);
        return recipe;
    }

    public void order (StringDrink drink,  StringRecipe recipe) {
        recipe.mix(drink);
    }
}

public class StringCaseChanger implements StringTransformer {

    public void execute(StringDrink drink) {

        String oldString = drink.getText();
        String newString = "";

        for (int i = 0 ; i < oldString.length() ; i++) {
            char currentChar = oldString.charAt(i);
            if (Character.isLowerCase(currentChar)) {
                currentChar = Character.toUpperCase(currentChar);
            } else { currentChar = Character.toLowerCase(currentChar); }
            newString += currentChar;
        }

        drink.setText(newString);
    }

    public void undo (StringDrink drink) {
        execute(drink);
    }
}

public class StringDrink {

    private String text;

    public StringDrink(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

public class StringInverter implements StringTransformer {

    public void execute(StringDrink drink) {

        String invert = "";
        for (int i = 0 ; i < drink.getText().length() ; i++) {
            invert = drink.getText().charAt(i) + invert;
        }

        drink.setText(invert);
    }

    public void undo(StringDrink drink) {
        execute(drink);
    }
}

public class StringRecipe {

    private List<StringTransformer> transformers;

    public StringRecipe (List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void mix(StringDrink drink) {

        for (StringTransformer transformer : transformers) {
            transformer.execute(drink);
        }
    }
}

public class StringReplacer implements StringTransformer {

    private char i;
    private char f;

    public StringReplacer (char i, char f) {
        this.i = i;
        this.f = f;
    }

    public void execute(StringDrink drink) {

        String oldString = drink.getText();
        String newString = "";

        for (int i = 0 ; i < oldString.length() ; i++) {
            char currentChar = oldString.charAt(i);
            if (currentChar == this.i) currentChar = f;
            newString += currentChar;
        }
        drink.setText(newString);
    }

    public void undo(StringDrink drink) {

        String oldString = drink.getText();
        String newString = "";

        for (int i = 0 ; i < oldString.length() ; i++) {
            char currentChar = oldString.charAt(i);
            if (currentChar == this.f) currentChar = this.i;
            newString += currentChar;
        }
        drink.setText(newString);
    }
}

public interface StringTransformer {

    void execute(StringDrink drink);
    void undo(StringDrink drink);
}

public class StringTransformerGroup implements StringTransformer {

    private List<StringTransformer> transformers;

    public StringTransformerGroup (List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void execute (StringDrink drink) {
        for (StringTransformer transformer : transformers)
            transformer.execute(drink);
    }

    public void undo (StringDrink drink) {
        System.out.println("Not");
    }
}

public class StringDrinkTest {

    @Test
    public void stringDrink() {

        StringDrink drink = new StringDrink("ABCD");
        assertEquals("ABCD", drink.getText());
        drink.setText("DCBA");
        assertEquals("DCBA", drink.getText());
    }

    @Test
    public void stringInverter() {

        StringDrink drink = new StringDrink("ABCD");
        StringInverter si = new StringInverter();
        si.execute(drink);
        assertEquals("DCBA", drink.getText());
    }

    @Test
    public void stringCaseChanger() {

        StringDrink drink = new StringDrink("aBcD");
        StringCaseChanger cc = new StringCaseChanger();
        cc.execute(drink);
        assertEquals("AbCd", drink.getText());
    }

    @Test
    public void stringReplacer() {

        StringDrink drink = new StringDrink("ABCDABCD");
        StringReplacer sr = new StringReplacer('A', 'X');
        sr.execute(drink);
        assertEquals("XBCDXBCD", drink.getText());
    }

    @Test
    public void stringRecipe() {

        StringDrink drink = new StringDrink("AbCd-aBcD");

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');

        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        transformers.add(sr);

        StringRecipe recipe = new StringRecipe(transformers);
        recipe.mix(drink);

        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void transformUndo() {

        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');

        si.execute(drink);
        cc.execute(drink);
        sr.execute(drink);

        sr.undo(drink);
        assertEquals("dCbA-DcBa", drink.getText());

        cc.undo(drink);
        assertEquals("DcBa-dCbA", drink.getText());

        si.undo(drink);
        assertEquals("AbCd-aBcD", drink.getText());
    }

    @Test
    public void transformerGroup() {

        StringDrink drink = new StringDrink("AbCd-aBcD");

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();

        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);

        StringTransformerGroup tg = new StringTransformerGroup(transformers);
        tg.execute(drink);

        assertEquals("dCbA-DcBa", drink.getText());
    }

    @Test
    public void transformerComposite() {

        StringDrink drink = new StringDrink("AbCd-aBcD");

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');
        List<StringTransformer> transformers1 = new ArrayList<>();
        transformers1.add(si);
        transformers1.add(cc);
        StringTransformerGroup tg1 = new StringTransformerGroup(transformers1);

        List<StringTransformer> transformers2 = new ArrayList<>();
        transformers2.add(sr);
        transformers2.add(cc);
        StringTransformerGroup tg2 = new StringTransformerGroup(transformers2);

        List<StringTransformer> transformers3 = new ArrayList<>();
        transformers3.add(tg1);
        transformers3.add(tg2);

        StringRecipe recipe = new StringRecipe(transformers3);
        recipe.mix(drink);

        assertEquals("DcBx-dCbA", drink.getText());
    }

    @Test
    public void happyHour() {

        Bar bar = new StringBar();
        assertFalse(bar.isHappyHour());

        bar.startHappyHour();
        assertTrue(bar.isHappyHour());

        bar.endHappyHour();
        assertFalse(bar.isHappyHour());
    }

    @Test
    public void addObserver() {

        Bar bar = new StringBar();

        HumanClient clientMock = Mockito.mock(HumanClient.class);
        bar.addObserver(clientMock);

        Mockito.verify(clientMock, Mockito.never()).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.never()).happyHourEnded(bar);

        bar.startHappyHour();
        Mockito.verify(clientMock, Mockito.times(1)).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.never()).happyHourEnded(bar);

        bar.endHappyHour();
        Mockito.verify(clientMock, Mockito.times(1)).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.times(1)).happyHourEnded(bar);
    }

    @Test
    public void removeObservers() {

        Bar bar = new StringBar();

        HumanClient clientMock = Mockito.mock(HumanClient.class);
        bar.addObserver(clientMock);
        bar.removeObserver(clientMock);

        bar.startHappyHour();
        bar.endHappyHour();

        Mockito.verify(clientMock, Mockito.never()).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.never()).happyHourEnded(bar);
    }

    @Test
    public void orderStringRecipe() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();

        stringBar.order(drink, recipe);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void impatientStrategy() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();

        ImpatientStrategy strategy = new ImpatientStrategy();
        HumanClient client = new HumanClient(strategy);

        // Recipe is ordered immediately
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void smartStrategyStartOpened() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();

        SmartStrategy strategy = new SmartStrategy();
        HumanClient client = new HumanClient(strategy);

        // Recipe is ordered immediately as happy hour was already under way
        stringBar.startHappyHour();
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void smartStrategyStartClosed() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();

        SmartStrategy strategy = new SmartStrategy();
        HumanClient client = new HumanClient(strategy);
        stringBar.addObserver(client); // this is important!

        client.wants(drink, recipe, stringBar);
        assertEquals("AbCd-aBcD", drink.getText());

        // Recipe is only ordered here
        stringBar.startHappyHour();
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void ferengiAlreadyOpened() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();
        FerengiClient client = new FerengiClient();

        // Recipe is ordered immediately
        stringBar.startHappyHour();
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void ferengiStartClosed() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();
        FerengiClient client = new FerengiClient();
        stringBar.addObserver(client); // this is important!

        client.wants(drink, recipe, stringBar);
        assertEquals("AbCd-aBcD", drink.getText());

        // Recipe is only ordered here
        stringBar.startHappyHour();
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void romulan() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();
        RomulanClient client = new RomulanClient();

        // Recipe is ordered immediately
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }
}

public class Order {

    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }

    public double getTotal() {
        double total = 0;
        for (OrderLine line : lines) {
            total += line.product.getPrice() * line.quantity;
        }
        return total;
    }

    public boolean isElegibleForFreeDelivery() {
        return getTotal() > 100;
    }

    public String printOrder() {

        StringBuffer printBuffer = new StringBuffer();
        for (OrderLine line : lines)
            printBuffer.append(line.product.getName() + "(x" + line.quantity + "): " + (line.product.getPrice() * line.quantity) + "\n");

        printBuffer.append("Total: " + getTotal());
        return printBuffer.toString();
    }
}

public class OrderLine {

    public Product product;
    public int quantity;
    public int total;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class Circle implements Object {

    private double x;
    private double y;
    private double radius;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void draw(GraphicFramework graphics) {
        graphics.drawCircle(x, y, radius);
    }
}

public interface GraphicFramework {
    void drawLine(double x1, double y1, double x2, double y2);
    void drawCircle(double x, double y, double radius);
}

public interface Object {
    public double getArea();
    public double getPerimeter();
    public void draw(GraphicFramework graphics);
}

public class Rectangle implements Object {

    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle (double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public void draw(GraphicFramework graphics) {
        graphics.drawLine(x, y, x + width, y);
        graphics.drawLine(x + width, y, x + width, y + height);
        graphics.drawLine(x + width, y + height, x, y + height);
        graphics.drawLine(x, y + height, x, y);
    }
}

public class Shape {

    private Object object;

    public Shape(double x, double y, double width, double height) {
        this.object = new Rectangle(x, y, width, height);
    }

    public Shape(double x, double y, double radius) {
        this.object = new Circle(x, y, radius);
    }

    public double getArea() {
        return object.getArea();
    }

    public double getPerimeter() {
        return object.getPerimeter();
    }

    public void draw(GraphicFramework graphics) {
        object.draw(graphics);
    }
}

public class Discount {

    private GenericDiscount discount = null;

    public Discount(int fixed) {
        discount = new FixedDiscount(fixed);
    }

    public Discount(double percentage) {
        discount = new PercentageDiscount(percentage);
    }

    public double applyDiscount(double price) {
        return discount != null ? discount.applyDiscount(price) : price;
    }
}

public class FixedDiscount implements GenericDiscount {

    private int fixed;

    public FixedDiscount(int fixed) {
        this.fixed = fixed;
    }

    public double applyDiscount(double price) {
        return fixed > price ? 0 : price - fixed;
    }
}

public interface GenericDiscount {
    double applyDiscount(double price);
}

public class PercentageDiscount implements GenericDiscount {

    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    public double applyDiscount(double price) {
        return price * (1 - percentage);
    }
}

public class SimpleOrder {

    private Discount discount;
    private double price;

    public SimpleOrder(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return discount == null ? price : discount.applyDiscount(price);
    }
}

public class Client extends Person {

    public Client(String name, String phone) {
        super(name, phone);
    }
}

public class Person {

    private final String name;
    private final String phone;

    public Person (String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}

import java.util.HashSet;
        import java.util.Set;

public class Supervisor extends Worker {

    Set<Worker> supervisee;

    public Supervisor(String name, String phone, String username, String password) {
        super(name, phone, username, password);
        supervisee = new HashSet<>();
    }

    public void addSupervisee(Worker worker) {
        supervisee.add(worker);
    }

    public boolean isSupervisee(Worker worker) {
        return supervisee.contains(worker);
    }
}

public class Worker extends Person {

    private final String username;
    private final String password;

    public Worker(String name, String phone, String username, String password) {
        super(name, phone);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(this.getName(), worker.getName()) &&
                Objects.equals(this.getPhone(), worker.getPhone()) &&
                Objects.equals(username, worker.username) &&
                Objects.equals(password, worker.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getPhone(), username, password);
    }
}

public class Turtle {

    private int row;
    private int column;
    private char direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction;
    }

    public void execute(char command) {

        if (command == 'F') {
            switch (direction) {
                case 'N':
                    row--;
                    break;
                case 'S':
                    row++;
                    break;
                case 'W':
                    column--;
                    break;
                case 'E':
                    column++;
                    break;
                default:
                    return;
            }
        } else {
            switch (direction) {
                case 'N':
                    direction = command == 'L' ? 'W' : 'E';
                    break;
                case 'S':
                    direction = command == 'L' ? 'E' : 'W';
                    break;
                case 'W':
                    direction = command == 'L' ? 'S' : 'N';
                    break;
                case 'E':
                    direction = command == 'L' ? 'N' : 'S';
                    break;
                default:
                    return;
            }
        }
    }
}

public class Tree {

    public Date plantedAt;
    public String locationLatitude;
    public String locationLongitude;
    public String locationName;
    private List<Date> appraisalDates;

    public Tree(Date plantedAt, String locationLatitude, String locationLongitude, String locationName) {
        this.plantedAt = plantedAt;
        this.setLocation(locationLatitude, locationLongitude, locationName);
        this.appraisalDates = new ArrayList<>();
    }

    public void setLocation(String locationLatitude, String locationLongitude, String locationName) {
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationName = locationName;
    }

    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + this.locationLatitude + "," + this.locationLongitude + " (" + this.locationName + ")";
    }

    void addAppraisal(Date appraisalDate) {
        this.appraisalDates.add(appraisalDate);
    }

    public List<Date> getAppraisals() {
        return this.appraisalDates;
    }

    public boolean isNextAppraisalOverdue() {

        Date latestAppraisalDate = new Date();

        if (this.appraisalDates.size() > 0) {
            latestAppraisalDate = this.appraisalDates.get(0);
        }

        for (Date appraisalDate : this.appraisalDates) {
            if (latestAppraisalDate.before(appraisalDate)) {
                latestAppraisalDate = appraisalDate;
            }
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestAppraisalDate);
        calendar.add(Calendar.MONTH, 3);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 2);

        Date nextAppraisalDate = calendar.getTime();

        return nextAppraisalDate.before(new Date());
    }
}

class OrderSpockTest extends Specification {

    def 'Is Elegible For Free Delivery (Small)'() {
        given:
        def order = new Order()
        order.add(new Product("Lollipop", 5), 10)

        when:
        def result = order.isElegibleForFreeDelivery()

        then:
        result == false
    }

    def 'Is Elegible For Free Delivery (Large)'() {
        given:
        def order = new Order()
        order.add(new Product("Playstation 4", 400), 2)
        order.add(new Product("Red Dead Redemption 2", 50), 1)

        when:
        def result = order.isElegibleForFreeDelivery()

        then:
        result == true
    }


    def 'Print Order'() {
        given:
        def order = new Order()
        order.add(new Product("Playstation 4", 400), 2);
        order.add(new Product("Red Dead Redemption 2", 50), 1);

        when:
        def result = order.printOrder()

        then:
        result == "Playstation 4(x2): 800.0\n" +
                "Red Dead Redemption 2(x1): 50.0\n" +
                "Total: 850.0"
    }
}

class WorkerSpockTest extends Specification {

    def 'Worker'() {
        given:
        def worker = new Worker("John Doe", "+1 222-22222", "john", "secret")

        expect:
        worker.getName() == "John Doe"
        worker.getPhone() == "+1 222-22222"
        !worker.login("john", "wrong")
        worker.login("john", "secret")
    }

    def 'Supervisor'() {
        given:
        def supervisor = new Supervisor("John Doe", "+1 222-22222", "john", "secret")

        def minion1 = new Worker("Minion 1", "+1 123-12345", "minion1", "1234")
        def minion2 = new Worker("Minion 2", "+1 123-12345", "minion2", "1234")

        when:
        supervisor.addSupervisee(minion1);

        then:
        "John Doe" == supervisor.getName()
        "+1 222-22222" == supervisor.getPhone()
        !supervisor.login("john", "wrong")
        supervisor.login("john", "secret")
        supervisor.isSupervisee(minion1)
        !supervisor.isSupervisee(minion2)
    }

    def 'Client'() {
        given:
        def client = new Client("John Doe", "+1 222-22222");

        expect:
        "John Doe" == client.getName()
        "+1 222-22222" == client.getPhone()
    }
}

class TurtleSpockTest extends Specification {

    def 'Rotate Left'() {
        given:
        def turtle = new Turtle(5, 5, 'N' as char);

        when:
        turtle.execute('L' as char);

        then:
        'W' == turtle.getDirection()

        and:
        turtle.execute('L' as char);

        then:
        'S' == turtle.getDirection()

        and:
        turtle.execute('L' as char);

        then:
        'E' == turtle.getDirection()

        and:
        turtle.execute('L' as char);

        then:
        'N' == turtle.getDirection()

        and:
        5 == turtle.getRow()
        5 == turtle.getColumn()
    }

    def 'Rotate Right'() {
        given:
        def turtle = new Turtle(5, 5, 'N' as char);

        when:
        turtle.execute('R' as char);

        then:
        'E' == turtle.getDirection()

        and:
        turtle.execute('R' as char);

        then:
        'S' == turtle.getDirection()

        and:
        turtle.execute('R' as char);

        then:
        'W' == turtle.getDirection()

        and:
        turtle.execute('R' as char);

        then:
        'N' == turtle.getDirection()

        and:
        5 == turtle.getRow()
        5 == turtle.getColumn()
    }

    def 'Forward'() {
        given:
        def turtleN = new Turtle(5, 5, 'N' as char)
        def turtleW = new Turtle(5, 5, 'W' as char);
        def turtleS = new Turtle(5, 5, 'S' as char);
        def turtleE = new Turtle(5, 5, 'E' as char);

        when:
        turtleN.execute('F' as char)
        turtleW.execute('F' as char);
        turtleS.execute('F' as char);
        turtleE.execute('F' as char);

        then:
        4 == turtleN.getRow()
        5 == turtleN.getColumn()

        and:
        5 == turtleW.getRow()
        4 == turtleW.getColumn()

        and:
        6 == turtleS.getRow()
        5 == turtleS.getColumn()

        and:
        5 == turtleE.getRow()
        6 == turtleE.getColumn()
    }
}

class TreeSpockTest extends Specification {
    def tree
    def date

    def setup() {
        def sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
        date = sdf.parse("31-08-2002 10:20:56")
        tree = new Tree(date, "41.177772696363114", "-8.59843522310257", "FEUP")
    }

    def 'Tree Creation'() {
        expect:
        tree.plantedAt == date
        tree.locationLatitude == "41.177772696363114"
        tree.locationLongitude == "-8.59843522310257"
        tree.locationName == "FEUP"
    }

    def 'Tree Set Location'() {
        given:
        tree.setLocation("loclat", "loclon", "locname")

        expect:
        tree.plantedAt == date
        tree.locationLatitude == "loclat"
        tree.locationLongitude == "loclon"
        tree.locationName == "locname"
    }

    def 'Tree to String'() {
        when:
        def result = tree.toString()

        then:
        result == "Tree planted at Sat Aug 31 10:20:56 WEST 2002 in location 41.177772696363114,-8.59843522310257 (FEUP)"
    }

    def 'Add Appraisal'() {
        when:
        def sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
        def appraisalDate = sdf.parse("31-08-2002 10:20:56")

        then:
        tree.getAppraisals().size() == 0

        and:
        tree.addAppraisal(appraisalDate)

        then:
        tree.getAppraisals().size() == 1
    }

    def 'Next Appraisal Overdue'() {
        given:
        def calendar = Calendar.getInstance()
        calendar.setTime(new Date())
        calendar.add(Calendar.MONTH, -6)

        when:
        def appraisalDate = calendar.getTime()

        then:
        !tree.isNextAppraisalOverdue()

        and:
        tree.addAppraisal(appraisalDate)

        then:
        tree.isNextAppraisalOverdue()
    }

    def 'Next Appraisal Not Overdue'() {
        given:
        def calendar = Calendar.getInstance()
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);

        when:
        def appraisalDate = calendar.getTime()

        then:
        !tree.isNextAppraisalOverdue()

        and:
        tree.addAppraisal(appraisalDate)

        then:
        !tree.isNextAppraisalOverdue()
    }
}
