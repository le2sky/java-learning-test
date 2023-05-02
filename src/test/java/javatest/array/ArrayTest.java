package javatest.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class ArrayTest {

    @Test
    void 자바_배열_선언_ints_기본값은_0() {
        int[] ints = new int[10];
        assertThat(ints[0]).isEqualTo(0);
    }

    @Test
    void 자바_배열_선언_strings_기본값은_null() {
        String[] strings = new String[10];
        assertThat(strings[0]).isNull();
    }

    @Test
    void 자바_배열_선언_float_기본값은_영점영에프() {
        float[] floats = new float[10];
        assertThat(floats[0]).isEqualTo(0.0f);
    }

    @Test
    void 자바_배열_선언_double_기본값은_영점영() {
        double[] doubles = new double[10];
        assertThat(doubles[0]).isEqualTo(0.0);
    }

    @Test
    void 자바_배열_선언_boolean_기본값은_false() {
        boolean[] booleans = new boolean[10];
        assertThat(booleans[0]).isFalse();
    }

    @Test
    void 자바_배열_선언_초기화() {
        int[] ints = new int[]{1, 2, 3, 4};
        assertThat(ints.length).isEqualTo(4);
    }

    @Test
    void 특정_배열에_값을_넣을_때_중복_없이_넣는다() {
        ArrayList<Integer> actual = new ArrayList<>();
        int[] values = {1, 2, 3, 4, 4, 5};
        for (int value : values) {
            if (!actual.contains(value)) {
                actual.add(value);
            }
        }
        assertThat(actual.size()).isEqualTo(5);
    }

    @Test
    void Array_List의_값을_하나씩_가져와서_배열에_넣는다() {
        List<Integer> targetIntList = Arrays.asList(1, 2, 3);
        List<String> targetStringList = Arrays.asList("test ", "sample, Hi ", "le2sky");
        int[] intActual = new int[targetIntList.size()];
        String[] stringActual = new String[targetStringList.size()];
        for (int i = 0; i < targetStringList.size(); i++) {
            stringActual[i] = targetStringList.get(i);
        }
        for (int i = 0; i < targetIntList.size(); i++) {
            //auto unboxing
            intActual[i] = targetIntList.get(i);
        }

        assertThat(Arrays.stream(intActual).sum()).isEqualTo(6);
        assertThat(String.join("", stringActual))
            .isEqualTo("test sample, Hi le2sky");
    }

    @Test
    void collection_toArray() {
        List<Integer> targetIntList = Arrays.asList(1, 2, 3);
        Integer[] ints = targetIntList.toArray(new Integer[0]);
        assertThat(Arrays.stream(ints).reduce(0, Integer::sum))
            .isEqualTo(6);
    }

    @Test
    void 부분_배열을_복사하기() {
        int[] source = {1, 2, 3, 4, 5};
        int[] ints1 = Arrays.copyOfRange(source, 2, source.length);
        int[] ints2 = Arrays.copyOfRange(source, 0, 3);
        int[] ints3 = Arrays.copyOfRange(source, 2, 4);

        assertThat(ints1).isEqualTo(new int[]{3, 4, 5});
        assertThat(ints2).isEqualTo(new int[]{1, 2, 3});
        assertThat(ints3).isEqualTo(new int[]{3, 4});
    }

    @Test
    void 배열_특정_값_찾기_with_binarySearch() {
        int[] source = {1, 2, 3, 4, 5, 4, 6};
        Arrays.sort(source);
        int actual = Arrays.binarySearch(source, 5);
        assertThat(actual).isEqualTo(5);
    }

    @Test
    void 배열을_array_list로_변경() {
        //primitive 타입은 아래처럼 불가능
        String[] strings = new String[]{"leesky", "temp"};
        List<String> list = Arrays.asList(strings);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(1)).isEqualTo("temp");
    }

    @Test
    void 배열_max() {
        Integer[] integers = new Integer[]{6, 1, 2, 3, 4, 5, 7};
        int max = Arrays.stream(integers)
            .max(Comparator.naturalOrder())
            .orElseThrow();

        assertThat(max).isEqualTo(7);
    }

    @Test
    void 배열_min() {
        Integer[] integers = new Integer[]{6, 1, 2, 3, 4, 5, 7};
        int min = Arrays.stream(integers)
            .min(Comparator.naturalOrder())
            .orElseThrow();

        assertThat(min).isEqualTo(1);
    }
}
