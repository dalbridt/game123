package org.gameoflife;

import org.gameoflife.newpack.Cell1;
import org.gameoflife.newpack.Create;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertEquals(0, cell.getX());
        assertEquals(0, cell.getY());
        assertTrue(cell.isAlive());
    }

    public void GameBoardTest(){
        // given - есть игровое поле
        GameField gameField = Create.gameField(10,10);
        // when когда иницализируем игровое поле, передаем размеры поля
        gameField.init();
        // then получаем список проинициализированных ячеек, каждая имееет координаты и статус по умолчанию false
        IntStream.range(0, 10).
    }

}
