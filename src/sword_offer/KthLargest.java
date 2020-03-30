package sword_offer;


import data.TreeNode;

/**
 * @author yibozhang
 * @date 2020/3/30 16:44
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 */
public class KthLargest {

    int index = 0;
    int ans = 0;

    public int kthLargest(TreeNode root, int k) {
        getKthNode(root, k);
        return ans;
    }

    private void getKthNode(TreeNode node, int k) {
        if (node.right != null) {
            getKthNode(node.right, k);
        }
        if (++index == k) {
            ans = node.val;
            return;
        } else if (index > k) {
            return;
        }
        if (node.left != null) {
            getKthNode(node.left, k);
        }
    }

}
