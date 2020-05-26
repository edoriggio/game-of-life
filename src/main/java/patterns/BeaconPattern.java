package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

/**
 * A definition of a Beacon pattern.
 *
 * @author Edoardo Riggio
 */
public class BeaconPattern extends PatternFactory {

    /**
     * Constructor for a BeaconPattern.
     * @param rule the BorderRule that is applied to this PatternFactory
     */
    public BeaconPattern(final BorderRule rule) {
        super(4, 4, rule);

        rowPositions = new int[]{0,1,0,1,2,3,2,3};
        colPositions = new int[]{0,0,1,1,2,2,3,3};
    }

}
