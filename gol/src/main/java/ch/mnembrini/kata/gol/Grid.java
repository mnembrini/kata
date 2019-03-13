package ch.mnembrini.kata.gol;

import java.util.Arrays;
import java.util.Objects;

public class Grid {

    private final int rowSize;
    private final int columnSize;

    private boolean[][] data;

    public Grid(int rowSize, int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        data = new boolean[rowSize][columnSize];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return rowSize == grid.rowSize &&
                columnSize == grid.columnSize &&
                Arrays.equals(data, grid.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rowSize, columnSize);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Grid{");
        sb.append("rowSize=").append(rowSize);
        sb.append(", columnSize=").append(columnSize);
        sb.append(", data=").append(Arrays.toString(data));
        sb.append('}');
        return sb.toString();
    }
}
