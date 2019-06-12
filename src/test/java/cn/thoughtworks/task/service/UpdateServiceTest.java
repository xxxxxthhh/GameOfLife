package cn.thoughtworks.task.service;

import cn.thoughtworks.task.domain.Cell;
import cn.thoughtworks.task.domain.Matrix;
import org.junit.Assert;
import org.junit.Test;


public class UpdateServiceTest {

    private UpdateService updateService = new UpdateService();
    @Test
    public void shouldGetNeighborCount() {

        Matrix matrix = new Matrix(3,3);
        Cell[][] cells = matrix.getMatrix();
        cells[0][0].setAlive(true);
        cells[0][1].setAlive(true);
        cells[0][2].setAlive(true);
        matrix.setMatrix(cells);

        int number1 = updateService.getAliveNeighborNumber(matrix, 0,0);
        int number2 = updateService.getAliveNeighborNumber(matrix,1, 1);
        int number3 = updateService.getAliveNeighborNumber(matrix, 2, 1);

        Assert.assertEquals(number1, 1);
        Assert.assertEquals(number2, 3);
        Assert.assertEquals(number3, 0);
    }

    @Test
    public void shouldGetPointStatus(){
        Matrix matrix = new Matrix(3,3);
        Cell[][] cells = matrix.getMatrix();
        cells[0][0].setAlive(true);
        cells[0][1].setAlive(true);
        cells[0][2].setAlive(true);

        boolean status1 = updateService.nextGenerrationStatus(1,1,matrix);
        boolean status2 = updateService.nextGenerrationStatus(2,1,matrix);
        boolean status3 = updateService.nextGenerrationStatus(0,0,matrix);

        Assert.assertTrue(status1);
        Assert.assertFalse(status2);
        Assert.assertFalse(status3);
    }

    @Test
    public void shouldGetNextMatrix() {
        Matrix matrix = new Matrix(3,3);
        Cell[][] cells = matrix.getMatrix();
        cells[0][0].setAlive(true);
        cells[0][1].setAlive(true);
        cells[0][2].setAlive(true);

        Cell[][] shoudbeMatrix = new Cell[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                shoudbeMatrix[i][j] = new Cell(false);
            }
        }
        shoudbeMatrix[0][1].setAlive(true);
        shoudbeMatrix[1][1].setAlive(true);

        Cell[][] newMatrxi = updateService.nextMatrix(matrix);

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.println(shoudbeMatrix[i][j].isAlive());
                System.out.println(" ");
                Assert.assertEquals(shoudbeMatrix[i][j].isAlive(), newMatrxi[i][j].isAlive());
            }
            System.out.println("\n");
        }
    }
}