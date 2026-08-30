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
    public boolean hasCycle(ListNode head) 
    {
        if (head == null || head.next == null) 
        {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        int power = 1;
        int steps = 1;

        while (fast.next != null) 
        {
            fast = fast.next;

            if (slow == fast) 
            {
                return true;
            }

            if (steps == power) 
            {
                // удваиваем интервал и "телепортируем" slow к fast
                power *= 2;
                steps = 0;
                slow = fast;
            }
            steps++;
        }

        return false;
    }
    
}
