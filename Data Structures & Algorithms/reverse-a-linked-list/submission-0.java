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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next; // сохраняем ссылку на следующий узел
            curr.next = prev;          // разворачиваем указатель
            prev = curr;                // сдвигаем prev вперёд
            curr = next;                 // сдвигаем curr вперёд
        }
        
        return prev; // prev теперь указывает на новую голову списка
    }
}
