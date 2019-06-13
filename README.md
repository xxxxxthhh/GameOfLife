# GameOfLife 生命游戏

## 游戏规则

参考[百度百科](https://baike.baidu.com/item/%E7%94%9F%E5%91%BD%E6%B8%B8%E6%88%8F/2926434?fr=aladdin)，游戏规则如下：

每个格子的生死遵循下面的原则：

1． 如果一个细胞周围有3个细胞为生（一个细胞周围共有8个细胞），则该细胞为生（即该细胞若原先为死，则转为生，若原先为生，则保持不变） 。

2． 如果一个细胞周围有2个细胞为生，则该细胞的生死状态保持不变；

3． 在其它情况下，该细胞为死（即该细胞若原先为生，则转为死，若原先为死，则保持不变）

## 实现功能

1. 可自定义封闭空间大小

2. 可通过位置自定义初始活细胞

3. 可自定义细胞迭代速度

4. 迭代过程中实现加速`s`，减速`w`

5. `q`退出迭代



   标准输入（txt格式）：

   ```java
   // 封闭空间长宽
   20 20
   // 初始活细胞坐标
   7,7;7,9;7,11;8,7;9,7;10,7;11,7;8,11;9,11;10,11;11,11;11,9
   // 初始速度
   600
   ```


## 界面展示

![image-20190613111352156](https://github.com/xxxxxthhh/pic_go/blob/master/%E9%A1%B5%E9%9D%A2%E5%B1%95%E7%A4%BA.png)



外观仿乐高方块设计，简单、美观、易懂。

运行时下方实时显示当前速度，可通过按键控制迭代速度。

## Thanks  ...

感谢 ThoughtWorks

感谢 Coach 杨皓

感谢 两天一起结对的小伙伴
