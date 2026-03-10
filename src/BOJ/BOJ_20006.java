package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 랭킹전 대기열
public class BOJ_20006 {

    static ArrayList<Room> room = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 플레이어수
        int player = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken()); // 정원

        // 입력 받아오기
        for (int i = 0; i < player; i++) {
            st = new StringTokenizer(br.readLine());
            Node p = new Node(Integer.parseInt(st.nextToken()), st.nextToken());
            boolean join = false;
            // room 목록을 순회하면서
            for (Room room : room) {
                // 1. 방의 정원이 차지 않았고
                // 2. 레벨 범위 내에 있다면
                if (room.players.size() < max && (room.baseLevel-10 <= p.level && room.baseLevel+10 >= p.level)) {
                    room.players.add(p);    // room에 player list를 추가함
                    join = true;    // join 여부를 변경
                    break;
                }
            }

            if (!join) {    // 방을 순회해도 join 되지 않았다면 새로운 방을 만듦
                room.add(new Room(p));
            }
        }

        // 마지막으로 방을 순회하면서
        for (Room room : room) {
            Collections.sort(room.players);     // 사전순으로 정렬해주고
            if (room.players.size() == max) {   // 정원이 채워지면 방 상태가 start
                sb.append("Started!").append("\n");
            } else {    // 아니라면 waiting
                sb.append("Waiting!").append("\n");
            }
            // 상태를 언급한 후 플레이어 목록을 담음
            for (Node p : room.players) {
                sb.append(p.level).append(" ").append(p.id).append("\n");
            }
        }
        System.out.println(sb.toString());

    }

    static class Node implements Comparable<Node>{
        int level;
        String id;

        public Node(int level, String id) {
            this.level = level;
            this.id = id;
        }

        @Override
        public int compareTo(Node o) {
            return this.id.compareTo(o.id); // 아이디 사전순 정렬
        }
    }

    // room은 baseLevel과 플레이어 node를 가지는데, 생성자가 Node player여서 들어온 player의 레벨이 기준이 된다
    static class Room {
        int baseLevel;
        ArrayList<Node> players = new ArrayList<>();

        public Room(Node firstPlayer) {
            this.baseLevel = firstPlayer.level;
            this.players.add(firstPlayer);
        }
    }
}
