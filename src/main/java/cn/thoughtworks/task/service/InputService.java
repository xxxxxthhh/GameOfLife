package cn.thoughtworks.task.service;

import cn.thoughtworks.task.domain.Params;
import cn.thoughtworks.task.error.ErrorMessage;
import cn.thoughtworks.task.util.NumberUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputService {

    private static final int SIZE_COMMAND = 0;
    private static final int INIT_ALIVE_CELL_COMMAND = 1;
    private static final int SPEED_COMMAND = 2;
    private static final String DEFAULT_SPEED = "1000";

    public ArrayList<String> initInput(Scanner scanner) {
        ArrayList<String> inputsArray = new ArrayList<>();
        System.out.print("初始文件路径：");
        String path = scanner.nextLine();
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int maxCommandLineCount = 3;
            for (int i = 0; i < maxCommandLineCount; i++) {
                inputsArray.add(bufferedReader.readLine());
            }
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("文件路径错误。");
        }
        return inputsArray;
    }

    public Params parseInput(ArrayList<String> input){

        String[] size = input.get(SIZE_COMMAND).split(" ");
        int initialRowsIndex = 0;
        int initialColsIndex = 1;
        String rows = size[initialRowsIndex];
        String cols = size[initialColsIndex];
        String command = input.get(INIT_ALIVE_CELL_COMMAND);
        String speedStr = input.get(SPEED_COMMAND);
        if (!NumberUtil.isNumeric(speedStr)){
            System.out.println(ErrorMessage.INVALID_NUMBER.getMsg());
            speedStr = DEFAULT_SPEED;
        }

        return new Params(rows, cols, command, speedStr);
    }
}
