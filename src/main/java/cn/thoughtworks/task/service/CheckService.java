package cn.thoughtworks.task.service;

import cn.thoughtworks.task.error.ErrorMessage;
import cn.thoughtworks.task.util.NumberUtil;

public class CheckService {
    public String checkSize(String rows, String cols) {
        if (NumberUtil.isNumeric(rows) && NumberUtil.isNumeric(cols)) {
            return null;
        } else {
            return ErrorMessage.INVALID_INPUT.getMsg();
        }
    }

    public static boolean ifIn(int x, int low, int high){
        return x >= low && x < high;
    }

    public String checkCommand(int rows, int cols, String command) {
        String[] points = command.split(";");
        if (points.length == 0) {
            return ErrorMessage.INVALID_INPUT.getMsg();
        }

        for (String point1 : points) {
            String[] point = point1.split(",");
            if (isInitialAliveCellInvalid(point)) {
                return ErrorMessage.INVALID_INPUT.getMsg();
            }

            if (isCellNotNumber(point))
                return ErrorMessage.INVALID_INPUT.getMsg();

            if (isCellOverFlow(rows, 0, point)) {
                return ErrorMessage.OUT_OF_RANGE.getMsg();
            }
            if (isCellOverFlow(cols, 1, point)) {
                return ErrorMessage.OUT_OF_RANGE.getMsg();
            }
        }

        return null;
    }

    private boolean isCellOverFlow(int rows, int i, String[] point) {
        return Integer.valueOf(point[i]) >= rows;
    }

    private boolean isCellNotNumber(String[] point) {
        return !NumberUtil.isNumeric(point[0]) || !NumberUtil.isNumeric(point[1]);
    }

    private boolean isInitialAliveCellInvalid(String[] point) {
        return point.length == 0 || point.length != 2;
    }

}

