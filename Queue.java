package queue;

import java.util.Iterator;

/**
 * @ClassName Queue
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/8 16:58
 * @Version 1.0
 **/
public class Queue <T>implements Iterable<T>{
    //首结点
    private Node head;
    //尾结点
    private Node last;
    //记录个数
    private int N;
    //内部类Node
    private class Node{
        public T item;
        public Node next;
        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }
    public Queue(){
        this.head=new Node(null,null);
        this.last=null;
        this.N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return  N;
    }
    //向队列中插入元素t
    public void enqueue(T t){
        //当前尾结点last为null
        if (last == null) {
            last = new Node(t,null);
            head.next=last;
        }else
        {
            //当前尾结点last不为null
        Node oldlast=last;
        last=new Node(t,null);
        oldlast.next=last;
        }
        N++;
    }
    //从队列中拿出一个元素
    public T dequeue(){
        if (isEmpty()) {
            return null;
        }
        Node oldFirst= head.next;
        head.next=oldFirst.next;
        N--;
        //因为出队列其实是在删除元素，如果元素删除完了，需要重置last=null
        if (isEmpty()) {
            last=null;
        }
        return oldFirst.item;
    }
    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }
    private class QIterator implements Iterator{
        private  Node n;
        public  QIterator(){
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
