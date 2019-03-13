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
                boolean alive = grid.cellAt(row, column);
                int aliveNeighbours = grid.countNeighbours(true, row, column);
                boolean nextState = computeNextState(alive, aliveNeighbours);
            }
        }


    }
}

