package sword_offer;

import data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yibozhang
 * @date 2020/4/1 21:57
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class PathSum {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root, int sum, int value, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (sum == value + root.val && root.left == null && root.right == null) ans.add(new ArrayList<>(list));
        dfs(root.left, sum, value + root.val, list);
        dfs(root.right, sum, value + root.val, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        List<List<Integer>> lists = new PathSum().pathSum(t1, 1);
        System.out.println(lists);
    }

}
