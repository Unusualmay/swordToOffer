package offer;

/**
 * 其实就是一个全排列的问题，然后在全排列的基础上进行条件的判断
 */
public class Related1_28 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,3,6,7,8,5,9};
        Related1_28 r1 = new Related1_28();
        r1.permution(nums);
    }
    public void permution(int[] nums) {
        if (nums == null) {
            return;
        }
        permution(nums,0);
    }
    public void permution(int[] nums, int i) {
        if (i == nums.length) {
            for(int k = 0; k < i; k++) {
                System.out.print(nums[k]);
            }
            if (nums[0]+nums[1]+nums[2]+nums[3]==nums[4]+nums[5]+nums[6]+nums[7]
                    && nums[0]+nums[2]+nums[4]+nums[6]==nums[1]+nums[3]+nums[5]
                    +nums[7]&&nums[0]+nums[1]+nums[4]+nums[5]==nums[2]+nums[3]+
                    nums[6]+nums[7]) {
                System.out.println("******此数组能找到排列符合条件******");
                return;
            }else{
                System.out.println("此数组不能找到排列符合条件");
            }
        }
        if (i > nums.length || i < 0 || nums == null) {
            return;
        }
        for(int j = i; j < nums.length; j++) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            permution(nums,i+1);
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
