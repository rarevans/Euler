
package com.evans.largestgridproduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.evans.largestgridproduct.Grid.DirectionIterator;

/**
 *
 * @author revans
 */
public class SouthWestDiagonalIteratorTest {

    private final Grid oneColumn;
    private final Grid fourByFour;
    private final Grid oneRow;
    private final Grid oneByOne;
    
    public SouthWestDiagonalIteratorTest()
    {
        oneColumn = new Grid("1, 2, 3, 4");
        fourByFour = new Grid("1 3 5 7, 2 4 6 8, 3 6 9 12, 4 8 12 16");
        oneRow = new Grid("1 2 3 4");
        oneByOne = new Grid("11");
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void oneRowGridHasNextIsTrue()
    {
        DirectionIterator iterator = oneRow.southWestIterator();
        
        assertTrue(iterator.hasNext());
    }
    
    @Test
    public void hasNextFalseAfterLastNumbers()
    {
        DirectionIterator iterator = oneByOne.southWestIterator();
        iterator.next();
        
        assertFalse(iterator.hasNext());
    }
    
    @Test
    public void nextThrowsAfterLastNumbers()
    {
        thrown.expect(NoSuchElementException.class);
        DirectionIterator iterator = oneByOne.southWestIterator();
        iterator.next();
        
        iterator.next();
    }

    @Test
    public void oneRowGridFirstNextCallMatchesFirstNumber()
    {
        ArrayList<Integer> expectedNumbers = new ArrayList<>(Arrays.asList(1));
        DirectionIterator iterator = oneRow.southWestIterator();
        
        ArrayList<Integer> numbers = iterator.next();
        
        assertThat(numbers, is(equalTo(expectedNumbers)));
    }
    
    @Test
    public void oneRowGridLastNextCallMatchesLastNumber()
    {
        ArrayList<Integer> expectedNumbers = new ArrayList<>(Arrays.asList(4));
        DirectionIterator iterator = oneRow.southWestIterator();
        iterator.next();
        iterator.next();
        iterator.next();
        
        ArrayList<Integer> numbers = iterator.next();
        
        assertThat(numbers, is(equalTo(expectedNumbers)));
    }
    
    @Test
    public void oneColumnGridFirstNextCallMatchesFirstNumber()
    {
        ArrayList<Integer> expectedNumbers = new ArrayList<>(Arrays.asList(1));
        DirectionIterator iterator = oneColumn.southWestIterator();
        
        ArrayList<Integer> numbers = iterator.next();
        
        assertThat(numbers, is(equalTo(expectedNumbers)));
    }
    
    @Test
    public void oneColumnGridLastNextCallMatchesLastNumber()
    {
        ArrayList<Integer> expectedNumbers = new ArrayList<>(Arrays.asList(4));
        DirectionIterator iterator = oneColumn.southEastIterator();
        iterator.next();
        iterator.next();
        iterator.next();
        
        ArrayList<Integer> numbers = iterator.next();
        
        assertThat(numbers, is(equalTo(expectedNumbers)));
    }
    
    @Test
    public void squareGridSecondNextMatches()
    {
        ArrayList<Integer> expectedNumbers = 
                new ArrayList<>(Arrays.asList(3, 2));
        DirectionIterator iterator = fourByFour.southWestIterator();
        iterator.next();
        
        ArrayList<Integer> numbers = iterator.next();
        
        assertThat(numbers, is(equalTo(expectedNumbers)));
    }
    
    @Test
    public void squareGridMiddleDiagonalMatches()
    {
        ArrayList<Integer> expectedNumbers = 
                new ArrayList<>(Arrays.asList(7, 6, 6, 4));
        DirectionIterator iterator = fourByFour.southWestIterator();
        iterator.next();
        iterator.next();
        iterator.next();
        
        ArrayList<Integer> numbers = iterator.next();
        
        assertThat(numbers, is(equalTo(expectedNumbers)));
    }
            
    @Test
    public void squareGridLastNextIsFinalNumber()
    {
        ArrayList<Integer> expectedNumbers = new ArrayList<>(Arrays.asList(16));
        DirectionIterator iterator = fourByFour.southWestIterator();
        for (int rows = 1; rows <= 6; ++rows) {
            iterator.next();
        }
        
        ArrayList<Integer> numbers = iterator.next();
        
        assertThat(numbers, is(equalTo(expectedNumbers)));
    }
            
}