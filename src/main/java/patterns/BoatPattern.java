package src.main.java.patterns;

import src.main.java.BorderRule;
import src.main.java.PatternFactory;

//TODO those values are not correct!
public class BoatPattern extends PatternFactory {

    public BoatPattern(BorderRule rule) {
        super(10,10,rule);
        rowPositions = new int[]{1};
        colPositions = new int[]{1};
    }
}
