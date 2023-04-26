package javatest.number;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 정수의_각자리수를_추출() {
        int target = 123;
        int[] expected = {3, 2, 1};
        int[] actual = new int[3];

        int index = 0;
        while (target > 0) {
            actual[index++] = target % 10;
            target /= 10;
        }
        assertThat(actual).isEqualTo(expected);
    }
}
