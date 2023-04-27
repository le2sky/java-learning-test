package javatest.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class HashMapTest {

    @Test
    void hashmap_기본_사용() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("key", 1);
        Integer value = hashMap.get("key");
        assertThat(value).isEqualTo(1);
    }

    @Test
    void hashmap_keys_values() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("math", 20);
        hashMap.put("english", 80);
        Set<String> keySet = hashMap.keySet();
        Collection<Integer> values = hashMap.values();
        Set<Entry<String, Integer>> entries = hashMap.entrySet();
        for (Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        assertThat(keySet.contains("math")).isTrue();
        assertThat(keySet.size()).isEqualTo(2);
        assertThat(values.contains(20)).isTrue();
        assertThat(values.size()).isEqualTo(2);
        assertThat(entries.size()).isEqualTo(2);
    }


    @Test
    void hashmap으로_요소_카운팅_with_getOrDefault() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] source = new String[]{"tdd", "oop", "ddd", "oop", "ddd"};
        for (String target : source) {
            hashMap.put(target, hashMap.getOrDefault(target, 0) + 1);
        }

        assertThat(hashMap.get("tdd")).isEqualTo(1);
        assertThat(hashMap.get("oop")).isEqualTo(2);
        assertThat(hashMap.get("ddd")).isEqualTo(2);
    }

    @Test
    void 순서를_보장하지않음() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("hello", 23);
        hashMap.put(", ", 22);
        hashMap.put("world!", 321);
        StringBuilder sb = new StringBuilder();
        for(String key : hashMap.keySet()) {
            sb.append(key);
        }

        assertThat(sb.toString()).isNotEqualTo("hello, world!");
    }

    @Test
    void putIfAbsent_값이_존재하지_않으면_설정한다() throws Exception {
        HashMap<String, Integer> hashMap = new HashMap<>();
        assertThat(hashMap.get("temp")).isNull();
        hashMap.putIfAbsent("temp", 2);
        assertThat(hashMap.get("temp")).isEqualTo(2);
        assertThat(hashMap.putIfAbsent("temp", 3)).isEqualTo(2);
        assertThat(hashMap.get("temp")).isEqualTo(2);
    }
}
