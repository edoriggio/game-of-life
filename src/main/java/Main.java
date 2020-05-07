package src.main.java;

/**
 * ...
 */
public class Main {

    private Main() {
        // never instantiated
    }

    /**
     * Run the application (from the command line).
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        Grid test_grid = new Grid(10, 20);
        test_grid.printNeighbors(5,5);
        System.out.println("__");
        test_grid.printNeighbors(0,0);
        System.out.println("__");

        final GameOfLife model = new GameOfLife(10, 20);
        model.displayCurrentGrid();
        final TextUserInterface tui = new TextUserInterface(model);
        tui.run();

        Grid testGrid = new Grid(10,10);
        test_grid.printGrid();
        test_grid.room(1);
        System.out.println("____");
        test_grid.printGrid();
    }

}
