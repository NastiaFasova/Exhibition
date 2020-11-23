package museum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import museum.exceptions.NotEnoughVisitorsException;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public abstract class EntertainmentPlace {
    private static final int MIN_NUMBER = 5;
    private String name;
    private String address;
    private LocalDate time;
    private List<Visitor> visitors;

    public EntertainmentPlace(String name, String address, LocalDate time, List<Visitor> visitors) {
        this.name = name;
        this.address = address;
        this.time = time;
        if (visitors.size() < MIN_NUMBER) {
            throw new NotEnoughVisitorsException("Not enough visitors for opening the museum exhibition");
        }
        this.visitors = visitors;
    }
}
