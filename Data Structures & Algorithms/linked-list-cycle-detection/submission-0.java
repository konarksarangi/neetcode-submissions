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
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> tracker = new HashSet<>();
        ListNode current = head;
        while (current!=null){
            if(tracker.contains(current)){
                return true;
            }
            tracker.add(current);
            current = current.next;
        }
        return false;
    }
}
