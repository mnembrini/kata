package ch.mnembrini.kata.gol;


public class GenerationService {


    public String print(Grid grid) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s", grid.getRowSize(), grid.getColumnSize()));
        sb.append("\n");

        for (int row = 0; row < grid.getRowSize(); row++) {
            for (int column = 0; column < grid.getColumnSize(); column++) {
                if (grid.getCell(row, column)) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }


    /**
     * Advance the game by one generation
     *
     * @param grid the game state
     */
    public void advance(Grid grid) {

        for (int row = 0; row < grid.getRowSize(); row++) {
            for (int column = 0; column < grid.getColumnSize(); column++) {
                advanceCell(grid, row, column);
            }
        }


    }

    private void advanceCell(Grid grid, int row, int column) {
        boolean alive = grid.getCell(row, column);
        int aliveNeighbours = grid.countAliveNeighbours(row, column);
        boolean nextState = computeNextState(alive, aliveNeighbours);
        grid.setCell(row, column, nextState);
    }

    private boolean computeNextState(boolean alive, int aliveNeighbours) {
        if (alive) {
            // rule 1
            // under population
            if (aliveNeighbours < 2) {
                return false;
            }
            // rule 2
            // over population
            else if (aliveNeighbours > 3) {
                return false;
            }
            // rule 3
            else {
                return true;
            }
        } else {
            // rule 4
            if (aliveNeighbours == 3) {
                return true;
            }
            return false;
        }

    }
}

