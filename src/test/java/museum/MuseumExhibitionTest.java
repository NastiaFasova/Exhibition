package museum;

import museum.Exhibit;
import museum.MuseumExhibition;
import museum.Visitor;
import museum.exceptions.NotEnoughExhibitsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class MuseumExhibitionTest {

    private MuseumExhibition exhibition;

    @Before
    public void setUp() throws Exception {
        Visitor firstVisitor = new Visitor("Olena", "Smola", 23);
        Visitor secondVisitor = new Visitor("Oleh", "Smola", 27);
        Visitor thirdVisitor = new Visitor("Dmytro", "Kusiaka", 33);
        Visitor fourthVisitor = new Visitor("Ihor", "Sheva", 13);
        Visitor fifthVisitor = new Visitor("Sasha", "Kuzyk", 39);
        Visitor sixthVisitor = new Visitor("Dmytro", "Maslo", 43);
        exhibition = new MuseumExhibition("Exhibition", "Shevchenka st.",
                LocalDate.of(2019, 12, 17),
                List.of(firstVisitor,  secondVisitor, thirdVisitor, fourthVisitor,
                        fifthVisitor, sixthVisitor));
    }

    @Test(expected = NotEnoughExhibitsException.class)
    public void ConstructorTest_CreateExhibit_ThrowsException() {
        Exhibit firstExhibit = new Exhibit("Gun", 45);
        Exhibit secondExhibit = new Exhibit("Sculpture", 27);
        exhibition.setExhibits(List.of(firstExhibit, secondExhibit));
    }

    @Test
    public void EducateTest_ReturnsString_Ok() {
        Assert.assertEquals(exhibition.educate(), exhibition);
    }
}