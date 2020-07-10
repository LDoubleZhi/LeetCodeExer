/**
 * @author : liulinzhi
 * @date: 2020/07/06/18:01
 * @description:
 */
public class NetherlandsFlag {
    public static void patition(int[] arr, int num)
    {//基础的荷兰国旗问题，小于等于num的放左边，大于的放右边
        //设置一个小于等于区域
        int min_index = -1;
        for(int i = 0;i < arr.length; i++){
            //判断当前数和num的关系
            if(arr[i] <= num){
                //和小等区下一个数交换，小等区+1
                swap(arr, i, min_index + 1);
                min_index++;
            }
        }
    }

    public static void NetherlandsFlag_patition(int[] arr, int num)
    {//基础的荷兰国旗问题，小于等于num的放左边，大于的放右边
        //设置一个小于区和大于区
        int min_index = -1;
        int max_index = arr.length;
        int i = 0;
        while(i < arr.length){
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
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,5,3,4,1};
        patition(arr, 4);
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();

        int[] arr1 = new int[]{2,4,4,6,1,7,8,4,2};
        NetherlandsFlag_patition(arr1, 4);
        for(int i : arr1)
            System.out.print(i + " ");
    }
}
