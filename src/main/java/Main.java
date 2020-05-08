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

        Grid testGridZoom = new Grid(5,5);
        testGridZoom.printGrid();
        testGridZoom.zoom(2);
        System.out.println("____");
        testGridZoom.printGrid();
    }

}
