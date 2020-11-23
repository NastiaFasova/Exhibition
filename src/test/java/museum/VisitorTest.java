package museum;

import museum.MuseumExhibition;
import museum.Visitor;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitorTest {

    @Test
    public void Visit_ReturnListOfVisitors_Ok() {
        Visitor visitor1 = new Visitor("Olena", "Kuzyk", 45);
        Visitor visitor2 = new Visitor("Ihor", "Petrov", 15);
        Visitor visitor3 = new Visitor("Vitaliy", "Lisnyak", 55);
        Visitor visitor4 = new Visitor("Maryna", "Ivanova", 27);
        Visitor visitor5 = new Visitor("Halyna", "Ivanova", 17);
        MuseumExhibition museumExhibition = new MuseumExhibition("Exhibition",
                "Shevchenka st.",
                LocalDate.of(2019, 12, 17),
                List.of(visitor1, visitor2, visitor3, visitor4, visitor5));
        Visitor visitor6 = new Visitor("Dan", "Kuzyk", 47);
        List<Visitor> expected = new ArrayList<>();
        expected.add(visitor1);
        expected.add(visitor2);
        expected.add(visitor3);
        expected.add(visitor4);
        expected.add(visitor5);
        expected.add(visitor6);
        List<Visitor> actual = visitor6.visit(museumExhibition);
        Assert.assertEquals(expected.size(), actual.size());
    }

    @Test
    public void Greet_ReturnsStringOfGreeting_Ok() {
        Visitor visitor = new Visitor("Olena", "Kuzyk", 45);
        String expected = "Hello! I'm Olena. I like visiting museums";
        String actual = visitor.greet();
        Assert.assertEquals(expected, actual);
    }
}