package tree;

import queue.Queue;

/**
 * @ClassName BinaryTree
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/11 1:13
 * @Version 1.0
 **/
public class BinaryTree <Key extends Comparable<Key>,Value>{
    //结点类
    public class Node{
        //键
        public Key key;
        //值
        private Value value;
        //左子结点
        public Node left;
        //右子结点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
    //根结点
    private Node root;
    //元素个数
    private int N;


    public  int size(){
        return N;
    }
    //添加元素key-value
    public void put(Key key,Value value){
       root= put(root ,key ,value);
    }

    //给定的树添加键值对
    private Node put(Node x,Key key, Value value){
        //如果X子树为空
        if (x==null){
            N++;
            return new Node(key,value,null,null);
        }
        //如果X子树不为空

        //比较X结点的key和key的大小
        int cmp = key .compareTo( x.key);
        if (cmp >0) {
            //如果Key大于x结点的key，则继续找X结点的右子树
            x.right=put(x.right,key,value);
        }
        else if (cmp < 0) {
            //如果Key小于x结点的key，则继续找X结点的左子树
            x.left=put(x.left,key,value);
        }else if (cmp==0){
            //如果Key等于x结点的key，则替换X结点的值为Value
            x.value=value;
        }
        return x;

    }
    //查询key对应value
    public Value get(Key key){
        return get(root,key);
    }
    //指定树查询key对应value
    private Value get(Node x, Key key){
        //x树为null
        if (x == null) {
            return null;
        }
        //x树不为null
        //比较key和x结点的key的大小
        int compare = key.compareTo(x.key);
        if (compare > 0 ) {
            //如果Key大于x结点的key，则继续找X结点的右子树
            return get(x.right,key);
        }
        else if (compare<0){
            //如果Key小于x结点的key，则继续找X结点的左子树
            return get(x.left,key);
        }
        else{
            //如果Key等于x结点的key，则找到键为key的结点，返回x结点键的值
            return x.value;
        }
    }
    //删除key对应的结点
    public void delete(Key key){
        delete(root,key);
    }
    //指定树删除key对应的结点
    private Node delete(Node x,Key key){
        //x树为null
        if (x == null) {
            return null;
        }
        //x树不为null
        //比较X结点的key和key的大小
        int cmp = key .compareTo( x.key);

        if (cmp >0) {
            //如果Key大于x结点的key，则继续找X结点的右子树
            x.right=delete(x.right,key);
        }
        else if (cmp < 0) {
            //如果Key小于x结点的key，则继续找X结点的左子树
            x.left=delete(x.left,key);
        }else {
            //如果Key等于x结点的key，则替换X结点的值为Value

            //找到右子树最小结点
            if (x.right == null) {
                //个数-1
                N--;
                return x.left;
            }
            if (x.left == null) {
                //个数-1
                N--;
                return x.right;
            }

            //找出右子树最左结点
            Node minNode= x.right;
            while (minNode.left!=null){
                minNode=minNode.left;
            }
            //删除右子树中最小结点
            Node n=x.right;
            while (n.left!=null){
                if (n.left.left== null) {
                    n.left=null;
                }
                else {
                    n=n.left;
                }
            }

            //让x结点左子树成为minNode左子树
            minNode.left=x.left;
            //让x结点右子树成为minNode右子树
            minNode.right=x.right;
            //让x结点父结点指向minNode
            x = minNode;
            //个数-1
            N--;

        }
        return x;
    }

    //整个树找出最小键
    public Key min(){
        return min(root).key;
    }
    //子树找出最小键

    private Node min(Node x){
        //判断x有没有左子结点，有则继续向左找，没有则x是最小键所在结点
        if (x.left != null) {
            return (min(x.left));

        }else {
            return x;
        }
    }
    //整个树找出最大键
    public Key max(){
        return max(root).key;
    }

    //子树找出最大键
    private Node max(Node x){
        //判断x有没有右子结点，有则继续向右找，没有则x是最大键所在结点
        if (x.right != null) {
            return max(x.right);
        }
        else {
            return x;
        }
    }
    //获取整个树所有的键
    //放入顺序：中左右
    public Queue<Key> preErgodic() //前序遍历 "根节点，左子树，（递归）右子树"
    {
        Queue<Key> keys = new Queue<>();
        preErgodic(root,keys);
        return  keys;
    }
    //指定树中获取所有键并放到keys队列
    private void preErgodic(Node x,Queue<Key> keys){
        if (x == null) {
            return;
        }
        //把x结点的key放到keys中
        keys.enqueue(x.key);

        //递归遍历x结点左子树
        if (x.left != null) {
            preErgodic(x.left,keys);
        }

        //递归遍历x结点右子树
        if (x.right != null) {
            preErgodic(x.right,keys);
        }
    }
    //中序遍历获取树中所有的键
    //放入顺序：左中右
    public Queue<Key> midErgodic() //中序遍历
    {
        Queue<Key> keys = new Queue<>();
        midErgodic(root,keys);
        return keys;
    }
    //使用中序遍历获取指定树X中所有的键并存放到key中
    private void midErgodic(Node x,Queue<Key> keys){
        if (x == null) {
            return;
        }
        //递归把左子树键放到keys中
        if (x.left != null) {
            midErgodic(x.left,keys);
        }
        //当前结点x放到keys中
        keys.enqueue(x.key);
        //递归把右子树键放到keys中
        if (x.right != null) {
            midErgodic(x.right,keys);
        }
    }
    //后序遍历获取树中所有的键
    //放入顺序：左右中
    public  Queue<Key> afterErgodic(){//后序遍历
        Queue<Key> keys = new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }
    //后序遍历，把指定树x中所有的键放入到keys中
    private void afterErgodic(Node x,Queue<Key> keys){
        if (x == null) {
            return;
        }
        //把左子树所有键放入到keys中，递归
        if (x.left != null) {
            afterErgodic(x.left,keys);
        }
        //把右子树所有键放入到keys中，递归
        if (x.right != null) {
            afterErgodic(x.right,keys);
        }
        //把x结点放入到keys中
        keys.enqueue(x.key);
    }

    //层序遍历 (广度优先)
    public Queue<Key> layerErgoidc(){
        //定义两个队列，分别存储树中的键和树中的结点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        //默认往队列放入根节点
        nodes.enqueue(root);
        while (!nodes.isEmpty()){
            //从队列中弹出结点，key放入keys中
            Node n = nodes.dequeue();
            keys.enqueue(n.key);
            //判断当前结点有没有左子结点，如果有，则放入nodes中
            if (n.left != null) {
                nodes.enqueue(n.left);
            }
            //判断当前结点有没有右子结点，如果有，则放入nodes中
            if (n.right != null) {
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }
    //获取整个树最大深度
    public int maxDepth(){
        return maxDepth(root);
    }
    //获取指定子树x最大深度
    private int maxDepth(Node x){
        if (x == null) {
            return 0;
        }
        //x最大深度
        int max=0;
        //x左子树最大深度
        int maxL=0;
        //x右子树最大深度
        int maxR=0;
        //计算x结点左子树最大深度
        if (x.left != null) {
            maxL=maxDepth(x.left);
        }
        //计算x结点右子树最大深度
        if (x.right != null) {
            maxR = maxDepth(x.right);
        }
        //比较左子树最大深度和右子树最大深度，取较大值+1即可
        max=maxL>maxR?maxL+1:maxR+1;

        return max;
    }

    //
}
