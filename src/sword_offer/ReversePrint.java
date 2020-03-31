package sword_offer;

import data.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yibozhang
 * @date 2020/3/31 10:34
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        helper(head,list);

        int[] ans = new int[list.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void helper(ListNode node,List<Integer> list){
        if(node == null) return;
        helper(node.next,list);
        list.add(node.val);
    }

}
