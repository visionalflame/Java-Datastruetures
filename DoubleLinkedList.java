package doubleLinkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class DoubleLinkedList <T>implements Iterable<T>{
    //头结点
    private Node head;
    //尾结点
    private Node last;
    //链表长度
    private int N;
    //结点类
    private class Node{
        public Node(T item,Node prev,Node next){
            this.item=item;
            this.next=next;
            this.prev=prev;
        }
        public T item;
        //上一结点
        public Node prev;
        //下一结点
        public Node next;
    }
    //构造
    public DoubleLinkedList(){
        //初始化头，尾结点
        this.head=new Node(null,null,null);
        this.last=null;
        this.N=0;
    }
    //清空
    public void clear(){
        this.head.next=null;
        this.head.prev=null;
        this.head.item=null;
        this.last=null;
        this.N=0;
    }
    //判空
    public boolean isEmpty(){
        return N==0;}
    public int length(){
        return N;}
    public T get(int i){
        Node n =head.next;      //注意next的作用
        for (int index = 0; index <i; index++) {
            n=n.next;
        }
        return n.item;
    }
    public Node getNode(int i){
        Node n=head.next;
        for (int index = 0; index < i; index++) {
            n=n.next;
        }
        return n;
    }
    public void insert(T t){
        if (isEmpty()){
            //创建新结点
            Node newNode=new Node(t,head,null);
            //让新结点成为尾结点
            last=newNode;
            //让头节点成为尾结点
            head.next=last;
        }
        else {
            //链表不为空
            Node oldLast=last;
            //创建新结点
            Node newNode=new Node(t,oldLast,null);
            //让当前尾结点指向新结点
            oldLast.next=newNode;
            //让新结点成为尾结点
            last=newNode;
        }
        //元素+1
        N++;
    };
    public void insert(int i,T t){
        //找到i位置前一结点
        Node pre=head;
        for (int index = 0; index < i; index++) {
            pre=pre.next;
        }
        //找到i位置结点
        Node curr=pre.next;
        //创建新节点
        Node newNode=new Node(t,pre,curr);
        //让i位置的前一个结点的下一结点变为新结点
        pre.next=newNode;
        //i位置的前一个结点变为新结点
        curr.prev=newNode;
        //元素+1
        N++;
    };
    public T remove(int i) {
        if (i<0||i>N)
            {return null;}
        Node node = getNode(i);
        if (node!=null){
            Node next=node.next;
            Node prev=node.prev;
            if (node.prev==null){
                head=next;
            }
            if (node.next==null){
                last=prev;
            }
            if (node.prev!=null&&node.next!=null) {
                prev.next = node.next;
                next.prev = node.prev;
            }
            N--;
            return node.item;
        }
        return null;
    }
    public int indexOf(T t){
        Node n=head;
        for (int i = 0; n.next!=null; i++) {
            if (n.next.equals(t)){
                return i;
            }
        }
        return -1;
    };
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return head.next.item;
    };
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    };

    @Override
    public Iterator<T> iterator() {
        return null;
    }
    private class TIterator implements Iterator{
        private Node n;
        public TIterator(){
            this.n=head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }
}
