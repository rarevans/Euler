package com.evans.sumofprimes;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author revans
 */
public class SumOfPrimesTest
{
    @Test
    public void SumOfPrimes_LessThan10_Correct()
    {
        SumOfPrimes sumOfPrimes = new SumOfPrimes();
        
        long sum = sumOfPrimes.sumLessThan(10);
        
        assertThat(sum, is(equalTo(17L)));
    }
    
    @Test
    public void SumOfPrimes_LessThan20_IsCorrect()
    {
        SumOfPrimes sumOfPrimes = new SumOfPrimes();
        
        long sum = sumOfPrimes.sumLessThan(20);
        
        assertThat(sum, is(equalTo(77L)));
    }
        
    @Test
    public void SumOfPrimes_LessThan30_IsCorrect()
    {
        SumOfPrimes sumOfPrimes = new SumOfPrimes();
        
        long sum = sumOfPrimes.sumLessThan(30);
        
        assertThat(sum, is(equalTo(129L)));
    }
        
    @Test
    public void SumOfPrimes_LessThan2000_IsCorrect()
    {
        SumOfPrimes sumOfPrimes = new SumOfPrimes();
        
        long sum = sumOfPrimes.sumLessThan(2000);
        
        assertThat(sum, is(equalTo(277050L)));
    }
    
    @Test
    public void SumOfPrimes_LessThan2million_IsCorrect()
    {
        SumOfPrimes sumOfPrimes = new SumOfPrimes();
        
        long sum = sumOfPrimes.sumLessThan(2000000);
        
        assertThat(sum, is(equalTo(142913828922L)));
    }
}
