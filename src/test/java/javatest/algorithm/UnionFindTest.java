package javatest.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UnionFindTest {


    @Test
    void unionFindTest() {
        int node = 10;
        int[] parent = new int[node];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        union(parent, 1, 2);
        union(parent, 2, 3);
        union(parent, 3, 4);
        union(parent, 5, 6);

        assertThat(compare(parent, 2, 3)).isTrue();
        assertThat(compare(parent, 1, 2)).isTrue();
        assertThat(compare(parent, 1, 3)).isTrue();
        assertThat(compare(parent, 1, 4)).isTrue();
        assertThat(compare(parent, 5, 6)).isTrue();

        assertThat(compare(parent, 5, 3)).isFalse();
        assertThat(compare(parent, 1, 7)).isFalse();
        assertThat(compare(parent, 1, 8)).isFalse();
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
