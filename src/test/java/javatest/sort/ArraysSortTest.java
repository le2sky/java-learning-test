package javatest.sort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class ArraysSortTest {

    @Test
    void primitive_type_배열_정렬() {
        int[] ints = {6, 3, 2, 1, 4, 5, 7};
        Arrays.sort(ints);
        assertThat(ints).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    void primitive_type_배열_부분_정렬() {
        int[] ints = {6, 3, 2, 1, 4, 5, 7};
        Arrays.sort(ints, 1, 4);
        assertThat(ints).isEqualTo(new int[]{6, 1, 2, 3, 4, 5, 7});
    }

    @Test
    void wrapper_type_역순정렬() {
        Integer[] integers = new Integer[]{6, 3, 2, 1, 4, 5, 7};
        Arrays.sort(integers, Collections.reverseOrder());
        assertThat(integers).isEqualTo(new Integer[]{7, 6, 5, 4, 3, 2, 1});
    }

    @Test
    void wrapper_type_역순_부분_정렬() {
        Integer[] integers = new Integer[]{6, 1, 2, 3, 4, 5, 7};
        Arrays.sort(integers, 1, 4, Collections.reverseOrder());
        assertThat(integers).isEqualTo(new Integer[]{6, 3, 2, 1, 4, 5, 7});
    }
}
