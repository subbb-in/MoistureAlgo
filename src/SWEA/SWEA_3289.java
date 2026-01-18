package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서로소 집합
public class SWEA_3289 {
    // 우선 부모 배열을 만들어야함
    static int[] p;
    static class Edge{
        int type, from, to;
        public Edge(int type, int from, int to) {
            this.type = type;
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "type=" + type +
                    ", from=" + from +
                    ", to=" + to +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());  // 노드수
            int M = Integer.parseInt(st.nextToken());  // 연산수

            Edge[] edges = new Edge[M]; // 엣지 배열

            // 명령어와 노드 번호를 입력 받음
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // make set
            p = new int[N+1];
            for (int i = 1; i <= N; i++) {
                p[i] = i;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");

            // 같은 집합인지 확인
            for (Edge e : edges){
                if(e.type == 0) {
                    unionSet(e.from, e.to);
                } else {
                    sb.append(findSet(e.from) == findSet(e.to) ? "1" : "0");
                }
            }

            System.out.println(sb);

        } // tc

    } // main 메서드

    static int findSet(int a) {
        if (p[a] != a) {
            p[a] = findSet(p[a]);
        }
        return p[a];
    }

    static boolean unionSet(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a == b) return false;

        p[b] = a;
        return true;
    }
}
