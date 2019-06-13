package cn.thoughtworks.task;

import cn.thoughtworks.task.domain.Cell;
import cn.thoughtworks.task.domain.Matrix;
import cn.thoughtworks.task.factory.MatrixFactory;
import cn.thoughtworks.task.service.DisplayService;
import cn.thoughtworks.task.service.UpdateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TaskApplication {

    volatile static  int speed = 1000;

    public static void main(String[] args) {
        Process process = null;
        DisplayService displayService = new DisplayService();
        UpdateService updateService = new UpdateService();
        ArrayList<String> input = new ArrayList<>();

        System.out.print("初始文件路径：");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println(path);
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < 3; i++) {
                input.add(bufferedReader.readLine());
            }
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("文件路径错误。");
        }
        String[] size = input.get(0).split(" ");
        String rows = size[0];
        String cols = size[1];
        String command = input.get(1);
        String sppedStr = input.get(2);

        Matrix matrix = new MatrixFactory().create(rows, cols, command);
        speed = Integer.valueOf(sppedStr);

        new Thread(){
            public void run() {
                while (scanner.hasNext()){
                    String ins = scanner.next();
                    if (ins.equals("q"))
                        System.exit(0);
                    if (ins.equals("w"))
                        speed += 300;
                    else if (ins.equals("s"))
                        speed = speed - 300 < 100 ? 100 : speed - 300;
                }
            }
        }.start();

        for (int i = 0; i < 100; i++) {
            displayService.display(matrix);
            System.out.println(speed);
            matrix.setMatrix(updateService.nextMatrix(matrix));
            try {
                Thread.currentThread().sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen();
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
