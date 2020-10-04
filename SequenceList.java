package seqList;
import java.util.Iterator;
import java.util.Objects;

public class SequenceList<T> implements Iterable{
    private T[] eles;   //存储数组
    private int N;  //记录个数

    public SequenceList(int capacity){//构造
        this.eles=(T[]) new Object[capacity];//Object强转
        this.N=0;
    }
    public void clear(){
        this.N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int length(){
        return N;
    }
    public T get(int i){
        return eles[i];
    }
    public void insert(T t){//尾部添加元素T
        if (N==eles.length){
            resize(eles.length*2);
        }
        eles[N++]=t;
    }
    public void insert(int i,T t){//先把i索引处的元素及其后面元素向后移动1位
        if (N==eles.length){
            resize(eles.length*2);
        }
        for (int index = N; index >i; index--) {
            eles[index]=eles[index-1];
        }
        eles[i]=t;

        N++;
    }
    public T remove(int i){
        T current=eles[i];//记录索引处的值
        for (int index = i; index <N-1 ; index++) {
            eles[index]=eles[index+1];
        }
        this.N--;
        if (N<eles.length/4){
            resize(eles.length/2);
        }
        return current;
    }
    public int indexOf(T t){
        for (int i = 0; i <N ; i++) {
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }
    //根据newsize 重置eles大小
    public void resize(int newsize){
        //定义一个临时数据，指向原数组
        T[] temp=eles;
        //创建新数组
        eles=(T[]) new Object[newsize];
        //原数组拷贝
        for (int i = 0; i <N; i++) {
            eles[i]=temp[i];
        }
    }
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class SIterator implements Iterator{
        private int cusor;
        public SIterator(){
            this.cusor=0;
        }
        @Override
        public boolean hasNext() {
            return cusor<N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }
}
