package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList{

    private Object[] arr;

    public ImmutableArrayList(Object[] arr) {

        this.arr = new Object[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
    }



    @Override
    public ImmutableArrayList add(Object e) {

        return this.add(arr.length, e);
    }



    @Override
    public ImmutableArrayList add(int index, Object e) {

        if (index > arr.length || index < 0) {
            throw new IndexOutOfBoundsException("List Index Out Of Range");
        }

        Object[] newArr = new Object[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        newArr[index] = e;
        System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
        return new ImmutableArrayList(newArr);
    }



    @Override
    public ImmutableArrayList addAll(Object[] c) {

        return this.addAll(arr.length, c);
    }



    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {

        if (index > arr.length || index < 0) {
            throw new IndexOutOfBoundsException("List Index Out Of Range");
        }

        Object[] newArr = new Object[arr.length + c.length];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(c, 0, newArr, index, c.length);
        System.arraycopy(arr,
                         index,
                         newArr,
                index + c.length,
                  arr.length - index);
        return new ImmutableArrayList(newArr);
    }



    @Override
    public Object get(int index) {
        
        if (index >= arr.length || index < 0) {
            throw new IndexOutOfBoundsException("List Index Out Of Range");
        }

        return arr[index];
    }



    @Override
    public ImmutableArrayList remove(int index) {

        if (index >= arr.length || index < 0) {
            throw new IndexOutOfBoundsException("List Index Out Of Range");
        }
        
        Object[] newArr = new Object[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, 
                index + 1, 
                        newArr, index, 
                arr.length - index - 1);
        return new ImmutableArrayList(newArr);
    }



    @Override
    public ImmutableArrayList set(int index, Object e) {

        if (index >= arr.length || index < 0) {
            throw new IndexOutOfBoundsException("List Index Out Of Range");
        }
        
        Object[] newArr = new Object[arr.length];
        System.arraycopy(arr, 0, newArr, 0, index);
        newArr[index] = e;
        System.arraycopy(arr, 
                index + 1, 
                        newArr, 
               index + 1,
                arr.length - 1 - index);
        return new ImmutableArrayList(newArr);
    }



    @Override
    public int indexOf(Object e) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == e) {
                return i;
            }
        }
        return -1;
    }



    @Override
    public int size() {

        return arr.length;
    }



    @Override
    public ImmutableArrayList clear() {

        return new ImmutableArrayList(new Object[0]);
    }



    @Override
    public boolean isEmpty() {

        return arr.length == 0;
    }



    @Override
    public Object[] toArray() {

        return arr;
    }



    @Override
    public String toString() {

        String str = Arrays.toString(arr);
        return str.substring(1, str.length() - 1);
    }
}
