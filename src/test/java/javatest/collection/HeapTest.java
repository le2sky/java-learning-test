package javatest.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

class HeapTest {

    @Test
    void priorityQueue_default는_최소힙() {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        stubIntegerHeap(minheap);

        int[] actual = new int[9];
        for (int i = 0; i < 9; i++) {
            actual[i] = minheap.poll();
        }
        assertThat(actual).isEqualTo(new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9
        });
    }

    @Test
    void priorityQueue_최대힙() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        stubIntegerHeap(maxHeap);
        int[] actual = new int[9];
        for (int i = 0; i < 9; i++) {
            actual[i] = maxHeap.poll();
        }
        assertThat(actual).isEqualTo(new int[]{
            9, 8, 7, 6, 5, 4, 3, 2, 1
        });
    }

    @Test
    void custom_priorityQueue_cost기준으로_최소힙() {
        PriorityQueue<Cost> costs = new PriorityQueue<>();
        costs.add(new Cost(1, 2, 3));
        costs.add(new Cost(1, 2, 2));
        costs.add(new Cost(1, 2, 1));

        int[] actual = new int[3];
        for (int i = 0; i < 3; i++) {
            actual[i] = costs.poll().getCost();
        }
        assertThat(actual).isEqualTo(new int[]{
            1, 2, 3
        });
    }

    @Test
    void custom_priorityQueue_cost기준으로_최대힙() {
        PriorityQueue<Cost> costs = new PriorityQueue<>(Comparator.reverseOrder());
        costs.add(new Cost(1, 2, 1));
        costs.add(new Cost(1, 2, 2));
        costs.add(new Cost(1, 2, 3));

        int[] actual = new int[3];
        for (int i = 0; i < 3; i++) {
            actual[i] = costs.poll().getCost();
        }
        assertThat(actual).isEqualTo(new int[]{
            3, 2, 1,
        });
    }

    class Cost implements Comparable<Cost> {

        private int cost;
        private int src;
        private int dest;

        public Cost(int src, int dest, int cost) {
            this.cost = cost;
            this.src = src;
            this.dest = dest;
        }

        @Override
        public int compareTo(Cost target) {
            return this.getCost() - target.getCost();
        }

        public int getCost() {
            return cost;
        }
    }

    private void stubIntegerHeap(PriorityQueue<Integer> heap) {
        heap.add(2);
        heap.add(8);
        heap.add(9);
        heap.add(6);
        heap.add(5);
        heap.add(3);
        heap.add(1);
        heap.add(4);
        heap.add(7);
    }
}
