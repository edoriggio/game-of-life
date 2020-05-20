package src.main.java;

public class Insert {

    private Insert() {
    }

    public static void insertPattern(Pattern pattern, Grid grid, BorderRule borderRule, int i, int j) throws Exception {

        boolean success;
        boolean patternNotFound = false;

        switch(pattern) {
            case GLIDER:
                PatternFactory glider = new GliderPattern(borderRule);
                success = glider.insertPattern(grid, i, j);
                break;
            case PUFFER:
                PatternFactory puffer = new PufferPattern(borderRule);
                success = puffer.insertPattern(grid, i, j);
                break;
            case GOSPERGLIDERGUN:
                PatternFactory gosperGun = new GosperGliderGunPattern(borderRule);
                success = gosperGun.insertPattern(grid, i, j);
                break;
            default:
                patternNotFound = false;
                success = false;
        }

        if (patternNotFound) {
            throw new PatternException("Pattern not found");
        }
        else if (!success) {
            throw new PatternException("Pattern could not fit the current Grid");
        }
    }
}
