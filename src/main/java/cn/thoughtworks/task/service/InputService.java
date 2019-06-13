package cn.thoughtworks.task.service;

import cn.thoughtworks.task.domain.Params;
import cn.thoughtworks.task.error.ErrorMessage;
import cn.thoughtworks.task.util.NumberUtil;
import com.sun.tools.internal.xjc.ErrorReceiver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputService {

    public ArrayList<String> initInput(Scanner scanner) {
        ArrayList<String> inputsArray = new ArrayList<>();
        System.out.print("初始文件路径：");
        String path = scanner.nextLine();
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < 3; i++) {
                inputsArray.add(bufferedReader.readLine());
            }
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("文件路径错误。");
        }
        return inputsArray;
    }

    public Params parseInput(ArrayList<String> input){

        String[] size = input.get(0).split(" ");
        String rows = size[0];
        String cols = size[1];
        String command = input.get(1);
        String sppedStr = input.get(2);
        if (!NumberUtil.isNumeric(sppedStr)){
            System.out.println(ErrorMessage.INVALID_NUMBER.getMsg());
            sppedStr = "1000";
        }

        return new Params(rows, cols, command, sppedStr);
    }
}
