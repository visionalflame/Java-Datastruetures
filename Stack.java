package mystack;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @ClassName Stack
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/6 8:33
 * @Version 1.0
 **/
public class Stack<T> implements Iterable<T>{
    private  class Node{
        public T item;
        public Node next;

        public Node(T item,Node next) {
            this.item = item;
            this.next = next;
        }
    }
    //记录首结点
    private Node head;
    //记录元素个数
    private int N;

    public Stack(){
        this.head=new Node(null,null);
        this.N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    /**
     * @Author Visional Flame
     * @Date  2020/7/6
     * @Param [t]
     * @return void
     * @Description 把t元素压入栈
     **/
    public void push(T t){
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        //创建新结点
        Node newNode = new Node(t, null);
        // 首结点指向新结点
        head.next=newNode;
        // 让新结点指向原来的第一个结点
        newNode.next=oldFirst;
        //元素个数+1
        N++;
    }
    /**
     * @Author Visional Flame
     * @Date  2020/7/6
     * @Param []
     * @return T
     * @Description 弹出栈顶元素
     **/
    public T pop(){
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        if (oldFirst == null) {
            return null;//防止空栈
        }
        //首结点指向第一个结点的下一结点
        head.next=oldFirst.next;
        //元素个数-1
        N--;
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{
        private Node n;
        public SIterator(){
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
