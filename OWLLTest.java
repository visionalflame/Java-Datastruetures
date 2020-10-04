package onewayLinkedlist;
import onewayLinkedlist.OneWayLinkedList;
public class OWLLTest {
    public static void main(String[] args) throws Exception {
        //创建单向链表对象
        OneWayLinkedList<String> sl=new OneWayLinkedList<>();
        sl.insert("funny");
        sl.insert("bunny");
        sl.insert("vvvvv");
        sl.insert(2,"justice");
        sl.insert("kof");
        for (String s:
             sl) {
            System.out.println(s);
        }
        System.out.println("___________");
        sl.reverse();
        for (String s:
             sl) {
            System.out.println(s);
        }
        System.out.println("-------------");
        System.out.println(sl.getMid());
        System.out.println("_________");
        System.out.println(sl.setCircle());
        System.out.println(sl.isCircle());
        System.out.println(sl.indexOf("vvvvv"));
        System.out.println(sl.getEntrance());
        System.out.println("-----------");
        //测试获取
        String getResult=sl.get(3);
        System.out.println("get(3): "+getResult);
        //测试删除
        String removeResult=sl.remove(2);
        System.out.println("remove(2):"+removeResult);
        //测试清空
        sl.clear();
        System.out.println("clear:"+sl.isEmpty());
        System.out.println("length:"+sl.length());
    }

}
