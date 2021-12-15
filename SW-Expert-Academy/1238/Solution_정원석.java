import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int N, S;
    static LinkedList<Integer>[] DirectedGraph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            DirectedGraph = new LinkedList[101];
            boolean[] chk = new boolean[101];
            st = new StringTokenizer(br.readLine());

            loop: for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if (DirectedGraph[from] == null) {
                    DirectedGraph[from] = new LinkedList<>();
                    DirectedGraph[from].add(to);
                } else {
                    for (int j = 0, size = DirectedGraph[from].size(); j < size; j++) {
                        if (DirectedGraph[from].get(j) == to) {
                            continue loop;
                        }
                    }
                    DirectedGraph[from].add(to);
                }
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(S);
            chk[S] = true;
            int answer = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                answer = 0;
                for (int i = 0; i < size; i++) {
                    int cur = q.poll();
                    answer = Math.max(answer, cur);
                    if (DirectedGraph[cur] != null) {
                        for (int j = 0, len = DirectedGraph[cur].size(); j < len; j++) {
                            int v = DirectedGraph[cur].get(j);
                            if (!chk[v]) {
                                q.add(v);
                                chk[v] = true;
                            }
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}