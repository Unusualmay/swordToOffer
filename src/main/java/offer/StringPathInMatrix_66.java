package offer;

public class StringPathInMatrix_66 {
    public static void main(String[] args) {
        StringPathInMatrix_66 spim = new StringPathInMatrix_66();
        char[] matrix = new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'};
        String str1 = "bcced";
        String str2 = "abcb";
        boolean result1 = spim.hasPath(matrix,4,3,str1);
        boolean result2 = spim.hasPath(matrix,4,3,str2);
        System.out.println(result1);
        System.out.print(result2);

    }

    /**
     * 在矩阵中查找路径
     * @param matrix 表示矩阵
     * @param clos　表示列数
     * @param rows　表示行数
     * @param str　表示所需要找的路径
     * @return
     */
    public boolean hasPath(char[] matrix, int clos, int rows, String str) {
        if (clos < 1 || rows < 1 || matrix.length != clos*rows || str.length() < 1) {
            return false;
        }
        boolean[] visited = new boolean[rows*clos];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < clos; col++) {
                if (hasPathCore(matrix,clos,col,rows,row,str,visited,pathLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param matrix　
     * @param cols
     * @param col
     * @param rows
     * @param row
     * @param str
     * @param visited　表示对应格子是否被访问，如果被访问，那么就要置true，否则就是false
     * @param pathLength 表示str中正在被访问的元素的个数
     * @return
     */
    public boolean hasPathCore(char[] matrix, int cols, int col, int rows,
                               int row, String str, boolean[] visited,
                               int pathLength) {
        //如果访问过的个数等于str的长度，那么就代表找到了该路径
        if (pathLength == str.length()) {
            return true;
        }
        boolean hasPath = false;
        //这里是代表对应的元素等于当前需要被访问的数
        if (col < cols && col >= 0 &&
                row < rows && row >= 0 &&
                matrix[cols*row+col]==str.charAt(pathLength) &&
                !visited[row*cols+col]) {
            pathLength++;
            visited[row*cols+col] = true;
            hasPath = hasPathCore(matrix,cols,col,rows,row+1,str,visited,pathLength)
                    ||hasPathCore(matrix,cols,col,rows,row-1,str,visited,pathLength)
                    ||hasPathCore(matrix,cols,col+1,rows,row,str,visited,pathLength)
                    ||hasPathCore(matrix,cols,col-1,rows,row,str,visited,pathLength);
            if (!hasPath) {
                pathLength--;
                visited[row*cols+col] = false;
            }
        }
        return hasPath;
    }
}
