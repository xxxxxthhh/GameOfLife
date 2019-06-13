package cn.thoughtworks.task;

import cn.thoughtworks.task.domain.Cell;
import cn.thoughtworks.task.domain.Matrix;
import cn.thoughtworks.task.domain.Params;
import cn.thoughtworks.task.factory.MatrixFactory;
import cn.thoughtworks.task.service.DisplayService;
import cn.thoughtworks.task.service.InputService;
import cn.thoughtworks.task.service.UpdateService;
import jdk.internal.util.xml.impl.Input;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TaskApplication {

    volatile static Integer speed = 1000;

    public static void main(String[] args) {
        DisplayService displayService = new DisplayService();
        InputService inputService = new InputService();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = inputService.initInput(scanner);
        Params params = inputService.parseInput(input);
        Matrix matrix = new MatrixFactory().create(params.getRows(), params.getCols(), params.getCommand());
        if (matrix == null)
            System.exit(0);
        speed = Integer.valueOf(params.getSpeed());

        displayService.setSpeed(speed);

        displayService.loopPrint(matrix, scanner);
    }


}
