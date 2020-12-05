package museum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VisitorMockitoTest {
    @Mock
    private MuseumExhibition myMock;

    @Test
    public void VisitMockito_ReturnListOfVisitors_Ok() {
        Visitor visitor1 = new Visitor("Olena", "Kuzyk", 45);
        Visitor visitor2 = new Visitor("Ihor", "Petrov", 15);
        Visitor visitor3 = new Visitor("Vitaliy", "Lisnyak", 55);
        Visitor visitor4 = new Visitor("Maryna", "Ivanova", 27);
        Visitor visitor5 = new Visitor("Halyna", "Ivanova", 17);
        Visitor visitor6 = new Visitor("Nastia", "Ivanova", 37);
        List<Visitor> expected = List.of(visitor1, visitor2,
                visitor3, visitor4, visitor5, visitor6);
        when(myMock.getVisitors()).thenReturn(expected.subList(0, expected.size() - 1));
        when(myMock.getName()).thenReturn("Exhibition");
        Assert.assertEquals(expected.size(), visitor6.visit(myMock).size());
        verify(myMock).getVisitors();
        verify(myMock).getName();
    }
}