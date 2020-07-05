/**
 * @author : liulinzhi
 * @date: 2020/07/05/21:56
 * @description:递归求数组中的最大值
 */
public class GetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {//只有一个数
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        //中点，不推荐(L+R)/2
        //万一L+R刚好溢出基本类型最大的长度会出错，
        //且位移运算比除法快
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
