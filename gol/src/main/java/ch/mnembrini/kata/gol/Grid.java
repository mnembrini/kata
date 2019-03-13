package ch.mnembrini.kata.gol;

public class Grid {

    private int rowSize;
    private int columnSize;

    private boolean[][] data;

    public Grid(int rowSize, int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        data = new boolean[rowSize][columnSize];
    }
}
