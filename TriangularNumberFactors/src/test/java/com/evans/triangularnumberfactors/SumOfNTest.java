
package com.evans.triangularnumberfactors;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author revans
 */
@RunWith(Parameterized.class)
public class SumOfNTest {

    @Parameterized.Parameters
    public static Collection sumNAnswers() {
        return Arrays.asList(new Object[][]{
            {1L, 1L},
            {2L, 3L},
            {3L, 6L},
            {4L, 10L},
            {5L, 15L},
            {6L, 21L},
            {7L, 28L}
        });
    }
    private final Long n;
    private final Long nSum;
    
    public SumOfNTest(Long n, Long nSum)
    {
        this.n = n;
        this.nSum = nSum;
    }
    
    @Test
    public void testSumOf1toN()
    {
        long sumOfN = SumOfN.is(n);
        
        assertThat(sumOfN, is(equalTo(nSum)));
    }

}