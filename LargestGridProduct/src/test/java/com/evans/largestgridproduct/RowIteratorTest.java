package com.evans.largestgridproduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author revans
 */
public class RowIteratorTest
{
    private final Grid oneRow;
    private final Grid fourRows;

    public RowIteratorTest()
    {
        oneRow = new Grid("12 8 94 200");
        fourRows = new Grid("1 2, 3 4, 5 6, 7 8");
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void oneRowGridFirstHasNextIsTrue()
    {
        Grid.DirectionIterator iterator = oneRow.rowIterator();
        
        assertTrue(iterator.hasNext());
    }

    @Test
    public void hasNextIsFalseForOneRowAfterNext()
    {
        Grid.DirectionIterator iterator = oneRow.rowIterator();
        iterator.next();
        
        assertFalse(iterator.hasNext());
    }
    
    @Test
    public void nextThrowsAfterLastRow()
    {
        Grid.DirectionIterator iterator = oneRow.rowIterator();
        thrown.expect(NoSuchElementException.class);
        
        iterator.next();
        iterator.next();
    }
    
    @Test
    public void firstNumbersOfOneRowMatch()
    {
        final ArrayList<Integer> expectedRow = 
                new ArrayList<>(Arrays.asList(12, 8, 94, 200));
        Grid.DirectionIterator iterator = oneRow.rowIterator();
        
        ArrayList<Integer> firstRow = iterator.next();

        assertThat(firstRow, is(equalTo(expectedRow)));
    }
    
    @Test
    public void hasNextFalseAfterFourNextOnFourRowGrid()
    {
        final ArrayList<Integer> expectedRow = 
                new ArrayList<>(Arrays.asList(7, 8));
        Grid.DirectionIterator iterator = fourRows.rowIterator();
        
        iterator.next();
        iterator.next();
        iterator.next();
        ArrayList<Integer> finalRow = iterator.next();
        
        assertFalse(iterator.hasNext());
        assertThat(finalRow, is(equalTo(expectedRow)));
    }

}
