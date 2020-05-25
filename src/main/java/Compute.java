package src.main.java;

import java.util.LinkedList;

/**
 * This class computes the next status of a Grid of cells given a Neighborhood instance
 * to compute the neighbourhood of each cell according to the rules of that instance.
 * The next state of each Cell is instead computed according to the Game of Life rules.
 *
 * @author Michele Cattaneo
 */
public class Compute {

    private Compute() {
        // Never instantiated. This class is a collection of functionalities.
    }

    /**
     * Update the second Grid that has been given according to the status of the fist one given.
     * @param neighborhood The kind of Neighborhood rule to be used
     * @param grid1 The Grid representing the current status
     * @param grid2 The Grid that will hold the next status depending on the current one
     */
    public static void computeNextGrid(final Neighborhood neighborhood, final Grid grid1,
                                       final Grid grid2) {
        int numberOfLiveNeighbors;
        LinkedList<int[]> currentNeighborhood;

        for (int i = 0; i < grid1.getRows(); i++) {
            for (int j = 0; j < grid1.getColumns(); j++) {
                currentNeighborhood = neighborhood.getNeighbors(grid1, i, j);
                numberOfLiveNeighbors = countNumberAliveCells(currentNeighborhood, grid1);
                changeStateAccordingToGameOfLifeRules(grid1.getCell(i, j),
                        grid2.getCell(i, j), numberOfLiveNeighbors);
            }
        }
    }

    /**
     * Count the number of Alive cells in the given grid of the given Neighborhood.
     * @param neighborhood The positions representing the cells to check
     * @param grid1 The grid into which the cells are checked
     * @return The number of Cells that are Alive in the given grid or the given positions
     */
    private static int countNumberAliveCells(final LinkedList<int[]> neighborhood,
                                             final Grid grid1) {
        int currentRow;
        int currentCol;
        int numberOfAliveCells = 0;

        for (final int[] position : neighborhood) {
            currentRow = position[0];
            currentCol = position[1];
            if (grid1.getCell(currentRow, currentCol).getState() == State.ALIVE) {
                numberOfAliveCells++;
            }
        }

        return numberOfAliveCells;
    }

    /**
     * Change the state of a Cell given the number of its neighbors that are Alive.
     * @param currentCell The current Cell with its current state
     * @param cellToChange The cell which  will have the status changed
     * @param numberOfAliveCells The number of neighbours of the first cell given that are Alive
     */
    private static void changeStateAccordingToGameOfLifeRules(final Cell currentCell,
                                                              final Cell cellToChange,
                                                              final int numberOfAliveCells) {

        if (currentCell.getState() == State.ALIVE
                && (numberOfAliveCells == 2 || numberOfAliveCells == 3)) {
            // Any live cell with two or three live neighbours survives.
            cellToChange.setState(State.ALIVE);
        } else if ( currentCell.getState() == State.DEAD && numberOfAliveCells == 3) {
            // Any dead cell with three live neighbours becomes a live cell.
            cellToChange.setState(State.ALIVE);
        } else {
            // All other live cells die in the next generation.
            // Similarly, all other dead cells stay dead.
            cellToChange.setState(State.DEAD);
        }
    }

}
