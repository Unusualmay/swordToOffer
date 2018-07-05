package offer;

public class PrintMatrix_20 {
    public static void main(String[] args) {
        int[][] data = new int[8][6];
        int i = 1;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 6; col++) {
                data[row][col] = i++;
//                System.out.println(data[row][col]);
            }
        }
        printMatrix(data,8,6);

    }
    public static void printMatrix(int[][] data, int rows, int columns) {
        if (data == null) {
            return;
        }

        int circleNums = Math.min(rows,columns) / 2;//打印的圈数
//        System.out.println(circleNums);
        for (int i = 0; i < circleNums; i++) {
            printCircle(data, i, rows, columns);
        }
        //如果行数或者列数都是奇数的话，那么最中间的圆圈只有一行或者一列元素，或者一个元素
        if (rows%2 == 1 || columns % 2 == 1) {
            printCircle(data,circleNums,rows,columns);
        }
    }
    public static void printCircle(int[][] data, int startIndex, int rows, int columns) {
        int maxrow = rows - 1 - startIndex;
        int maxcol = columns - 1 - startIndex;
        int i = startIndex;
        int j = startIndex;
        int rowNums = maxrow - startIndex;
        int colNums = maxcol - startIndex;
//        System.out.println("maxcol:" + maxcol);
//        System.out.println("startIndex:" + startIndex);
        //如果只有一个元素的情况下
        if (startIndex == maxrow) {
            System.out.println(data[startIndex][startIndex]);
            return;
        }
        while (j < maxcol) {
            System.out.println(data[i][j]);
            j++;
        }
        if (j == maxcol) {
            while (i < maxrow) {
                System.out.println(data[i][j]);
                i++;
            }
        }
        //如果只有一行的情况下,就不能执行此操作
        if (i == maxrow && rowNums != 0) {
            while (j > startIndex) {
                System.out.println(data[i][j]);
                j--;
            }
        }
        //如果只有一列的情况下，就不能执行此操作
        if (j == startIndex && colNums != 0) {

            while (i > startIndex) {
                System.out.println(data[i][j]);
                i--;
            }
        }
    }
}
