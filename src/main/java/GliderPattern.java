package src.main.java;

public class GliderPattern extends PatternFactory{

    /**
     * Constructor for a GliderPattern.
     * @param rule the BorderRule to be applied
     */
    public GliderPattern(BorderRule rule) {
        super(4, 3, rule);
        rowPositions = new int[]{0,1,1,2,2};
        colPositions = new int[]{2,0,2,2,1};
    }
}
