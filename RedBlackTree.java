package tree;

/**
 * @ClassName RedBlackTree
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/9/14 19:20
 * @Version 1.0
 **/
public class RedBlackTree<Key extends Comparable<Key>,Value>{
    //根节点
    private Node root;
    //记录树中元素个数
    private int N;
    //红色链接
    private static final boolean RED = true;
    //黑色链接
    private static final boolean BLACK = true;

    //class Node
    private class Node{
        //key
        private Key key;
        //value
        private Value value;
        //left child Node
        private Node left;
        //right child Node
        private Node right;
        //the color that pointed by his father
        public boolean color;


        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }
    /**
     * @Author Visional Flame
     * @Date  2020/9/14
     * @Param []
     * @return int
     * @Description
     **/
    //get the size of tree
    public int size(){
        return N;
    }
    /**
     * @Author Visional Flame
     * @Date  2020/9/14
     * @Param [x]
     * @return boolean
     * @Description
     **/
    //is the currect node's link to his father is red?
    private boolean isRed(Node x){
        if (x == null){
            return false;
        }
        return x.color==RED;
    }
    //rotate to the left
    private Node rotateLeft(Node h){
        //获取h结点的右子结点，表示为x
        Node x = h.right;
        //让x结点的左子节点成为h结点的右子结点
        h.right= x.left;
        //让h成为x结点的左子结点
        x.left= h;
        //让x结点的color属性等于h结点的h结点的color 属性
        x.color=h.color;
        //让h结点的color属性变为红色
        h.color = RED;
        return x;
    }
    /**
     * @Author Visional Flame
     * @Date  2020/9/14
     * @Param
     * @return
     * @Description
     **/
    //rotate to the right
    private Node rotateRight(Node h){
        //获取h结点的左子结点，表示为x
        Node x = h.left;
        //让x结点的右子结点成为h结点的左子结点
        h.left= x.right;
        //让h结点成为x结点的右子结点
        x.right=h;
        //让x结点的color属性等于h结点的color属性
        x.color = h.color;
        //让h结点的color属性为红色
        h.color = RED;
        return x;
    }
    //颜色反转，拆分4-结点
    private void filpColors(Node h){
        //当前结点变为红色
        h.color = RED;
        //左子结点和右子结点变为黑色
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    //整个树上完成插入操作
    public void put(Key key,Value value){
        root=put(root,key,value);
        //根节点颜色总是黑色
        root.color = RED;
    }
    private Node put(Node h,Key key,Value value){
        //判断h是否为空，如果为空则直接返回红色结点
        if (h == null) {
            //数量+1
            N++;
            return new Node(key,value,null,null,RED);
        }

        //比较h结点的键和key的大小
        int cmp = key.compareTo(h.key);
        if (cmp<0){
            //继续往左
            h.left = put(h.left,key,value);
        }else if(cmp>0){
            //继续往右
            h.right = put(h.right,key,value);
        }else {
            //发生值的替换
            h.value=value;
        }

        //进行左旋,当当前结点的左子结点为黑色，右子结点为红色，需要左旋
        if (isRed(h.right) && !isRed(h.left)){
             h =rotateLeft(h);
        }
        //进行右旋,当当前结点的左子结点和左子结点的左子结点的都为红色，需要右旋
        if (isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }

        //颜色翻转,当前结点的左右子结点都为红色使进行颜色反转
        if (isRed(h.left) && isRed(h.right)){
            filpColors(h);
        }
        return h;
    }
    //根据key返回值
    public Value get(Key key){
        return get(root,key);
    }

    //从指定树x中查找key对应的值
    public Value get(Node x,Key key){
        if (x == null){
            return null;
        }

        //比较x结点的键和key的大小
        int cmp = key.compareTo(x.key);
        if (cmp<0){
            return get(x.left,key);
        }else if (cmp>0){
            return get(x.right,key);
        }else {
            return x.value;
        }
    }
}
