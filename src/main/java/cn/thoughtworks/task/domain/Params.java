package cn.thoughtworks.task.domain;

public class Params {
    private String rows;
    private String cols;
    private String command;
    private String speed;

    public Params(String rows, String cols, String command, String speed) {
        this.rows = rows;
        this.cols = cols;
        this.command = command;
        this.speed = speed;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getCols() {
        return cols;
    }

    public void setCols(String cols) {
        this.cols = cols;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
