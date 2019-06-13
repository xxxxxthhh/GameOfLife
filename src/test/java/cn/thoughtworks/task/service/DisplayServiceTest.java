package cn.thoughtworks.task.service;


import cn.thoughtworks.task.domain.Cell;
import cn.thoughtworks.task.domain.Matrix;
import org.junit.Test;


public class DisplayServiceTest {
    private DisplayService displayService = new DisplayService();
    private UpdateService updateService = new UpdateService();

    @Test
    public void shouldDisplayMatrix() {
        Matrix matrix = new Matrix(20, 20);
        Cell[][] cells = matrix.getMatrix();
        cells[10][5].setAlive(true);
        cells[10][6].setAlive(true);
        cells[10][7].setAlive(true);
        cells[10][8].setAlive(true);
        cells[10][9].setAlive(true);
        cells[10][10].setAlive(true);
        cells[10][11].setAlive(true);
        cells[10][12].setAlive(true);
        cells[10][13].setAlive(true);
        cells[10][14].setAlive(true);
        for (int i=0; i<10; i++){
            displayService.display(matrix);
            matrix.setMatrix(updateService.nextMatrix(matrix));
            System.out.println("=====================");
        }

    }

    }