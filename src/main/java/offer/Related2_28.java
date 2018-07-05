package offer;

/**
 * 8皇后问题可以看成是全排列的问题
 */
public class Related2_28 {
    static int count = 0;
    public static void main(String[] args) {
        int[] columnIndex = new int[8];
        for(int i = 0; i < 8; i++) {
            columnIndex[i] = i;
        }
        Related2_28 r2 = new Related2_28();
        r2.permution(columnIndex);
        System.out.println("共有"+count+"种排列方法");

    }
    public void permution(int[] columnIndex) {
        if (columnIndex == null) {
            return;
        }
        permution(columnIndex,0);
    }

    /**
     * 用递归的方法将所有的排列的都求出来
     * @param columnIndex
     * @param i
     */
    public void permution(int[] columnIndex, int i) {
        if (i > columnIndex.length || i < 0) {
            return;
        }
        if (i==columnIndex.length) {
            for(int x = 0; x < i; x++) {
                for(int y = x + 1; y < i; y++) {
                    if (Math.abs(x-y) == Math.abs(columnIndex[x] - columnIndex[y])) {
                        System.out.print("8皇后的排列应该是这样：");
                        count++;
                        for(int z = 0; z < i; z++) {
                            System.out.print(columnIndex[z]);
                        }
                        System.out.println();
                        return;
                    }
                }
            }
        }
        for(int j = i; j < columnIndex.length; j++) {
            int temp = columnIndex[i];
            columnIndex[i] = columnIndex[j];
            columnIndex[j] = temp;
            permution(columnIndex,i+1);
            temp = columnIndex[i];
            columnIndex[i] = columnIndex[j];
            columnIndex[j] = temp;
        }
    }
}
