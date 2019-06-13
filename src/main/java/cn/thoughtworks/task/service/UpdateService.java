package cn.thoughtworks.task.service;

import cn.thoughtworks.task.domain.Cell;
import cn.thoughtworks.task.domain.Matrix;

public class UpdateService {

    public int getAliveNeighborNumber(Matrix matrix, int x, int y) {
        int rows = matrix.getRows();
        int cols = matrix.getCols();
        int num = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (CheckService.ifIn(x+i,0,rows) && CheckService.ifIn(y+j,0,cols)){
                    if (matrix.getCell(x + i, y + j).isAlive()){
                        num+=1;
                    }
                }
            }
        }

        if (matrix.getCell(x, y).isAlive()) {
            return  num-1;
        }
        return num;
    }

    public boolean nextGenerationStatus(int x, int y, Matrix matrix) {
        int count = this.getAliveNeighborNumber(matrix, x, y);
        if (count == 3){
            return true;
        } else if (count == 2) {
            return matrix.getCell(x, y).isAlive();
        }
        return false;
    }

    public Cell[][] nextMatrix(Matrix matrix){
        int rows = matrix.getRows();
        int cols = matrix.getCols();
        Cell[][] newMatrix = new Cell[rows][cols];

        for (int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                newMatrix[i][j] = new Cell(false);
                newMatrix[i][j].setAlive(nextGenerationStatus(i,j,matrix));
            }
        }
        return newMatrix;
    }

}
