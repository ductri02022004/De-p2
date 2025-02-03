import java.util.LinkedList;
import java.util.Queue;

public class dijkstra {

    static void findTheRouteBFS(int G[][], int a, int z) {
        int n = G.length;
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;
        parent[a] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == z) {
                printPath(parent, z);
                return;
            }
            for (int v = 0; v < n; v++) {
                if (G[u][v] != 0 && !visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                    parent[v] = u;
                }
            }
        }
        System.out.println("No path found from " + a + " to " + z);
    }

    static void printPath(int[] parent, int j) {
        if (parent[j] == -1) {
            System.out.print(j);
            return;
        }
        printPath(parent, parent[j]);
        System.out.print(" -> " + j);
    }

     static void dijkstra(int G[][], int a, int z, int[] nodeValues) {
        int n = G.length;
        int[] L = new int[n];
        Boolean[] S = new Boolean[n];

        for (int i = 0; i < n; i++) {
            L[i] = Integer.MAX_VALUE;
            S[i] = false;
        }

        L[a] = 0;

        while (S[z] == false) {
            int min = Integer.MAX_VALUE;
            int u = -1;
            for (int k = 0; k < n; k++) {
                if (S[k] == false && L[k] < min) {
                    min = L[k];
                    u = k;
                }
            }

            if (u == -1) {
                break;
            }

            S[u] = true;
            for (int v = 0; v < n; v++) {
                if (S[v] == false && G[u][v] != 0 && L[u] + G[u][v] - nodeValues[v] < L[v]) {
                    L[v] = L[u] + G[u][v] - nodeValues[v];
                }
            }
        }

        System.out.println("a \t z \t L");
        System.out.println(a + " \t " + z + "\t" + L[z]);
    }

    public static void main(String[] args) {
        int[][] G = {
                {0,0,0,0,4,12,0,0},
                {0,0,0,12,4,3,11,0},
                {0,0,0,0,3,0,4,0},
                {0,12,0,0,0,15,3,3},
                {12,4,3,0,2,0,0,0},
                {4,3,0,15,0,0,0,0},
                {0,11,4,3,0,0,0,7},
                {0,0,0,3,0,0,7,0}
        };
        int[] nodeValues = {1, 3, 1, 3, 2, 2, 2, 1};
        dijkstra(G, 0, 4, nodeValues);
        findTheRouteBFS(G, 0, 4);
    }
}
