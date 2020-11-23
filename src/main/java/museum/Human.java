package museum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Human {
    private String name;
    private String surname;
    private int age;

    public Human() {
    }

    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    protected String greet() {
        return "Hello! I'm " + this.name;
    }
}
