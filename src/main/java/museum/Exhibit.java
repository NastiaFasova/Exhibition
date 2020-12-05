package museum;

import lombok.Data;
import lombok.EqualsAndHashCode;

//Композиция между Exhibit и Exhibition
@EqualsAndHashCode
@Data
public class Exhibit {
    private String name;
    private int age;
    private String location;
    private double price;

    public Exhibit(String name, int age, String location, double price) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.price = price;
    }

    public Exhibit(String name, int age, double price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    public Exhibit(String name) {
        this.name = name;
    }

}
