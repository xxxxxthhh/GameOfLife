package cn.thoughtworks.task.factory;

import cn.thoughtworks.task.domain.Matrix;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixFactoryTest {
    @Test
    public void shouldGetMatrix(){
        int cols = 5;
        int rols = 5;

        String command = "0,0;1,1;2,2;3,3;4,4;";

        Matrix newMatrix = new MatrixFactory().create("5","5",command);

        Assert.assertTrue(newMatrix.getCell(0, 0).isAlive());
        Assert.assertTrue(newMatrix.getCell(2, 2).isAlive());
        Assert.assertTrue(newMatrix.getCell(3, 3).isAlive());
        Assert.assertFalse(newMatrix.getCell(3, 0).isAlive());
        Assert.assertFalse(newMatrix.getCell(4, 3).isAlive());
    }

}