package leetcode;

/**
 * @since 2023.02.25
 * URL : https://leetcode.com/problems/linked-list-cycle/
 *
 * 연결된 목록의 헤드인 가 주어 head지면 연결된 목록에 주기가 있는지 확인합니다.
 *
 * 포인터 를 계속 따라가면 다시 도달할 수 있는 노드가 목록에 있으면 연결 목록에 순환이 있습니다
 * next .내부적으로 tail의  포인터가 연결된  pos 노드의 인덱스를 나타내는 데 사용됩니다  .
 * 매개   변수로 전달되지 않습니다 .nextpos
 *
 * true연결된 목록에 순환이 있으면 반환합니다  . 그렇지 않으면 를 반환합니다 false.
 *
 * 입력: head = [3,2,0,-4], pos = 1
 *  출력: true
 *  설명: 연결 목록에는 꼬리가 첫 번째 노드(인덱스 0)에 연결되는 주기가 있습니다.
 *
 *  입력: head = [1,2], pos = 0
 *  출력: true
 *  설명: 꼬리가 0번째 노드에 연결되는 연결 목록에 주기가 있습니다.
 *
 *  입력: head = [1], pos = -1
 *  출력: false
 *  설명: 연결 목록에 순환이 없습니다.
 *
 *  제약:]
 * 목록의 노드 수는 범위에 있습니다 .[0, 10^4]
 * -10^5 <= Node.val <= 10^5
 * pos값은 -1또는 연결된 목록의 유효한 인덱스 입니다.
 *
 *
 * 후속 조치:O(1) (예: 상수) 메모리를 사용하여 해결할 수 있습니까 ?
 */
public class LinkedListCycle {

    /**
     * fast and slow 알고리즘 사용
     * (토끼와 거북이 알고리즘 사용)
     * 토끼는 2칸씩 이동
     * 거북이는 1칸씩 이동
     * 같이 순회하면서 만나는지점이 순회한코스
     * 만날때 return true 하면 끝!
     */
    public boolean hasCycle(ListNode head) {
        ListNode tot = head; //거북이는 한칸
        ListNode hare = head; //토끼는 두칸
        while(hare != null && hare.next != null) {
            tot = tot.next;
            hare = hare.next.next;

            if (tot == hare) {
                return true;
            }

        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
