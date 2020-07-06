import java.util.Arrays;

/**
 * @author : liulinzhi
 * @date: 2020/07/06/17:58
 * @description:归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length <= 1)
            return;
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
    }
    public static void mergeSort(int[] arr, int left, int right, int[] temp)
    {
        if(left == right)
            return;
        int mid = left + ((right - left)>>1);
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid+1,right, temp);
        merge(arr, left, mid, right, temp);

    }
    public static void merge(int[] arr, int left, int mid,int right, int[] temp)
    {
        int i = left;
        int j = mid + 1;
        for(int k = left; k <= right; k++)
        {
            if(i > mid && j <= right)
                temp[k] = arr[j++];
            else if(j > right && i <=mid)
                temp[k] = arr[i++];
            else if(arr[i] <= arr[j])
                temp[k] = arr[i++];
            else
                temp[k] = arr[j++];
        }
        copyArray0(temp, left, right,arr);
    }

    public static void copyArray0(int[] arr,int left, int right,int[] temp)
    {
        for(int i = left; i <= right; i++)
            temp[i] = arr[i];

    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);

    }
}
