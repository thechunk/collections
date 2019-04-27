package set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import static org.junit.Assert.*;

public class SetTests {

    private Set set;

    @Before
    public void setUp() throws Exception {
        set = new Set<>(new Integer[] {3, 4});
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void size() {
        assertEquals(2, set.size());
        set.add(1);
        set.add(2);
        assertEquals(4, set.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(set.isEmpty());
        set.add(1);
        set.add(2);
        assertFalse(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    public void contains() {
        assertFalse(set.contains(1));
        set.add(1);
        set.add(2);
        assertTrue(set.contains(1));
        assertFalse(set.contains(5));
    }

    @Test(expected = NullPointerException.class)
    public void containsThrowsNullPointer() {
        set.contains(null);
    }

    @Test(expected = ClassCastException.class)
    public void containsThrowsClassCast() {
        set.contains("str");
    }

    @Test
    public void iterator() {
        Iterator it = set.iterator();
        assertNotNull(it);
        assertTrue(it.hasNext());
        ArrayList<Integer> keys = new ArrayList<>();
        keys.add((Integer)it.next());
        keys.add((Integer)it.next());
        assertTrue(keys.containsAll(Arrays.asList(3, 4)));
    }

    @Test
    public void toArray() {
        Object[] keys = set.toArray();
        assertEquals(2, keys.length);
        Arrays.sort(keys);
        assertArrayEquals(keys, new Integer[] {3, 4});
    }

    @Test
    public void add() {
        assertTrue(set.add(1));
        assertFalse(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.containsAll(Arrays.asList(1, 2)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addThrowsUnsupportedOperation() {
    }

    @Test(expected = ClassCastException.class)
    public void addThrowsClassCast() {
        set.add("str");
    }

    @Test(expected = NullPointerException.class)
    public void addThrowsNullPointer() {
        set.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addThrowsIllegalArgument() {
    }

    @Test
    public void remove() {
        assertTrue(set.remove(3));
        assertEquals(1, set.size());
        assertFalse(set.remove(5));
        set.add(5);
        assertTrue(set.remove(5));
        assertFalse(set.remove(5));
        assertEquals(1, set.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrowsUnsupportedOperation() {
    }

    @Test(expected = ClassCastException.class)
    public void removeThrowsClassCast() {
        set.remove("str");
    }

    @Test(expected = NullPointerException.class)
    public void removeThrowsNullPointer() {
        set.remove(null);
    }

    @Test
    public void addAll() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void removeAll() {
        assertTrue(set.removeAll(Arrays.asList(3, 4)));
        assertEquals(0, set.size());
        set.add(1);
        set.add(2);
        set.add(3);
        assertTrue(set.removeAll(Arrays.asList(1, 2)));
        assertTrue(set.contains(3) && set.size() == 1);
        assertFalse(set.removeAll(Arrays.asList(5, 6)));

        assertFalse(set.removeAll(null));
        assertFalse(set.removeAll(Collections.emptyList()));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAllThrowsUnsupportedOperation() {
    }

    @Test(expected = ClassCastException.class)
    public void removeAllThrowsClassCast() {
        set.add("str");
    }

    @Test(expected = NullPointerException.class)
    public void removeAllThrowsNullPointer() {
        set.add(null);
    }

    @Test
    public void retainAll() {
    }

    @Test
    public void containsAll() {
    }

    @Test
    public void toArray1() {
    }
}