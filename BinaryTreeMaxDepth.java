package tree;

/**
 * @ClassName BinaryTreeMaxDepth
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/20 14:56
 * @Version 1.0
 **/
public class BinaryTreeMaxDepth {
    public static void main(String[] args) {
        //创建树对象
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");
        int depth = tree.maxDepth();
        System.out.println(depth);
    }
}
