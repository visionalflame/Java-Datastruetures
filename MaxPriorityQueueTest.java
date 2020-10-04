package priorityQueue;

/**
 * @ClassName MaxPriorityQueueTest
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/27 22:48
 * @Version 1.0
 **/
public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        //创建优先队列
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);
        //存储元素
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");
        /*queue.insert("H");
        queue.insert("I");
       */ //通过循环从队列中获取最大元素
        while (!queue.isEmpty()){
            String max= queue.delMax();
            System.out.println(max);
        }
    }
}
