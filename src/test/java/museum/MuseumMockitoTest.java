package museum;

import museum.exceptions.NotEnoughExhibitsException;
import museum.exceptions.NotEnoughVisitorsException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MuseumMockitoTest {
    // для того, чтобы каждый раз не создавать Visitor и Exhibit и их особыми параметрами
    // используем Mockito
    @Mock
    private Visitor myVisitor;
    @Mock
    private Exhibit myExhibit;
    @Mock
    private MuseumExhibition.Manager myManager;

    @Test(expected = NotEnoughVisitorsException.class)
    public void Constructor_CreateMuseum_ThrowsNotEnoughVisitorsException() {
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(myVisitor);
        new MuseumExhibition("Exhibition", "Shevchenka st.",
                LocalDate.of(2019, 12, 17), visitors);
    }

    @Test
    public void Constructor_CreateMuseum_Ok() {
        List<Visitor> visitors = List.of(myVisitor, myVisitor, myVisitor, myVisitor, myVisitor);
        MuseumExhibition museumExhibition = new MuseumExhibition("Exhibition", "Shevchenka st.",
                LocalDate.of(2019, 12, 17), visitors);
        Assert.assertEquals(visitors, museumExhibition.getVisitors());
    }

    @Test(expected = NotEnoughExhibitsException.class)
    public void Constructor_CreateMuseum_ThrowsNotEnoughExhibitsException() {
        List<Visitor> visitors = List.of(myVisitor, myVisitor, myVisitor, myVisitor, myVisitor);
        MuseumExhibition museumExhibition = new MuseumExhibition("Exhibition", "Shevchenka st.",
                LocalDate.of(2019, 12, 17), visitors, List.of(myManager),
                List.of(myExhibit), TypeOfExhibition.HISTORICAL);
        Assert.assertEquals(visitors, museumExhibition.getVisitors());
    }

    @Test
    public void Constructor_CreateMuseumWithVisitors_Ok() {
        List<Visitor> visitors = List.of(myVisitor, myVisitor, myVisitor, myVisitor, myVisitor);
        List<Exhibit> exhibits = List.of(myExhibit, myExhibit, myExhibit, myExhibit, myExhibit);
        MuseumExhibition museumExhibition = new MuseumExhibition("Exhibition", "Shevchenka st.",
                LocalDate.of(2019, 12, 17), visitors, List.of(myManager),
                exhibits, TypeOfExhibition.HISTORICAL);
        Assert.assertEquals(exhibits, museumExhibition.getExhibits());
    }


}