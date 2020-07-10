/**
 * @author : liulinzhi
 * @date: 2020/07/08/19:15
 * @description:
 */
public class QuickSort2 {

    public static void quick_2_0(int[] arr, int L, int R){
        process(arr,L, R);
    }


    public static void process(int[] arr, int L, int R) {
        //中间的等于区都不动
        int[] index_arr = patition(arr, L, R);
        int parL = index_arr[0];
        int parR = index_arr[1];

        if(parL > L + 1)
            process(arr, L, parL -1);
        if(parR < R - 1)
            process(arr, parR + 1, R);

    }
    public static int[] patition(int[] arr, int L, int R)
    {//基础的荷兰国旗问题，小于等于num的放左边，大于的放右边
        //设置一个小于区和大于区
        int[] index_arr = new int[2];
        int num = arr[R];
        int min_index = L-1;
        int max_index = R;
        int i = L;
        while(i < R){
            //进入大于区就停止
            if(i >= max_index)
                break;
            //判断当前数和num的关系
            if(arr[i] < num){
                //和小于区下一个数交换，小等区+1
                swap(arr, i, min_index + 1);
                min_index++;
                i++;//看下一个数
            }
            else if(arr[i] > num)
            {   //和大于区前一个数交换，大于区扩大1
                swap(arr, i, max_index - 1);
                max_index--;
            }
            else//等于时候直接下一个
                i++;
        }
        swap(arr, max_index, R);
        index_arr[0] = min_index+1;
        index_arr[1] = max_index;
        return index_arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,4,7,2,9,0,1,4,3,5,3};
//        patition(arr, 4);
        quick_2_0(arr, 0, arr.length-1);
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}
