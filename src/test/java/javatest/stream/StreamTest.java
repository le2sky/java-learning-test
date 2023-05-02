package javatest.stream;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class StreamTest {

    @Test
    void list에_담긴_모든_숫자_값을_2배한_결과_list() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = numbers.stream().map(n -> n * 2).collect(Collectors.toList());
        assertThat(actual).isEqualTo(List.of(2, 4, 6, 8, 10, 12));
    }

    @Test
    void list에서_짝수만_남긴_결과_list() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = numbers.stream().filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        assertThat(actual).isEqualTo(List.of(2, 4, 6));
    }

    @Test
    void list에서_홀수만_남긴_결과를_set으로_반환() {
        List<Integer> numbers = Arrays.asList(1, 3, 3, 4, 5, 6);
        Set<Integer> actual = numbers.stream().filter(n -> n % 2 != 0)
            .collect(Collectors.toSet());

        assertThat(actual).isEqualTo(new HashSet<>(List.of(1, 3, 5)));
    }

    @Test
    void list_총합() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int reduce = numbers.stream().reduce(0, (acc, v) -> acc + v);
        assertThat(reduce).isEqualTo(21);
    }

    @Test
    void list_총합_with_lambda() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer reduce = numbers.stream().reduce(0, Integer::sum);
        assertThat(reduce).isEqualTo(21);
    }

    @Test
    void list_총합_with_sum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();

        assertThat(sum).isEqualTo(21);
    }

    @Test
    void list_요소_중_최대() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int max = numbers.stream()
            .max(Comparator.naturalOrder())
            .orElseThrow();

        assertThat(max).isEqualTo(6);
    }

    @Test
    void list_요소_중_최소() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int min = numbers.stream()
            .min(Comparator.naturalOrder())
            .orElseThrow();

        assertThat(min).isEqualTo(1);
    }
}
