package museum;

import museum.exceptions.NotEnoughExhibitsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MuseumExhibitionTest {
    private static final double DELTA = 1e-15;

    private MuseumExhibition exhibition;
    Exhibit firstExhibit;
    Exhibit secondExhibit;
    Exhibit thirdExhibit;
    Exhibit fourthExhibit;
    Exhibit fifthExhibit;
    Exhibit sixthExhibit;

    @Before
    public void setUp() throws Exception {
        Visitor firstVisitor = new Visitor("Olena", "Smola", 23);
        Visitor secondVisitor = new Visitor("Oleh", "Smola", 27);
        Visitor thirdVisitor = new Visitor("Dmytro", "Kusiaka", 33);
        Visitor fourthVisitor = new Visitor("Ihor", "Sheva", 13);
        Visitor fifthVisitor = new Visitor("Sasha", "Kuzyk", 39);
        Visitor sixthVisitor = new Visitor("Dmytro", "Maslo", 43);

        firstExhibit = new Exhibit("Gun", 45, 1000);
        secondExhibit = new Exhibit("Sculpture", 27, 5000);
        thirdExhibit = new Exhibit("Picture", 133, 5600);
        fourthExhibit = new Exhibit("Photo", 120, 1601);
        fifthExhibit = new Exhibit("Map", 310, 3400);
        sixthExhibit = new Exhibit("Sword", 155, 9700);
        List<Exhibit> exhibits = List.of(firstExhibit, secondExhibit,
                thirdExhibit, fourthExhibit, fifthExhibit, sixthExhibit);
        exhibition = new MuseumExhibition("Exhibition", "Shevchenka st.",
                LocalDate.of(2019, 12, 17),
                List.of(firstVisitor,  secondVisitor, thirdVisitor, fourthVisitor,
                        fifthVisitor, sixthVisitor), exhibits);
    }

    @Test(expected = NotEnoughExhibitsException.class)
    public void ConstructorTest_CreateExhibit_ThrowsException() {
        Exhibit firstExhibit = new Exhibit("Gun", 45, 3700);
        Exhibit secondExhibit = new Exhibit("Sculpture", 27, 5600);
        exhibition.setExhibits(List.of(firstExhibit, secondExhibit));
    }

    @Test
    public void EducateTest_ReturnsString_Ok() {
        Assert.assertEquals(exhibition.educate(), exhibition);
    }

    @Test
    public void GetSumOfExhibits_ReturnsExhibitsSum_Ok() {
        Double expected = 26301D;
        Double actual = exhibition.getSumOfExhibits();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GetTheCheapestExhibit_ReturnsExhibit_Ok() {
        Assert.assertEquals(firstExhibit, exhibition.getTheCheapestExhibit());
    }

    @Test
    public void GetTheMostExpensiveExhibit_ReturnsExhibit_Ok() {
        Assert.assertEquals(sixthExhibit, exhibition.getTheMostExpensiveExhibit());
    }

    @Test
    public void GetTheAveragePriceOfExhibits_ReturnsAveragePrice_Ok() {
        double expected = 4383.5D;
        double actual = exhibition.getTheAveragePriceOfExhibits();
        Assert.assertEquals( expected, actual, DELTA);
    }

    @Test
    public void GetOldExhibits_ReturnsMap_Ok() {
        Map<String, List<Exhibit>> expected = new HashMap<>();
        List<Exhibit> appropriateList = List.of(thirdExhibit, fifthExhibit, sixthExhibit);
        List<Exhibit> unAppropriateList = List.of(firstExhibit, secondExhibit, fourthExhibit);
        expected.put("Подходит", appropriateList);
        expected.put("Не подходит", unAppropriateList);

        Assert.assertEquals(expected, exhibition.getOldExhibits(125));
    }
}