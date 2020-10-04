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
    //����ÿ��Ԫ����items�е�������pq������Ҫ������
    private int[] pq;
    //����pq������pq��ֵ��Ϊ������pq��������Ϊֵ
    private int[] qp;
    //��¼Ԫ�ظ���
    private int N;
    //����
    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.pq= new int[capacity+1];
        this.qp= new int[capacity+1];
        this.N=0;
        //Ĭ������£�������û���κ����ݣ���pq�е�Ԫ�ض�Ϊ-1
        for (int i = 0; i <qp.length ; i++) {
            qp[i]=-1;
        }
    }
    //��ȡԪ�ظ���
    public  int size(){
        return N;
    }
    //�ж��Ƿ�Ϊ��
    public boolean isEmpty(){
        return N==0;
    }
    //�ж�iԪ���Ƿ�С��jԪ��
    private boolean less(int i,int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }
    //��������i��j����ֵ
    private void exch(int i ,int j){
        //����pq�е�����
        int tmp = pq[i];
        pq[i]=pq[j];
        pq[j]= tmp;

        //����qp�е�����
        qp[pq[i]]=i;
        qp[pq[j]]=j;
    }
    //�ж�k��ӦԪ���Ƿ����
    public boolean contains(int k){
        return qp[k] != -1;
    }
    //��СԪ�ع���������
    public int minIndex(){
        return pq[1];
    }
    //������в���Ԫ�ز���������i
    public void insert(int i,T t){
        //�ж�i�Ƿ��Ѿ�������������Ѿ������������ò���
        if (contains(i)) {
            return;
        }
        //Ԫ�ظ���+1
        N++;
        //�����ݴ洢��items��Ӧiλ�ô�
        items[i]=t;
        //��i�洢��pq��
        pq[N] = i;
        //ͨ��qp����¼pq�е�i
        qp[i]=N;
        //ͨ�����ϸ���ɶѵĵ���
        swim(N);
    }
    //ɾ����СԪ�أ������ظ�Ԫ�ع�������
    public int delMin(){
        //��ȡ��СԪ�ع�������
        int minIndex = pq[1];
        //����pq������1�������������ֵ
        exch(1,N);
        //ɾ��qp�ж�Ӧ������
        qp[pq[N]]=-1;
        //ɾ��pq���������������
        pq[N]=-1;
        //ɾ��items�ж�Ӧ����
        items[minIndex]=null;
        //Ԫ�ظ���-1
        N--;
        //�³�����
        sink(1);
        return minIndex;
    }
    //ɾ��i������Ԫ��
    public void delete(int i){
        //�ҵ�i��pq�е�����
        int k = qp[i];

        //����pq����k����ֵ������N����ֵ
        exch(k,N);
        //ɾ��qp�е�����
        qp[pq[N]]=-1;
        //ɾ��pq�е�����
        pq[N]=-1;
        //ɾ��items�е�����
        items[N]=null;
        //Ԫ������-1
        N--;
        //�ѵ���
        swim(k);
        sink(k);

    }
    //��������i������Ԫ���޸�Ϊt
    public void changeItem(int i,T t){
        //�޸�items��iλ��Ԫ��Ϊt
        items[i] = t;
        //�ҵ�i��pq�г��ֵ�λ��
        int k = qp[i];
        //�ѵ���
        sink(k);
        swim(k);
    }
    //ͨ���ϸ��㷨ʹ����k��Ԫ���ڶ��д�����ȷλ��
    private void swim(int k){
        while(k>1){
            if (less(k,k/2)){
                exch(k,k/2);
            }

            k=k/2;

        }
    }
    //ͨ���³��㷨ʹ����k��Ԫ���ڶ��д�����ȷλ��
    private void sink(int k){
        while (2*k<=N){
            //�ҵ��ӽ���еĽ�Сֵ
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
            //�Ƚϵ�ǰ���ͽ�Сֵ
            if (less(k,min)){
                break;
            }

            exch(k,min);
            k=min;
        }
    }
}
