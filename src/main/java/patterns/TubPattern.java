package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

//TODO these values are not correct!
public class TubPattern extends PatternFactory {

    public TubPattern(BorderRule rule) {
        super(10,10,rule);
        rowPositions = new int[]{1};
        colPositions = new int[]{1};
    }
}
