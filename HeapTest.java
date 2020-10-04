package heap;

/**
 * @ClassName HeapTest
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/21 18:12
 * @Version 1.0
 **/
public class HeapTest {
    public static void main(String[] args) {
        //创建堆对象
        Heap<String> heap = new Heap<String>(10);
        //往堆中存入字符串数据
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");
        heap.insert("H");
        //通过循环从堆中删除数据
        String result= null;
        while ((result = heap.delMax())!=null){
            System.out.print(result+"  ");
        }

    }
}
