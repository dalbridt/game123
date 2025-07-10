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

    public GameService(GameField gameField) {
        this.gameField = gameField;
    }

    public void calculateNextGeneration() {
        gameField.getListOfCells().stream().forEach(cell -> {
            cell.setNextAlive(calculateNextAlive(cell));
        });
        saveNewGenerationState();
    }


    public String getFieldAsString() {
        return  gameField.toString();
    }


    boolean calculateNextAlive(Cell cell) {
        long aliveNeighbors = cell.getNeighbors().stream().filter(Cell::getCurrentAlive).count();
        if (cell.getCurrentAlive()) {
            return aliveNeighbors == 2 || aliveNeighbors == 3;
        } else{
            return aliveNeighbors == 3;
        }
    }

    /**
     * меняет next на current
     */
    void saveNewGenerationState() {
        gameField.getListOfCells().stream().forEach(Cell::update);
    }

}
