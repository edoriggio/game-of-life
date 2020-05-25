package src.main.java;

import java.util.LinkedList;

/**
 * A Neighborhood is a way to specify all neighboring positions of a given position inside a Grid
 * according to a specific ( a concrete class ) BorderRule.
 *
 * @author Michele Cattaneo
 */
public abstract class Neighborhood {
    protected final BorderRule rule;

    /**
     * Constructor for the Neighborhood class.
     * @param rule the rule to handle the neighborhood of bordering positions.
     */
    public Neighborhood(final BorderRule rule) {
        this.rule = rule;
    }

    /**
     * Get a list of arrays of size 2, representing a couple (i,j) of the neighbouring positions of
     * the given position in the given grid, according to the BorderRule instance.
     * @param grid the grid in which the neighbouring positions are being looked for
     * @param i the index for the row of the postion
     * @param j the index for the columns of the position
     * @return a LinkedList< int[] > of neighbouring positions
     */
    public abstract LinkedList<int[]> getNeighbors(Grid grid, int i, int j);
}
