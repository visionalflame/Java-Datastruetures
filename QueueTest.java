package queue;

/**
 * @ClassName QueueTest
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/8 17:43
 * @Version 1.0
 **/
public class QueueTest {
    public static void main(String[] args) {
        //创建队列对象
        Queue<String> strings = new Queue<>();
        //测试队列enqueue
        strings.enqueue("123");
        strings.enqueue("456");
        strings.enqueue("789");
        strings.enqueue("000");
        for (String str:strings
             ) {
            System.out.println(str);
        }
        //测试队列dequeue
        System.out.println("---------");
        String result=strings.dequeue();
        System.out.println(result);
        System.out.println("剩余："+strings.size());
    }
}
