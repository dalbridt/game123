package org.gameoflife;

import org.gameoflife.newpack.Cell1;
import org.gameoflife.newpack.Create;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    @Test
    public void CellTest(){
        // Cell
        // Int x, y - coordinates
        // bool alive
        //given - есть ячейка
        Cell1 cell = Create.cell(0,0).withStatus(true).please();
        // when - запрашиваем координаты и статус
        // then - получаем значения координат и статус
        assertAll(
                () -> assertEquals(0, cell.getX()),
                () -> assertEquals(0, cell.getY()),
                () -> assertTrue(cell.isAlive())
        );
    }

    public void GameBoardTest(){
        // given - есть игровое поле
        Board board = Create.board(10,10);
        // when когда иницализируем игровое поле, передаем размеры поля
        board.init();
        // then получаем список проинициализированных ячеек, каждая имееет координаты и статус по умолчанию false
        IntStream.range(0, 10).forEach(i -> IntStream.range(0, 10).forEach(j -> assertFalse(board.getCell(i, j).isAlive())));
    }

}
