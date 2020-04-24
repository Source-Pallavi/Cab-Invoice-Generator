package web.bridagelabz.CabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InvoiceServiceTest {

    InvoiceService invoiceService ;
    @Before
    public void setUp() throws Exception
    {
         invoiceService = new InvoiceService();
    }
    @Test
    public void givenDistanceAndTimeReturn_TotalFare()
    {
       double distance =2.0;
       int time=5;
        double fare= invoiceService.calculateFare(distance,time, InvoiceService.Type.PREMIUM);
        Assert.assertEquals(40,fare,0.0);
    }

    @Test
    public void givenDistance_Time_lessAndReturn_MinFare()
    {
        double distance =0.1;
        int time=1;
        double fare= invoiceService.calculateFare(distance,time, InvoiceService.Type.NORMAL);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_SholdReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5, InvoiceService.Type.NORMAL),
                new Ride(0.1, 1, InvoiceService.Type.PREMIUM)
        };
       InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedinvoiceSummary = new InvoiceSummary(2, 42.0);
        Assert.assertEquals(expectedinvoiceSummary,summary);
    }

    @Test
    public void givenUserIdAndridesShuoldReturnInvoiceSummary()
    {
    String userId="a@b.com";
    Ride[] rides={new Ride(2.0,5, InvoiceService.Type.PREMIUM),
                  new Ride(0.1,1, InvoiceService.Type.NORMAL)
    };
            invoiceService.addRides(userId,rides);
          InvoiceSummary invoiceSummary=  invoiceService.getInvoiceSummary(userId);
          InvoiceSummary expectedInvoiceSummary= new InvoiceSummary(2,30.0);
          Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }
    @Test
    public void genrateBillWhenRideIspremimum()
    { double distance =4;
     int time=7;
     double fare=invoiceService.calculateFare(distance,time, InvoiceService.Type.PREMIUM);
     Assert.assertEquals(74,fare,0.0);
    }
    @Test
    public void givenUserIdAndridesShuoldReturnInvoiceSummary_WhenRideIs_Prime()
    {
        String userId="a@b.com";
        Ride[] rides={new Ride(2.0,5, InvoiceService.Type.PREMIUM),
                new Ride(0.1,1, InvoiceService.Type.NORMAL)
        };
        invoiceService.addRides(userId,rides);
        InvoiceSummary invoiceSummary=  invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary= new InvoiceSummary(2,42.0);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }

}
