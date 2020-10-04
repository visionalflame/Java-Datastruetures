package tree;

import queue.Queue;

/**
 * @ClassName BinaryTreegodicTest
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/14 0:42
 * @Version 1.0
 **/
public class BinaryTreegodicTest {
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
        //前序遍历
        Queue<String> keys = tree.preErgodic();
        for (String key:keys
             ) {
            String value = tree.get(key);
            System.out.println(key+"---"+value);
        }
        System.out.println("-----------");
        //中序遍历
        Queue<String> keys2 = tree.midErgodic();
        for (String key:keys2
             ) {
            String value = tree.get(key);
            System.out.println(key + "---" + value);
        }
        System.out.println("-------");
        //后序遍历
        Queue<String> keys3 = tree.afterErgodic();
        for (String key:keys3
        ) {
            String value = tree.get(key);
            System.out.println(key + "---" + value);
        }
        System.out.println("-----");
        //层序遍历
        Queue<String> keys4 = tree.layerErgoidc();
        for (String key:keys4
             ) {
            String value = tree.get(key);
            System.out.println(key + "---" + value);
        }
    }
}
