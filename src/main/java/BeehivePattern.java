package src.main.java;

/**
 * A definition of a Beehive pattern.
 *
 * @author Edoardo Riggio
 * @version 25/05/2020
 */
public class BeehivePattern extends PatternFactory {

    /**
     * Constructor for a BeehivePattern.
     * @param rule the BorderRule that is applied to this PatternFactory
     */
    public BeehivePattern(final BorderRule rule) {
        super(3, 4, rule);

        rowPositions = new int[]{0,0,1,1,2,2};

        colPositions = new int[]{1,2,0,3,1,2};
    }

}
