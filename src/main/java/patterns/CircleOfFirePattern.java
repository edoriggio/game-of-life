package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;


/**
 * A definition of an Circle of Fire pattern.
 *
 * @author Michele Cattaneo
 */
public class CircleOfFirePattern extends PatternFactory {

    /**
     * Constructor for the class CircleOfFirePattern.
     * @param rule the BorderRule to be applied to the pattern
     */
    public CircleOfFirePattern(final BorderRule rule) {
        super(11, 11, rule);

        colPositions = new int[]{
          4,6,2,5,8,3,5,7,1,2,3,5,7,8,9,5,
          0,1,2,3,4,6,7,8,9,10,5,1,2,3,5,7,8,9,3,5,7,2,5,8,4,6
        };

        rowPositions = new int[]{
          0,0,1,1,1,2,2,2,3,3,3,3,3,3,3,4,
          5,5,5,5,5,5,5,5,5,5 ,6,7,7,7,7,7,7,7,8,8,8,9,9,9,10,10
        };

    }
}
