package offer;

public class ReverseWordsInSentence_42_1 {
    public static void main(String[] args) {
        ReverseWordsInSentence_42_1 rwis = new ReverseWordsInSentence_42_1();
        char[] result = rwis.reverseSentence("I am a student.");
//        System.out.println(result);
    }
int tabNum = 0;
    public char[] reverseSentence(String sentence) {
        if (sentence == null || sentence.length() <= 0) {
            return null;
        }
        /**
         * 现将整个句子全部翻转一遍
         */
        int start = 0;
        int end = sentence.length()-1;
        char[] str = sentence.toCharArray();
        reverse(str,start,end);
        for(int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.println();
        /**
         * 再将单个单词翻转一遍
         */
        int low = 0;
        int tabNum = 0;
        for(int j = 0; j < sentence.length(); j++) {
            if(str[j] == ' ' && str[j+1] != ' ') {
                int high = j-tabNum-1;
                reverse(str,low,high);
                tabNum = 0;
                low = j+1;
            } else if (str[j] == ' ') {
                tabNum++;
            }
        }
        for(int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.println();
//        System.out.println(str.toString());???为什么返回的是[C@7f31245a
        return str;
    }

    public void reverse(char[] str,int start, int end) {
       while(start < end) {
           char temp = str[start];
           str[start] = str[end];
           str[end] = temp;
           start++;
           end--;
       }
    }
}
