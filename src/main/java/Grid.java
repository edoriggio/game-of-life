package src.main.java;

import java.util.LinkedList;
import java.util.List;

public class Grid {
    private int[][] grid;
    private final int[] rule_row;
    private final int[] rule_col;
    private final int rows;
    private final int cols;

    public Grid(int row, int col) {
        grid = new int[row][col];
        // vectors to represents neigbors
        // north, south, east, west
        rule_row = new int[]{-1, +1, 0, 0};
        rule_col = new int[]{0, 0, +1, -1};

        cols = col-1;
        rows = row-1;
    }

    private boolean inRange(int row, int col) {
        return (row >=0 && col >= 0 && col <= cols && row <= rows);
    }

    private List<int[]> getNeihgbors(int row, int col) {
        LinkedList<int[]> result = new LinkedList<>();
        int rr;
        int cc;
        for(int i=0; i < rule_row.length; i++) {
            rr = row + rule_row[i];
            cc = col + rule_col[i];

            if (inRange(rr, cc)) {
                result.add(new int[]{rr, cc});
            }
        }
        return result;
    }

    public int getNumberOfNeighbors(final int row, final int col) {
        int counter = 0;
        int rr, cc;

        for(int i = 0; i < rule_row.length; i++) {
            rr = row + rule_row[i];
            cc = col + rule_col[i];
            if (inRange(rr, cc)) {
                if (grid[rr][cc] == 1) {
                    counter += 1;
                }
            }
        }
        return counter;
    }

    public void printNeigbors(int row, int col) {
        for(int[] pair : getNeihgbors(row, col)) {
            System.out.println(pair[0]+" "+pair[1]);
        }
    }


}
