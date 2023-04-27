package javatest.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;

class TreeMapTest {

    @Test
    void key를_기준으로_정렬된다() throws Exception {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("e", 5);
        treeMap.put("d", 4);
        treeMap.put("c", 3);
        treeMap.put("b", 2);
        treeMap.put("a", 1);
        StringBuilder sb = new StringBuilder();
        for (String key : treeMap.keySet()) {
            sb.append(key);
        }

        assertThat(sb.toString()).isEqualTo("abcde");
    }

}
