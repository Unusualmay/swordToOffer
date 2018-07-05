package offer;

public class StringToInt_49 {
    public static void main(String[] args) {
        StringToInt_49 sti = new StringToInt_49();
//        System.out.println(sti.stringToInt("12345"));
//        System.out.println(sti.stringToInt(null));
        System.out.println(sti.stringToInt("-2147483648"));
//        System.out.println(Integer.MAX_VALUE);
    }

    public boolean isDigits(char num) {
        if (num < '0' || num > '9') {
            return false;
        } else {
            return true;
        }
    }

    public int stringToInt(String str) {
        if (str == null) {
            throw new NumberFormatException("输入字符串为空字符串");
        }
        if (str == "0") {
            return 0;
        }
        int result;
        char first = str.charAt(0);
        if (first == '-') {
            result = parseToInt(str,1,false);
        } else if (first == '+') {
            result = parseToInt(str,1,true);
        } else if (first < '9' && first > '0') {
            result = parseToInt(str,0,true);
        } else {
            throw new NumberFormatException("输入参数不合法");
        }
        return result;
    }

    public int parseToInt(String str, int index, boolean positive) {
        int length = str.length();
        long temp = 0;
        while (index < length && isDigits(str.charAt(index))) {
            temp = temp * 10 + str.charAt(index) - '0';
            index++;
            if (temp > (long)Integer.MAX_VALUE+1) {
                throw new NumberFormatException("结果越界");
            }
        }
        System.out.println(positive);

        if (positive) {
            System.out.println(temp);
            if (temp > Integer.MAX_VALUE) {
                throw new NumberFormatException("结果越界");
            } else {
                temp = (int) temp;
            }
        } else {
            if (temp == (long)Integer.MAX_VALUE + 1) {
                temp = (int)-(Integer.MAX_VALUE + 1);
            } else {
                temp = (int)-temp;
            }
        }
        return (int)temp;

    }
}
