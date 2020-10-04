package priorityQueue;

/**
 * @ClassName MaxPriorityQueue
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/27 21:39
 * @Version 1.0
 **/
public class MaxPriorityQueue<T extends Comparable<T>> {
    //存储元素
    private T[] items;
    //记录个数
    private int N;

    public MaxPriorityQueue(int capacity) {
        this.items= (T[]) new Comparable[capacity+1];
        this.N=0;
    }

    //获取元素个数
    public int size(){
        return N;
    }

    //判断是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //判断i的值是否小于j的值
    public boolean less(int i , int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换i，j的值
    private void exch(int i , int j){
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //堆中插入元素
    public void insert(T t){
        items[++N]=t;
        swim(N);
    }

    //删除堆中最大元素并返回其值
    public T delMax(){
        T max = items[1];
        exch(1,N);
        N--;
        sink(1);
        return max;
    }

    //使用上浮算法，使索引K的元素在堆中处于正确位置
    private void swim(int k){
        while(k>1){
            if (less(k/2,k)){
                exch(k/2,k);
            }
            k=k/2;
        }
    }
    //使用下沉算法，使索引K的元素在堆中处于正确位置
    private void sink(int k){
        while (2*k<=N){
            int max;
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    max=2*k+1;
                }else{
                    max=2*k;
                }
            }else {
                max=2*k;
            }


            if (!less(k,max)){
                break;
            }
            exch(k,max);

            k=max;
        }

    }
}
