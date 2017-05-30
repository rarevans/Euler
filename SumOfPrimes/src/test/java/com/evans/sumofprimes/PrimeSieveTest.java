package com.evans.sumofprimes;

import java.util.ArrayList;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author revans
 */
public class PrimeSieveTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void Ctr_Succeeds()
    {
        new PrimeSieve();
    }
    
    @Test
    public void GetPrimes_NotEmpty()
    {
        PrimeSieve sieve = new PrimeSieve();
        
        ArrayList<Integer> primes = sieve.getPrimes();

        assertFalse(primes.isEmpty());
    }
    
    @Test
    public void IsPrime_12_IsFalse()
    {
        PrimeSieve sieve = new PrimeSieve();
        
        assertFalse(sieve.IsPrime(12));
    }
    
    @Test
    public void IsPrime_11_IsTrue()
    {
        PrimeSieve sieve = new PrimeSieve();
        
        assertTrue(sieve.IsPrime(11));
    }
    
    @Test
    public void IsPrime_997_IsTrue()
    {
        PrimeSieve sieve = new PrimeSieve();
        
        assertTrue(sieve.IsPrime(997));
    }
    
    @Test
    public void IsPrime_104743_IsPrime()
    {
        PrimeSieve sieve = new PrimeSieve();
        
        assertTrue(sieve.IsPrime(104743));
    }
    
    @Test
    public void IsPrime_104741_IsPrime()
    {
        PrimeSieve sieve = new PrimeSieve();
        
        assertFalse(sieve.IsPrime(104741));
    }
 
}
