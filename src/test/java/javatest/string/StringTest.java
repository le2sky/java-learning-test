package javatest.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void 문자열_자르기_with_split() {
        String target = "le2sky";
        String[] strings = target.split("");
        assertThat(strings.length).isEqualTo(6);
    }

    @Test
    void 문자열_자르기_with_subString() {
        String target = "hello, world!";
        String hello = target.substring(0, 7);
        String world = target.substring(7);
        assertThat(hello).isEqualTo("hello, ");
        assertThat(world).isEqualTo("world!");
    }

    @Test
    void 문자열_합치기_with_concat() {
        String hello = "hello, ";
        String world = "world!";
        assertThat(hello.concat(world)).isEqualTo("hello, world!");
    }

    @Test
    void 문자열_합치기_with_String_join() {
        String hello = "hello, ";
        String world = "world!";
        assertThat(String.join("", hello, world)).isEqualTo("hello, world!");
    }
}
