/**
 * 无序数组转有序数组--快速算法
 */
public class AlgorithmPractice {
    public static void main(String[] args) {
        int[] ary={89,21,38,25,158,29,66,40,5,99};
        qsort(ary,0,ary.length-1);
        for (int i = 0; i < ary.length; i++) {
            System.out.print(ary[i]+"，");
        }
    }

    public static void qsort(int[] data,int left,int right){
        int base=data[left];//89
        int ll=left;//0
        int rr=right;//10
        while(ll<rr){
            while(ll<rr && data[rr]>=base){
                rr--;//9
            }
            if(ll<rr){
                int temp=data[rr];//99
                data[rr]=data[ll];//89,21,38,25,158,29,66,40,5,89
                data[ll]=temp;//99,21,38,25,158,29,66,40,5,89
                ll++;//1
            }
            while(ll<rr && data[ll]<=base){
                ll++;
            }
            if(ll<rr){
                int temp=data[rr];//89
                data[rr]=data[ll];//99,21,38,25,158,29,66,40,5,21
                data[ll]=temp;//99,89,38,25,158,29,66,40,5,21
                rr--;//8
            }
        }
        if(ll>left){
            qsort(data,left,ll-1);
        }
        if(rr<right){
            qsort(data,ll+1,right);
        }
    }
}
