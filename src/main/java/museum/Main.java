package museum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MuseumExhibition museumExhibition = new MuseumExhibition("Exhibition", "Shevchenka st.",
                LocalDate.of(2019, 12, 17),
                getVisitors(),
                List.of(new MuseumExhibition.Manager("Ihor", "Ivanchenko", 49)),
                getExhibits(), TypeOfExhibition.HISTORICAL);
        MuseumExhibition museumExhibition2 = new MuseumExhibition("ArtExhibition", "Poshtova st.",
                LocalDate.of(2019, 11, 11),
                getVisitors(),
                List.of(new MuseumExhibition.Manager("Ivan", "Ivanchenko", 45)),
                getExhibits(), TypeOfExhibition.ARTISTIC);

        System.out.println(museumExhibition);

        Visitor fourthVisitor = new Visitor("Dmytro", "Franko", 33);
        fourthVisitor.visit(museumExhibition);
        fourthVisitor.visit(museumExhibition2);

        //polymorphism
        Human fifthVisitor = new Visitor("Dan", "Hugh", 33);
        System.out.println(fifthVisitor.greet());

        System.out.println(museumExhibition);

        System.out.println("~~~~~~~~~~~~~~~~");
        museumExhibition.showExhibits();
        System.out.println("~~~~~~~~~~~~~~~~");
        museumExhibition.showVisitors();
        System.out.println(TypeOfExhibition.showTypeOfMuseumExhibition());
        System.out.println(Arrays.toString(TypeOfExhibition.values()));

        System.out.println("Sum of the exhibits " + museumExhibition.getSumOfExhibits() + "$");
        System.out.println("The most expensive exhibit: "
                + museumExhibition.getTheMostExpensiveExhibit());
        System.out.println("The cheapest exhibit: "
                + museumExhibition.getTheCheapestExhibit());
        System.out.println("The average price of exhibits: "
                + museumExhibition.getTheAveragePriceOfExhibits());
        museumExhibition.getOldExhibits(55);

        System.out.println("The oldest exhibit the visitor saw: " +
                fourthVisitor.getTheOldestExhibitVisitorSaw(List.of(museumExhibition, museumExhibition2)));
    }

    private static List<Visitor> getVisitors() {
        Visitor firstVisitor = new Visitor("Olena", "Smola", 23);
        Visitor secondVisitor = new Visitor("Oleh", "Smola", 27);
        Visitor thirdVisitor = new Visitor("Dmytro", "Kusiaka", 33);
        Visitor fourthVisitor = new Visitor("Ihor", "Sheva", 13);
        Visitor fifthVisitor = new Visitor("Sasha", "Kuzyk", 39);
        Visitor sixthVisitor = new Visitor("Dmytro", "Maslo", 43);
        return List.of(firstVisitor, secondVisitor, thirdVisitor,
                fourthVisitor, fifthVisitor, sixthVisitor);
    }

    private static List<Exhibit> getExhibits() {
        Exhibit firstExhibit = new Exhibit("Gun", 45, 1559);
        Exhibit secondExhibit = new Exhibit("Sculpture", 27, 5000);
        Exhibit thirdExhibit = new Exhibit("Picture", 133, 5600);
        Exhibit fourthExhibit = new Exhibit("Photo", 120, 1600);
        Exhibit fifthExhibit = new Exhibit("Map", 310, 3400);
        Exhibit sixthExhibit = new Exhibit("Sword", 155, 9700);
        return List.of(firstExhibit, secondExhibit, thirdExhibit,
                fourthExhibit, fifthExhibit, sixthExhibit);
    }

}

