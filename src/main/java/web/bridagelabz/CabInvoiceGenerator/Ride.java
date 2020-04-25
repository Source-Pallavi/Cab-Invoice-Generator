package web.bridagelabz.CabInvoiceGenerator;

public class Ride {
    public final double distance;
    public final int time;
    private final Ride.Type type;

    public enum Type{
        NORMAL, PREMIUM;
    }
    public Ride(double distance, int time, Ride.Type type) {
        this.distance=distance;
        this.time=time;
        this.type=type;

    }

}
