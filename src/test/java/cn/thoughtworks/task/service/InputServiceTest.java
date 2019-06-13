package cn.thoughtworks.task.service;

import cn.thoughtworks.task.domain.Params;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InputServiceTest {

    private InputService inputService = new InputService();

    @Test
    public void shouldGetAValidParam() {
//        Params params = new Params("10", "10", "0,0;1,1;2;2", "2000");
        ArrayList input = new ArrayList();
        input.add("20 10");
        input.add("0,0;1,1;2;2");
        input.add("2000");
        Params params = inputService.parseInput(input);
        Assert.assertEquals("20", params.getRows());
        Assert.assertEquals("10", params.getCols());
        Assert.assertEquals("0,0;1,1;2;2", params.getCommand());
        Assert.assertEquals("2000", params.getSpeed());
    }

    @Test
    public void shouldGetDefaultSpeed() {
        ArrayList input = new ArrayList();
        input.add("20 10");
        input.add("0,0;1,1;2;2");
        input.add("aaa");
        Params params = inputService.parseInput(input);
        Assert.assertEquals("1000", params.getSpeed());
    }
}