import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    ArrayList<Attraction> attractions;
    ArrayList<Stall> stalls;
    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;
    Visitor visitor;
    Visitor child;

    @Before
    public void setUp(){
        attractions = new ArrayList<>();
        stalls = new ArrayList<>();

        dodgems = new Dodgems("Bumper Cars", 5);
        park = new Park("Leafy Meadows", 9);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 10);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 9);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 6);

        attractions.add(dodgems);
        attractions.add(park);
        attractions.add(playground);
        attractions.add(rollerCoaster);
        stalls.add(candyflossStall);
        stalls.add(iceCreamStall);
        stalls.add(tobaccoStall);

        themePark = new ThemePark(attractions, stalls);

        visitor = new Visitor(20, 2.5, 200);
        child = new Visitor(10, 1.5, 600);
    }

    @Test
    public void canGetAllReviewed() {
        ArrayList<IReviewed> allReviewed = new ArrayList<>();
        allReviewed.addAll(attractions);
        allReviewed.addAll(stalls);
        assertEquals(allReviewed, themePark.getAllReviewed());
    }

    @Test
    public void visitorCanVisitAttraction(){
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
        assertEquals(1, visitor.getVisitedAttractionsAmount());
    }

    @Test
    public void canGetReviewHash(){
        assertEquals(7, themePark.allReviewsHash().size());
    }

    @Test
    public void canGetAllSecurity(){
        assertEquals(3, themePark.getAllSecurity().size());
    }

    @Test
    public void tall20YOVisitorCanVisitTwoSecureAttractions(){
        assertEquals(2, themePark.getAllowedFor(visitor).size());
    }

    @Test
    public void youngVisitorCanVisitOneSecureAttraction(){
        assertEquals(1, themePark.getAllowedFor(child).size());
    }


}
