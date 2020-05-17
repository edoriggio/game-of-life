package src.main.java;

import java.util.Scanner;

/**
 * ...
 */
public class TextUserInterface {

    private final GameOfLife model;

    /**
     * Create a new TUI operating on the given Model.
     * @param model The model of this application
     */
    public TextUserInterface(final GameOfLife model) {
        this.model = model;
    }

    /**
     * Run the application.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            String command = sc.nextLine();
            if (command.equals("step")) {
                model.step();
                model.getCurrentGrid().printGrid();
            } else if ( command.equals("exit")) {
                flag = false;
            } else {
                flag = false;
                break;
            }
        }
    }
}
