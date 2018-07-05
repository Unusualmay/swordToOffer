package offer2;

public class OfferDemo2 {
	public static boolean search(int[][] data, int rows, int cols, Integer number) {
		if(data == null || rows <= 0 || cols <= 0 || number == null) {
			return false;
		} else {
			boolean isFind = false;
			int row = 0;
			int col = cols-1;
			while (row < rows && col >=0) {
				if (data[row][col] == number) {
					isFind = true;
					break;//记得使用break跳出该循环
					} else if (data[row][col] > number) {
						col--;
					} else {
						row++;
					}
				}
			return isFind;
		}	
	}
	public static void main(String[] args) {
		int [][] data = new int[][] {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int cols = data[0].length;
		int rows = data.length;
		System.out.println(cols + ":" + rows); 
		if (search(data, rows, cols, null)) {
			System.out.println("==========");
			System.out.println("找到了该数");
		} else {
			System.out.println("抱歉没找到");
		}
	}

}
