package src.main.java;

/**
 * A definition of a Loaf pattern.
 *
 * @author Edoardo Riggio
 * @version 25/05/2020
 */
public class LoafPattern extends PatternFactory {

    /**
     * Constructor for a LoafPattern.
     * @param rule the BorderRule that is applied to this PatternFactory
     */
    public LoafPattern(final BorderRule rule) {
        super(4, 4, rule);

        rowPositions = new int[]{0,0,1,1,2,2,3};

        colPositions = new int[]{1,2,0,3,1,3,2};
    }

}
