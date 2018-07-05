package offer;

public class GreatestSumOfSubArrays_31 {
    //findGreatestSumOfSubArray方法返回的是０时要区分是最大和值为０还是因为不合理的输入
    //所以要定义一个全局的变量，来判断输入是否合法
    boolean invalidInput = false;
    int maxSum;
    public static void main(String[] args) {
        GreatestSumOfSubArrays_31 gssa = new GreatestSumOfSubArrays_31();
        int[] arr = new int[] {1,-2,3,10,-4,7,2,-5};
        int length = arr.length;//因为findGreatestSumOfSubArray方法返回的是０,所以要区分
//        System.out.println(gssa.findGreatestSumOfSubArray(arr,length));
        gssa.findMAxFi(arr,0,0);
        System.out.println(gssa.maxSum);
    }

    /**
     * 方法1这是距离分析数组的特征，时间复杂度是o(n)
     * @param arr
     * @param length
     * @return
     */
    public int findGreatestSumOfSubArray(int[] arr, int length) {
        if (arr==null || length <= 0) {
            invalidInput = true;
            return 0;
        }
        invalidInput = false;
        int currentSum = 0;
        int greatestSum = 0;

        for(int i = 0;i < length; i++) {
            if (currentSum < 0) {
                currentSum = arr[i];
            } else {
                currentSum += arr[i];
            }
            if (currentSum > greatestSum) {
                greatestSum = currentSum;
            }
        }
        return greatestSum;
    }


    public int findMAxFi(int[] arr, int index, int greatestSum) {
        if (arr == null || arr.length <= 0) {
            invalidInput = true;
            return 0;
        }
        if (maxSum < greatestSum) {
            maxSum = greatestSum;
        }
        if (index == arr.length) {
            return greatestSum;
        }
        if (greatestSum < 0) {
            return findMAxFi(arr,index+1, arr[index]);
        } else {
            return findMAxFi(arr,index+1, arr[index] + greatestSum);
        }
    }
}
