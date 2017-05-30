package com.evans.sumofprimes;


import java.util.ArrayList;

/**
 *
 */
public class PrimeSieve {

    private final int field;
    private int offset;
    private int greatest;
    private ArrayList<Integer> primes;

    public ArrayList<Integer> getPrimes()
    {
        return primes;
    }
    
    public PrimeSieve()
    {
        field = 1000;
        offset = 0;
        greatest = 0;
        prepPrimes();
    }

    private void prepPrimes()
    {
        primes = new ArrayList<>(startingPrimes.length);

        for (int prime : startingPrimes) {
            primes.add(prime);
        }
        greatest = 997;
        
        offset += field;
    }
    
    private static final int[] startingPrimes = 
    {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
        43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
        101, 103, 107, 109, 113, 127, 131, 137, 139, 149,
        151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
        199, 211, 223, 227, 229, 233, 239, 241, 251, 257,
        263, 269, 271, 277, 281, 283, 293, 307, 311, 313,
        317, 331, 337, 347, 349, 353, 359, 367, 373, 379,
        383, 389, 397, 401, 409, 419, 421, 431, 433, 439,
        443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
        503, 509, 521, 523, 541, 547, 557, 563, 569, 571,
        577, 587, 593, 599, 601, 607, 613, 617, 619, 631,
        641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
        701, 709, 719, 727, 733, 739, 743, 751, 757, 761,
        769, 773, 787, 797, 809, 811, 821, 823, 827, 829,
        839, 853, 857, 859, 863, 877, 881, 883, 887, 907,
        911, 919, 929, 937, 941, 947, 953, 967, 971, 977,
        983, 991, 997
    };
    
    public void FindMore()
    {
        ArrayList<Integer> candidates = new ArrayList<>();
        
        for (int index = 0; index < field; ++index) {
            int candidate = index + offset;
            int root = (int) Math.sqrt(candidate) + 1;
            
            boolean found = false;

            for (Integer prime : primes) {
                if (prime >= root) {
                    break;
                }
                
                if ((candidate % prime) == 0) {
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                greatest = candidate;
                candidates.add(candidate);
            }
        }
        
        primes.addAll(candidates);
        offset += field;
    }
    
    public boolean IsPrime(int candidate)
    {
        return IsPrime(0, candidate);
    }
    
    private boolean IsPrime(int checkedPrimeIndex, int candidate)
    {
        for (int index = checkedPrimeIndex; index < primes.size(); ++index) {
            int prime = primes.get(index);

            if (prime == candidate)
            {
                return true;
            }
            
            if ((candidate % prime) == 0)
            {
                return false;
            }
        }
        
        int knownPrimes = primes.size();
        
        FindMore();
        
        return IsPrime(knownPrimes, candidate);
    }

    int getGreatest()
    {
        return greatest;
    }


}
