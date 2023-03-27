package com.blank.peng.learn.datastructure;

public class Array {
    private int[] data;
    private int size;

    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }


    public int get(int index) {
        return data[index];
    }

    /**
     * 修改指定索引位置的值
     *
     * @param index   位置
     * @param element 新值
     */
    public void set(int index, int element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("no apace to add ele");
        }
        data[index] = element;
    }

    public void addLast(int element) {
        add(size, element);
    }

    public void addFirst(int element) {
        add(0, element);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int find(int ele) {
        for (int i = 0; i < size; i++) {
            if (data[i] == ele)
                return i;
        }
        return -1;
    }

    /**
     * 在指定位置添加元素
     *
     * @param index   位置
     * @param element 元素
     */
    public void add(int index, int element) {
        //没有空间则扩容
        if (size == data.length) {
            resizeArray(size * 2);
        }

        for (int i = size - 1; i >= index; i--) {
            //往后移
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    private void resizeArray(int newCapacity) {
        int[] newData = new int[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 是否包含某个元素
     *
     * @param ele 元素
     * @return true 包含/false 不包含
     */
    public boolean contains(int ele) {
        for (int i = 0; i < size; i++) {
            if (data[i] == ele) return true;
        }
        return false;
    }

    public void removeEle(int ele) {
        int index = find(ele);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 删除第一个位置的元素
     */
    public int removeFirst() {
        return this.remove(0);
    }

    /**
     * 删除最后一个位置的元素
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 待删除位置
     */
    public int remove(int index) {
        if (size == data.length / 2) {
            resizeArray(size / 2);
        }
        int ret = data[index];
        for (int i = index; i < size - 1; i++) {
            //往前移
            data[i] = data[i + 1];
        }
        size--;
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("{Array: Capacity -> %d, Size -> %d", data.length, size));
        builder.append("\nElements:[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]}");
        return builder.toString();
    }

}
