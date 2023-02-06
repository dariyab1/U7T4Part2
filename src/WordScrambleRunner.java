import java.util.ArrayList;
import java.util.Arrays;

public class WordScrambleRunner
{
    public static int passedTests = 0;
    public static int failedTests = 0;

    public static void main(String[] args)
    {
        System.out.println("--------- TEST scrambleWord (part a) ---------");
        String result1 = WordScramble.scrambleWord("TAN");
        testScramble(result1, "TNA", 1);
        String result2 = WordScramble.scrambleWord("ABRACADABRA");
        testScramble(result2, "BARCADABARA", 2);
        String result3 = WordScramble.scrambleWord("WHOA");
        testScramble(result3, "WHOA", 3);
        String result4 = WordScramble.scrambleWord("AARDVARK");
        testScramble(result4, "ARADVRAK", 4);
        String result5 = WordScramble.scrambleWord("EGGS");
        testScramble(result5, "EGGS", 5);
        String result6 = WordScramble.scrambleWord("A");
        testScramble(result6, "A", 6);
        String result7 = WordScramble.scrambleWord("");
        testScramble(result7, "", 7);

        System.out.println("--------- TEST scrambleOrRemove (part b) ---------");
        ArrayList<String> testWordList = new ArrayList<String>(Arrays.asList("TAN", "ABRACADABRA", "WHOA", "APPLE", "EGGS"));
        WordScramble.scrambleOrRemove(testWordList);
        ArrayList<String> expectedAfterScrambleRemove = new ArrayList<String>(Arrays.asList("TNA", "BARCADABARA", "PAPLE"));
        testScrambleRemove(testWordList, expectedAfterScrambleRemove, 8);
        System.out.println("--------------------------------------------------");
        int totalTests = passedTests + failedTests;
        System.out.println("TOTAL PASSED TESTS: " + passedTests + " out of " + totalTests);
        System.out.println("TOTAL FAILED TESTS: " + failedTests + " out of " + totalTests);
    }

    public static void testScramble(String actual, String expected, int testNo)
    {
        System.out.print("TEST #" + testNo + " -- ");
        if (actual.equals(expected))
        {
            System.out.println("PASS!");
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

    public static void testScrambleRemove(ArrayList<String> actual, ArrayList<String> expected, int testNo)
    {
        boolean equalLists = true;
        if (actual.size() != expected.size())
        {
            equalLists = false;
        }
        else
        {
            for (int i = 0; i < actual.size(); i++)
            {
                if (!actual.get(i).equals(expected.get(i)))
                {
                    equalLists = false;
                }
            }
        }

        System.out.print("TEST #" + testNo + " -- ");
        if (equalLists)
        {
            System.out.println("PASS!");
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