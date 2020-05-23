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
     * @throws InterruptedException Exception for Thread.sleep()
     */
    public void run() throws InterruptedException {
        final Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            final String command = sc.nextLine();
            if ("step".equals(command)) {
                model.step();
                model.getCurrentGrid().printGrid();
            } else if ("exit".equals(command)) {
                flag = false;
            } else {
                break;
            }
        }
    }
}
