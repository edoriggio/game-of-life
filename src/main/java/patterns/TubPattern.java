package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

/**
 * A definition of a Tub pattern.
 *
 * @author Edoardo Riggio
 * @version 25/05/2020
 */
public class TubPattern extends PatternFactory {

    /**
     * Constructor for a TubPattern.
     * @param rule the BorderRule that is applied to this PatternFactory
     */
    public TubPattern(final BorderRule rule) {
        super(10,10,rule);

        rowPositions = new int[]{1,0,2,1};
        colPositions = new int[]{0,1,1,2};
    }
}
