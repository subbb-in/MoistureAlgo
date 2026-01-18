package PRO;

import java.util.ArrayList;
import java.util.List;

// 길 찾기 게임
public class PRO_42892 {
    // 최종 배열의 인덱스
    static int idx = 0;

    // 노드 선언
    static class Node {
        int x;
        int y;
        int idx;
        Node left;  // 양쪽 노드는 일단 null 가능
        Node right;

        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    static int[][] solution(int[][] nodeinfo) {
        int[][] result = new int[2][nodeinfo.length];    // 최종적으로 반환할 2차원 배열

        // 각 좌표 및 인덱스(공 번호)를 담은 노드를 생성해서 리스트데 담음
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(nodeinfo[i][0],nodeinfo[i][1], i+1));
        }

        // 좌표 속 노드를 정렬하기
        list.sort((a, b) -> {
            if(a.y != b.y) return b.y - a.y; // y좌표가 서로 다르면 내림차순으로 정렬ㄹ
            return a.x - b.x; // y 좌표가 같다면 x를 기준으로 오름차순 정렬
        });

        // 최상위 노드를 찾기
        Node root = list.get(0);

        // 최상위 노드를 넣고 리스트의 다음 요소를 넣어서 관계망을 형성함
        for (int i = 1; i < nodeinfo.length; i++) {
            insert(root, list.get(i));
        }

        // 전위 & 후위 순회
        int[] pre = new int[nodeinfo.length];   // 전위 순회 결과 배열
        int[] post = new int[nodeinfo.length];  // 후위 순회 결과 배열
        idx = 0;
        preorder(root, pre);    // 전위 순회 메서드 실행
        idx = 0;    // 인덱스 초기화
        postorder(root, post);  // 후위 순회 메서드 실행

        // 만들어진 배열을 최종 결과 배열에 담음
        result[0] = pre;
        result[1] = post;

        return result;
    }

    // node를 넣어서 트리를 만드는 메서드
    private static void insert(Node root, Node node) {
        if(root.x > node.x) { // x좌표를 기준으로 부모보다 작으면 왼편에 삽입
            if (root.left == null) root.left = node;    // 만약 부모의 왼쪽이 null이면 해당 노드를 왼편에 넣고
            else insert(root.left, node);   // 아니라면 부모의 왼편 노드를 다시 루트 노드로 잡아서 그 아래에 넣음
        } else {
            if (root.right == null) root.right = node;  // 부모의 오른쪽이 null이면 해당 노드를 오른편에 넣음
            else insert(root.right, node);  // 아니라면 부모의 오른쪽 노드를 다시 루트 노드로 잡고 그 아래에 넣음
        }
    }

    // 전위 순회 메서드 : 부모 - 왼 - 오
    private static void preorder(Node root, int[] pre) {
        if(root == null) return;
        pre[idx++] = root.idx;  // 부모 노드의 인덱스를 넣음
        preorder(root.left, pre);   // 왼쪽 노드를 넣음
        preorder(root.right, pre);  // 오른쪽 노드를 넣음
    }

    // 후위 순회 메서드 : 왼 - 오 - 부모
    private static void postorder(Node root, int[] post) {
        if(root == null) return;
        postorder(root.left, post);    // 왼쪽 노드를 넣음
        postorder(root.right, post);    // 오른쪽 노드를 넣음
        post[idx++] = root.idx; // 부모 노드를 넣음
    }

}
