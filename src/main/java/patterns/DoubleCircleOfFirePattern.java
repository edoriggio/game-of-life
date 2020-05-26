package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

/**
 * A definition of a Double circle of Fire pattern.
 * Found out that putting 2 circle of fire next to another create a cool pattern.
 *
 * @author Michele Cattaneo
 */
public class DoubleCircleOfFirePattern extends PatternFactory {
    /*
    The caseCol and baseRow arrays are the same as the ones from a CircleOfFire.
    The finals arrays contains the same value in the first half and the second half
    is the same value shifted by 8 cells, so that the second shape is shifted by 8.
     */

    /**
     * Constructor for the class DoubleCircleOfFirePattern.
     * @param rule the BorderRule to be applied to the pattern
     */
    public DoubleCircleOfFirePattern(final BorderRule rule) {
        super(19,19,rule);

        final int[] baseCol = new int[]{
          4,6,2,5,8,3,5,7,1,2,3,5,7,8,9,5,
          0,1,2,3,4,6,7,8,9,10,5,1,2,3,5,7,8,9,3,5,7,2,5,8,4,6
        };

        final int[] baseRow = rowPositions = new int[]{
          0,0,1,1,1,2,2,2,3,3,3,3,3,3,3,4,
          5,5,5,5,5,5,5,5,5,5 ,6,7,7,7,7,7,7,7,8,8,8,9,9,9,10,10
        };

        int[] finalRow = new int[84];
        int[] finalCol = new int[84];

        for (int i = 0; i < 84; i++) {
            if (i < 42) {
                finalRow[i] = baseRow[i];
                finalCol[i] = baseCol[i];
            } else {
                finalRow[i] = baseRow[i - 42] + 8;
                finalCol[i] = baseCol[i - 42] + 8;
            }
        }

        rowPositions = finalRow;
        colPositions = finalCol;
    }
}
