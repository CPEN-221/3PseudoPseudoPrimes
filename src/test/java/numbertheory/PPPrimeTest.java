package numbertheory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PPPrimeTest {

    /* The input list is empty */
    @Test
    public void test_EmptyList() {
        // empty list
        List<Integer> outList =
            PseudoPseudoPrimes.getAllPPPrimes(new ArrayList<Integer>(Arrays.asList()));
        assertEquals(Arrays.asList(), outList);
    }


    /* The input list contains only one entry and that entry is not a 3-ppprime */
    @Test
    public void test_OneNotPPPrime() {
        List<Integer> outList =
            PseudoPseudoPrimes.getAllPPPrimes(new ArrayList<Integer>(Arrays.asList(12)));
        assertEquals(Arrays.asList(), outList);
    }

    /* The input list contains only one entry and that entry is a 3-ppprime */
    @Test
    public void test_OnePPPrime() {
        List<Integer> outList =
            PseudoPseudoPrimes.getAllPPPrimes(new ArrayList<Integer>(Arrays.asList(49)));
        assertEquals(Arrays.asList(49), outList);
    }

    /* The input list contains multiple numbers, a few of which are 3-ppp */
    @Test
    public void test_LongListAFewPPPrimes() {
        List<Integer> outList = PseudoPseudoPrimes
            .getAllPPPrimes(new ArrayList<Integer>(Arrays.asList(1, 5, 7, 9, 14, 49, 65)));
        assertEquals(Arrays.asList(5, 7, 49, 65), outList);
    }

    /* The input list contains multiple numbers, none of which are 3-ppp */
    @Test
    public void test_LongListNoPPPPrimes() {
        List<Integer> outList = PseudoPseudoPrimes
            .getAllPPPrimes(new ArrayList<Integer>(Arrays.asList(-1, 10, 12, 100, 200)));
        assertEquals(Arrays.asList(), outList);
    }

    /* The input list contains multiple numbers, all of which are 3-ppp, and has some duplicate entries */
    @Test
    public void test_AllPPPrimesWithDuplicates() {
        List<Integer> outList = PseudoPseudoPrimes
            .getAllPPPrimes(new ArrayList<Integer>(Arrays.asList(73, 79, 85, 85)));
        assertEquals(Arrays.asList(73, 79, 85), outList);
    }

    /* The input list is unsorted and contains multiple numbers, a few of which are 3-ppp */
    @Test
    public void test_LongUnsortedListAFewPPPrimes() {
        List<Integer> outList = PseudoPseudoPrimes
            .getAllPPPrimes(new ArrayList<Integer>(Arrays.asList(49, 14, 2, 7, 1, 65, 9)));
        assertEquals(Arrays.asList(2, 7, 49, 65), outList);
    }

    /* The input list is sorted in the reverse order and contains multiple numbers, a few of which are 3-ppp */
    @Test
    public void test_LongDescendingListAFewPPPrimes() {
        List<Integer> outList = PseudoPseudoPrimes
            .getAllPPPrimes(new ArrayList<Integer>(Arrays.asList(65, 49, 14, 9, 7, 2, 1)));
        assertEquals(Arrays.asList(2, 7, 49, 65), outList);
    }

    /* The input list has elements in random order, some are PPPrimes, and the list contains duplicates */
    @Test
    public void test_General() {
        List<Integer> outList = PseudoPseudoPrimes.getAllPPPrimes(new ArrayList<Integer>(
            Arrays.asList(3, 1, 27, 19, 13, 109, 109, 13, 3, 255, 12, 93, 255, 12, 27)));
        assertEquals(Arrays.asList(3, 13, 19, 93, 109, 255), outList);
    }
}
