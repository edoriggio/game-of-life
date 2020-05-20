package src.main.java;

import java.util.LinkedList;

/**
 * This class computes the next status of a Grid of cells given a Neigborhood instance
 * to compute the neighbourhood of each cell according to the rules of that instance.
 * The next state of each Cell is instead computed according to the Game of Life rules.
 */
public class Compute {

    private Compute() {
        // Avoid that Compute might be instantiated
    }

    /**
     * Update the second Grid that has been given according to the status of the fist one given.
     *
     * @param grid1 the Grid representing the current status
     * @param grid2 the Grid that will hold the next status depending on the current one
     */
    public static void computeNextGrid(Neighborhood neighborhood, Grid grid1, Grid grid2) {
        int numberOfLiveNeighbors;
        LinkedList<int[]> currentNeighborhood;
        for (int i = 0; i < grid1.getRows(); i++) {
            for (int j = 0; j < grid1.getColumns(); j++) {
                currentNeighborhood = neighborhood.getNeighbors(grid1, i, j);
                numberOfLiveNeighbors = countNumberAliveCells(currentNeighborhood, grid1);
                changeStateAccordingToGameOfLifeRules(grid1.getCell(i, j), grid2.getCell(i, j), numberOfLiveNeighbors);
            }
        }
    }

    /**
     * Count the number of Alive cells in the given grid of the given Neighborhood.
     * @param neighborhood the positions representing the cells to check
     * @param grid1 the grid into which the cells are checked
     * @return the number of Cells that are Alive in the given grid or the given positions.
     */
    private static int countNumberAliveCells(LinkedList<int[]> neighborhood, Grid grid1) {
        int currentRow;
        int currentCol;
        int numberOfAliveCells = 0;
        for (int[] position : neighborhood) {
            currentRow = position[0];
            currentCol = position[1];
            if(grid1.getCell(currentRow, currentCol).getState() == State.ALIVE) {
                numberOfAliveCells++;
            }
        }
        return numberOfAliveCells;
    }

    /**
     * Change the state of a Cell given the number of its neighbors that are Alive.
     * @param currentCell the current Cell with its current state.
     * @param cellToChange the cell which  will have the status changed.
     * @param numberOfAliveCells the number of neighbours of the first cell given that are Alive.
     */
    private static void changeStateAccordingToGameOfLifeRules(Cell currentCell, Cell cellToChange, int numberOfAliveCells) {
        // Any live cell with two or three live neighbours survives.
        if (currentCell.getState() == State.ALIVE && ( numberOfAliveCells == 2 || numberOfAliveCells == 3)) {
            cellToChange.setState(State.ALIVE);
        }
        // Any dead cell with three live neighbours becomes a live cell.
        else if ( currentCell.getState() == State.DEAD && numberOfAliveCells == 3) {
            cellToChange.setState(State.ALIVE);
        }
        // All other live cells die in the next generation. Similarly, all other dead cells stay dead.
        else {
            cellToChange.setState(State.DEAD);
        }
    }

}
