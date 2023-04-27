package javatest.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringBuilderTest {

    @Test
    void append() {
        StringBuilder stringBuilder = new StringBuilder("hello, ");
        stringBuilder.append("world!");
        assertThat(stringBuilder.toString()).isEqualTo("hello, world!");
    }

    @Test
    void delete() {
        StringBuilder stringBuilder = new StringBuilder("hello!");
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        assertThat(stringBuilder.toString()).isEqualTo("hello");
    }

    @Test
    void reverse() {
        StringBuilder stringBuilder = new StringBuilder("다간 을선전");
        stringBuilder.reverse();
        assertThat(stringBuilder.toString()).isEqualTo("전선을 간다");
    }

    @Test
    void deleteCharAt() {
        StringBuilder stringBuilder = new StringBuilder("육군 훈려련소가");
        stringBuilder.deleteCharAt(stringBuilder.indexOf("려"));
        assertThat(stringBuilder.toString()).isEqualTo("육군 훈련소가");
    }
}
