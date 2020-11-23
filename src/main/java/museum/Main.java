package museum;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MuseumExhibition museumExhibition = new MuseumExhibition("Exhibition", "Shevchenka st.",
                LocalDate.of(2019, 12, 17),
                getVisitors(),
                List.of(new MuseumExhibition.Manager("Ihor", "Ivanchenko", 49)),
                getExhibits(), TypeOfExhibition.HISTORICAL);
        System.out.println(museumExhibition);

        Visitor fourthVisitor = new Visitor("Dmytro", "Franko", 33);
        fourthVisitor.visit(museumExhibition);

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
        Exhibit firstExhibit = new Exhibit("Gun", 45);
        Exhibit secondExhibit = new Exhibit("Sculpture", 27);
        Exhibit thirdExhibit = new Exhibit("Picture", 133);
        Exhibit fourthExhibit = new Exhibit("Photo", 120);
        Exhibit fifthExhibit = new Exhibit("Map", 310);
        Exhibit sixthExhibit = new Exhibit("Sword", 155);
        return List.of(firstExhibit, secondExhibit, thirdExhibit,
                fourthExhibit, fifthExhibit, sixthExhibit);
    }

}

