package web.bridagelabz.CabInvoiceGenerator;

public class InvoiceService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double MiniMum_Fare=5;
    private static final double MINIMUM_COST_PER_KM_FOR_PRIM =15;
    private static final double COST_PER_TIME_OFPRIM = 2;
    private static final double MINI_FARE_OF_PRIM = 20;

    private RideRepostory rideRepository;


    public InvoiceService()
    { this.rideRepository= new RideRepostory();}

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

    public double calculateFare(double distance, int time,Ride.Type type)
    {double fare;
      if(type==Ride.Type.PREMIUM) {
          return Math.max(distance * MINIMUM_COST_PER_KM_FOR_PRIM + time * COST_PER_TIME_OFPRIM, MINI_FARE_OF_PRIM);
      }
      else{
            return Math.max((distance * MINIMUM_COST_PER_KM )+( time * COST_PER_TIME),MiniMum_Fare);}

    }
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0,fare=0;
        for (Ride ride:rides)
            {
                fare+=(this.calculateFare(ride.distance, ride.time, Ride.Type.PREMIUM));
                fare+=(this.calculateFare(ride.distance, ride.time, Ride.Type.NORMAL));
                System.out.println(fare+"   semi total");
            }
        totalFare=fare;
        System.out.println(totalFare);
        return new InvoiceSummary(rides.length,fare);
    }
}
