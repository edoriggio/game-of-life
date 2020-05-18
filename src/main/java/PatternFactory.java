package src.main.java;

public abstract class PatternFactory {
    final int rowsNeeded;
    final int colsNeeded;
    int[] rowPositions;
    int[] colPositions;
    BorderRule borderRule;

    public PatternFactory(int i, int j, BorderRule rule) {
        rowsNeeded = i;
        colsNeeded = j;
        borderRule = rule;
    }
    public abstract boolean insertPattern(Grid grid, int i, int j);
}
