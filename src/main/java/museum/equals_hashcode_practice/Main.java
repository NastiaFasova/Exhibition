package museum.equals_hashcode_practice;

import museum.Exhibit;
import museum.Visitor;

public class Main {
    public static void main(String[] args) {
        EqualsHashcode practice = new EqualsHashcode();
        Visitor firstVisitor = new Visitor("Olha", "Dmytriv", 14);
        Visitor secondVisitor = new Visitor("Olha", "Dmytriv", 14);

        Exhibit firstExhibit = new Exhibit("weapon");
        Exhibit secondExhibit = new Exhibit("weapon");
        System.out.println("NonOverriddenHashcode\nAre hashcodes equal? "
                + practice.nonOverriddenHashcode(firstVisitor,secondVisitor));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("OverriddenHashcode\nAre hashcodes equal? "
                + practice.overriddenHashcode(firstExhibit, secondExhibit));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("OverriddenEquals\n Are object equal? "
                + practice.overriddenEquals(firstExhibit, secondExhibit));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("NonOverriddenEquals\n Are object equal? "
                + practice.nonOverriddenEquals(firstVisitor,secondVisitor));
    }
}
