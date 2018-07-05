package offer;

public class ArrayConstruction_52 {
    public static void main(String[] args) {
        double[] arr1 = new double[]{2,3,5,1,7,4,9};
        double[] arr2 = new double[7];//如果没有进行初始化，数组自己也会进行初始化的操作
        ArrayConstruction_52 cma = new ArrayConstruction_52();
        cma.multiplay(arr1,arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }

    /**
     * 此方法就是将B数组分解为C*D
     * @param arr1
     * @param arr2
     */
    public void multiplay(double[] arr1, double[] arr2) {
        if (arr1.length == arr2.length && arr2.length > 0) {
            int length1 = arr1.length;
            int length2 = arr2.length;
            arr2[0] = 1;//后面这个值会发生改变
            //求出C数组，并且将其赋值给arr2(B数组)
            for (int i = 1; i < length1; i++) {
                arr2[i] = arr1[i-1] * arr2[i-1];
            }
            //求出D数组，将其赋值给temp,然后temp乘以D数组，就是最终的结果arr2(B数组)
            double temp = 1;
            for (int i = length1-2; i >= 0; i--) {
                temp *= arr1[i+1];
                arr2[i] *= temp;
            }
        }
    }
}
