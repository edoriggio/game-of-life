package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

/**
 * A definition of a LWSS pattern.
 *
 * @author Edoardo Riggio
 */
public class LWSSPattern extends PatternFactory {

    /**
     * Constructor for a LWSSPattern.
     * @param rule the BorderRule that is applied to this PatternFactory
     */
    public LWSSPattern(final BorderRule rule) {
        super(4, 5, rule);

        rowPositions = new int[]{0,0,1,2,2,3,3,3,3};
        colPositions = new int[]{1,4,0,0,4,0,1,2,3};
    }

}
