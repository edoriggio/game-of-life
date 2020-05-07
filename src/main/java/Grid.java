package src.main.java;

import java.util.LinkedList;
import java.util.List;

public class Grid {
    private Cell[][] grid;
    private final int[] rule_row;
    private final int[] rule_col;
    private final int rows;
    private final int cols;

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

    public void killAllCells() {
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                grid[row][col].kill();
            }
        }
    }

    public void put(Cell cell, int row, int col) {
        grid[row][col] = cell;
    }

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
