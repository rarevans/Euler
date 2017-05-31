package com.evans.largestgridproduct;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author revans
 */
public class GridTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void ctrBasicGridSucceeds()
    {
        String fourByfour
                = "0 4 19 2, 4 78 8 2, 19 14 5 22, 90 7 4 21";

        Grid grid = new Grid(fourByfour);

        assertThat(grid.getRows(), is(equalTo(4)));
        assertThat(grid.getColumns(), is(equalTo(4)));
    }

    @Test
    public void ctrSingleRowSucceeds()
    {
        String singleRowGrid = "0 0 2 12";

        Grid grid = new Grid(singleRowGrid);
        
        assertThat(grid.getRows(), is(equalTo(1)));
        assertThat(grid.getColumns(), is(equalTo(4)));
    }

    @Test
    public void ctrSingleColumnSucceeds()
    {
        String singleColumnGrid = "1, 5, 6, 4, 11";
        
        Grid grid = new Grid(singleColumnGrid);
        
        assertThat(grid.getRows(), is(equalTo(5)));
        assertThat(grid.getColumns(), is(equalTo(1)));
    }
    
    @Test
    public void ctrNullGridStringThrows()
    {
        thrown.expect(NullPointerException.class);

        Grid grid = new Grid(null);
    }

    @Test
    public void ctrEmptyStringThrows()
    {
        thrown.expect(NumberFormatException.class);

        new Grid("");
    }

    @Test
    public void ctrNonDigitsThrows()
    {
        String nonDigitsGrid
                = "12 9 8, 2 A C, 9 1 3";
        thrown.expect(NumberFormatException.class);

        new Grid(nonDigitsGrid);
    }

    @Test
    public void ctrJaggedGridThrows()
    {
        String unevenRowsGrid
                = "0 10 11, 12 4, 9 0 0";
        thrown.expect(IllegalArgumentException.class);

        new Grid(unevenRowsGrid);
    }
}
