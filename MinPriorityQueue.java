package priorityQueue;

/**
 * @ClassName MinPriorityQueue
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/27 23:14
 * @Version 1.0
 **/
public class MinPriorityQueue<T extends Comparable<T>> {
    private int N;
    private T[] items;

    public MinPriorityQueue(int capaticy) {

        this.items= (T[]) new Comparable[capaticy+1];
        this.N=0;
    }

    //判空
    public boolean isEmpty(){
        return N==0;
    }
    //判断i元素是否小于j元素
    private boolean less(int i,int j) {
        return items[i].compareTo(items[j])<0;
    }
    //交换堆中i索引和j索引的值
    private void exch(int i , int j){
        T tmp= items[i];
        items[i]=items[j];
        items[j]=tmp;
    }
    //删除最小元素
    public T delMin(){
        T min = items[1];
        exch(1,N);
        N--;
        sink(1);

        return min;

    }
    //插入元素
    public void insert(T t){
        items[++N]=t;
        swim(N);
    }
    //上浮算法，使k处元素能在堆中处于一个正确位置
    private void swim(int k){
        //通过循环比较当前结点和其父结点大小
        while (k>1){
            if (less(k,k/2)){
                exch(k,k/2);
            }
            k=k/2;
        }
    }
    //下沉算法，使k处元素能在堆中处于一个正确位置
    private void sink(int k){
        //通过循环比较当前结点和其子结点中的较小值
        while (2*k<=N){
            //1.找到子结点中的较小值
            int min;
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    min=2*k;
                }
                else {
                    min=2*k+1;
                }
            }else {
                min=2*k;
            }
            //2.判断当前结点和较小值大小
            if (less(k,min)){
                break;
            }
            exch(k,min);

            k=min;
        }

    }
}
