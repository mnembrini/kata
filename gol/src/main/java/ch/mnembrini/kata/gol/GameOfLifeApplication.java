package ch.mnembrini.kata.gol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLifeApplication {


    public static void main(String[] args) throws IOException {

        if (args.length < 2) {
            System.out.println("Usage: java -jar GameOfLifeApplication.jar <inputFile>");
            System.exit(-1);
        }

        String inputFile = args[1];
        try (Stream<String> lines = Files.lines(Paths.get(inputFile))) {
            List<String> input = lines.collect(Collectors.toList());
            String firstLine = input.get(0);
            firstLine = firstLine.replace("Generation ", "");
            firstLine = firstLine.replace(":", "");
            int generation = Integer.parseInt(firstLine);

            String secondLine = input.get(1);
            String[] dimensions = secondLine.split(" ");
            int rowSize = Integer.parseInt(dimensions[0]);
            int columnSize = Integer.parseInt(dimensions[1]);

            Grid grid = parseGrid(input.subList(2, input.size()), rowSize, columnSize);


        }


    }

    private static Grid parseGrid(List<String> rows, int rowSize, int columnSize) {

        Grid grid = new Grid(rowSize, columnSize);

        for (int row = 0; row < rows.size(); row++) {
            String line = rows.get(row);
            for (int column = 0; column < line.length(); column++) {
                char cell = line.charAt(column);

                // we only need to set the alive cells
                if (cell == '*') {
                    grid.setCell(row, column, true);
                }
            }
        }
        return grid;
    }
}
