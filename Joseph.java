package onewayLinkedlist;
/**
 * @ClassName Joseph
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/6/29 23:38
 * @Version 1.0
 **/
public class Joseph {
    public static void main(String[] args) {
        //约瑟夫问题解决

        //1 构建循环链表，包含41个节点，存储1-41个值
        //记录首节点
        Node<Integer> first = null;
        //记录前一节点
        Node<Integer> prev= null;
        for (int i = 1; i <=41; i++) {

            //如果是第一个节点
            if (i==1){
                first=new Node<>(i,null);
                prev=first;
                continue;
            }
            //如果不是第一个节点
            Node<Integer> newNode = new Node<>(i, null);
            prev.next=newNode;
            prev=newNode;//重置pre
            //如果是最后一个节点，那么需要最后一个节点的下一个节点变为first
            if (i==41){
                prev.next=first;//设为循环链表
            }
        }
        //2 count计数器 模拟报数
        int count=0;
        //3 遍历循环链表
        //记录每次遍历拿到的节点，默认为首节点
        Node<Integer> n = first;
        //记录当前节点的上一个节点
        Node<Integer> before=null;
        while (n!=n.next){
            //模拟报数
            count++;

            //判断当前报数是否为3
            if (count==3){
                //如果为3，删除当前节点，打印当前节点，重置count=0,让当前节点n后移
                before.next=n.next;
                System.out.print(n.item+" ");
                count=0;
                n=n.next;
            }else {
                //如果不是3，让before变为当前节点，让当前节点后移。
                before=n;
                n=n.next;
            }
        }
        //打印最后一个元素
        System.out.println(n.item);
    }
    private static class Node<T>{
        //存储元素
        public T item;
        //指向下一节点
        public Node next;

        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }


}
