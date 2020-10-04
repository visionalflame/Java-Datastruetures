package priorityQueue;

/**
 * @ClassName IndexMinPriorityQueueTest
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/8/2 1:14
 * @Version 1.0
 **/
public class IndexMinPriorityQueueTest {
    public static void main(String[] args) {
        //创建索引最小优先队列对象
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<String>(10);

        //在队列中添加元素
        queue.insert(0,"A");
        queue.insert(1,"C");
        queue.insert(2,"F");
        queue.insert(3,"L");
        queue.insert(4,"J");
        //测试修改
        queue.changeItem(2,"B");

        //测试删除
        queue.delete(1);
        while (!queue.isEmpty()){
            int index = queue.delMin();
            System.out.print(index + "");
        }
    }
}
