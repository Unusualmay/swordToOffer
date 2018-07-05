package offer;

public class NumericStrings_54 {
    public static void main(String[] args) {
        NumericStrings_54 sin = new NumericStrings_54();
        System.out.println(sin.isNumber("+123e2"));
        System.out.println(sin.isNumber("-1e-16"));
        System.out.println(sin.isNumber("+-5"));

    }
    public boolean isNumber(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        int index = 0;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            index++;
        }
        if (str.charAt(index) == '.' || str.charAt(index) == 'e' || str.charAt(index) == 'E') {
            return false;
        }
        int pointNum = 0;
        int eNumber = 0;
        while(index < str.length()) {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                index++;
            } else if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
                eNumber++;
                if (eNumber == 1) {
                    return isExponential(str, index + 1);
                } else {
                    return false;
                }
            } else if (str.charAt(index) == '.') {
                pointNum++;
                if (pointNum == 1) {
                    index++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (index == str.length()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExponential(String str, int index) {
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            index++;
        }
        while (index < str.length()) {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                index++;
            } else {
                return false;
            }
        }
        if (index == str.length()) {
            return true;
        } else {
            return false;
        }
    }
}
