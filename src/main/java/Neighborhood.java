package src.main.java;

import java.util.LinkedList;

public abstract class Neighborhood {
    protected final BorderRule rule;

    public Neighborhood(BorderRule rule) {
        this.rule = rule;
    }

    public abstract LinkedList<int[]> getNeighbors(Grid grid, int i, int j);
}
