package cn.thoughtworks.task.util;

import cn.thoughtworks.task.domain.Cell;

public class CellUtil {

    public static Cell[][] create(int rows, int cols){
        Cell[][] cells = new Cell[rows][cols];
        for (int i=0; i < rows; i++){
            for (int j=0; j < cols; j++){
                cells[i][j] = new Cell(false);
            }
        }
        return cells;
    }
}
