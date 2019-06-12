package cn.thoughtworks.task.factory;

import cn.thoughtworks.task.domain.Matrix;
import cn.thoughtworks.task.service.CheckService;

public class MatrixFactory {
    public Matrix create(String rows, String cols, String command) {
        CheckService checkService = new CheckService();

        String sizeCheckResult =  checkService.checkSize(rows,cols);

        if (sizeCheckResult != null){
            System.out.println(sizeCheckResult);
            return null;
        }

        int transRows = Integer.valueOf(rows);
        int transCols = Integer.valueOf(cols);

        String commandCheckResult = checkService.checkCommand(transRows,transCols, command);

        if (commandCheckResult != null){
            System.out.println(commandCheckResult);
            return null;
        }


        Matrix matrix = new Matrix(transRows, transCols);
        String[] points = command.split(";");


        for (int i = 0; i < points.length; i++) {
            String[] point = points[i].split(",");
            matrix.getCell(Integer.valueOf(point[0]), Integer.valueOf(point[1])).setAlive(true);
        }
        return matrix;
    }
}
