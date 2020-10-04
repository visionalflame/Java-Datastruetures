package heap;

/**
 * @ClassName HeapSort
 * @Description TODO
 * @Author MR.Zhou
 * @Date 2020/7/21 20:28
 * @Version 1.0
 **/
public class HeapSort <T extends Comparable<T>>{//堆排序
   private static boolean less(Comparable[] heap, int i, int j){//判断heap堆中索引i出的元素是否小于j的元素
        return heap[i].compareTo(heap[j])<0;
    }
    private static void exch(Comparable[] heap, int i ,int j){//元素交换
        Comparable tmp=heap[i];
        heap[i]=heap[j];
        heap[j]=tmp;
    }
    public static void sort(Comparable[] source){
        //构建堆
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source,heap);
        //定义一个变量，记录未排序的元素中最大索引
        int N = heap.length-1;
        //通过循环，交换1索引处的元素和未排序索引最大元素
        while (N!=1){
            //交换元素
            exch(heap,1,N);
            //排序交换后最大元素所在的索引，让它不要参与堆的下沉调整
            N--;
            //对索引1处的元素进行堆的下沉调整
            sink(heap,1,N);
        }
        //把heap中的数据复制到原数组source
        System.arraycopy(heap,1,source,0,source.length);

    }
    private static void createHeap(Comparable[] source,Comparable[] heap){//根据数组构造堆
        //把source中的元素拷贝到heap中，heap中的元素形成一个无序的堆
        System.arraycopy(source,0,heap,1,source.length);

        //对堆中元素下沉调整（从长度一半处开始，往索引1处扫描）
        for (int i = (heap.length)/2;i>0 ; i--) {
            sink(heap,i,heap.length-1);
        }
    }
    //在heap堆中对target处元素下沉，范围0~range
    private static void sink(Comparable[] heap , int target, int range){
        while(2*target<=range){
            //1.找出当前结点的较大的子结点
            int max ;
            if ((2*target+1)<=range){
                if (less(heap,2*target,2*target+1)){
                    max=2*target+1;
                }
                else {
                    max= 2 * target;
                }
            }else {
                max=2*target;
            }
            //2.比较当前结点的值和较大子结点的值
            if (!less(heap,target,max)){
                break;
            }
            exch(heap,target,max);

            target=max;
        }
    }
}
