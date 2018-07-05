package offer;

public class ReplaceBlank_04 {
	public static int afterAddNums;
	public static char[] swapBlank(char[] string, int maxSize) {
		if (string == null || maxSize <= 0) {
			System.out.println("kong");
			return null;
		}
		int blankNums = 0;
		afterAddNums = 0;
//		System.out.println("======");
		for (int i = 0; i < maxSize && string[i] != '\0'; i++) {
			if (string[i] == ' ') {
				blankNums++;
			} 
		}
		afterAddNums = maxSize + blankNums * 2;
		int originPoint = maxSize-1;
		int afterPoint = afterAddNums - 1;
		if (afterAddNums == maxSize) {
			return string; 
		}
		while(originPoint >= 0 && afterPoint >= 0) {
			if (string[originPoint] == ' ') {
				string[afterPoint--] = '0';
				string[afterPoint--] = '2';
				string[afterPoint--] = '%';
			} else {
				string[afterPoint--] = string[originPoint];
			}
			originPoint--;
		}
		return string;
	}
	
	public static void main(String[] args) {
//		char[] string = new char[50]; 
//		string[0] = '2';
//		string[1] = 'g';
//		string[2] = 'f';
//		string[3] = 's';
//		string[4] = 'h';
//		string[5] = 'f';
//		string[6] = ' ';
//		string[7] = '=';
//		string[8] = '.';
//		string[9] = '/';
//		string[10]= ' ';
//		string[11]= '?';
		char[] string = new char[50];
		
		swapBlank(string, 12);
		System.out.println(new String(string, 0, afterAddNums));
	}

}
