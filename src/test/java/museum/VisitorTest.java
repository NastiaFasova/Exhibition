package museum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitorTest {
    private MuseumExhibition museumExhibition;
    private Exhibit firstExhibit;
    private Exhibit secondExhibit;
    private Exhibit thirdExhibit;
    private Exhibit fourthExhibit;
    private Exhibit fifthExhibit;
    private Visitor visitor1;
    private Visitor visitor2;
    private Visitor visitor3;
    private Visitor visitor4;
    private Visitor visitor5;

    @Before
    public void setUp() throws Exception {
        visitor1 = new Visitor("Olena", "Kuzyk", 45);
        visitor2 = new Visitor("Ihor", "Petrov", 15);
        visitor3 = new Visitor("Vitaliy", "Lisnyak", 55);
        visitor4 = new Visitor("Maryna", "Ivanova", 27);
        visitor5 = new Visitor("Halyna", "Ivanova", 17);

        firstExhibit = new Exhibit("Gun", 45, 1559);
        secondExhibit = new Exhibit("Sculpture", 27, 5000);
        thirdExhibit = new Exhibit("Picture", 133, 5600);
        fourthExhibit = new Exhibit("Photo", 120, 1600);
        fifthExhibit = new Exhibit("Map", 310, 3400);
        museumExhibition = new MuseumExhibition("Exhibition", "Shevchenka st.",
                LocalDate.of(2019, 12, 17),
                List.of(visitor1, visitor2, visitor3, visitor4, visitor5),
                List.of(new MuseumExhibition.Manager("Ihor", "Ivanchenko", 49)),
                List.of(firstExhibit, secondExhibit, thirdExhibit, fourthExhibit, fifthExhibit),
                TypeOfExhibition.HISTORICAL);
    }

    @Test
    public void Visit_ReturnListOfVisitors_Ok() {
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

    @Test
    public void GetTheOldestExhibitVisitorSaw_ReturnsExhibit_Ok() {
        Assert.assertEquals(fifthExhibit, visitor1.getTheOldestExhibitVisitorSaw(List.of(museumExhibition)));
    }
}