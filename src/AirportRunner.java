import java.util.ArrayList;
import java.util.Arrays;

public class AirportRunner
{
    public static int passedTests = 0;
    public static int failedTests = 0;

    public static void main(String[] args)
    {
        // setup test Flight arraylist and capitalHub
        Flight f0 = new Flight(25, 50.00, 30);
        Flight f1 = new Flight(10, 100.50, 60);
        Flight f2 = new Flight(50, 200.00, 40);
        Flight f3 = new Flight(20, 100.00, 120);
        ArrayList<Flight> allFlights = new ArrayList<Flight>(Arrays.asList(f0, f1, f2, f3));
        Airport capitalHub = new Airport(allFlights);

        System.out.println("--------- TEST getTotalRevenue (part a) ---------");
        double revenue = capitalHub.getTotalRevenue();
        testRevenue(revenue, 12255.0, 1);

        System.out.println("--------- TEST updateFlights (part b) ---------");
        int passengersWithRemovedFlights = capitalHub.updateFlights();
        testUpdate(passengersWithRemovedFlights, 30, 2);

        ArrayList<Flight> expectedAllFlightsPostUpdate = new ArrayList<Flight>(Arrays.asList(f0, f2));
        ArrayList<Flight> actualAllFlightsPostUpdate = capitalHub.getAllFlights();
        testUpdateFlights(actualAllFlightsPostUpdate, expectedAllFlightsPostUpdate, 3);
        System.out.println("Note for TEST #3: the arraylist should contain two Flight objects");
        System.out.println("   (their memory addresses) that refer to f0 and f2 created above");
        System.out.println("--------------------------------------------------");
        System.out.println("TOTAL PASSED TESTS: " + passedTests + " out of 3");
        System.out.println("TOTAL FAILED TESTS: " + failedTests + " out of 3");
    }

    public static void testRevenue(double actual, double expected, int testNo)
    {
        System.out.print("TEST #" + testNo + " -- ");
        if (actual == expected)
        {
            System.out.println("PASS");
            passedTests++;
        }
        else
        {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expected);
        System.out.println("   Actual: " + actual);
    }

    public static void testUpdate(int actual, int expected, int testNo)
    {
        System.out.print("TEST #" + testNo + " -- ");
        if (actual == expected)
        {
            System.out.println("PASS");
            passedTests++;
        }
        else
        {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expected);
        System.out.println("   Actual: " + actual);
    }

    public static void testUpdateFlights(ArrayList<Flight> actual, ArrayList<Flight> expected, int testNo)
    {
        System.out.print("TEST #" + testNo + " -- ");
        if (actual.equals(expected))
        {
            System.out.println("PASS");
            passedTests++;
        }
        else
        {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expected);
        System.out.println("   Actual: " + actual);
    }
}