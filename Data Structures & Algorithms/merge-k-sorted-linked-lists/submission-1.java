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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if (lists == null || lists.length == 0) 
        {
            return null;
        }

        int n = lists.length;
        while (n > 1) 
        {
            int half = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++) 
            {
                lists[i] = mergeTwoLists(lists[i], lists[i + half]);
            }
            n = half; // "хвост" (нечётный лишний элемент) остаётся на месте half-1
        }

        return lists[0];    
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null && list2 != null) 
        {
            if (list1.val <= list2.val) 
            {
                tail.next = list1;
                list1 = list1.next;
            } 
            else 
            {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // прикрепляем оставшуюся часть (она уже отсортирована)
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;        
    }

}
