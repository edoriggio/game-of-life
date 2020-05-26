package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

/**
 * A definition of a Blinker pattern.
 *
 * @author Edoardo Riggio
 */
public class BlinkerPattern extends PatternFactory {

    /**
     * Constructor for a BlockPattern.
     * @param rule the BorderRule that is applied to this PatternFactory
     */
    public BlinkerPattern(final BorderRule rule) {
        super(3, 3, rule);

        rowPositions = new int[]{1,1,1};
        colPositions = new int[]{0,1,2};
    }

}
