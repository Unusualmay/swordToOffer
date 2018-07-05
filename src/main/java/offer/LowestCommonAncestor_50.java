package offer;

import java.util.Iterator;
import java.util.LinkedList;

public class LowestCommonAncestor_50 {
    public static void main(String[] args) {
        /**
         * 普通的树测试用例
         */
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        n1.children.add(n2);
        n1.children.add(n3);
        n2.children.add(n4);
        n2.children.add(n5);
        n4.children.add(n6);
        n4.children.add(n7);
        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);
        LowestCommonAncestor_50 lca = new LowestCommonAncestor_50();
        TreeNode ancestor = lca.lowestCommonAncestor_2(n1,n6,n8);
        System.out.println(ancestor.getData());

        /**
         * 二叉排序树测试用例
         */
        BinaryTreeNode b13 = new BinaryTreeNode(28,null,null);
        BinaryTreeNode b12 = new BinaryTreeNode(23,null,null);
        BinaryTreeNode b11 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode b10 = new BinaryTreeNode(0,null,null);
        BinaryTreeNode b9 = new BinaryTreeNode(3,null,null);
        BinaryTreeNode b8 = new BinaryTreeNode(1,null,null);
        BinaryTreeNode b7 = new BinaryTreeNode(25,b12,b13);
        BinaryTreeNode b6 = new BinaryTreeNode(15,null,null);
        BinaryTreeNode b5 = new BinaryTreeNode(4,b10,b11);
        BinaryTreeNode b4 = new BinaryTreeNode(2,b8,b9);
        BinaryTreeNode b3 = new BinaryTreeNode(20,b6,b7);
        BinaryTreeNode b2 = new BinaryTreeNode(5,b4,b5);
        BinaryTreeNode b1 = new BinaryTreeNode(10,b2,b3);
        BinaryTreeNode ancestor1 = lca.lowestCommonAncestor(b1,b8,b11);
        System.out.println(ancestor1.getData());

        /**
         * 含有指向父节点的普通树
         */
        TreeNodeWithParent t1 = new TreeNodeWithParent(1,null);
        TreeNodeWithParent t2 = new TreeNodeWithParent(2,t1);
        TreeNodeWithParent t3 = new TreeNodeWithParent(3,t1);
        TreeNodeWithParent t4 = new TreeNodeWithParent(4,t2);
        TreeNodeWithParent t5 = new TreeNodeWithParent(5,t2);
        TreeNodeWithParent t6 = new TreeNodeWithParent(6,t4);
        TreeNodeWithParent t7 = new TreeNodeWithParent(7,t4);
        TreeNodeWithParent t8 = new TreeNodeWithParent(8,t5);
        TreeNodeWithParent t9 = new TreeNodeWithParent(9,t5);
        TreeNodeWithParent t10 = new TreeNodeWithParent(10,t5);
        t1.children.add(t2);
        t1.children.add(t3);
        t2.children.add(t4);
        t2.children.add(t5);
        t4.children.add(t6);
        t4.children.add(t7);
        t5.children.add(t8);
        t5.children.add(t9);
        t5.children.add(t10);
        TreeNodeWithParent ancestor_2 = lca.LowestCommonAncestor_1(t1,t6,t8);
        System.out.println(ancestor_2.getData());
    }

    /**
     * 该树是二叉排序树，即左子树小于根节点小于右子树
     * @param root
     * @param p
     * @param q
     * @return
     */
    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        if (root.getData() > p.getData() && root.getData() > q.getData()) {
            return lowestCommonAncestor(root.getLeft(),p,q);
        } else if (root.getData() < p.getData() && root.getData() < q.getData()) {
            return lowestCommonAncestor(root.getRight(),p,q);
        } else {
            return root;
        }
    }

    /**
     * 带有父节点指向的普通的树，不是二叉树
     * 将题目变化为求两个链表的公共结点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNodeWithParent LowestCommonAncestor_1(TreeNodeWithParent root,
                                                     TreeNodeWithParent p,
                                                     TreeNodeWithParent q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        int pLength = 0;
        int qLength = 0;
        TreeNodeWithParent tp = p;
        TreeNodeWithParent tq = q;
        while (tp != null) {
            pLength++;
            tp = tp.getParent();
        }
        while (tq != null) {
            qLength++;
            tq = tq.getParent();
        }
        int difLength = Math.abs(pLength - qLength);
        if (pLength > qLength) {
            for (int i = 0; i < difLength; i++) {
                p = p.getParent();
            }
        } else if (pLength < qLength) {
            for (int i = 0; i < difLength; i++) {
                q = q.getParent();
            }
        }
        for (int j = 0; j < min(pLength, qLength); j++) {
            if (p==q) {
                return p;
            }
            p = p.getParent();
            q = q.getParent();
        }
        return p;
    }

    public int min(int a, int b) {
        return a<b?a:b;
    }

    /**
     * 该树是普通树，而且没有指向父节点的引用
     * 方法１：利用两个数组，遍历出两个结点的路径信息，并存储起来
     * 此方法：会有重复的访问树的结点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        LinkedList<TreeNode> path1 = new LinkedList<>();
        LinkedList<TreeNode> path2 = new LinkedList<>();
        getNodePath(root,p,path1);
        getNodePath(root,q,path2);
        return getLastCommonNode(path1,path2);
    }

    public void getNodePath(TreeNode root, TreeNode node, LinkedList<TreeNode> path) {
        if (root == null || node == null) {
            return;
        }
        path.add(root);
        LinkedList<TreeNode> children = root.children;
        for (TreeNode child : children) {
            if (child == node) {
                path.add(child);
                return;
            } else {
                getNodePath(child,node,path);
            }
        }
        path.remove(path.size()-1);
    }

    public TreeNode getLastCommonNode(LinkedList<TreeNode> path1, LinkedList<TreeNode> path2) {
        if (path1 == null || path2 == null) {
            return null;
        }
        Iterator<TreeNode> iteratorp1 = path1.iterator();
        Iterator<TreeNode> iteratorp2 = path2.iterator();
        TreeNode ancestor = null;
        while (iteratorp1.hasNext() && iteratorp2.hasNext()) {
            TreeNode temp = iteratorp1.next();
            if (temp == iteratorp2.next()) {
                ancestor = temp;
            }
        }
        return ancestor;
    }
}
