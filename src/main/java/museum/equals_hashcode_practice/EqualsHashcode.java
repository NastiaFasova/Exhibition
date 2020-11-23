package museum.equals_hashcode_practice;

import museum.Exhibit;
import museum.Visitor;

public class EqualsHashcode {

    /*Вызываем непереопределенный метод hashcode()
      Функция должна возвращать false*/
    public boolean nonOverriddenHashcode(Visitor firstVisitor, Visitor secondVisitor) {
        int firstHashcode = firstVisitor.hashCode();
        int secondHashcode = secondVisitor.hashCode();
        System.out.println(firstVisitor);
        System.out.println(secondVisitor);
        return firstHashcode == secondHashcode;
    }

    /*Вызываем переопределенный метод hashcode()
         Функция должна возвращать true*/
    public boolean overriddenHashcode(Exhibit firstExhibit, Exhibit secondExhibit) {
        int firstHashcode = firstExhibit.hashCode();
        int secondHashcode = secondExhibit.hashCode();
        System.out.println(firstExhibit);
        System.out.println(secondExhibit);
        return firstHashcode == secondHashcode;
    }

    /*Вызываем переопределенный метод equals()
        Функция должна возвращать true*/
    public boolean overriddenEquals(Exhibit firstExhibit, Exhibit secondExhibit) {
        System.out.println(firstExhibit);
        System.out.println(secondExhibit);
        return firstExhibit.equals(secondExhibit);
    }

    /*Вызываем непереопределенный метод equals()
        Функция должна возвращать false*/
    public boolean nonOverriddenEquals(Visitor firstVisitor, Visitor secondVisitor) {
        System.out.println(firstVisitor);
        System.out.println(secondVisitor);
        return firstVisitor.equals(secondVisitor);
    }
}
