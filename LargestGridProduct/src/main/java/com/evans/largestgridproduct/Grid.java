package com.evans.largestgridproduct;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 */
public class Grid
{

    private final ArrayList<ArrayList<Integer>> rows;

    Grid(String basicGrid)
    {
        Objects.requireNonNull(basicGrid);
        
        this.rows = new ArrayList<>();
        
        String[] rows = basicGrid.split(",");
        int rowLength = 0;
        
        for (String row : rows) {
            String[] numbers = row.trim().split(" ");
            
            ArrayList<Integer> thisRow = new ArrayList<>(numbers.length);
            
            for (String number : numbers) {
                int parsedInt = Integer.parseInt(number);
                thisRow.add(parsedInt);
            }
            
            if (rowLength != 0 && thisRow.size() != rowLength)
            {
                throw new IllegalArgumentException("not all rows have the same length.");
            }
            
            rowLength = thisRow.size();
            
            this.rows.add(thisRow);
        }
    }

    public int getRows()
    {
        return rows.size();
    }
    
    public int getColumns()
    {
        return rows.get(0).size();
    }

    public DirectionIterator rowIterator()
    {
        return new RowIterator(this);
    }

    DirectionIterator columnIterator()
    {
        return new ColumnIterator(this);
    }

    DirectionIterator southEastIterator()
    {
        return new SouthEastDiagonalIterator(this);
    }

    DirectionIterator southWestIterator()
    {
        return new SouthWestDiagonalIterator(this);
    }

    public interface DirectionIterator
    {
        public boolean hasNext();
        
        public ArrayList<Integer> next();
    }
    
    private class RowIterator implements DirectionIterator
    {

        private final Grid grid;
        private int rowIndex;

        private RowIterator(Grid grid)
        {
            this.grid = grid;
            this.rowIndex = 0;
        }

        @Override
        public boolean hasNext()
        {
            return rowIndex < grid.getRows();
        }

        @Override
        public ArrayList<Integer> next()
        {
            if (!hasNext()) {
                throw new NoSuchElementException("iterating past end of collection.");
            }
            return grid.rows.get(rowIndex++);
        }

    }
    
    private class ColumnIterator implements DirectionIterator
    {

        private final Grid grid;
        private int columnIndex;

        private ColumnIterator(Grid grid)
        {
            this.grid = grid;
            this.columnIndex = 0;
        }

        @Override
        public boolean hasNext()
        {
            return columnIndex < grid.getColumns();
        }

        @Override
        public ArrayList<Integer> next()
        {
            if (!hasNext()) {
                throw new NoSuchElementException("iterating past end of collection.");
            }
            ArrayList<Integer> column = new ArrayList<>(grid.getRows());
            
            for (ArrayList<Integer> row : grid.rows) {
                column.add(row.get(columnIndex));
            }
            
            ++columnIndex;
            return column;
        }

    }
    
    private class SouthEastDiagonalIterator implements DirectionIterator
    {

        private final Grid grid;
        private final int limit;
        private int returned;
        private int currentRow;
        private int currentColumn;

        private SouthEastDiagonalIterator(Grid grid)
        {
            this.grid = grid;
            limit = grid.getRows() + grid.getColumns() - 1;
            returned = 0;
            currentRow = 0;
            currentColumn = grid.getColumns() - 1;
        }

        @Override
        public boolean hasNext()
        {
            return (returned < limit);
        }

        @Override
        public ArrayList<Integer> next()
        {
            if (!hasNext()) {
                throw new NoSuchElementException("iterating past end of collection.");
            }
            
            double columnsSquared = grid.getColumns() * grid.getColumns();
            double rowsSquared = grid.getRows() * grid.getRows();
            int numElements = (int)Math.floor(Math.sqrt(rowsSquared + columnsSquared));
            ArrayList<Integer> numbers = new ArrayList<>(numElements);
         
            for (
                int rowIndex = currentRow, columnIndex = currentColumn;
                rowIndex < grid.getRows() && columnIndex < grid.getColumns();
                ++rowIndex, ++columnIndex
                ) {
                int number = rows.get(rowIndex).get(columnIndex);
                
                numbers.add(number);
            }

            ++returned;

            if (currentColumn > 0) {
                --currentColumn;
            } else {
                ++currentRow;
            }
            
            return numbers;
        }
    }
    
    
    private class SouthWestDiagonalIterator implements DirectionIterator
    {

        private final Grid grid;
        private final int limit;
        private int returned;
        private int currentRow;
        private int currentColumn;

        public SouthWestDiagonalIterator(Grid grid)
        {
            this.grid = grid;
            limit = grid.getRows() + grid.getColumns() - 1;
            returned = 0;
            currentRow = 0;
            currentColumn = 0;
        }

        @Override
        public boolean hasNext()
        {
            return (returned < limit);
        }

        @Override
        public ArrayList<Integer> next()
        {
            if (!hasNext()) {
                throw new NoSuchElementException("iterating past end of collection.");
            }
            
            double columnsSquared = grid.getColumns() * grid.getColumns();
            double rowsSquared = grid.getRows() * grid.getRows();
            int numElements = (int)Math.floor(Math.sqrt(rowsSquared + columnsSquared));
            ArrayList<Integer> numbers = new ArrayList<>(numElements);
         
         
            for (int rowIndex = currentRow, columnIndex = currentColumn; rowIndex < grid.getRows() && columnIndex >= 0; ++rowIndex, --columnIndex) {
                int number = rows.get(rowIndex).get(columnIndex);
                
                numbers.add(number);
            }

            ++returned;

            if ((currentColumn + 1)< grid.getColumns()) {
                ++currentColumn;
            } else {
                ++currentRow;
            }
            
            return numbers;
        }
    }

}
