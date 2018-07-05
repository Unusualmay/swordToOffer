package offer;

public class RegularExpressionsMatching_53 {
    public static void main(String[] args) {
        RegularExpressionsMatching_53 match53 = new RegularExpressionsMatching_53();
        System.out.println(match53.match("aabbcc","a.*b.*c."));
    }

    /**
     * 正则表达式的匹配
     * @param input
     * @param parttern
     * @return
     */
    public boolean match(String input, String parttern) {
        if (input == null || parttern == null ||
                input.length() <= 0 || parttern.length() <= 0) {
            return false;
        }
        return match(input,0,parttern,0);
    }

    public boolean match(String input, int i, String parttern, int p) {
        if (i >= input.length() && p >= parttern.length()) {
            return true;
        }
        //模式串到达结尾，但是匹配串还没有到达结尾
        if (i != input.length() && p >= parttern.length()) {
            return false;
        }
        //模式串可能到达结尾，可能没有到达结尾
        //模式串没有到达结尾
        if (p + 1 < parttern.length() && parttern.charAt(p+1) == '*') {
            //匹配串到达结尾
            if (i >= input.length()) {
                return match(input,i,parttern,p+2);
            } else {
                if (input.charAt(i) == parttern.charAt(p) || parttern.charAt(p) == '.') {
                    return
                            //匹配串不移动，模式串向后移动两个位置
                            match(input,i,parttern,p+2) ||
                                    //匹配串向后移动一个位置，模式串不移动
                                    match(input,i+1,parttern,p) ||
                                    //匹配串向后移动一个位置，模式串移动两个位置
                                    match(input,i+1, parttern, p+2);

                } else {
                    return match(input, i, parttern, p+2);
                }
            }
        }
        //模式串还没有到达结尾，但是匹配串到达了结尾
        if (i >= input.length()) {
            return false;
        }

        if (input.charAt(i) == parttern.charAt(p) || parttern.charAt(p) == '.') {
            return match(input,i+1,parttern,p+1);
        } else {
            return false;
        }
    }
}
