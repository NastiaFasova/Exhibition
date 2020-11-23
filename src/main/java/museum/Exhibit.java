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

    public Exhibit(String name, int age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public Exhibit(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Exhibit(String name) {
        this.name = name;
    }

}
