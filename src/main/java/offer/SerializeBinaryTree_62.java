package offer;

public class SerializeBinaryTree_62 {
    public static void main(String[] args) {
        SerializeBinaryTree_62 sbt = new SerializeBinaryTree_62();
        BinaryTreeNode n4 = new BinaryTreeNode(5,null,null);
        BinaryTreeNode n5 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode n6 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode n7 = new BinaryTreeNode(5,null,null);
        BinaryTreeNode n2 = new BinaryTreeNode(6,n4,n5);
        BinaryTreeNode n3 = new BinaryTreeNode(9,n6,n7);
        BinaryTreeNode n1 = new BinaryTreeNode(8,n2,n3);
        StringBuilder str = new StringBuilder();
        String str1 = sbt.serialize(n1,str);
        sbt.preOrder(n1);
        System.out.println();
        System.out.println("-------------------------");
        BinaryTreeNode root;
        root = sbt.deSerialize_last(str1);
        sbt.preOrder(root);
    }

    /**
     * 序列化二叉树，实际上就是前序遍历
     */
    public String serialize(BinaryTreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("#,");
            return str.toString();
        }
        str.append(root.getData() + ",");
        serialize(root.getLeft(),str);
        serialize(root.getRight(),str);
        return str.toString();
    }
    int index;
    public BinaryTreeNode deSerialize_last(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] strs = str.split(",");
        index = 0;
        return deSerialize(strs);
    }

    public BinaryTreeNode deSerialize(String[] str) {
        if (str.length <= index) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode();
        //注意这里的变量是$的时候会发生错误NumberFormatException
        if (str[index].equals("#")) {
            index++;
            return null;
        } else {
            root.setData(Integer.parseInt(str[index++]));
            root.setLeft(deSerialize(str));
            root.setRight(deSerialize(str));
            return root;
        }
    }

    public void preOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData()+"\t");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
}
