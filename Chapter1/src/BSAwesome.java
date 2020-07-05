import javax.print.attribute.standard.PagesPerMinute;

/**
 * @author : liulinzhi
 * @date: 2020/07/05/20:59
 * @description: 局部最小值问题：
 * 1）[0] < [1]
 * 2)[n-1] < [n-2]
 * 3)[i-1] > [i] <[i+1]
 * 这三种都是局部最小值
 */
public class BSAwesome {
    //nums无序且任意两个相邻的数不相等，返回一个局部最小值
    public static int search(int[] nums){
        if(nums[0] < nums[1])
            return 0;
        if(nums[nums.length-1] < nums[nums.length-2])
            return nums.length-1;
        //如果都不满足，开头降低，后面升高，必然有局部最小值
        //自己选左边或右边开始
        int L = 1;
        int R = nums.length - 2;
        int mid = 0;
        int temp = 1;
        while(L <= R)
        {
            mid = L + ((R - L) >> 2);
            if(nums[mid] < nums[L]){
                L = mid + 1;
                temp = mid;
            }
            else{
                R = mid - 1;
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,3,2,9,12};
        System.out.println(search(nums));
    }
}
