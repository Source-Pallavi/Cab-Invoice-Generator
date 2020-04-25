package web.bridagelabz.CabInvoiceGenerator;

public class InvoiceSummary {
    private final double averageFare;
    private final int numOfRides;
    private final double totalFare;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides=numOfRides;
        this.totalFare=totalFare;
        this.averageFare=this.totalFare/this.numOfRides;

    }
    @Override
    public boolean equals(Object obj) {
       if(this==obj) return true;
    if (obj==null || getClass()!=obj.getClass()) return false;
    InvoiceSummary that =(InvoiceSummary) obj;
    return numOfRides==that.numOfRides&&
    Double.compare(that.totalFare,totalFare)==0&&
    Double.compare(that.averageFare,averageFare)==0;}


    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
