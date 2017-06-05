
package com.evans.triangularnumberfactors;

import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import org.junit.*;

/**
 *
 * @author revans
 */
public class FactorsTest {

    public FactorsTest() {
    }

    @Test
    public void factorsOf10()
    {
        ArrayList<Long> expectedFactors = new ArrayList<>(Arrays.asList(1L, 2L, 5L, 10L));
        
        ArrayList<Long> factors = Factors.of(10L);
        
        assertThat(factors, is(equalTo(expectedFactors)));
    }

    @Test
    public void factorsOf28()
    {
        ArrayList<Long> expectedFactors
                = new ArrayList<>(Arrays.asList(1L, 2L, 4L, 7L, 14L, 28L));
        
        ArrayList<Long> factors = Factors.of(28L);
        
        assertThat(factors, is(equalTo(expectedFactors)));
    }

    @Test
    public void factorsOf12375()
    {
        // 76576500
        ArrayList<Long> factors = Factors.of(SumOfN.is(12375L));
        
        assertThat(factors.size(), is(equalTo(576)));
    }

    @Test
    public void moreThan500Factors()
    {
        long n = 0L;
        ArrayList<Long> factors = new ArrayList<>();

        while (factors.size() < 500) {
            ++n;
            long sumOfN = SumOfN.is(n);
            factors = Factors.of(sumOfN);
        }
        
        assertThat(factors.size(), is(equalTo(576)));
        assertThat(n, is(equalTo(12375L)));
    }
}