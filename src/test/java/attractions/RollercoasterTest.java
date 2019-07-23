package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor shortAdult;
    Visitor tallChild;
    Visitor shortChild;
    Visitor tallAdult;


    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        shortAdult = new Visitor(28, 1.40, 50);
        tallChild = new Visitor(11, 2.50, 12);
        shortChild = new Visitor(11, 1.3, 22);
        tallAdult = new Visitor(23, 1.46, 300);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void doesntAllowShortPeopleOrUnder13s(){
        assertEquals(false, rollerCoaster.isAllowedTo(shortAdult));
        assertEquals(false, rollerCoaster.isAllowedTo(tallChild));
        assertEquals(false, rollerCoaster.isAllowedTo(shortChild));
    }

    @Test
    public void allowsTallPeopleOver12() {
        assertEquals(true, rollerCoaster.isAllowedTo(tallAdult));
    }

    @Test
    public void canGetDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0);
    }

    @Test
    public void chargesDoubleForOver2m(){
        assertEquals(16.8, rollerCoaster.priceFor(tallChild), 0);
    }

    @Test
    public void chargesDefaultForUnder2m(){
        assertEquals(8.4, rollerCoaster.priceFor(shortAdult), 0);
    }
}
