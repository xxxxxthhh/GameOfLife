package cn.thoughtworks.task.service;

import cn.thoughtworks.task.domain.Matrix;

public class UpdateService {

    public int getAliveNeighborNumber(Matrix matrix, int x, int y) {

        int rows = matrix.getRows();
        int cols = matrix.getCols();

        int num = 0;

        if (x + 1 < rows && matrix.getCell(x + 1, y).isAlive()) {
            num += 1;
        }

        if (x + 1 < rows && y + 1 < cols && matrix.getCell(x + 1, y + 1).isAlive()) {
            num += 1;
        }

        if (y + 1 < cols && matrix.getCell(x, y + 1).isAlive()) {
            num += 1;
        }
        if (x + 1 > rows && y > 0 && matrix.getCell(x + 1, y - 1).isAlive()) {
            num += 1;
        }
        if (x > 0 && y > 0 && matrix.getCell(x - 1, y - 1).isAlive()) {
            num += 1;
        }
        if (y > 0 && matrix.getCell(x, y - 1).isAlive()) {
            num += 1;
        }
        if (x > 0 && matrix.getCell(x - 1, y).isAlive()) {
            num += 1;
        }
        if (x > 0 && y + 1 < cols && matrix.getCell(x - 1, y + 1).isAlive()) {
            num += 1;
        }
        return num;
    }

    public boolean nextGenerrationStatus(int x, int y, Matrix matrix) {
        int count = this.getAliveNeighborNumber(matrix, x, y);
        if (count == 3)
            return true;
        else if (count == 2)
            return matrix.getCell(x, y).isAlive();
        return false;
    }
}
