package javatest.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class KruskalTest {

    @Test
    void 최소_신장_트리() {
        int node = 6;
        int[] parent = new int[node + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[][] edges = new int[][]{
            {1, 2, 1},
            {1, 3, 3},
            {2, 3, 2}
        };
        int expectedCost = 3;
        Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);

        int answer = 0;
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];
            if (!compare(parent, src, dest)) {
                answer += cost;
                union(parent, src, dest);
            }
        }

        assertThat(answer).isEqualTo(expectedCost);
    }


    public void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent, parent[x]);
    }

    public boolean compare(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        return a == b;
    }
}
