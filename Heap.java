package heap;

/**
 * @ClassName Heap
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/21 15:14
 * @Version 1.0
 **/
public class Heap<T extends Comparable<T>> {
    //存储堆中元素
    private T[] items;
    //记录元素个数
    private int N;

    public Heap(int capacity) {
        this.items =(T[]) new Comparable[capacity+1];
        this.N=0;
    }
    //判断堆中索引i处元素是否小于索引j处元素
    private boolean less(int i,int j){
        return (items[i].compareTo(items[j])<0);
    }
    //交换索引i，j处的值
    private void exch(int i,int j){
        T temp=items[i];
        items[i]=items[j];
        items[j]=temp;
    }
    //往堆中插入元素
    public void insert(T t){
        items[++N]=t;//++N作用，废弃掉0索引，同时保证元素数量匹配
        swim(N);
    }
    //使用上浮算法，让索引k处元素处在正确位置
    private void swim(int k){
        //通过循环不断比较当前结点的值和父结点的值，如果发现父结点的值比当前结点的值小，则交换位置
        while(k>1){
            //比较当前结点和其父结点
            if (less(k/2,k)) {
                exch(k/2,k);
            }
            k=k/2;
        }
    }

    //删除堆中最大元素
    public T delMax(){
        T max = items[1];
        //交换所以1处的元素和最大索引元素，让完全二叉树中最右侧元素变为临时根节点
        exch(1,N);
        //最大索引处元素删除掉
        items[N]=null;
        //元素个数-1
        N--;
        //下沉调整堆，让堆重新有序
        sink(1);
        return max;
    }
    //使用下沉算法，使k处的元素在堆中处于一个正确位置
    private void sink(int k){
        //通过循环不断对比当前结点和其左子节点2*k以及右子结点2k+1处中较大的元素的大小，如果当前结点小，则需要交换位置
        while(2*k<=N){
            //获取当前结点的子结点中的较大结点
            int max;//记录较大结点的索引
            if (2*k+1 <=N) {
                if (less(2*k,2*k+1)){
                    max=2*k+1;
                }
                else {
                    max=2*k;
                }
            }
            else {
                max=2*k;
            }
            //比较当前节点和较大结点的值
            if (!less(k,max)){
                break;
            }

            //交换k索引和max索引的值
            exch(k,max);

            //变换k的值
            k=max;
        }
    }

}
