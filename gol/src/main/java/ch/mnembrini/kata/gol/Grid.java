package ch.mnembrini.kata.gol;

import java.util.Arrays;
import java.util.Objects;

public class Grid {

    private final int rowSize;
    private final int columnSize;

    /**
     * Has extra cells around to simplify counting neighbours.
     * true means the cell is alive
     */
    private boolean[][] data;

    public Grid(int rowSize, int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        data = new boolean[rowSize + 2][columnSize + 2];
    }

    public boolean getCell(int row, int column) {
        return data[row][column];
    }

    public int countAliveNeighbours(int row, int column) {
        int total = 0;

        // above
        total += countAlive(row - 1, column);
        total += countAlive(row - 1, column - 1);
        total += countAlive(row - 1, column + 1);

        // bottom
        total += countAlive(row + 1, column);
        total += countAlive(row + 1, column - 1);
        total += countAlive(row + 1, column + 1);

        // sides
        total += countAlive(row, column + 1);
        total += countAlive(row, column - 1);

        return total;

    }

    private int countAlive(int row, int column) {
        if (getCell(row, column)) {
            return 1;
        }
        return 0;
    }

    public void setCell(int row, int column, boolean nextState) {
        data[row][column] = nextState;
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
