package symbolTable;

/**
 * @ClassName SymbolTable
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/9 14:34
 * @Version 1.0
 **/
public class OrderSymbolTable<Key extends Comparable<Key>, Value>{
    //首结点
    private Node head;
    //元素个数
    private int N;

    public OrderSymbolTable() {
        this.head=new Node(null,null,null);
        this.N=0;
    }

    private class Node{
        //键
        public Key key;
        //值
        public Value value;
        //下一结点
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }


    }
    public int size(){
        return N;
    }
    public void put (Key key,Value value){//实现key有序排列
        //定义两个变量，记录当前和上一结点
        Node curr = head.next;
        Node prev = head;
        while(curr!=null&& key.compareTo(curr.key)>0){
            //变换当前和前一结点即可
            prev=curr;
            curr=curr.next;
        }
        //如果当前结点curr的key和要插入的key一样，则替换
        if (curr != null&&key.compareTo(curr.key)==0) {
            curr.value=value;
            return;
        }
        //如果当前结点curr的key和要插入的key不一样，把新结点插入到curr之前

            Node newNode = new Node(key, value, curr);
            prev.next=newNode;
            N++;


       /* //1符号表中已经存在key键的键值对，找到并替换
        Node n=head;
        while (n.next!=null){
            //变换n
            n=n.next;
            //判断n结点的key是否为k而已，是则替换n结点的值
            if (n.key.equals(key)) {
                n.value=value;
                return;
            }
        }
        //2符号表中不存在key键键值对，创建新结点，保存键值对并插入到链表尾部。 head。next=新结点
        //元素个数+1
        Node newNode = new Node(key, value, null);
        Node oldFirst = head.next;
        newNode.next=oldFirst;
        head.next=newNode;
        N++;*/
    }
    public void delete(Key key){
        //找到键为Key的键值对，把该结点从链表中删除
        Node n =head;
        while (n.next!=null){
            //判断n结点下一个结点的键是否为key，如是则删除该结点
            if (n.next.key.equals(key)) {
                n.next=n.next.next;
                N--;
                return;
            }

            //变换n
            n=n.next;
        }
    }
    public Value get(Key key){
        Node n = head;
        while (n.next!=null){
            //变换n
            n=n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }
}
