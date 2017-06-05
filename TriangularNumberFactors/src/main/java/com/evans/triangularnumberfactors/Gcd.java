
package com.evans.triangularnumberfactors;

/**
 *
 */
public class Gcd {

    static long gcd(long a, long b)
    {
        return gcdRemainder(a, b);
    }
    
    private static long gcdRemainder(long a, long b)
    {
        if (a < b) {
            long c = a;
            a = b;
            b = c;
        }
        long temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private static long gcdSubtraction(long a, long b)
    {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

}
