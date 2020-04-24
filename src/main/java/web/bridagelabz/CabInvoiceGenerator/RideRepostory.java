package web.bridagelabz.CabInvoiceGenerator;

import java.util.*;

public class RideRepostory {
    Map<String, ArrayList<Ride>> userRides= null;

    public RideRepostory(/*Map<String, ArrayList<Ride>> userRides*/) {
        this.userRides =new HashMap<>();
    }



    public void addRides(String userId,Ride[] rides)
    {
//        ArrayList<Ride> rideList =this.userRides.get(userId);
//        if (rideList==null)
//        {
            this.userRides.put(userId,new ArrayList<>(Arrays.asList(rides)));
//        }
    }
    public Ride[] getRides(String userId)
    {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
