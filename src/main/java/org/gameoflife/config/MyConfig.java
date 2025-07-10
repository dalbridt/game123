package org.gameoflife.config;

import org.gameoflife.entities.Cell;
import org.gameoflife.entities.GameField;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:first-generation.properties")
@ComponentScan("org.gameoflife")
public class MyConfig {
    private final Environment env;

    public MyConfig(Environment env) {
        this.env = env;
    }
    @Bean
    public GameField gameField() {
        int width = Integer.parseInt(env.getProperty("width", "10"));
        int height = Integer.parseInt(env.getProperty("height", "10"));
        String liveCellsRaw = env.getProperty("liveCells");

        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells.add(new Cell(i, j, false));
            }
        }
        GameField gameField = new GameField(cells, width, height);

        Arrays.stream(liveCellsRaw.split(";"))
                .map(s -> s.trim())
                .map(pair -> pair.split(","))
                .filter(pair -> pair.length == 2)
                .forEach(coord -> {
                    int x = Integer.parseInt(coord[0].trim());
                    int y = Integer.parseInt(coord[1].trim());
                    gameField.getCell(x, y).setCurrentAlive(true);
                });

        gameField.getListOfCells().stream().forEach(cell -> {
            List<Cell> neighbors = getNeighborsForCell(cell.getX(), cell.getY(), gameField);
            cell.setNeighbors(neighbors);
        });
        return gameField;
    }

    List<Cell> getNeighborsForCell(int x, int y, GameField gameField) {
        int width = Integer.parseInt(env.getProperty("width", "20"));
        int height = Integer.parseInt(env.getProperty("height", "20"));
        List<Cell> neighbors = new ArrayList<>();

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (i < 0 || i >= width) {
                    continue;
                }
                if (j < 0 || j >= height) {
                    continue;
                }
                neighbors.add(gameField.getCell(i, j));
            }
        }
        return neighbors;
    }

}
