import attractions.Attraction;
import attractions.Dodgems;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.nio.channels.IllegalSelectorException;
import java.util.ArrayList;
import java.util.HashMap;

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

    public ArrayList<ISecurity> getAllSecurity(){
        ArrayList<ISecurity> allSecurity = new ArrayList<>();
        for(Attraction attraction : attractions){
            if(attraction instanceof ISecurity){
                allSecurity.add((ISecurity) attraction);
            }
        }
        for(Stall stall : stalls){
            if(stall instanceof ISecurity){
                allSecurity.add((ISecurity) stall);
            }
        }
        return allSecurity;
    }

    public void visit(Visitor visitor, Attraction attraction){
        visitor.visit(attraction);
        attraction.increaseVisitCount();
    }

    public HashMap<String, Integer> allReviewsHash(){
        HashMap<String, Integer> reviewHash = new HashMap<>();
        for(IReviewed reviewedItem : getAllReviewed()){
            reviewHash.put(reviewedItem.getName(), reviewedItem.getRating());
        }
        return reviewHash;
    }

    public ArrayList<ISecurity> getAllowedFor(Visitor visitor){
        ArrayList<ISecurity> allowedAreas = new ArrayList<>();
        for(ISecurity securePlace : getAllSecurity()){
            if(securePlace.isAllowedTo(visitor)){
                allowedAreas.add(securePlace);
            }
        }
        return allowedAreas;
    }
}
