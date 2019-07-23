package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor child;
    Visitor teenager;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        child = new Visitor(12, 1.5, 30);
        teenager = new Visitor(11, 1.3, 40);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    public void canGetDefaultPrice(){
        assertEquals(4.5, dodgems.defaultPrice(), 0);
    }

    @Test
    public void chargesDoubleForOver2m(){
        assertEquals(2.25, dodgems.priceFor(teenager), 0);
    }

    @Test
    public void chargesDefaultForUnder2m(){
        assertEquals(4.5, dodgems.priceFor(child), 0);
    }
}
