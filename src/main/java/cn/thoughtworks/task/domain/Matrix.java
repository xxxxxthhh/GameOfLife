package cn.thoughtworks.task.domain;

public class Matrix {
    private int rows;
    private int cols;

    private Cell[][] matrix;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new Cell[rows][cols];
        for(int i=0; i < rows; i++){
            for (int j=0; j < cols; j++){
                matrix[i][j] = new Cell(false);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return matrix[x][y];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setMatrix(Cell[][] matrix) {
        this.matrix = matrix;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }
}
