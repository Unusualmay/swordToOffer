package offer;

/**
 * 机器人的运动范围，此题的与６６题是同一原理
 */
public class RobotMove_67 {
    public static void main(String[] args) {
        RobotMove_67 rm = new RobotMove_67();
        System.out.print(rm.movingCount(343,23,45));
    }

    public int movingCount(int k ,int cols, int rows) {
        if (k < 0 || cols < 1 || rows < 1) {
            return 0;
        }
        boolean[] visited = new boolean[rows*cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int count = movingCountCore(k,cols,rows,0,0,visited);
        return count;
    }

    /**
     *
     * @param k 输入参数k
     * @param cols 列数
     * @param rows 行数
     * @param col　当前的列
     * @param row　当前的行
     * @param visited　表示当前格子是否被访问的标记
     * @return
     */
    public int movingCountCore(int k, int cols, int rows, int col, int row, boolean[] visited) {
        int count = 0;
        if (col<cols && col>=0 &&
                row<rows && row>=0 &&
                !visited[cols*row+col] &&
                getDigitNum(col)+getDigitNum(row)<=k) {
            visited[cols*row+col] = true;
            count = 1 + movingCountCore(k,cols,rows,col+1,row,visited)
                    + movingCountCore(k,cols,rows,col-1,row,visited)
                    + movingCountCore(k,cols,row,col,row+1,visited)
                    + movingCountCore(k,cols,rows,col,row-1,visited);
        }
        return count;

    }

    public int getDigitNum(int num) {
        int result = 0;
        while (num > 0) {
            int temp = num % 10;
            result += temp;
            num = num / 10;
        }
        return result;
    }


}
