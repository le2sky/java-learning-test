package javatest.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    @Test
    void 문자열_자르기_with_split() {
        String target = "le2sky";
        String[] strings = target.split("");
        assertThat(strings.length).isEqualTo(6);
    }

    // substring(n, k) n번 인덱스 부터 k-1번 인덱스까지
    @Test
    void 문자열_자르기_with_subString() {
        String target = "hello, world!";
        String hello = target.substring(0, 7);
        String world = target.substring(7);
        String h = target.substring(0, 1);

        assertThat(hello).isEqualTo("hello, ");
        assertThat(world).isEqualTo("world!");
        assertThat(h).isEqualTo("h");
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

    @Test
    void 문자열_길이() {
        String hello = "hello";

        assertThat(hello.length()).isEqualTo(5);
    }

    @Test
    void 빈_문자열_확인() {
        assertThat("".isEmpty()).isTrue();
    }

    @Test
    void 인덱스로_문자_찾기() {
        String hello = "hello";
        int result = hello.indexOf("o");//문자로 인덱스
        int lastIndex = hello.lastIndexOf("l"); // 마지막 문자
        char result2 = hello.charAt(4); //인덱스로 문자

        assertThat(result).isEqualTo(4);
        assertThat(hello.charAt(result)).isEqualTo((char) result2);
        assertThat(lastIndex).isEqualTo(3);
    }

    // 전부다 바뀌는 듯
    @Test
    void 특정_문자_교체하기() {
        String hello = "h?ello?";
        String replaced = hello.replace("?", "!");

        assertThat(replaced).isEqualTo("h!ello!");
    }

    @Test
    void 문자열_비교() {
        String hello = "hello";
        String world = "world";
        boolean result = hello.equals(world);

        assertThat(result).isFalse();
    }

    @Test
    void 문자열_포함() {
        String helloworld = "helloWorld!";
        boolean world = helloworld.contains("World"); //대소문자 구분

        assertThat(world).isTrue();
    }

    @Test
    void 대소문자_변환하기() {
        String target = "aBc";
        String upper = target.toUpperCase();
        String lower = target.toLowerCase();

        assertThat(upper).isEqualTo("ABC");
        assertThat(lower).isEqualTo("abc");
    }

    @Test
    void 문자열_사전순_비교() {
        assertThat("abcd".compareTo("abce")).isEqualTo(-1);
        assertThat("b".compareTo("a")).isEqualTo(1);
        assertThat("a".compareTo("a")).isEqualTo(0);
    }

    @Test
    void 문자열_to_숫자() {
        String target = "300";

        assertThat(Integer.parseInt(target)).isEqualTo(300);
    }

    @Test
    void 숫자_to_문자열() {
        int target = 300;

        assertThat(Integer.toString(target)).isEqualTo("300");
    }
}
