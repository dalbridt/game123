package org.gameoflife.newpack;

public class Cell1 {
    private Integer coordX;
    private Integer coordY;
    private boolean alive;

    public Cell1(int x, int y) {
        this.coordX = x;
        this.coordY = y;
    }
    public Cell1(int x, int y, boolean Alive) {
        this.coordX = x;
        this.coordY = y;
        this.alive = Alive;
    }

    public Cell1(boolean Alive) {
        this.alive = Alive;
    }

    public Integer getX() {
        return coordX;
    }

    public Integer getY() {
        return coordY;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
