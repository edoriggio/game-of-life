package src.main.java;

/**
 * The Grid class is used to create a bi-dimensional array.
 * This array is composed of cells.
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

    public Cell getCell(int i, int j) {
        if (i < rows && j < columns) {
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
                System.out.print(grid[row][column].getState() == State.DEAD ? "\u25A1" : "\u25A0");
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
