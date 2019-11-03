package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAdd() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        ill = ill.add(17);
        Object[] expect = {17};
        Object[] got = ill.toArray();
        assertArrayEquals(expect, got);
    }

    @Test
    public void testAddFull() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        ill = ill.add(17);
        ill = ill.add(1);
        ill = ill.add(55);
        Object[] expect = {17, 1, 55};
        Object[] got = ill.toArray();
        assertArrayEquals(expect, got);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddIndex() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        ill = ill.add(17);
        ill = ill.add(1);
        ill = ill.add(1, 55);
        Object[] expect = {17, 55, 1};
        Object[] got = ill.toArray();
        assertArrayEquals(expect, got);
    }

    @Test
    public void testAddBeg() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        ill = ill.add(17);
        ill = ill.add(1);
        ill = ill.add(0, 55);
        Object[] expect = {55, 17, 1};
        Object[] got = ill.toArray();
        assertArrayEquals(expect, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOutOfBoundsNeg() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        ill = ill.add(17);
        ill = ill.add(1);

        //exception here
        ill = ill.add(-1, 55);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOutOfBoundsPos() {

        ImmutableLinkedList ill = new ImmutableLinkedList();
        ill = ill.add(17);
        ill = ill.add(1);

        //exception here
        ill = ill.add(3, 55);

    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddAll() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);
        Object[] got = ill.toArray();
        assertArrayEquals(arr, got);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddAllIndex() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);
        Object[] arr2 = {88, 99};
        ill = ill.addAll(2, arr2);
        Object[] expect = {1, 2, 88, 99, 3, 4};
        Object[] got = ill.toArray();
        assertArrayEquals(expect, got);
    }

    @Test
    public void testAddAllBeg() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);
        Object[] arr2 = {88, 99};
        ill = ill.addAll(0, arr2);
        Object[] expect = {88, 99, 1, 2, 3, 4};
        Object[] got = ill.toArray();
        assertArrayEquals(expect, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllOutOfBoundsNeg() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);
        Object[] arr2 = {88, 99};

        //exception here
        ill = ill.addAll(-2, arr2);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllOutOfBoundsPos() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);
        Object[] arr2 = {88, 99};

        //exception here
        ill = ill.addAll(100, arr2);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testGet() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);
        Object expect = 2;
        Object got= ill.get(1);
        assertEquals(expect, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBoundsPos() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);

        //exception here
        Object got = ill.get(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBoundsNeg() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);

        //exception here
        Object got = ill.get(-1);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testRemove() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);
        Object[] got = ill.remove(1).toArray();
        Object[] expect = {1, 3, 4};
        assertArrayEquals(expect, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBoundsPos() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);

        //exception here
        ill = ill.remove(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBoundsNeg() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);

        //exception here
        ill = ill.remove(-100);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testSet() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);

        Object[] got = ill.set(1, 555).toArray();
        Object[] expect = {1, 555, 3, 4};
        assertArrayEquals(got, expect);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBoundsPos() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);

        //exception here
        ill = ill.set(100, 33);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBoundsNeg() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);

        //exception here
        ill = ill.set(-100, -100);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testIndexOf() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4, 5, 6};
        ill = ill.addAll(arr);
        assertEquals(ill.indexOf(5), 4);
    }

    @Test
    public void testIndexOfStart() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4, 5, 6};
        ill = ill.addAll(arr);
        assertEquals(ill.indexOf(1), 0);
    }

    @Test
    public void testIndexOfEnd() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4, 5, 6};
        ill = ill.addAll(arr);
        assertEquals(ill.indexOf(6), 5);
    }

    @Test
    public void testIndexOfNotInArray() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4, 5, 6};
        ill = ill.addAll(arr);
        assertEquals(ill.indexOf(44), -1);
    }

    @Test
    public void testIndexOfEmpty() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {};
        ill = ill.addAll(arr);
        assertEquals(ill.indexOf(5), -1);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testSize() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4, 5, 6};
        ill = ill.addAll(arr);
        assertEquals(ill.size(), 6);
    }

    @Test
    public void testSizeZero() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {};
        ill = ill.addAll(arr);
        assertEquals(ill.size(), 0);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testClear() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3};
        ill = ill.addAll(arr);
        ill = ill.clear();
        assertArrayEquals(new Object[0], ill.toArray());
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testIsEmpty() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {};
        ill = ill.addAll(arr);
        assertEquals(true, ill.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {2, 3, 4};
        ill = ill.addAll(arr);
        assertEquals(false, ill.isEmpty());
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testToString() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4, 5};
        ill = ill.addAll(arr);
        assertEquals("1, 2, 3, 4, 5", ill.toString());
    }


    @Test
    public void testEmptyToString() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {};
        ill = ill.addAll(arr);
        assertEquals("", ill.toString());
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testGetFirst() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {2, 3, 4};
        ill = ill.addAll(arr);
        Object expect = 2;
        Object got = ill.getFirst();
        assertEquals(expect, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstEmpty() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {};
        ill = ill.addAll(arr);

        //exception here
        Object got = ill.getFirst();
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testGetLast() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {2, 3, 4};
        ill = ill.addAll(arr);
        Object expect = 4;
        Object got = ill.getLast();
        assertEquals(expect, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastEmpty() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {};
        ill = ill.addAll(arr);

        //exception here
        Object got = ill.getLast();
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddFirst() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {2, 3, 4};
        ill = ill.addAll(arr);
        Object[] expect = {1, 2, 3, 4};
        Object[] got = ill.addFirst(1).toArray();
        assertArrayEquals(expect, got);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddLast() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {2, 3, 4};
        ill = ill.addAll(arr);
        Object[] expect = {2, 3, 4, 1};
        Object[] got = ill.addLast(1).toArray();
        assertArrayEquals(expect, got);
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);
        Object[] expect = {2, 3, 4};
        Object[] got = ill.removeFirst().toArray();
        assertArrayEquals(expect, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFirstEmpty() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {};
        ill = ill.addAll(arr);

        //exception here
        Object[] got = ill.removeFirst().toArray();
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {1, 2, 3, 4};
        ill = ill.addAll(arr);
        Object[] expect = {1, 2, 3};
        Object[] got = ill.removeLast().toArray();
        assertArrayEquals(expect, got);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLastEmpty() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        Object[] arr = {};
        ill = ill.addAll(arr);

        //exception here
        Object[] got = ill.removeLast().toArray();
    }

////////////////////////////////////////////////////////////////////////////*/
}
