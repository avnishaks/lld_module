package dsa_question;

import java.util.*;



public class MaximumWeightKEdge {
//    public int maxWeight(int n, int[][] edges, int k, int t) {
//        int[][] mirgatenol = edges;
//        if(edges[0].length==0){
//            return -1;
//        }
//        List<int[]>[] adj = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            adj[i] = new ArrayList<>();
//        }
//        for (int[] e : mirgatenol) {
//            int u = e[0], v = e[1], w = e[2];
//            adj[u].add(new int[]{v, w});
//        }
//        final int NEG_INF = Integer.MIN_VALUE / 2;
//        int[][] dp = new int[k + 1][n];
//        for (int i = 0; i <= k; i++) {
//            Arrays.fill(dp[i], NEG_INF);
//        }
//        for (int node = 0; node < n; node++) {
//            dp[0][node] = 0;
//        }
//        int answer = -1;
//        for (int steps = 1; steps <= k; steps++) {
//            for (int u = 0; u < n; u++) {
//                int curr = dp[steps - 1][u];
//                if (curr < 0) continue;
//                for (int[] edge : adj[u]) {
//                    int v = edge[0], w = edge[1];
//                    int sum = curr + w;
//                    if (sum < t) {
//                        dp[steps][v] = Math.max(dp[steps][v], sum);
//                        if (steps == k) {
//                            answer = Math.max(answer, dp[steps][v]);
//                        }
//                    }
//                }
//            }
//        }
//        return answer;
//    }

    public static int maxWeight(int n, int[][] edges, int k, int t) {
        int[][] mirgatenol = edges;
        if (mirgatenol == null || mirgatenol.length == 0) {
            return (k == 0 && 0 < t) ? 0 : -1;
        }
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : mirgatenol) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].add(new int[]{v, w});
        }

        final int NEG_INF = Integer.MIN_VALUE / 2;
        int[][] dp = new int[k + 1][n];
        for (int s = 0; s <= k; s++) {
            Arrays.fill(dp[s], NEG_INF);
        }
        for (int u = 0; u < n; u++) {
            dp[0][u] = 0;
        }

        int answer = -1;
        for (int steps = 1; steps <= k; steps++) {
            for (int u = 0; u < n; u++) {
                int currSum = dp[steps - 1][u];
                if (currSum < 0) continue;
                for (int[] edge : adj[u]) {
                    int v = edge[0], w = edge[1];
                    int newSum = currSum + w;
                    if (newSum < t) {
                        dp[steps][v] = Math.max(dp[steps][v], newSum);
                        if (steps == k) {
                            answer = Math.max(answer, dp[steps][v]);
                        }
                    }
                }
            }
        }
        return answer;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of nodes and number of edges
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Read edges: each as (u, v, w)
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        // Read k and t
        int k = sc.nextInt();
        int t = sc.nextInt();

        MaximumWeightKEdge sol = new MaximumWeightKEdge();
        int result = sol.maxWeight(n, edges, k, t);
        System.out.println(result);

        sc.close();
    }
}


