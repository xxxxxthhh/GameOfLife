package cn.thoughtworks.task.service;

import cn.thoughtworks.task.error.ErrorMessage;
import org.junit.Assert;
import org.junit.Test;

public class CheckServiceTest {

    private CheckService checkService = new CheckService();

    @Test

    public void shouldGetNullWithoutCommand() {
        String rows = "3";
        String cols = "4";

        Assert.assertNull(checkService.checkSize(rows, cols));

    }

    @Test
    public void shouldGetInvalidInputWithoutCommand() {
        String rows = "aaa";
        String cols = "3";

        Assert.assertEquals(ErrorMessage.INVALID_INPUT.getMsg(), checkService.checkSize(rows, cols));
    }

    @Test
    public void shouldGetNullWithCommand() {
        int rows = 3;
        int cols = 3;
        String command = "0,0;1,1;2,2";

        System.out.println(checkService.checkCommand(rows, cols, command));
        Assert.assertNull(checkService.checkCommand(rows, cols, command));
    }

    @Test
    public void shouldGetOutOfRange() {
        int rows = 3;
        int cols = 3;
        String command = "0,0;3,1;2,2";

        System.out.println(checkService.checkCommand(rows, cols, command));
        Assert.assertEquals(ErrorMessage.OUT_OF_RANGE.getMsg() , checkService.checkCommand(rows, cols, command));
    }

    @Test
    public void shouldGetInvalidInputWithCommand() {
        int rows = 3;
        int cols = 3;
       // String command = "0,0;3@,1;2,2";
        String command = "asdadasfasfas";

        System.out.println(checkService.checkCommand(rows, cols, command));
        Assert.assertEquals(ErrorMessage.INVALID_INPUT.getMsg(), checkService.checkCommand(rows, cols, command));
    }

}