package src.main.java;

/**
 * This enum contains all of the possible predefined patterns that can be added.
 * To each of them it assigns a more human readable String.
 *
 * @author Edoardo Riggio
 */
public enum Pattern {
    BLOCK("Block"),
    BEEHIVE("Beehive"),
    LOAF("Loaf"),
    BOAT("Boat"),
    TUB("Tub"),

    BLINKER("Blinker"),
    TOAD("Toad"),
    BEACON("Beacon"),

    GLIDER("Glider"),
    LWSS("Light-weight Spaceship"),

    PUFFER("Puffer"),
    FROTHINGPUFFER("Frothing Puffer"),
    GOSPERGLIDERGUN("Gosper Glider Gun"),
    HEXAPOLE("Hexapole"),
    CIRCLEOFFIRE("Circle of Fire"),
    DOUBLECIRCLEOFFIRE("Double Circle of Fire");

    private final String name;

    /**
     * Constructor for the Pattern enum.
     * @param name The human readable name of the pattern
     */
    Pattern(final String name) {
        this.name = name;
    }

    /**
     * This method gives out the human readable name of the pattern.
     * @return The name of the pattern
     */
    public String getName() {
        return name;
    }
}
