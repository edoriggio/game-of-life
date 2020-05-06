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
        test_grid.printNeigbors(5,5);
        System.out.println("__");
        test_grid.printNeigbors(0,0);
        final Model model = new Model();
        final TextUserInterface tui = new TextUserInterface(model);
        tui.run();
    }

}
