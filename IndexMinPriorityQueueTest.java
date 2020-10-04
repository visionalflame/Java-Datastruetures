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
        //����������С���ȶ��ж���
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<String>(10);

        //�ڶ��������Ԫ��
        queue.insert(0,"A");
        queue.insert(1,"C");
        queue.insert(2,"F");
        queue.insert(3,"L");
        queue.insert(4,"J");
        //�����޸�
        queue.changeItem(2,"B");

        //����ɾ��
        queue.delete(1);
        while (!queue.isEmpty()){
            int index = queue.delMin();
            System.out.print(index + "");
        }
    }
}
