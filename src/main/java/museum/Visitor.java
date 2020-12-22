package museum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Асоциация между Visitor и Exhibition
public class Visitor extends Human {

    public Visitor(String name, String surname, int age) {
        super(name, surname, age);
    }

    public Visitor() {
    }

    public <T extends EntertainmentPlace> List<Visitor> visit(T place) {
        Visitor visitor = new Visitor(super.getName(), super.getSurname(),
                super.getAge());
        System.out.println(visitor.getName() + " " + visitor.getSurname()
                + " is visiting " + place.getName());
        List<Visitor> visitors = new ArrayList<>(place.getVisitors());
        visitors.add(visitor);
        place.setVisitors(visitors);
        return visitors;
    }

    @Override
    public String greet() {
        return super.greet() + ". I like visiting museums";
    }

    public Exhibit getTheOldestExhibitVisitorSaw(List<MuseumExhibition> museumExhibitions) {
        return museumExhibitions
                .stream()
                .flatMap(m -> m.getExhibits().stream())
                .max(Comparator.comparing(Exhibit::getAge))
                .orElseThrow(RuntimeException::new);
    }
}
