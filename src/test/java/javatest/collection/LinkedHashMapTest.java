package javatest.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;

class LinkedHashMapTest {

    @Test
    void linked_hash_map_은_순서를_보장한다() {
        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();
        hashMap.put("hello", 23);
        hashMap.put(", ", 22);
        hashMap.put("world!", 321);
        StringBuilder sb = new StringBuilder();
        for(String key : hashMap.keySet()) {
            sb.append(key);
        }

        assertThat(sb.toString()).isEqualTo("hello, world!");
    }
}
