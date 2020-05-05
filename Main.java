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
        final Model model = new Model();
        final TextUserInterface tui = new TextUserInterface(model);
        tui.run();
    }
    
}