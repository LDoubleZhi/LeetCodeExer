/**
 * @author : liulinzhi
 * @date: 2020/07/05/20:59
 * @description:基本二分查找
 */
public class BSExist {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length==0)
            return -1;
        int L = 0;
        int R = nums.length - 1;
        int mid = 0;
        while(L <= R){
            mid = L + ((R - L) >> 1);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                L = mid + 1;
            else
                R = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }
}
