/**
 * ...
 */
public class TextUserInterface {

    private final Model model;
    
    
    /**
     * Create a new TUI operating on the given Model.
     * @param model The model of this application
     */
    public TextUserInterface(final Model model) {
        this.model = model;
    }
    
    /**
     * Run the application.
     */
    public void run() {
        System.out.println("Welcome to " + model.toString());
    }
    
}