package org.gameoflife.entities;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameField {
    Integer width;
    Integer height;

    private List<Cell> listOfCells;

    public GameField(List<Cell> listOfCells, Integer width, Integer height) {
        this.listOfCells = listOfCells;
        if (width != null && height != null) {
            if (width > 0 && height > 0) {
                this.width = width;
                this.height = height;
            }
        }
    }

    public List<Cell> getListOfCells() {
        return listOfCells;
    }

    public Cell getCell(int x, int y) {
        for (Cell cell : listOfCells) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }
        return null;
    }

    public Integer getWidth() {
        return width;
    }


    public Integer getHeight() {
        return height;
    }


    @Override
    public String toString() {
        return IntStream.range(0, height)
                .mapToObj(y ->
                        IntStream.range(0, width)
                        .mapToObj(x -> this.getCell(x, y).getCurrentAlive() ? "[]" : "--")
                                .collect(Collectors.joining(""))
                        ).collect(Collectors.joining("\n"));

    }
}
