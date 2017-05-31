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
public class ColumnIteratorTest
{

    private final Grid oneColumn;
    private final Grid fourColumn;
    
    public ColumnIteratorTest()
    {
        this.oneColumn = new Grid("1, 2, 3, 4");
        this.fourColumn = new Grid("1 3 5 7, 2 4 6 8");
    }
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void oneColumnGridhasNextIsTrue()
    {
        Grid.DirectionIterator iterator = oneColumn.columnIterator();
        
        assertTrue(iterator.hasNext());
    }
    
    @Test
    public void hasNextIsFalseForOneColumnAfterNext()
    {
        Grid.DirectionIterator iterator = oneColumn.columnIterator();
        
        iterator.next();
        
        assertFalse(iterator.hasNext());
    }
    
    @Test
    public void nextThrowsAfterLastColumn()
    {
        thrown.expect(NoSuchElementException.class);
        Grid.DirectionIterator iterator = oneColumn.columnIterator();
        
        iterator.next();
        iterator.next();
    }
    
    @Test
    public void firstNumbersOfOneColumnGridMatch()
    {
        final ArrayList<Integer> expectedColumn =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Grid.DirectionIterator iterator = oneColumn.columnIterator();
        
        ArrayList<Integer> column = iterator.next();
        
        assertThat(column, is(equalTo(expectedColumn)));
    }
    
    @Test
    public void hasNextFalseAfterFourNextOnFourColumnGrid()
    {
        final ArrayList<Integer> expectedColumn =
                new ArrayList<>(Arrays.asList(7, 8));
        Grid.DirectionIterator iterator = fourColumn.columnIterator();
        iterator.next();
        iterator.next();
        iterator.next();

        ArrayList<Integer> finalColumn = iterator.next();
        
        assertFalse(iterator.hasNext());
        assertThat(finalColumn, is(equalTo(expectedColumn)));
    }
}
