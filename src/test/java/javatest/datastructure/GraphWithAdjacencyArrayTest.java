package javatest.datastructure;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GraphWithAdjacencyArrayTest {

    @Test
    void 양방향으로_설정_가능() {
        Graph graph = new Graph(3);
        graph.put(1, 2);
        int[][] actual = graph.getGraph();
        assertThat(actual[1][2] == 1).isTrue();
        assertThat(actual[2][1] == 1).isTrue();
    }

    @Test
    void 단방향으로_설정_가능() {
        Graph graph = new Graph(3);
        graph.putSingle(1, 2);
        int[][] actual = graph.getGraph();
        assertThat(actual[1][2] == 1).isTrue();
        assertThat(actual[2][1] == 1).isFalse();
    }

    class Graph {

        private int[][] graph;

        public Graph(int size) {
            this.graph = new int[size + 1][size + 1];
        }

        public int[][] getGraph() {
            return graph;
        }

        public void put(int src, int dest) {
            graph[src][dest] = graph[dest][src] = 1;
        }

        public void putSingle(int src, int dest) {
            graph[src][dest] = 1;
        }
    }
}
