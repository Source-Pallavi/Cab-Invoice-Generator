package web.bridagelabz.CabInvoiceGenerator;

public class Ride {
    public final double distance;
    public final int time;
    public InvoiceService.Type type;

    public Ride(double distance, int time, InvoiceService.Type type) {
        this.distance=distance;
        this.time=time;
        this.type=type;

    }

}
