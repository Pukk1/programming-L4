import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tpo.SplayTree;

import java.util.Arrays;
import java.util.List;

public class SplayTreeTests {

    @ParameterizedTest
    @CsvSource({
            "1,one",
            "2,two",
            "3,three",
    })
    public void testPutAndGet(int key, String value) {
        SplayTree<Integer, String> splayTree = new SplayTree<>();

        splayTree.put(key, value);
        assertEquals(value, splayTree.get(key));
    }

    @ParameterizedTest
    @CsvSource({
            "1,one",
            "2,two",
            "3,three",
    })
    public void testRemoveAndContains(int key, String value) {
        SplayTree<Integer, String> splayTree = new SplayTree<>();

        splayTree.put(key, value);
        assertEquals(value, splayTree.get(key));

        splayTree.remove(key);
        assertFalse(splayTree.contains(key));
    }

    @Test
    public void testSize() {
        SplayTree<Integer, String> splayTree = new SplayTree<>();

        splayTree.put(1, "1");
        splayTree.put(2, "2");
        splayTree.put(3, "3");

        assertEquals(3, splayTree.size());
    }

    @Test
    public void testKeys() {
        SplayTree<Integer, String> splayTree = new SplayTree<>();

        splayTree.put(1, "1");
        splayTree.put(2, "2");
        splayTree.put(3, "3");

        assertArrayEquals(new List[]{Arrays.asList(1, 2, 3)}, new List[]{splayTree.keys()});
    }
}
