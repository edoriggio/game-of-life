package src.main.java;

public class Insert {

    private Insert() {
    }

    public static void insertPattern(Pattern pattern, Grid grid, BorderRule borderRule, int i, int j) {
        switch(pattern) {
            case GLIDER:
                PatternFactory glider = new GliderPattern(borderRule);
                glider.insertPattern(grid, i, j);
                break;
            case PUFFER:
                PatternFactory puffer = new PufferPattern(borderRule);
                puffer.insertPattern(grid, i, j);
                break;
            case GOSPERGLIDERGUN:
                PatternFactory gosperGun = new GosperGliderGunPattern(borderRule);
                gosperGun.insertPattern(grid, i, j);
                break;
        }
    }
}
