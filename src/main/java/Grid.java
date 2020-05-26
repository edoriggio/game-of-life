package src.main.java;

/**
 * The Grid class is used to create a bi-dimensional array.
 * This array is composed of cells.
 *
 * @author Edoardo Riggio
 */
public class Grid {

    public final Cell[][] grid;
    private final int rows;
    private final int columns;

    /**
     * Constructor for a grid of dead cells.
     * @param rows The number of rows of the grid
     * @param columns The number of columns of the grid
     */
    public Grid(final int rows, final int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Cell[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = new Cell(State.DEAD);
            }
        }
    }

    /**
     * Given an x and y coordinates, retrieve the cell located
     * at those coordinates.
     * @param i The x coordinate of the cell to find
     * @param j The y coordinate of the cell to find
     * @return The Cell if it has been found,
     *         null otherwise
     */
    public Cell getCell(final int i, final int j) {
        if (i < rows && j < columns && i >= 0 && j >= 0) {
            return grid[i][j];
        } else {
            return null;
        }
    }

    /**
     * Getter for the number of rows of a grid.
     * @return The number of rows
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Getter for the number of columns of a grid.
     * @return The number of columns
     */
    public int getColumns() {
        return this.columns;
    }

    /**
     * Print all of the grid cells' states.
     */
    public void printGrid() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(grid[row][column].getState() == State.DEAD ? "O" : "X");
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
