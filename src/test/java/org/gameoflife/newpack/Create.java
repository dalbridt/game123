package org.gameoflife.newpack;

import org.gameoflife.GameField;

public class Create {
    public static CellBuilder cell(int x, int y) {
        CellBuilder cellBuilder = new CellBuilder(x, y);
        return cellBuilder;
    }

    public static GameField gameField(int height, int width) {
    }
}
