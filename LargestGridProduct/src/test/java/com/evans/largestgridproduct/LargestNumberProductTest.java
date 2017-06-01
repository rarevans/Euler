
package com.evans.largestgridproduct;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author revans
 */
public class LargestNumberProductTest {

    public LargestNumberProductTest() {
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void ctrAdjacentNumbersMustBeGreaterThanZero()
    {
        thrown.expect(IllegalArgumentException.class);
        
        new LargestNumberProduct(0);
    }

    @Test
    public void checkEmptyNumberSequenceThrows()
    {
        thrown.expect(IllegalArgumentException.class);
        LargestNumberProduct numberProduct = new LargestNumberProduct(2);
        ArrayList<Integer> numberSequence = new ArrayList<>();
        
        numberProduct.check(numberSequence);
    }
    
    @Test
    public void answerOfSingleNumberSequenceIsTheNumber()
    {
        LargestNumberProduct numberProduct = new LargestNumberProduct(2);
        ArrayList<Integer> numberSequence = new ArrayList<>(Arrays.asList(14));
        
        numberProduct.check(numberSequence);
        
        assertThat(numberProduct.answer(), is(equalTo(14L)));
    }
    
    @Test
    public void answerLessThanMaxAdjcentNumbersIsSequenceProduct()
    {
        LargestNumberProduct numberProduct = new LargestNumberProduct(5);
        ArrayList<Integer> numberSequence = new ArrayList<>(Arrays.asList(2, 7, 9));
        
        numberProduct.check(numberSequence);
        
        assertThat(numberProduct.answer(), is(equalTo(126L)));
    }
    
    @Test
    public void answerForZerosIsZero()
    {
        LargestNumberProduct numberProduct = new LargestNumberProduct(5);
        ArrayList<Integer> numberSequence = new ArrayList<>(Arrays.asList(0, 0, 0));
        
        numberProduct.check(numberSequence);
        
        assertThat(numberProduct.answer(), is(equalTo(0L)));
    }
    
    @Test
    public void answerForIntermediateZeroIsZero()
    {
        LargestNumberProduct numberProduct = new LargestNumberProduct(7);
        ArrayList<Integer> numberSequence = new ArrayList<>(Arrays.asList(2, 0, 9));
        
        numberProduct.check(numberSequence);
        
        assertThat(numberProduct.answer(), is(equalTo(0L)));
    }
    
    @Test
    public void answerForMaxAdjacentSequenceIsSequenceProduct()
    {
        LargestNumberProduct numberProduct = new LargestNumberProduct(5);
        ArrayList<Integer> numberSequence = new ArrayList<>(Arrays.asList(2, 7, 9, 4, 19));
        
        numberProduct.check(numberSequence);
        
        assertThat(numberProduct.answer(), is(equalTo(9576L)));
    }
    
    @Test
    public void answerLongerThanMaxAdjacentSequenceIsCorrect()
    {
        LargestNumberProduct numberProduct = new LargestNumberProduct(5);
        ArrayList<Integer> numberSequence = 
                new ArrayList<>(Arrays.asList(2, 7, 9, 1, 3, 19, 3, 5, 7));
        
        numberProduct.check(numberSequence);
        
        assertThat(numberProduct.answer(), is(equalTo(5985L)));
    }
}