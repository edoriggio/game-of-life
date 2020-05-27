package src.main.java;

import src.main.java.gui.MainFrame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class from which the application runs.
 *
 * @author Edoardo Riggio & Michele Cattaneo
 */
public class Main {

    private static int rows = 80;
    private static int cols = 80;
    private static int cellSize = 10;

    private Main() {
        // Not to be instantiated
    }

    /**
     * Run the application.
     * @param args the command line arguments in that order:
     *             number of rows, number of columns, cell size ( max 20px )
     * @throws InterruptedException Exception for the step timer
     */
    public static void main(final String[] args) throws InterruptedException {

        System.out.println("   ██████╗  █████╗ ███╗   ███╗███████╗ ██████╗ ███████╗██╗     ██╗███████╗███████╗\n" +
                "  ██╔════╝ ██╔══██╗████╗ ████║██╔════╝██╔═══██╗██╔════╝██║     ██║██╔════╝██╔════╝\n" +
                "  ██║  ███╗███████║██╔████╔██║█████╗  ██║   ██║█████╗  ██║     ██║█████╗  █████╗  \n" +
                "  ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ██║   ██║██╔══╝  ██║     ██║██╔══╝  ██╔══╝  \n" +
                "  ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗╚██████╔╝██║     ███████╗██║██║     ███████╗\n" +
                "   ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝ ╚═════╝ ╚═╝     ╚══════╝╚═╝╚═╝     ╚══════╝\n");

        // Get terminal inputs:
        if (args.length == 3) {
            rows = Integer.parseInt(args[0]);
            cols = Integer.parseInt(args[1]);
            cellSize = Integer.parseInt(args[2]);
        }
        // If no inputs were given, ask for them again:
        else {
            if (!readInputs()){
                System.out.println("Your inputs seems to be invalid; default values were given: rows="
                        + rows + " cols=" + cols + " cell size=" + cellSize);
            }
        }

        System.out.println("Generating grid...");

        // Make sure that the size of the cell is at most 20px
        cellSize = Math.min(cellSize, 20);

        // Model
        final GameOfLife game = new GameOfLife(rows, cols);

        // GUI
        final MainFrame frame = new MainFrame(game, cellSize);
        frame.setVisible(true);

        // start executing steps of the instance of GameOfLife
        game.startExecutingSteps();

    }

    /**
     * Read values from the standard input.
     * @return true if the input and the number of inputs was valid, false otherwise.
     */
    private static boolean readInputs() {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList<Integer> inputs = new ArrayList<>();
        System.out.println("Provide parameters in that order: number of rows, number of columns, cell size");

        int i = 0;
        while (i < 3) {
            if (scanner.hasNextInt()) {
                inputs.add(scanner.nextInt());

            }
            i++;
        }
        if (inputs.size() == 3) {
            rows = inputs.get(0);
            cols = inputs.get(1);
            cellSize = inputs.get(2);
            return true;
        }
        return false;
    }

}
