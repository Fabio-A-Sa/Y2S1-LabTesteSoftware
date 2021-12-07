package pt.up.fe.ldts.example4;

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
