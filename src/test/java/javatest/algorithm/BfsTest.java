package javatest.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class BfsTest {

    @Test
    void 너비우선으로_탐색한다() {
        int size = 6;
        Graph graph = new Graph(size);
        graph.put(1, 2);
        graph.put(1, 3);
        graph.put(2, 4);
        graph.put(2, 5);
        graph.put(3, 6);

        boolean[] visited = new boolean[size + 1];
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> actual = new ArrayList<>();
        bfs(1, visited, graph, actual);

        assertThat(actual).isEqualTo(expected);
    }

    public void bfs(int node,boolean[] visited, Graph graph, List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            int now = queue.poll();
            list.add(now);
            visited[now] = true;
            for(int next : graph.relation(now)) {
                if(!visited[next])
                    queue.offer(next);
            }
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

        public ArrayList<Integer> relation(int node) {
            return graph[node];
        }
    }

}
