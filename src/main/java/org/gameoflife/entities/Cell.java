package org.gameoflife.entities;

import java.util.List;

public class Cell {
    Integer x;
    Integer y;
    Boolean currentAlive;
    Boolean nextAlive;
    List<Cell> neighbours;

    public Cell(Integer x, Integer y, Boolean currentAlive) {
        this.x = x;
        this.y = y;
        this.currentAlive = currentAlive;
        this.nextAlive = currentAlive;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Boolean getCurrentAlive() {
        return currentAlive;
    }

    public void setCurrentAlive(Boolean currentAlive) {
        this.currentAlive = currentAlive;
    }

    public Boolean getNextAlive() {
        return nextAlive;
    }

    public void setNextAlive(Boolean nextAlive) {
        this.nextAlive = nextAlive;
    }

    public List<Cell> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }
}
