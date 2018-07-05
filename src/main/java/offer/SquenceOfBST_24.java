package offer;

public class SquenceOfBST_24 {
    public static void main(String[] args) {
        int[] seq1 = new int[] {8,5,7,6,9,11,10};
        int[] seq2 = new int[] {8,5,7,6,9,4,10};
        int[] seq3 = new int[] {5,7,6,11,9,10,8};
        int[] seq4 = new int[] {7,5,3,8};
        int[] seq5 = new int[] {1};
//        System.out.println(verifySeqOfBST(seq1,0,6));
//        System.out.println(verifySeqOfBST(seq2,0,6));
//        System.out.println(verifySeqOfBST(seq3,0,6));
//        System.out.println(verifySeqOfBST(seq4,0,3));
//        System.out.println(verifySeqOfBST(null, 0,5));
//        System.out.println(verifySeqOfBST(seq5,0,0));
        System.out.println(verify(seq1,0,6));
        System.out.println(verify(seq2,0,6));
        System.out.println(verify(seq5,0,0));

    }

    /**
     * 判断某个序列是不是二叉搜索树后序遍历
     * @param seq
     * @param start
     * @param end
     * @return
     */
    public static boolean verifySeqOfBST(int[] seq, int start, int end) {
        if (seq == null || end < start) {
            return false;
        }
        int root = seq[end];
        int index = start;
        //找到左子树的索引
        while (start < end) {
            if (seq[index] < root) {
                index++;
            } else {
                break;
            }
        }
        int index2 = index;
        //剩下的都是右子树，右子树必须都大于根节点
        while (index2 < end) {
            if (seq[index2] > root) {
                index2++;
            } else {
                return false;
            }
        }
        //判断左子树是不是二叉搜索树
        boolean left = true;
        if (index > start) {
            left = verifySeqOfBST(seq, start, index - 1);
//            System.out.println("left:"+left);
        }
        //判断右子树是不是二叉搜索树
        boolean right = true;
        if (index < end-1) {
            right = verifySeqOfBST(seq, index, end - 1);
//            System.out.println("right:" + right);
        }
        return left && right;
    }

    /**
     * 判断某个序列是不是二叉搜索树的先序遍历
     * @param seq
     * @param start
     * @param end
     * @return
     */
    public static  boolean verify(int[] seq, int start, int end) {
        if (seq == null || end < start) {
            return false;
        }
        if (start == end) {
            return true;
        }
        int root = seq[start];
        int index = start + 1;
        //找到左子树的索引
        while (index <= end) {
            if (seq[index] < root) {
                index++;
            } else {
                break;
            }
        }
        int index2 = index;
        //剩下的都是右子树，右子树必须都大于根节点
        while (index2 <= end) {
            if (seq[index2] > root) {
                index2++;
            } else {
                return false;
            }
        }
        //判断左子树是不是二叉搜索树
        boolean left = true;
        if (index > start) {
            left = verifySeqOfBST(seq, start + 1, index - 1);
//            System.out.println("left:"+left);
        }
        //判断右子树是不是二叉搜索树
        boolean right = true;
        if (index < end-1) {
            right = verifySeqOfBST(seq, index, end);
//            System.out.println("right:" + right);
        }
        return left && right;
    }
}
