package sword_offer;

import data.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yibozhang
 * @date 2020/3/31 10:36
 */
public class BuildTree {

    Map<Integer, Integer> memo = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int inorderStart, int inorderEnd) {
        TreeNode node = new TreeNode(preorder[preStart]);
        int rootIndexInorder = memo.get(node.val);
        int leftTreeLength = rootIndexInorder - inorderStart;
        int rightTreeLength = inorderEnd - rootIndexInorder;
        if (leftTreeLength > 0)
            node.left = helper(preorder, preStart + 1, preStart + leftTreeLength - 1, inorderStart, rootIndexInorder - 1);
        if (rightTreeLength > 0)
            node.right = helper(preorder, preStart + leftTreeLength + 1, preEnd, rootIndexInorder + 1, inorderEnd);
        return node;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = new BuildTree().buildTree(pre, in);
        System.out.println();
    }
}
