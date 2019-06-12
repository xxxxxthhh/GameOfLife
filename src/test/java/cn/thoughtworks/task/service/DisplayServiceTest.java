package cn.thoughtworks.task.service;


import cn.thoughtworks.task.domain.Cell;
import cn.thoughtworks.task.domain.Matrix;
import org.junit.Test;

public class DisplayServiceTest {
    private DisplayService displayService = new DisplayService();

    @Test
    public void shouldDisplayMatrix() {
        Matrix matrix = new Matrix(3, 3);
        Cell[][] cells = matrix.getMatrix();
        cells[0][1].setAlive(true);
        cells[1][1].setAlive(true);
        cells[2][1].setAlive(true);

        displayService.display(matrix);
    }

    }