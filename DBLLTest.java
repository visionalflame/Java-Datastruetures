package doubleLinkedlist;
import doubleLinkedlist.DoubleLinkedList;

public class DBLLTest {
    public static void main(String[] args) throws NullPointerException{
        //创建双向链表对象
        DoubleLinkedList<String>sl = new DoubleLinkedList<>();
        //测试插入
        sl.insert("first");
        sl.insert("second");
        sl.insert(1,"third");
        sl.insert("forth");
        for (int i = 0; i < sl.length(); i++) {

                System.out.println(sl.get(i));

        }
        System.out.println(sl.length());
        System.out.println("----------------");
        //测试获取
        String s = sl.get(1);
        System.out.println("get:"+s);
        //测试删除
        String remove = sl.remove(3);
        System.out.println("remove:"+remove);
        //测试清空
        sl.clear();
        System.out.println("clear:"+sl.length());
        System.out.println("--------------");
        System.out.println("first  "+sl.getFirst());
        System.out.println("last  "+sl.getLast());
    }


}
