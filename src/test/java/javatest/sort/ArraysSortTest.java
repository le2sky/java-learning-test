package javatest.sort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
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
    void primitive_type_배열_역순_정렬() {
        int[] ints = {6, 3, 2, 1, 4, 5, 7};
        int[] result = IntStream.of(ints)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(it -> it)
                .toArray();

        assertThat(result).isEqualTo(new int[]{7, 6, 5, 4, 3, 2, 1});
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

    @Test
    void comparator를_이용해서_sort_커스터마이징_길이가_같다면_사전순() {
        String[] strings = new String[]{"apple3", "apple2", "apple1"};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        assertThat(strings).isEqualTo(new String[]{"apple1", "apple2", "apple3"});
    }

    @Test
    void 람다를_이용해서_sort_커스터마이징() {
        String[] strings = new String[]{"apple3", "apple2", "apple1"};
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        assertThat(strings).isEqualTo(new String[]{"apple1", "apple2", "apple3"});
    }

    @Test
    void 람다를_이용해서_collection_sort_커스터마이징() {
        ArrayList<String> strings = new ArrayList<>(List.of("apple3", "apple2", "apple1"));
        Collections.sort(strings, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        assertThat(strings).isEqualTo(List.of("apple1", "apple2", "apple3"));
    }
}
