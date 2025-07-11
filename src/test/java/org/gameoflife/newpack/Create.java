package org.gameoflife.newpack;

import org.gameoflife.Board;

public class Create {
    public static CellBuilder cell(int x, int y) {
        CellBuilder cellBuilder = new CellBuilder(x, y);
        return cellBuilder;
    }

    public static Board board(int height, int width) {
    }

}
