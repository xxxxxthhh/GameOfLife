package cn.thoughtworks.task.service;

import cn.thoughtworks.task.domain.Matrix;

public class DisplayService {
    public void display(Matrix matrix) {
        int rows = matrix.getRows();
        int cols = matrix.getCols();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix.getCell(i, j).isAlive()) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
