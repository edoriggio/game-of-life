package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

/**
 * A definition of a GliderPattern.
 *
 * @author Michele Cattaneo
 */
public class GliderPattern extends PatternFactory {

    /**
     * Constructor for a GliderPattern.
     * @param rule the BorderRule to be applied
     */
    public GliderPattern(final BorderRule rule) {
        super(4, 3, rule);

        rowPositions = new int[]{0,1,1,2,2};
        colPositions = new int[]{2,0,2,2,1};
    }
}
