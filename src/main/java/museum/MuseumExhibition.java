package museum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import museum.exceptions.NotEnoughExhibitsException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class MuseumExhibition extends EntertainmentPlace implements Educatable {
    private static final int MIN_NUMBER = 5;
    private List<Manager> manager;
    private List<Exhibit> exhibits;
    private TypeOfExhibition typeOfExhibition;

    public MuseumExhibition(String name, String address, LocalDate time, List<Visitor> visitors) {
        super(name, address, time, visitors);
    }

    public MuseumExhibition(String name, String address, LocalDate time, List<Visitor> visitors,
                            List<Exhibit> exhibits) {
        super(name, address, time, visitors);
        if (exhibits.size() < MIN_NUMBER) {
            throw new NotEnoughExhibitsException("Not enough exhibits for opening the museum exhibition !!!");
        }
        this.exhibits = exhibits;
    }

    public MuseumExhibition(String name, String address, LocalDate time,
                            List<Visitor> visitors, List<Manager> manager, List<Exhibit> exhibits,
                            TypeOfExhibition typeOfExhibition) {
        super(name, address, time, visitors);
        this.manager = manager;
        if (exhibits.size() < MIN_NUMBER) {
            throw new NotEnoughExhibitsException("Not enough exhibits for opening the museum exhibition !!!");
        }
        this.exhibits = exhibits;
        this.typeOfExhibition = typeOfExhibition;
    }

    public void setExhibits(List<Exhibit> exhibits) {
        if (exhibits.size() < MIN_NUMBER) {
            throw new NotEnoughExhibitsException("Not enough exhibits for opening the museum exhibition !!!");
        }
        this.exhibits = exhibits;
    }

    @Override
    public MuseumExhibition educate() {
        System.out.println("This museum exhibition educates people");
        return this;
    }

    public double getSumOfExhibits() {
        return getExhibits()
                .stream()
                .map(Exhibit::getPrice)
                .reduce(0D, Double::sum);
    }

    public Exhibit getTheMostExpensiveExhibit() {
        return getExhibits()
                .stream()
                .max(Comparator.comparing(Exhibit::getPrice))
                .orElseThrow(RuntimeException::new);
    }

    public Exhibit getTheCheapestExhibit() {
        return getExhibits()
                .stream()
                .min(Comparator.comparing(Exhibit::getPrice))
                .orElseThrow(RuntimeException::new);
    }

    public Double getTheAveragePriceOfExhibits() {
        return getExhibits()
                .stream()
                .mapToDouble(Exhibit::getPrice)
                .average()
                .orElseThrow(RuntimeException::new);
    }

    public Map<String, List<Exhibit>> getOldExhibits(int age) {
        Map<String, List<Exhibit>> map = new HashMap<>();
        List<Exhibit> oldExhibits = getExhibits()
                .stream()
                .filter(e -> e.getAge() >= age)
                .collect(Collectors.toList());
        map.put("Подходит", oldExhibits);
        List<Exhibit> notEnoughOldExhibits = getExhibits()
                .stream()
                .filter(e -> !oldExhibits.contains(e))
                .collect(Collectors.toList());
        map.put("Не подходит", notEnoughOldExhibits);
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        return map;
    }

    //nested class
    public static class Manager extends Human {
        public Manager(String name, String surname, int age) {
            super(name, surname, age);
        }
    }


    //creating of Iterator
    public void showExhibits() {
        List<Exhibit> exhibits = getExhibits();
        Iterator<Exhibit> iterator = exhibits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //creating of Iterator
    public void showVisitors() {
        List<Visitor> visitors = getVisitors();
        Iterator<Visitor> iterator = visitors.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
