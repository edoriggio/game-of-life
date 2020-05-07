package src.main.java;

import java.util.LinkedList;
import java.util.List;

public class Grid {
    private Cell[][] grid;
    private final int[] rule_row;
    private final int[] rule_col;
    private int rows;
    private int cols;

    public Grid(int row, int col) {
        grid = new Cell[row][col];
        // vectors to represents neighbors
        // north, south, east, west
        rule_row = new int[]{-1, +1, 0, 0};
        rule_col = new int[]{0, 0, +1, -1};

        cols = col - 1;
        rows = row - 1;
        randomlyPopulateGrid();
    }

    /**
     * Randomly set each position of the grid to have an alive or dead cell.
     */
    private void randomlyPopulateGrid() {
        int rand;
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                rand = (int)(Math.random()*10);
                grid[row][col] = new Cell(rand > 5);
            }
        }
    }

    /**
     * Make all cells in the grid die.
     */
    public void killAllCells() {
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                grid[row][col].kill();
            }
        }
    }

    /**
     * Put the given Cell at the given position.
     * @param cell the cell to put
     * @param row the row where to put the Cell
     * @param col the column where to put the Cell
     */
    public void put(final Cell cell, final int row, final int col) {
        grid[row][col] = cell;
    }

    /**
     * Checks whether the given position is a valid position for this grid, meaning that
     * it is not out of bounds.
     * @param row the row of the position to check
     * @param col the column of the position to check
     * @return true if the position is valid, false otherwise.
     */
    private boolean inRange(final int row, final int col) {
        return (row >= 0 && col >= 0 && col <= cols && row <= rows);
    }

    private LinkedList<int[]> getNeighbors(final int row, final int col) {
        LinkedList<int[]> result = new LinkedList<>();
        int rr;
        int cc;
        for (int i = 0; i < rule_row.length; i++) {
            rr = row + rule_row[i];
            cc = col + rule_col[i];

            if (inRange(rr, cc)) {
                result.add(new int[]{rr, cc});
            }
        }

        return result;
    }

    /**
     * Get the number of neighbouring cells that are alive.
     * @param row the row position
     * @param col the column position
     * @return the number of neighbouring cell that are alive
     */
    public int getNumberOfNeighbors(final int row, final int col) {
        int counter = 0;
        int rr;
        int cc;

        for (int i = 0; i < rule_row.length; i++) {
            rr = row + rule_row[i];
            cc = col + rule_col[i];
            if (inRange(rr, cc)) {
                if (grid[rr][cc].isAlive()) {
                    counter += 1;
                }
            }
        }

        return counter;
    }

    /**
     * Modify the given Grid of cells according to the status of the Grid calling the method.
     * @param gridToUpdate the grid that will be modified
     */
    public void calculateNext(Grid gridToUpdate) {
        // modify gridToUpdate depending on this grid
        // that means for each position in this grid, compute the number
        // of neighbors and depending of this number chose if the new cell must
        // die/stay alive/live
    }

    public void room(int zoom) {
        if (zoom > 0) {
            zoomOutBy(zoom);
        } else if (zoom < 0) {
            zoomInBy(zoom);
        } else {
            //if zoom 0 do nothing
            return;
        }
    }

    //TODO bugged if zoom greater than 1
    // lowest rows are not copied
    private void zoomOutBy(int zoom) {
        int nextRowSize = rows+1 + 2*zoom;
        int nextColSize = cols+1 + 2*zoom;
        Cell[][] newGrid = new Cell[nextRowSize][nextColSize];
        // copy old grid into the new one with the offset of the zoom
        for (int row = 0; row < nextRowSize; row++) {
            for (int col = 0; col < nextColSize; col++) {
                //if we are in the new area being created, just put a dead Cell
                if (row < zoom || col < zoom || row > rows+1 || col > cols+1) {
                    //System.out.println("OUT "+row+" "+col);
                    newGrid[row][col] = new Cell(false);
                } else {
                    // otherwise copy the old grid
                    newGrid[row][col] = grid[row-zoom][col-zoom];
                }
            }
        }
        grid = newGrid;
        rows = nextRowSize-1;
        cols = nextColSize-1;
    }

    private void zoomInBy(int zoom) {
        //TODO implement zoom-in
    }

    /**
     * Print all neighbouring positions of the given cell.
     * @param row the row of the cell
     * @param col the column of the cell
     */
    public void printNeighbors(final int row, final int col) {
        for (int[] pair : getNeighbors(row, col)) {
            System.out.println(pair[0] + " " + pair[1]);

        }
    }

    /**
     * Print this Grid in the standard output.
     */
    public void printGrid() {
        char toPrint;
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                toPrint = (grid[row][col] != null && grid[row][col].isAlive()) ? 'O' : 'X';
                System.out.print(toPrint+" ");
            }

            System.out.println();
        }
    }
}
