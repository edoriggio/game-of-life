package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

/**
 * A definition of a Boat pattern.
 *
 * @author Edoardo Riggio
 */
public class BoatPattern extends PatternFactory {

    /**
     * Constructor for a BoatPattern.
     * @param rule the BorderRule that is applied to this PatternFactory
     */
    public BoatPattern(final BorderRule rule) {
        super(3,3,rule);

        rowPositions = new int[]{1,0,2,1,2};
        colPositions = new int[]{0,1,1,2,2};
    }
}
