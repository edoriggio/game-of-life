package src.main.java;

import java.util.LinkedList;

public class MooreNeighborhood extends Neighborhood{

    int[] rowRule;
    int[] colRule;

    /**
     * Constructor for the MooreNeighborhood class.
     * This Neighborhood considers as neighbors all 8 cells next to the given one.
     * @param rule the bordering rule that this neighborhood has to follow.
     */
    public MooreNeighborhood(BorderRule rule) {
        super(rule);
        rowRule = new int[]{-1, +1, 0, 0, -1, -1, +1, +1};
        colRule = new int[]{0, 0, +1, -1, -1, +1, -1, +1};
    }

    @Override
    public LinkedList<int[]> getNeighbors(final Grid grid, final int i, final int j) {
        LinkedList<int[]> listOfNeighbouringPositions = new LinkedList<>();
        int currentRow;
        int currentCol;
        int[] currentPosition;
        for (int k = 0; k < rowRule.length; k++){
            currentRow = i + rowRule[k];
            currentCol = j + colRule[k];

            currentPosition = rule.validate(grid, currentRow, currentCol);

            listOfNeighbouringPositions.add(currentPosition);

        }
        return listOfNeighbouringPositions;
    }

    public void printNeighbors(final Grid grid, final int i, final int j) {
        LinkedList<int[]> toPrint = getNeighbors(grid, i, j);
        for (int[] position : toPrint) {
            System.out.println(""+position[0]+" "+position[1]);
        }
    }




}
