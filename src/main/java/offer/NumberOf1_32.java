package offer;

public class NumberOf1_32 {
    public static void main(String[] args) {
        NumberOf1_32 no = new NumberOf1_32();
        System.out.println(no.numberOf1Between1ToN(23425253));
        System.out.println(no.numberOf1Between1ToN1(23425253));
    }

    /**
     * 这种方法是每输入一个数，都要得出这个数中有几个１，直到１－ｎ中所有的数遍历完
     * 这种方法的复杂度是n*max(lgn);
     * @param n
     * @return
     */
    public int numberOf1Between1ToN(int n) {
        int number = 0;
        for (int i = 1; i <= n; i++) {
            number += numberOf1(i);
        }
        return number;
    }

    public int numberOf1(int i) {
        int number = 0;
        while(i>0) {
            if (i%10 == 1) {
                number++;
            }
            i=i/10;
        }
        return number;
    }

    /**
     * 方法２，从数字规律实现，时间复杂度是o(logn)
     * 例如：输入的是21345
     * 1.最高位是１的次数：10000-19999,共10000次
     * 2.将21345分为：1-1345和1346-21345
     * 2.1分析1346-21345的低4位为１的个数，
     *    每一位都可以为１，其余位为０－９中任意数，那么共1346-11345和11346-21345两种情况，
     * 　　那么2*4*1000=8000;
     * 2.2分析1-1345的１的个数
     *    最高位为１的次数：345+1=346
     *    利用递归可以分为1-345和346-1345;
     * 2.2.1分析346-1345的低3位中１的个数
     *    共10*10*10*3=3000;
     * 2.2.2分析1-345的１的个数
     * 　　最高位：
     *    递归可以分为：1-45和46-345
     *    然后1-45可以分为:
     *      1-5和6-45
     * @param n
     * @return
     */



    public int numberOf1Between1ToN1(int n) {
        int number = 0;
        StringBuilder s = new StringBuilder(((Integer)n).toString());
        return numberOf1(s);
    }
    public int numberOf1(StringBuilder s) {
        if (s==null||s.length()<=0||s.charAt(0)<'0'||s.charAt(s.length()-1)>'9') {
            return 0;
        }
        int first = s.charAt(0)-'0';
        if (first == 0 && s.length()==1) {
            return 0;
        }
        if (first > 0 && s.length()==1) {
            return 1;
        }
        int numberFirst = 0;
        if (first>1) {
            numberFirst = powerBase10(s.length()-1);
        }
        if (first==1) {
            numberFirst = Integer.parseInt(s.substring(1))+1;
        }
        int numberOther = first * (s.length()-1) * powerBase10(s.length()-2);
        int numRecursive = numberOf1(s.deleteCharAt(0));
        return numberFirst+numberOther+numRecursive;
    }

    public int powerBase10(int n) {
        int number = 1;
        for(int i = 0; i<n; i++) {
            number*=10;
        }
        return number;
    }
}
