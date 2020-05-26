package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

/**
 * A definition of an Hexapole pattern.
 *
 * @author Michele Cattaneo
 */
public class HexapolePattern extends PatternFactory {

    /**
     * Constructor for the class HexapolePattern.
     * @param rule the rule to be applied to this pattern factory
     */
    public HexapolePattern(final BorderRule rule) {
        super(9, 9, rule);

        rowPositions = new int[]{0,0,1,1,3,3,5,5,7,7,8,8};
        colPositions = new int[]{8,7,8,6,6,4,4,2,2,0,1,0};
    }
}
