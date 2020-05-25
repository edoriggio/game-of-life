package src.main.java;

import java.util.LinkedList;

/**
 * This Neighborhood represents the Moore rule, for that a cell in a grid has 8 neighboring cells
 * that creates a square around that cell. This type of neighbouring rule is the one used for the
 * Game Of Life.
 *
 * @author Michele Cattaneo
 */
public class MooreNeighborhood extends Neighborhood {

    private final int[] rowRule;
    private final int[] colRule;

    /**
     * Constructor for the MooreNeighborhood class.
     * This Neighborhood considers as neighbors all 8 cells next to the given one.
     * @param rule the bordering rule that this neighborhood has to follow.
     */
    public MooreNeighborhood(final BorderRule rule) {
        super(rule);
        this.rowRule = new int[]{-1, +1, 0, 0, -1, -1, +1, +1};
        this.colRule = new int[]{0, 0, +1, -1, -1, +1, -1, +1};
    }

    @Override
    public LinkedList<int[]> getNeighbors(final Grid grid, final int i, final int j) {
        final LinkedList<int[]> listOfNeighbouringPositions = new LinkedList<>();
        int currentRow;
        int currentCol;
        int[] currentPosition;

        for (int k = 0; k < rowRule.length; k++) {
            currentRow = i + rowRule[k];
            currentCol = j + colRule[k];

            currentPosition = rule.validate(grid, currentRow, currentCol);

            listOfNeighbouringPositions.add(currentPosition);

        }

        return listOfNeighbouringPositions;
    }

    /**
     * Print all the neighbors of the given position in the given grid according
     * to the border rule of this.
     * @param grid the grid containing the position
     * @param i the index of the row
     * @param j the index of the column
     */
    public void printNeighbors(final Grid grid, final int i, final int j) {
        final LinkedList<int[]> toPrint = getNeighbors(grid, i, j);
        for (final int[] position : toPrint) {
            System.out.println("" + position[0] + " " + position[1]);
        }
    }

}
