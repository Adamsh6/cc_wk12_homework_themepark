import attractions.Attraction;
import attractions.Dodgems;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;

public class ThemePark {
    ArrayList<Attraction> attractions;
    ArrayList<Stall> stalls;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> allReviewed = new ArrayList<>();
        for(Attraction attraction : attractions){
            if(attraction instanceof IReviewed){
                allReviewed.add(attraction);
            }
        }
        for(Stall stall : stalls){
            if(stall instanceof IReviewed){
                allReviewed.add(stall);
            }
        }
        return allReviewed;
    }

    public void visit(Visitor visitor, Attraction attraction){

    }
}
