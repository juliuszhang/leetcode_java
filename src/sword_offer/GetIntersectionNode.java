package sword_offer;

import data.ListNode;

/**
 * @author yibozhang
 * @date 2020/3/30 16:08
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;

        while(n1!=n2){
            n1 = n1 == null? headB:n1.next;
            n2 = n2 == null? headA:n2.next;
        }

        return n1;
    }

}
