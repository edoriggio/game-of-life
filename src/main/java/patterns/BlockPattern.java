package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

/**
 * A definition of a Block pattern.
 *
 * @author Edoardo Riggio
 * @version 25/05/2020
 */
public class BlockPattern extends PatternFactory {

    /**
     * Constructor for a BlockPattern.
     * @param rule the BorderRule that is applied to this PatternFactory
     */
    public BlockPattern(final BorderRule rule) {
        super(2, 2, rule);

        rowPositions = new int[]{0,1,0,1};
        colPositions = new int[]{0,0,1,1};
    }

}
