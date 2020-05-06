package src.main.java;

public class Cell {

    private boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public Cell check(int neighbors) {
        // TODO: Implement method
        return new Cell(true);
    }

    public boolean isAlive() {
        return alive;
    }

    // Ask if it is better to return a Cell
    // or bool in check()
    // public void setAlive(boolean alive) {
    //     this.alive = alive;
    // }
}
