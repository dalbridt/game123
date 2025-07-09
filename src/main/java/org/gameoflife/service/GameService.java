package org.gameoflife.service;

import org.gameoflife.entities.Cell;
import org.gameoflife.entities.GameField;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Service
public class GameService {
    private GameField gameField;

    void setupFirstGeneration() {
        // todo - нужно рефакторить
        Properties props = new Properties();

        try(InputStream inputStream = new FileInputStream("src/main/resources/first-generation.properties")) {
            props.load(inputStream);
            int width = Integer.parseInt(props.getProperty("width"));
            int height = Integer.parseInt(props.getProperty("height"));
            String liveCellsRaw = props.getProperty("liveCells");

            if (liveCellsRaw == null || liveCellsRaw.length() < 2) {
                throw new RuntimeException("invalid live cells configuration");
            }

            setupEmptyCells(width, height);

            Arrays.stream(liveCellsRaw.split(","))
                    .map(s -> s.trim())
                    .map(pair -> pair.split("[,:]"))
                    .filter(pair -> pair.length == 2)
                    .forEach(coord ->{
                        int x = Integer.parseInt(coord[0].trim());
                        int y = Integer.parseInt(coord[1].trim());
                        gameField.getCell(x, y).setCurrentAlive(true);
                    });

            setNeighborsforAllCells();

        } catch (Exception e) {
            throw new RuntimeException("failed to read first generation file" + e);
        }
    }

    void setupEmptyCells(int width, int height) {
        List <Cell> cells = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells.add(new Cell(i, j, false));
            }
        }
        gameField = new GameField(cells, width, height);
    }

    void setNeighborsforAllCells() {
        // todo - самое важное!!!!
    }

     List <Cell> getNeighborsForCell(int x, int y) {
        // todo подумать как сделать через стрим
        List <Cell> neighbors = new ArrayList<>();

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (i < 0 || i >= gameField.getWidth()) {
                    continue;
                }
                if (j < 0 || j >= gameField.getHeight()) {
                    continue;
                }

                neighbors.add(gameField.getCell(i, j));
            }
        }
        return neighbors;
    }

    void calculateNextGeneration() {

    }

    void saveNewGenerationState() {}

    @Override
    public String toString() {
        return null ;
        // TODO - нужно чтоб отдавать на печать строкой
    }
}
