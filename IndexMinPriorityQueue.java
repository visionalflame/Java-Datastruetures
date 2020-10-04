package priorityQueue;

/**
 * @ClassName IndexMinPriorityQueue
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/30 21:35
 * @Version 1.0
 **/
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    //保存每个元素在items中的索引，pq数组需要堆有序
    private int[] pq;
    //保存pq的逆序，pq的值作为索引，pq的索引作为值
    private int[] qp;
    //记录元素个数
    private int N;
    //构造
    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.pq= new int[capacity+1];
        this.qp= new int[capacity+1];
        this.N=0;
        //默认情况下，队列中没有任何数据，让pq中的元素都为-1
        for (int i = 0; i <qp.length ; i++) {
            qp[i]=-1;
        }
    }
    //获取元素个数
    public  int size(){
        return N;
    }
    //判断是否为空
    public boolean isEmpty(){
        return N==0;
    }
    //判断i元素是否小于j元素
    private boolean less(int i,int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }
    //交换索引i，j处的值
    private void exch(int i ,int j){
        //交换pq中的数据
        int tmp = pq[i];
        pq[i]=pq[j];
        pq[j]= tmp;

        //更新qp中的数据
        qp[pq[i]]=i;
        qp[pq[j]]=j;
    }
    //判断k对应元素是否存在
    public boolean contains(int k){
        return qp[k] != -1;
    }
    //最小元素关联的索引
    public int minIndex(){
        return pq[1];
    }
    //向队列中插入元素并关联索引i
    public void insert(int i,T t){
        //判断i是否已经被关联，如果已经被关联，则不让插入
        if (contains(i)) {
            return;
        }
        //元素个数+1
        N++;
        //把数据存储到items对应i位置处
        items[i]=t;
        //把i存储到pq中
        pq[N] = i;
        //通过qp来记录pq中的i
        qp[i]=N;
        //通过堆上浮完成堆的调整
        swim(N);
    }
    //删除最小元素，并返回该元素关联索引
    public int delMin(){
        //获取最小元素关联索引
        int minIndex = pq[1];
        //交换pq中索引1和最大索引处的值
        exch(1,N);
        //删除qp中对应的内容
        qp[pq[N]]=-1;
        //删除pq最大索引处的内容
        pq[N]=-1;
        //删除items中对应内容
        items[minIndex]=null;
        //元素个数-1
        N--;
        //下沉调整
        sink(1);
        return minIndex;
    }
    //删除i关联的元素
    public void delete(int i){
        //找到i在pq中的索引
        int k = qp[i];

        //交换pq索引k处的值和索引N处的值
        exch(k,N);
        //删除qp中的内容
        qp[pq[N]]=-1;
        //删除pq中的内容
        pq[N]=-1;
        //删除items中的内容
        items[N]=null;
        //元素数量-1
        N--;
        //堆调整
        swim(k);
        sink(k);

    }
    //把宇索引i关联的元素修改为t
    public void changeItem(int i,T t){
        //修改items中i位置元素为t
        items[i] = t;
        //找到i在pq中出现的位置
        int k = qp[i];
        //堆调整
        sink(k);
        swim(k);
    }
    //通过上浮算法使索引k的元素在堆中处于正确位置
    private void swim(int k){
        while(k>1){
            if (less(k,k/2)){
                exch(k,k/2);
            }

            k=k/2;

        }
    }
    //通过下沉算法使索引k的元素在堆中处于正确位置
    private void sink(int k){
        while (2*k<=N){
            //找到子结点中的较小值
            int min;
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    min = 2*k;
                }
                else {
                    min= 2*k+1;
                }
            }else {
                min= 2*k;
            }
            //比较当前结点和较小值
            if (less(k,min)){
                break;
            }

            exch(k,min);
            k=min;
        }
    }
}
