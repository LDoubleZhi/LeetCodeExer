import java.util.HashSet;

/**
 * @author : liulinzhi
 * @date: 2020/07/15/21:03
 * @description:
 */
public class getIntersectionNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        //首先判断是否有环
        if(getLoopNode(head1) == null && getLoopNode(head2)==null)
            return noLoop(head1, head2);
        if(getLoopNode(head1) != null && getLoopNode(head2) != null)
            return bothLoop(head1,getLoopNode(head1),
                    head2,getLoopNode(head2));
        return null;
    }

    public static Node getLoopNode(Node head) {
        //对于环形链表，使用额外空间复杂度为1的或n的
        //方法1，直接用HashSet
        /*
        HashSet<Node> hashset = new HashSet<>();
        while(head != null){
            if(hashset.contains(head)==false){
                hashset.add(head);
                head = head.next;}
            else
                return head;
        }
        return null;
        */
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node quick = head;
        Node slow = head;
        if (quick.next==null || quick.next.next==null)
            return null;
        quick = quick.next.next;
        slow = slow.next;
        while(quick != slow){
            //判断是否有环
            if (quick.next==null || quick.next.next==null)
                return null;
            quick = quick.next.next;
            slow = slow.next;
        }
        //quick回到起点重设步长为1
        quick = head;
        while(quick != slow){
            quick = quick.next;
            slow = slow.next;
        }
        return quick;
    }

    public static Node noLoop(Node head1, Node head2){
        //对无环判断是否相交
        int len1 = 0;
        int len2 = 0;
        Node max = head1;
        Node min = head2;
        //分别得到两个链表长度
        while (max != null) {
            len1++;
            max = max.next;
        }
        while (min != null) {
            len2++;
            min = min.next;
        }
        //包装max_len和max匹配长链表
        int max_len=len1,min_len=len2;
        if(len1 < len2){
            int t = len1;
            max = head2;
            max_len = len2;
            min = head1;
            min_len = t;
        }else{
            max = head1;
            min = head2;
        }

        int count = max_len - min_len;
        while(count>0)
        {
            max= max.next;
            count--;
        }
        //正式遍历比较
        while(max != min)
        {
            max = max.next;
            min = min.next;
        }
        return max;
    }
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        //Y型相交，和noloop思想相同
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        //不相交或入环接入点不一样
        else {
            //loop1继续走是否遇到loop2
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
//        System.out.println(getLoopNode(head1));

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
//        System.out.println(getLoopNode(head2));
//        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = head1.next.next.next;// ->4
//        System.out.println(getLoopNode(head1).value);
        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
//        System.out.println(getIntersectNode(head1, head2).value);
//        System.out.println(getLoopNode(head1).value);
        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
