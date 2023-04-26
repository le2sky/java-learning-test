package javatest.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DfsTest {

    @Test
    void 깊이_우선으로_탐색한다() {
        int size = 6;
        Graph graph = new Graph(size);
        graph.put(1, 2);
        graph.put(1, 3);
        graph.put(2, 4);
        graph.put(2, 5);
        graph.put(3, 6);

        boolean[] visited = new boolean[size + 1];
        List<Integer> expected = List.of(1, 2, 4, 5, 3, 6);
        List<Integer> actual = new ArrayList<>();
        dfs(1, visited, graph, actual);

        assertThat(actual).isEqualTo(expected);
    }

    private void dfs(int node, boolean[] visited, Graph graph, List<Integer> list) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        list.add(node);
        for (int next : graph.getGraph(node)) {
            dfs(next, visited, graph, list);
        }
    }

    class Graph {

        private ArrayList<Integer>[] graph;

        public Graph(int size) {
            graph = new ArrayList[size + 1];
            for (int i = 0; i <= size; i++) {
                graph[i] = new ArrayList<>();
            }
        }

        public void put(int src, int dest) {
            graph[src].add(dest);
            graph[dest].add(src);
        }

        public ArrayList<Integer> getGraph(int node) {
            return graph[node];
        }
    }
}
