package cn.thoughtworks.task.service;

import cn.thoughtworks.task.domain.Matrix;

import java.util.Scanner;

public class DisplayService {
    volatile int speed = 1000;

    public void display(Matrix matrix) {
        int rows = matrix.getRows();
        int cols = matrix.getCols();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix.getCell(i, j).isAlive()) {
                    System.out.print("\033[41;32;4m" + "  " + "\033[0m");
                } else {
                    System.out.print("\033[47;4m" + "  " + "\033[0m");
                }
            }
            System.out.println();
        }
    }

    public void loopPrint(Matrix matrix, Scanner scanner) {
        DisplayService displayService = new DisplayService();
        UpdateService updateService = new UpdateService();

        new Thread(() -> {
            while (scanner.hasNext()) {
                String ins = scanner.next();
                if (ins.equals("q"))
                    System.exit(0);
                if (ins.equals("w"))
                    speed += 300;
                else if (ins.equals("s"))
                    speed = speed - 300 < 100 ? 100 : speed - 300;
            }
        }).start();
        for (;;) {
            displayService.display(matrix);
            System.out.println(speed);
            matrix.setMatrix(updateService.nextMatrix(matrix));
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            displayService.clearScreen();
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
