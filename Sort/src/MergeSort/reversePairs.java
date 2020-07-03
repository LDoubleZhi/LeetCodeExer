package MergeSort;

import com.sun.scenario.effect.Merge;
import sun.rmi.server.InactiveGroupException;

/**
 * @author : liulinzhi
 * @date: 2020/07/02/21:15
 * @description:逆序对问题
 */
public class reversePairs {
    private static Comparable[] temp;
    private static int count = 0;

    private static int MergeSort(Comparable[] a){
        if(a == null || a.length <=1)
            return 0;//没有的话对空数组会出错
        temp = new Comparable[a.length];

        return sort(a, 0, a.length-1, temp);
    }

    private static int sort(Comparable[] a, int left, int right, Comparable[] temp)
    {
        if(left == right) return 0;
        int mid = (left + right) /2;
        return sort(a, left, mid, temp)
                    +sort(a, mid+1, right, temp)
                    +merge(a, left, mid, right, temp);

    }

    public static int merge(Comparable[] a,int left, int mid
            , int right, Comparable[] temp){
        int sum = 0;
        int i = left, j = mid + 1;
        for(int k = left; k <= right; k++)
            temp[k] = a[k];

        for(int k = left; k <= right; k++){
            if(i>mid)   a[k] = temp[j++];
            else if (j > right) a[k] = temp[i++];
            else if (less(temp[j], temp[i])) {
                a[k]=temp[j++];
                sum += (mid - i + 1);
            }
            else    {
                a[k]=temp[i++];
            }
        }
        return sum;
    }

    public static int  reversePairs(int[] nums) {
        Integer[] num = new Integer[nums.length];
        for(int i =0; i<nums.length;i++)
            num[i]= (Integer)nums[i];
        return MergeSort(num);
    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {7,5,6,4};
        int[] nums = {};
//        SelectionSort(a);
//        InsertionSort(a);
//        ShellSort(a);
        MergeSort(a);
        assert isSorted(a);
        show(a);
        System.out.println(reversePairs(nums));



    }

}
