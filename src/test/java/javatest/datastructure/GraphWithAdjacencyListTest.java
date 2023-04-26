package javatest.datastructure;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

// 인접 리스트
class GraphWithAdjacencyListTest {

    @Test
    void 정점마다_인접노드의_연결리스트를_가진다() {
        Graph graph = new Graph(3);
        assertThat(graph.getGraph(3)).isInstanceOf(ArrayList.class);
    }

    @Test
    void 양방향으로_설정_가능() {
        Graph graph = new Graph(3);
        graph.put(1, 2);
        ArrayList<Integer> srcList = graph.getGraph(1);
        ArrayList<Integer> destList = graph.getGraph(2);
        assertThat(srcList.contains(2)).isTrue();
        assertThat(destList.contains(1)).isTrue();
    }

    @Test
    void 단방향으로_설정_가능() {
        Graph graph = new Graph(3);
        graph.putSingle(1, 2);
        ArrayList<Integer> srcList = graph.getGraph(1);
        ArrayList<Integer> destList = graph.getGraph(2);
        assertThat(srcList.contains(2)).isTrue();
        assertThat(destList.contains(1)).isFalse();
    }


    class Graph {

        private ArrayList<ArrayList<Integer>> graph;

        public Graph(int size) {
            this.graph = new ArrayList<>();
            for (int i = 0; i < size + 1; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public ArrayList<Integer> getGraph(int i) {
            return graph.get(i);
        }

        public void put(int src, int dest) {
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        public void putSingle(int src, int dest) {
            graph.get(src).add(dest);
        }
    }


}
