
package com.evans.triangularnumberfactors;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 */
public class Factors {

    static ArrayList<Long> of(long n)
    {
        TreeSet<Long> factors = new TreeSet<>();
        factors.add(1L);
        
        for (long i = 2; i <= n/2; ++i) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        factors.add(n);
        
        return new ArrayList<>(factors);
    }
    

}
