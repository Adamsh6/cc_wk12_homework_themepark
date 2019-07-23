package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor child;
    Visitor adult;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 6);
        child = new Visitor(17, 2.5, 50);
        adult = new Visitor(18, 2.6, 60);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void doesntAllowUnder18s(){
        assertEquals(false, tobaccoStall.isAllowedTo(child));
    }

    @Test
    public void allowsOver17s(){
        assertEquals(true, tobaccoStall.isAllowedTo(adult));
    }
}
