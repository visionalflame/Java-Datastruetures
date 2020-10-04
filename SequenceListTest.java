package seqList;
import seqList.SequenceList;
public class SequenceListTest {
    public static void main(String[] args) {
        //创建顺序表对象
        SequenceList<String> sl = new SequenceList<String>(2);
        //插入
        sl.insert("yaoming");
        sl.insert("kobe");
        sl.insert("bruse");
        sl.insert(1, "james");
        for (int i = 0; i < sl.length(); i++)  {
            System.out.println(sl.get(i));
        }

        //获取
        String getResult = sl.get(1);
        System.out.println("get:" + getResult);
        //删除
        String removeResult = sl.remove(2);
        System.out.println("delete:" + removeResult);
        //清空
        //sl.clear();
        System.out.println("clear:" + sl.length());
        //遍历
    }
}