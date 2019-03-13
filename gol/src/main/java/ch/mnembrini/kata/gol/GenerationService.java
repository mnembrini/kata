package ch.mnembrini.kata.gol;


public class GenerationService {


    /**
     * Advance the game by one generation
     *
     * @param grid the game state
     */
    public void next(Grid grid) {

        for (int row = 0; row < grid.getRowSize(); row++) {
            for (int column = 0; column < grid.getColumnSize(); column++) {
                boolean alive = grid.getCell(row, column);
                int aliveNeighbours = grid.countAliveNeighbours(row, column);
                boolean nextState = computeNextState(alive, aliveNeighbours);
                grid.setCell(row, column, nextState);
            }
        }


    }

    private boolean computeNextState(boolean alive, int aliveNeighbours) {
        return false;
    }
}

