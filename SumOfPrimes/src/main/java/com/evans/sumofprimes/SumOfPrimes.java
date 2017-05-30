package com.evans.sumofprimes;

/**
 *
 */
public class SumOfPrimes {

    private PrimeSieve sieve;

    public SumOfPrimes()
    {
        sieve = new PrimeSieve();
    }
    
    long sumLessThan(int i)
    {
        while (sieve.getGreatest() < i) {
            sieve.FindMore();
        }
        
        long sum = 0L;
        
        for (Integer prime : sieve.getPrimes()) {
            if (prime >= i)
                break;
            sum += prime;
        }
        
        return sum;
    }

}
