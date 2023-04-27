package javatest.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PermutationTest {

    private List<int[]> answer;

    @BeforeEach
    void setUp() {
        answer = new ArrayList<>();
    }

    @Test
    void permutation() {
        //4P2
        int[] arr = new int[]{1, 2, 3, 4};
        int n = arr.length;
        int r = 2;
        int expectedSize = getPermutationCaseCount(n, r);
        int[] buffer = new int[r];
        boolean[] visited = new boolean[n];
        permutation(arr, n, r, buffer, visited, 0);

        Set<String> set = new HashSet<>();
        for (int[] ints : answer) {
            String string = Arrays.stream(ints)
                .mapToObj(String::valueOf)
                .toString();
            set.add(string);
        }

        assertThat(answer.size()).isEqualTo(expectedSize);
        assertThat(set.size()).isEqualTo(expectedSize);
    }

    private int getPermutationCaseCount(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    private int factorial(int i) {
        if (i == 1) {
            return 1;
        }
        return i * factorial(i - 1);
    }

    private void permutation(int[] arr, int n, int r, int[] buffer, boolean[] visited, int depth) {
        if (depth == r) {
            int[] copy = Arrays.copyOfRange(buffer, 0, buffer.length);
            answer.add(copy);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                buffer[depth] = arr[i];
                permutation(arr, n, r, buffer, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
