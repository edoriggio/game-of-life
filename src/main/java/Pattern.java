package src.main.java;

public enum Pattern {
    GLIDER("Glider"),
    PUFFER("Puffer"),
    GOSPERGLIDERGUN("Gosper Glider Gun");

    private final String name;

    Pattern(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
