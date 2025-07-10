package org.gameoflife.newpack;

public class CellBuilder {
    private int x;
    private int y;
    private boolean status;

    public CellBuilder(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CellBuilder withStatus(boolean b) {
        this.status = b;
        return this;
    }

    public Cell1 please() {
        Cell1 cell = new Cell1(x, y, status);
        return cell;
    }
}
