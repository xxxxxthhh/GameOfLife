package cn.thoughtworks.task.service;

import cn.thoughtworks.task.error.ErrorMessage;
import cn.thoughtworks.task.util.NumberUtil;
import com.sun.tools.internal.xjc.ErrorReceiver;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckService {
    public String checkSize(String rows, String cols) {
        if (NumberUtil.isNumeric(rows) && NumberUtil.isNumeric(cols)) {
            return null;
        } else {
            return ErrorMessage.INVALID_INPUT.getMsg();
        }
    }


    //TODO
    public String checkCommand(int rows, int cols, String command) {
        String[] points = command.split(";");
        if (points.length == 0) {
            return ErrorMessage.INVALID_INPUT.getMsg();
        }

        for (int i = 0; i < points.length; i++) {
            String[] point = points[i].split(",");
            if (point.length == 0 || point.length != 2) {
                return ErrorMessage.INVALID_INPUT.getMsg();
            }

            if (!NumberUtil.isNumeric(point[0]) || !NumberUtil.isNumeric(point[1]))
                return ErrorMessage.INVALID_INPUT.getMsg();

            if (Integer.valueOf(point[0]) >= rows) {
                return ErrorMessage.OUT_OF_RANGE.getMsg();
            }
            if (Integer.valueOf(point[1]) >= cols) {
                return ErrorMessage.OUT_OF_RANGE.getMsg();
            }
        }

//        Pattern pattern = Pattern.compile("");
//
//        for (int i = 0; i < point.length; i++) {
//            Matcher isLocation = pattern.matcher(point[i]); // matcher是全匹配
//            if (!isLocation.matches()) {
//                return ErrorMessage.INVALID_INPUT.getMsg();
//            }
//        }


        return null;
    }

}

