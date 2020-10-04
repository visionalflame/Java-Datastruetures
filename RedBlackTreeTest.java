package tree;

/**
 * @ClassName RedBlackTreeTest
 * @Description TODO    
 * @Author MR.Zhou
 * @Date 2020/9/20 16:26
 * @Version 1.0
 **/
public class RedBlackTreeTest {
    public static void main(String[] args) {
        //创建红黑树
        RedBlackTree<String, String> tree = new RedBlackTree<>();
        //往树中插入元素
        tree.put("1","first");
        tree.put("2","Second");
        tree.put("3","third");
        //从树中获取元素
        String r1 = tree.get("1");
        System.out.println(r1);

        String r2 = tree.get("2");
        System.out.println(r2);

        String r3 = tree.get("3");
        System.out.println(r3);


    }
}
