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
}
