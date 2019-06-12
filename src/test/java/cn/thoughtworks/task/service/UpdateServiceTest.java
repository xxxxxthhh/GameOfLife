package cn.thoughtworks.task.service;

import cn.thoughtworks.task.domain.Cell;
import cn.thoughtworks.task.domain.Matrix;
import org.junit.Assert;
import org.junit.Test;


public class UpdateServiceTest {

    UpdateService updateService = new UpdateService();
    @Test
    public void testGetAliveNeighborNumber() {

        Matrix matrix = new Matrix(3,3);
        Cell[][] cells = matrix.getMatrix();
        cells[0][0].setAlive(true);
        cells[0][1].setAlive(true);
        cells[0][2].setAlive(true);
        matrix.setMatrix(cells);
        int number1 = updateService.getAliveNeighborNumber(matrix, 0,0);
        int number2 = updateService.getAliveNeighborNumber(matrix,1, 1);
        int number3 = updateService.getAliveNeighborNumber(matrix, 2, 1);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);
        Assert.assertEquals(number1, 1);
        Assert.assertEquals(number2, 3);
        Assert.assertEquals(number3, 0);
    }

}