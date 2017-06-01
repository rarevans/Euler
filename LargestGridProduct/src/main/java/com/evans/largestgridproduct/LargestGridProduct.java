
package com.evans.largestgridproduct;

import java.util.ArrayList;

/**
 *
 */
public class LargestGridProduct {

    private final int numAdjacentNumbers;
    private final Grid grid;

    LargestGridProduct(int numAdjacentNumbers, Grid grid)
    {
        this.numAdjacentNumbers = numAdjacentNumbers;
        this.grid = grid;

    }

    long Largest()
    {
        ArrayList<Grid.DirectionIterator> iterators = new ArrayList<>();

        iterators.add(grid.rowIterator());
        iterators.add(grid.columnIterator());
        iterators.add(grid.southEastIterator());
        iterators.add(grid.southWestIterator());
        
        LargestNumberProduct numberProduct = new LargestNumberProduct(numAdjacentNumbers);

        for (Grid.DirectionIterator direction : iterators) {

            while (direction.hasNext()) {
                ArrayList<Integer> nextSequence = direction.next();
                numberProduct.check(nextSequence);
            }
        }
        
        return numberProduct.answer();
    }

}
