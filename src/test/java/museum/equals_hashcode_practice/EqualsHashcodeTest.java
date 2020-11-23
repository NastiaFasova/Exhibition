package museum.equals_hashcode_practice;

import museum.Exhibit;
import museum.Visitor;
import museum.equals_hashcode_practice.EqualsHashcode;
import org.junit.Assert;
import org.junit.Test;

public class EqualsHashcodeTest {
    private Visitor firstVisitor;
    private Visitor secondVisitor;
    private Exhibit firstExhibit;
    private Exhibit secondExhibit;
    private EqualsHashcode equalsHashcode = new EqualsHashcode();

    @Test
    public void NonOverriddenHashcodeTest_ObjectsEqual_False() {
        firstVisitor = new Visitor("Olha", "Dmytriv", 14);
        secondVisitor = new Visitor("Olha", "Dmytriv", 14);
        boolean actual = equalsHashcode.nonOverriddenHashcode(firstVisitor, secondVisitor);
        Assert.assertFalse(actual);
    }

    @Test
    public void OverriddenHashcode_ObjectsEqual_True() {
        firstExhibit = new Exhibit("weapon");
        secondExhibit = new Exhibit("weapon");
        boolean actual = equalsHashcode.overriddenHashcode(firstExhibit, secondExhibit);
        Assert.assertTrue(actual);
    }

    @Test
    public void OverriddenEquals_ObjectsEqual_True() {
        firstExhibit = new Exhibit("weapon");
        secondExhibit = new Exhibit("weapon");
        boolean actual = equalsHashcode.overriddenEquals(firstExhibit, secondExhibit);
        Assert.assertTrue(actual);
    }

    @Test
    public void NonOverriddenEquals_ObjectsEqual_False() {
        firstVisitor = new Visitor("Olha", "Dmytriv", 14);
        secondVisitor = new Visitor("Olha", "Dmytriv", 14);
        boolean actual = equalsHashcode.nonOverriddenEquals(firstVisitor, secondVisitor);
        Assert.assertFalse(actual);
    }
}