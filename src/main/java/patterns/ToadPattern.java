package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

/**
 * A definition of a Toad pattern.
 *
 * @author Edoardo Riggio
 */
public class ToadPattern extends PatternFactory {

    /**
     * Constructor for a ToadPattern.
     * @param rule the BorderRule that is applied to this PatternFactory
     */
    public ToadPattern(final BorderRule rule) {
        super(2, 4, rule);

        rowPositions = new int[]{0,0,0,1,1,1};
        colPositions = new int[]{1,2,3,0,1,2};
    }

}
