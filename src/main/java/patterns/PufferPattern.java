package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

/**
 * A definition of a PufferPattern.
 *
 * @author Edoardo Riggio
 */
public class PufferPattern extends PatternFactory {

    /**
     * Constructor for a PufferPattern.
     * @param rule the BorderRule to be applied
     */
    public PufferPattern(final BorderRule rule) {
        super(2, 27, rule);

        rowPositions = new int[]{
          0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,2,2,2,
          2,2,2,2,2,3,3,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6,6
        };

        colPositions = new int[]{
          1,2,3,10,16,23,24,25,0,3,9,10,11,15,16,17,23,
          26,3,8,9,11,15,17,18,23,3,23,3,6,20,23,3,6,7,
          19,20,23,2,6,7,19,20,24
        };
    }

}
