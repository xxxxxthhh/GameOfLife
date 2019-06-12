package cn.thoughtworks.task.error;

public enum ErrorMessage {
    INVALID_NUMBER("invalid number error."),
    OUT_OF_RANGE("number out of range."),
    INVALID_INPUT("input is invalid.");

    private String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
