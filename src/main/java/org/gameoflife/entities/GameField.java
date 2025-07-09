package org.gameoflife.entities;

import java.util.List;

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

    public void setListOfCells(List<Cell> listOfCells) {
        this.listOfCells = listOfCells;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
