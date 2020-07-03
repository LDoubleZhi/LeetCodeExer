package MergeSort;

import java.util.Comparator;

/**
 * @author : liulinzhi
 * @date: 2020/07/03/18:49
 * @description:小和问题：
 * 在一个数组中，每一个数的左边比当前的数小的数
 * 累加起来，叫做这个数的小和
 */
public class MinSumByMerge {
    private static Comparable[] temp;

    public static int MinSumByMerge(Comparable[] arr)
    {
        if(arr == null || arr.length == 0)
            return 0;
        temp = new Comparable[arr.length];
        return sort(arr, 0, arr.length-1, temp);

    }
    private  static int sort(Comparable[] a, int left, int right, Comparable[] temp)
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
            if(i>mid)   {
                a[k] = temp[j++];
                for(int s = left; s <= mid; s++){
                    sum += (int) temp[s];
                }
            }
            else if (j > right) a[k] = temp[i++];
            else if (less(temp[j], temp[i])) {
                a[k]=temp[j++];
                for(int s = left; s < i; s++){
                    sum += (int) temp[s];
                }

            }
            else    {
                a[k]=temp[i++];
            }
        }
        System.out.println(sum);
        return sum;
    }


    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,3,4,2,5};

        System.out.println(MinSumByMerge(arr));

    }
}
