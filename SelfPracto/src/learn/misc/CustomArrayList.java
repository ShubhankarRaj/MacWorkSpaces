package com.learn.misc;

import java.util.Arrays;

/**
 * Created By MMT6540 on 23 Jan, 2018
 */
public class CustomArrayList<L> {
    private static final int DEFAULT_INITIAL_CAPACITY = 5;
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    private int size;

    //  Making this Object Array as transient would restore the value of the array
    //  as soon as it is saved in the DB
    private transient Object[] customArrayListElementData;

    //  Constructor with parametrized size
    public CustomArrayList(int initialCapacity){
        super();
        if(initialCapacity < 0)
            throw new IllegalArgumentException("Illegal size of Arraylist - "+initialCapacity);
        this.customArrayListElementData = new Object[initialCapacity];
    }

    //  Constructor with Empty List
    public CustomArrayList(){
        super();
        this.customArrayListElementData = EMPTY_ELEMENT_DATA;
    }

    //  Method to get the size of the CustomArrayList
    public int size(){
        return size;
    }

    //  Method to check if the Arraylist is empty. Returns True or False
    public boolean isEmpty(){
        return size==0;
    }

    //  Method to add a value to the Arraylist
    public boolean add(L l){
        ensureCapacity(size + 1);
        customArrayListElementData[size++] = l;
        return true;
    }

    //  Method to clear the Arraylist
    public void clear(){
        for(int i = 0; i < size; i++){
            customArrayListElementData[i] = null;
        }
        size = 0;
    }

    //  Method to get the Element at a particular Index
    @SuppressWarnings("unchecked")
    public L get(int index){
        if(index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException("Array Index Out Of Bounds Exception at index "+index);
        return (L) customArrayListElementData[index];
    }

    //  Adding an Element at a particular position
    public void add(int index, L element){
        ensureCapacity(size + 1);
        System.arraycopy(customArrayListElementData, index, customArrayListElementData, index+1, size - index);
        customArrayListElementData[index] = element;
        size++;
    }

    //  Remove the Element from a particular Index
    public void remove(int index){
        int removeNumber = size - index -1;
        if(removeNumber > 0){
            System.arraycopy(customArrayListElementData, index+1, customArrayListElementData, index, removeNumber);
        }
        customArrayListElementData[--size] = null;
    }

    //  Increase the capacity of an Arraylist to hold number of elements specified
    private void growCustomArrayList(int minCapacity){
        int oldCapacity = customArrayListElementData.length;
        int newCapacity = oldCapacity + (oldCapacity/2);
        if(newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        customArrayListElementData = Arrays.copyOf(customArrayListElementData, newCapacity);
    }

    //  Ensure the capacity and grow the customArrayList
    private void ensureCapacity(int minCapacity){
        //  Handling the case when the ArrayList is Empty
        if(customArrayListElementData == EMPTY_ELEMENT_DATA){
            minCapacity = Math.max(DEFAULT_INITIAL_CAPACITY, minCapacity);
        }
        if(minCapacity - customArrayListElementData.length > 0){
            growCustomArrayList(minCapacity);
        }

    }

    public static void main(String[] args){
        CustomArrayList<String> strList = new CustomArrayList<>();
        strList.add("String 1");
        strList.add("String 2");
        System.out.println("After adding Elements, size of the list"+strList.size());
    }
}
