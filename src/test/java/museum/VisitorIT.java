package museum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VisitorIT {
    @Mock
    private MuseumExhibition myMock;

    @Spy
    private Visitor visitor;

    @Test
    public void VisitMockito_ReturnListOfVisitors_Ok() {
        visitor.setName("Ihor");
        visitor.setSurname("Olih");
        List<Visitor> expected = List.of(visitor);
        when(myMock.getVisitors()).thenReturn(List.of());
        when(myMock.getName()).thenReturn("Exhibition");
        Assert.assertEquals(expected.size(), visitor.visit(myMock).size());
        verify(myMock).getVisitors();
        verify(myMock).getName();
    }
}