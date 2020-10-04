package priorityQueue;

/**
 * @ClassName MinPriorityQueueTest
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/28 22:19
 * @Version 1.0
 **/
public class MinPriorityQueueTest {
    public static void main(String[] args) {
        //创建最小优先队列对象
        MinPriorityQueue<String> queue = new MinPriorityQueue<String>(10);
        //往队列中存数据
        queue.insert("H");
        queue.insert("G");
        queue.insert("F");
        queue.insert("E");
        queue.insert("D");
        queue.insert("C");
        queue.insert("B");
        queue.insert("A");


        //循环获取最小优先队列元素
        while (!queue.isEmpty()){
            String min = queue.delMin();
            System.out.print(min + " ");
        }
    }
}
