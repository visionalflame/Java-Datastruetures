package onewayLinkedlist;
import java.util.Iterator;
public class OneWayLinkedList <T>implements Iterable<T>{
    //记录头节点
    private Node head;
    //记录链表长度
    private int N;

    //节点类
    private class Node{
        //存储元素
        public T item;
        //指向下一节点
        public Node next;

        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }

    public OneWayLinkedList(){
        //初始化头节点
        this.head=new Node(null,null);
        //初始化元素个数
        this.N=0;
    }
    public void clear(){
        head.next=null;
        this.N=0;
    }
    public int length(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public T get(int i){
        //通过循环从头结点开始往后找，找I次找到对应元素
        Node n=head.next;
        for (int index = 0; index <i; index++) {
            n=n.next;
        }
        return n.item;
    }
    public void insert(T t){
        //找到当前最后一个节点
        Node n=head;
        while (n.next!=null){
            n=n.next;
        }
        //创建新节点，保存元素T
        Node newNode= new Node(t,null);
        //让当前最后一个节点指向新节点
        n.next=newNode;

        //元素个数+1
        N++;
    }
    public void insert(int i,T t){
        //找到i 位置前一个节点
        Node prev=head.next;
        for (int index = 0; index < i-1; index++) {
            prev=prev.next;
        }
        //找到i位置节点
        Node curr=prev.next;
        //创建新节点，新节点指向原来i位置节点
        Node newNode=new Node(t,curr);
        //原来i前一个节点指向新节点即可
        prev.next=newNode;
        //个数+1
        N++;
    }
    public T remove(int i){
        //找到i位置前一个节点
        Node prev=head.next;
        for (int index = 0; index < i-1; index++) {
            prev=prev.next;
        }
        //找到i位置节点
        Node curr=prev.next;
        //找到i位置下一个节点
        Node nextNode=curr.next;
        //i前一个节点指向下一个节点
        prev.next=nextNode;
        //元素个数-1
        N--;
        return curr.item;
    }
    public int indexOf(T t){
        //从头节点开始依次找到每一个节点，取出item，如果和t相同则找到index
        Node n=head;
        for (int i = 0; n.next!=null; i++) {
            n=n.next;
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }
    public void reverse(){
        //判断是否为空链表,是则结束，不是则调用recerse()的重载
        if (isEmpty()){
            return;
        }
        reverse(head.next);
    }
    //反转指定节点curr
    public Node reverse(Node curr){
        if (curr.next==null){
            head.next=curr;
            return curr;
        }
        //递归反转当前节点curr下一个节点,返回值就是链表反转后，当前节点的上一个节点
        Node prev =reverse(curr.next);
        //让返回的节点的下一个节点变为当前节点curr
        prev.next=curr;
        //把当前节点的下一个节点变为null
        curr.next=null;
        return curr;
    }
    //快慢指针
    public  T getMid(){
        Node fast = head;
        Node slow = head;
        //两个指针遍历
        while (fast!=null&&fast.next!=null){
            //移动两个指针
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.item;
    }
    //判定是否为环
    public boolean isCircle(){
        //定义快慢指针
        Node fast=head;
        Node slow=head;
        //遍历
        while (fast!=null&&fast.next!=null){
            //变化fast和slow
            fast=fast.next.next;
            slow=slow.next;
            if (fast.next.next==null)
                return false;
            if (fast==slow)
            return true;
        }
        return true;
    }
    //设置链表为环
    public boolean setCircle(){
        Node n=head;
        while (n.next!=null){
            n=n.next;
        }
        n.next=head;
        return true;
    }
    //有环链表入口
    public int getEntrance(){
        //定义快慢指针
        Node fast=head;
        Node slow=head;
        Node temp=null;
        //遍历
        while (fast!=null&&fast.next!=null){
            //变化fast和slow
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)
            //准备临时指针指向head，继续遍历，当临时指针与慢指针相遇时为环的入口
            {
                temp=head;
                continue;
            }
            //临时指针变换
            if (temp!=null){
                temp=temp.next;
                if (temp.equals(slow)){
                    break;
                }
            }
        }
        return indexOf(slow.item);
    }
    @Override
    public Iterator<T> iterator(){
        return new LIterator();
    }
    private class LIterator implements Iterator{
        private Node n;
        public LIterator(){
            this.n=head;
        }
        @Override
        public boolean hasNext(){
            return n.next!=null;
        }
        @Override
        public Object next(){
            n=n.next;
            return n.item;
        }
    }
}
