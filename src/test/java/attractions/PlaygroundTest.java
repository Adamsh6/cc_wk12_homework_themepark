package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;
    Visitor tooOld;
    Visitor child;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        child = new Visitor(15, 2.5, 50);
        tooOld = new Visitor(16, 2.6, 60);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void isAllowedToFalseIfOver15(){
        assertEquals(false, playground.isAllowedTo(tooOld));
    }

    @Test
    public void isAllowedToTrueIfUnder16(){
        assertEquals(true, playground.isAllowedTo(child));
    }
}
