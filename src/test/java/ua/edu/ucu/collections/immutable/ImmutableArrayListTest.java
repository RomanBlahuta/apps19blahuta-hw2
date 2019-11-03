package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testArray() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        Object[] expected = {1, 2, 3, 4};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

    @Test
    public void testEmptyArray() {
        Object[] arr = {};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        Object[] expected = {};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAdd() {
        Object[] arr = {1, 2, 3};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        ial = ial.add(100);
        Object[] expected = {1, 2, 3, 100};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddIndex() {
        Object[] arr = {1, 2, 3};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        ial = ial.add(1, 77);
        Object[] expected = {1, 77, 2, 3};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOutOfBoundsNeg() {
        Object[] arr = {1, 2, 3};
        ImmutableArrayList ial = new ImmutableArrayList(arr);

        //exception here
        ial = ial.add(-1, 77);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOutOfBoundsPos() {
        Object[] arr = {1, 2, 3};
        ImmutableArrayList ial = new ImmutableArrayList(arr);

        //exception here
        ial = ial.add(100, 77);
    }
////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddAll() {
        Object[] arr = {1, 2, 3};
        Object[] arr2 = {11, 22, 33};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        ial = ial.addAll(arr2);
        Object[] expected = {1, 2, 3, 11, 22, 33};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddAllIndex() {
        Object[] arr = {1, 2, 3};
        Object[] arr2 = {11, 22, 33};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        ial = ial.addAll(0, arr2);
        Object[] expected = {11, 22, 33, 1, 2, 3};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllOutOfBoundsNeg() {
        Object[] arr = {1, 2, 3};
        Object[] arr2 = {11, 22, 33};
        ImmutableArrayList ial = new ImmutableArrayList(arr);

        //exception here
        ial = ial.addAll(-1, arr2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllOutOfBoundsPos() {
        Object[] arr = {1, 2, 3};
        Object[] arr2 = {11, 22, 33};
        ImmutableArrayList ial = new ImmutableArrayList(arr);

        //exception here
        ial = ial.addAll(5, arr2);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testGet() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        Object expected = 2;
        Object got = ial.get(1);

        assertEquals(expected, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBoundsPos() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);

        //exception here
        Object got = ial.get(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBoundsNeg() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);

        //exception here
        Object got = ial.get(-2);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testRemove() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        ial = ial.remove(2);
        Object[] expected = {1, 2, 4};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

    @Test
    public void testRemoveBeg() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        ial = ial.remove(0);
        Object[] expected = {2, 3, 4};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

    @Test
    public void testRemoveEnd() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        ial = ial.remove(3);
        Object[] expected = {1, 2, 3};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBoundsPos() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);

        //exception here
        ial = ial.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBoundsNeg() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);

        //exception here
        ial = ial.remove(-5);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testSet() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        ial = ial.set(1, 8);
        Object[] expected = {1, 8, 3, 4};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

    @Test
    public void testSetEnd() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        ial = ial.set(3, 8);
        Object[] expected = {1, 2, 3, 8};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

    @Test
    public void testSetBeg() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        ial = ial.set(0, 8);
        Object[] expected = {8, 2, 3, 4};
        Object[] got = ial.toArray();

        assertArrayEquals(expected, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBoundsPos() {

        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);

        //exception here
        ial = ial.set(7, 8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBoundsNeg() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);

        //exception here
        ial = ial.set(-7, 8);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testIndexOf() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        int expected = 3;
        int got = ial.indexOf(4);

        assertEquals(expected, got);
    }

    @Test
    public void testIndexOfNotFound() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        int expected = -1;
        int got = ial.indexOf(66);

        assertEquals(expected, got);

    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testSize() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        int expected = 4;
        int got = ial.size();

        assertEquals(expected, got);
    }

    @Test
    public void testSizeZero() {
        Object[] arr = new Object[0];
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        int expected = 0;
        int got = ial.size();

        assertEquals(expected, got);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testClear() {
        Object[] arr = {1, 2, 3, 4, 5};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        Object[] expected = new Object[0];
        Object[] got = ial.clear().toArray();

        assertArrayEquals(expected, got);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testIsEmpty() {
        Object[] arr = new Object[0];
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        boolean expected = true;
        boolean got = ial.isEmpty();

        assertEquals(expected, got);
    }

    @Test
    public void testIsNotEmpty() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        boolean expected = false;
        boolean got = ial.isEmpty();

        assertEquals(expected, got);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testEmptyToString() {
        Object[] arr = new Object[0];
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        String expected = "";
        String got = ial.toString();

        assertEquals(expected, got);
    }


    @Test
    public void testToString() {
        Object[] arr = {1, 2, 3, 4};
        ImmutableArrayList ial = new ImmutableArrayList(arr);
        String expected = "1, 2, 3, 4";
        String got = ial.toString();

        assertEquals(expected, got);
    }

////////////////////////////////////////////////////////////////////////////
}
