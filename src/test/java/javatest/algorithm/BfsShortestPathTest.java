package javatest.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class BfsShortestPathTest {

    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};

    @Test
    void bfs로_일반적으로_최단경로를_구하는_패턴() {
        int[][] map = {
            {1, 1, 0, 0},
            {1, 1, 1, 0},
            {1, 0, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 0, 1},
        };
        int row = map.length;
        int col = map[0].length;
        boolean[][] visited = new boolean[row][col];
        int actual = bfs(0, 0, visited, row, col, map);
        assertThat(actual).isEqualTo(8);
    }

    @Test
    void 경로를_찾을_수_없으면_마이너스_일() {
        int[][] map = {
            {1, 1, 0, 0},
            {1, 1, 1, 0},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 1},
        };
        int row = map.length;
        int col = map[0].length;
        boolean[][] visited = new boolean[row][col];
        int actual = bfs(0, 0, visited, row, col, map);
        assertThat(actual).isEqualTo(-1);
    }

    int bfs(int x, int y, boolean[][] visited, int row, int col, int[][] map) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.x][node.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue;
                }
                if (map[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                queue.add(new Node(nx, ny, node.depth + 1));
            }

            if (visited[row - 1][col - 1]) {
                return node.depth;
            }
        }

        return -1;
    }

    class Node {

        public int x;
        public int y;
        public int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
