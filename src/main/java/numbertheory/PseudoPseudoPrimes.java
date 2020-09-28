package numbertheory;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PseudoPseudoPrimes {
    /**
     * Given a list of integers inList, return a list that contains all
     * the 3-pseudopseudoprimes in inList, sorted in ascending order.
     * If a 3-pseudopseudoprime occurs more than once in inList, it should appear
     * only once in the returned list.
     *
     * @param inList is not null
     * @return a list that contains all the 3-pseudopseudoprimes in inList,
     * sorted in ascending order, and with no duplicates
     */
    /*
        We use Java's streams to process the list. The code is compact.
        We will discuss streams later.
    */
    public static ArrayList<Integer> getAllPPPrimes(ArrayList<Integer> inList) {
        return inList.stream().filter(PseudoPseudoPrimes::isPPPrime).sorted().distinct().collect(
            Collectors.toCollection(ArrayList::new));
    }

    /**
     * Check if n is a PseudoPseudoPrime
     *
     * @param n the number to check for being a PseudoPseudoPrime; n > 0
     * @return true if n is a PseudoPseudoPrime and false otherwise
     */
    private static boolean isPPPrime(int n) {
        if (n == 2 || n == 3 || n == 5) {
            return true;
        }
        for (int a = 3; a <= n; a += 3) {
            for (int b = a + 3; b <= n; b += 3) {
                if (expmod(a, n, n) == a && expmod(b, n, n) == b) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Compute (a^b mod n)
     *
     * @param a the number to compute the exponential of, a >= 0
     * @param b the exponent, b >= 0
     * @param n the size of the field, n > 0
     * @return (a ^ b mod n)
     */
    /* We use fast exponentiation modulo n */
    private static int expmod(int a, int b, int n) {
        int result = 1;
        int currentProduct = a;
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * currentProduct) % n;
            }
            b = b / 2;
            currentProduct = (currentProduct * currentProduct) % n;
        }
        return result;
    }
}