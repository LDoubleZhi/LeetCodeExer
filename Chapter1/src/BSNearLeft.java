/**
 * @author : liulinzhi
 * @date: 2020/07/05/20:59
 * @description:在有序数组中，找>=某个数最左侧的位置
 * 或者<=某个数最右边的位置
 */
public class BSNearLeft {
    public static int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        int mid = 0;
        int temp = -1;
        while(L <= R)
        {
            mid = L + ((R - L) >> 2);
            if(nums[mid] >= target){
                temp = mid;
                R = mid - 1;
            }
            else
                L = mid + 1;

        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,2
        ,3,3,3,7,7,7,7,7};
        System.out.println(search(nums, 7));
    }

}
