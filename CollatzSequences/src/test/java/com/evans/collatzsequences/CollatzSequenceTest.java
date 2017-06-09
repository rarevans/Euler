
package com.evans.collatzsequences;

import com.evans.collatzsequences.CollatzSequence.Answer;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author revans
 */
public class CollatzSequenceTest {

    @Test
    public void sequenceFor1()
    {
        ArrayList<Long> expected = 
            new ArrayList<>(Arrays.asList(1L));
        
        ArrayList<Long> sequence = CollatzSequence.of(1);
        
        assertThat(sequence, is(equalTo(expected)));
    }
    
    @Test
    public void sequenceFor3()
    {
        ArrayList<Long> expected = 
            new ArrayList<>(Arrays.asList(3L, 10L, 5L, 16L, 8L, 4L, 2L, 1L));

        ArrayList<Long> sequence = CollatzSequence.of(3);

        assertThat(sequence, is(equalTo(expected)));
    }
    
    @Test
    public void sequenceFor13()
    {
        ArrayList<Long> expected = 
            new ArrayList<>(Arrays.asList(13L, 40L, 20L, 10L, 5L, 16L, 8L, 4L, 2L, 1L));

        ArrayList<Long> sequence = CollatzSequence.of(13);
        
        assertThat(sequence, is(equalTo(expected)));
    }
    
    @Test
    public void staticCollatzSequenceLength()
    {
        assertThat(CollatzSequence.lengthFor(1), is(equalTo(1)));
        assertThat(CollatzSequence.lengthFor(3), is(equalTo(8)));
        assertThat(CollatzSequence.lengthFor(13), is(equalTo(10)));
    }
    
    @Test
    public void cachedLongestSequenceBelowOneMillion()
    {
        int oneMillion = 1 * 1000 * 1000;
        CollatzSequence sequence = new CollatzSequence();
        
        Answer answer = sequence.longestBelow(oneMillion);
        
        assertThat(answer.getNumber(), is(equalTo(837799)));
        assertThat(answer.getLength(), is(equalTo(525)));
    }
    
    @Test
    public void explicitlyCalculateLongestSequenceBelowOneMillion()
    {
        int longestSequence = 1;
        int bestNumber = 1;
        int limit = 1 * 1000 * 1000;
        
        for (int candidate = 2; candidate < limit; ++candidate) {
            int length = CollatzSequence.lengthFor(candidate);
            if (length > longestSequence) {
                longestSequence = length;
                bestNumber = candidate;
            }
        }
        
        assertThat(bestNumber, is(equalTo(837799)));
        assertThat(longestSequence, is(equalTo(525)));
    }

}