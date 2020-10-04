package heap;

import java.util.Arrays;

/**
 * @ClassName HeapSortTest
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/23 22:08
 * @Version 1.0
 **/
public class HeapSortTest {
    public static void main(String[] args) {
        //待排序数组
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        //通过HeapSort对数组元素排序
        HeapSort.sort(arr);
        //打印排序后数组中的元素
        System.out.println(Arrays.toString(arr));
    }
}
