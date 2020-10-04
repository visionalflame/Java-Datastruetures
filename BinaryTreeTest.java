package tree;

/**
 * @ClassName BinaryTreeTest
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/12 22:17
 * @Version 1.0
 **/
public class BinaryTreeTest {
    public static void main(String[] args) {
        //创建二叉查找树对象
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
        //测试插入
        binaryTree.put(1,"张三");
        binaryTree.put(2,"李四");
        binaryTree.put(3,"王五");

        System.out.println(("插入完毕后元素个数" + binaryTree.size()));

        //测试获取

        System.out.println(binaryTree.get(2));


        //测试删除

        binaryTree.delete(2);
        System.out.println(("delete  " + binaryTree.size()));
        System.out.println(("3:" + binaryTree.get(2)));
    }
}
