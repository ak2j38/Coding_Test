import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
//        ListNode l4 = new ListNode(3);
//        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        ListNode resultHead = deleteDuplicates(l1);

        while (resultHead.next != null) {
            System.out.println(resultHead.val);
            resultHead = resultHead.next;
        }
        System.out.println(resultHead.val);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        // 입력값이 0일 때
        if (head == null) return null;
        if (head.next == null) return head;

        // head에서부터 출발한다.
        HashSet<Integer> uniqueNums = new HashSet<>();
        uniqueNums.add(head.val);
        ListNode currentNode = head;
        ListNode tail = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;

            if (uniqueNums.contains(currentNode.val)) {
                continue;
            }
            uniqueNums.add(currentNode.val);
            tail.next = currentNode;
            tail = currentNode;
        }
        tail.next = null;

        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
