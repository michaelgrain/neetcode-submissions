/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Продвигаем fast на n+1 шагов вперёд
        for (int i = 0; i <= n; i++)
        {
            fast = fast.next;
        }

        // Двигаем оба указателя, пока fast не дойдёт до конца
        while (fast != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        // slow теперь стоит прямо перед узлом, который нужно удалить
        slow.next = slow.next.next;

        return dummy.next;
    }
}
