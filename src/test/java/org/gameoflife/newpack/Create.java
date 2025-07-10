package org.gameoflife.newpack;

public class Create {
    public static CellBuilder cell(int x, int y) {
        CellBuilder cellBuilder = new CellBuilder(x, y);
        return cellBuilder;
    }
}
