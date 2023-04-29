package javatest.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombinationTest {

    private List<int[]> answer;

    @BeforeEach
    void setUp() {
        this.answer = new ArrayList<>();
    }

    @Test
    void combination의_경우의_수() {
        //nCr = n!/ ((n-r)! * r!)
        int[] arr = new int[]{1, 2, 3, 4};
        int n = arr.length;
        int r = 3;
        boolean[] visited = new boolean[n];
        int expected = factorial(n) / (factorial(n - r) * factorial(r));
        combination(arr, visited, 0, n, r);
        assertThat(answer.size()).isEqualTo(expected);
    }

    private int factorial(int i) {
        if (i == 1) {
            return 1;
        }
        return i * factorial(i - 1);
    }

    private void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int[] buffer = getBuffer(arr, visited);
            answer.add(buffer);
            print(arr, visited, n);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private int[] getBuffer(int[] arr, boolean[] visited) {
        ArrayList<Integer> buffer = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                buffer.add(arr[i]);
            }
        }
        return buffer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    private void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
