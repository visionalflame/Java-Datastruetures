package tree;

/**
 * @ClassName RedBlackTree
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/9/14 19:20
 * @Version 1.0
 **/
public class RedBlackTree<Key extends Comparable<Key>,Value>{
    //���ڵ�
    private Node root;
    //��¼����Ԫ�ظ���
    private int N;
    //��ɫ����
    private static final boolean RED = true;
    //��ɫ����
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
        //��ȡh�������ӽ�㣬��ʾΪx
        Node x = h.right;
        //��x�������ӽڵ��Ϊh�������ӽ��
        h.right= x.left;
        //��h��Ϊx�������ӽ��
        x.left= h;
        //��x����color���Ե���h����h����color ����
        x.color=h.color;
        //��h����color���Ա�Ϊ��ɫ
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
        //��ȡh�������ӽ�㣬��ʾΪx
        Node x = h.left;
        //��x�������ӽ���Ϊh�������ӽ��
        h.left= x.right;
        //��h����Ϊx�������ӽ��
        x.right=h;
        //��x����color���Ե���h����color����
        x.color = h.color;
        //��h����color����Ϊ��ɫ
        h.color = RED;
        return x;
    }
    //��ɫ��ת�����4-���
    private void filpColors(Node h){
        //��ǰ����Ϊ��ɫ
        h.color = RED;
        //���ӽ������ӽ���Ϊ��ɫ
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    //����������ɲ������
    public void put(Key key,Value value){
        root=put(root,key,value);
        //���ڵ���ɫ���Ǻ�ɫ
        root.color = RED;
    }
    private Node put(Node h,Key key,Value value){
        //�ж�h�Ƿ�Ϊ�գ����Ϊ����ֱ�ӷ��غ�ɫ���
        if (h == null) {
            //����+1
            N++;
            return new Node(key,value,null,null,RED);
        }

        //�Ƚ�h���ļ���key�Ĵ�С
        int cmp = key.compareTo(h.key);
        if (cmp<0){
            //��������
            h.left = put(h.left,key,value);
        }else if(cmp>0){
            //��������
            h.right = put(h.right,key,value);
        }else {
            //����ֵ���滻
            h.value=value;
        }

        //��������,����ǰ�������ӽ��Ϊ��ɫ�����ӽ��Ϊ��ɫ����Ҫ����
        if (isRed(h.right) && !isRed(h.left)){
             h =rotateLeft(h);
        }
        //��������,����ǰ�������ӽ������ӽ������ӽ��Ķ�Ϊ��ɫ����Ҫ����
        if (isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }

        //��ɫ��ת,��ǰ���������ӽ�㶼Ϊ��ɫʹ������ɫ��ת
        if (isRed(h.left) && isRed(h.right)){
            filpColors(h);
        }
        return h;
    }
    //����key����ֵ
    public Value get(Key key){
        return get(root,key);
    }

    //��ָ����x�в���key��Ӧ��ֵ
    public Value get(Node x,Key key){
        if (x == null){
            return null;
        }

        //�Ƚ�x���ļ���key�Ĵ�С
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
