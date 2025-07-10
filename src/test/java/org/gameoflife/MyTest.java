package org.gameoflife;

import org.gameoflife.newpack.Cell1;
import org.gameoflife.newpack.Create;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyTest {

    @Test
    public void firstTest(){
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


}
